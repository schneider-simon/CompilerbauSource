tree grammar TypeCheck;

options {
  language = Java;
  output = AST;
  tokenVocab = AntlrX;
  TokenLabelType = XToken;
  ASTLabelType = XTree;
  rewrite=true;
}

tokens{
  ITOF;
  IDA;
  PLUS='+';
}

@header {
    package de.dhbw.compiler.xantlrparser2;
    
    import java.util.HashMap;
}

@members {

    private HashMap<String, Integer>  varTypes = new HashMap<String, Integer>();

}


// Deklarationen
decl:       ^(DECLARE ID 'int' .*)  { varTypes.put($ID.text, XTree.INTTYPE); } 
          | ^(DECLARE ID 'float' .*) { varTypes.put($ID.text, XTree.FLOATTYPE); } 
          |  ^(DECLARE ID 'string' .*) { varTypes.put($ID.text, XTree.STRINGTYPE); } ;

// Expr und Cond!!
expr:       
            ^(u=UMINUS x=expr) 
              { if ($x.start.exprType == XTree.STRINGTYPE) {
                  System.err.println("Error at "+$op.line+","+$op.getCharPositionInLine()+": Operand '-' is not valid for string operands.");
                } else {  
                  $u.exprType=$x.start.exprType; 
                }
              }
          | ^((op='+' | op='-' | op='/' | op='*' | op='<' | op='>' | op='=') l=expr r=expr)
           
              { if ($l.start.exprType == XTree.STRINGTYPE || $r.start.exprType == XTree.STRINGTYPE) {
                  if ($l.start.exprType ==  $r.start.exprType) {
                     if ($op.type == PLUS) {
                        // Beide String und op ist +
                        $op.exprType=XTree.STRINGTYPE;
                     } else {
                        // Beide String aber op kein +
                        $op.exprType=XTree.INVALIDTYPE;
                        System.err.println("Error at "+$op.line+","+$op.getCharPositionInLine()+": "+$op.text+" ("+$op.token.getType()+") is not valid for string operands.");
                     }
                  } else {
                    // Einer von beiden kein String
                    $op.exprType=XTree.INVALIDTYPE;
                    System.err.println("Error at "+$op.line+","+$op.getCharPositionInLine()+": A string operand cannot be combined with a non-string operand.");
                  }
                } else if ($l.start.exprType == $r.start.exprType) { 
                   // Typen gleich
                   $op.exprType=$l.start.exprType; 
                } else {
                   // Typen ungleich aber kein String
                   $op.exprType=XTree.FLOATTYPE; 
                }
              }
          
              -> {$l.start.exprType == XTree.INTTYPE && $r.start.exprType == XTree.FLOATTYPE}? ^($op ^(ITOF $l) $r) 
              -> {$l.start.exprType == XTree.FLOATTYPE && $r.start.exprType == XTree.INTTYPE}? ^($op $l ^(ITOF $r))
              -> ^($op $l $r)
             
          | i=INT     {$i.exprType=XTree.INTTYPE; }
          | f=FLOAT   {$f.exprType=XTree.FLOATTYPE; }
          | s=STRING  {$s.exprType=XTree.STRINGTYPE; }
          | v=ID      {if (varTypes.containsKey($ID.text)) { 
                        $v.exprType=varTypes.get($ID.text);
                       } else {
                        $v.exprType=XTree.INVALIDTYPE;
                        System.err.println("Error at "+$v.line+","+$v.getCharPositionInLine()+": Variable "+$ID.text+" is not defined.");
                       }
                      };

assignstat:  ^(op=':=' ID  expr) {
              if (varTypes.containsKey($ID.text)) {
                $ID.exprType = varTypes.get($ID.text);
	              if ($ID.exprType != $expr.start.exprType && !($expr.start.exprType==XTree.INVALIDTYPE  || $expr.start.exprType==XTree.INTTYPE && $ID.exprType==XTree.FLOATTYPE)) {
	                System.err.println("Error at "+$op.line+","+$op.getCharPositionInLine()+": An expression of type "+$expr.start.getExprTypeString()+" cannot be assigned to a variable of type "+$ID.getExprTypeString()+".");       
	              }
              } else {
                System.err.println("Error at "+$op.line+","+$op.getCharPositionInLine()+": variable "+$ID.text+" is not defined.");
                $ID.exprType = XTree.INVALIDTYPE; 
              }
             }
             -> {$expr.start.exprType==XTree.INTTYPE && $ID.exprType==XTree.FLOATTYPE }? ^(':=' IDA[$ID.token]  ^(ITOF expr))
             -> ^(':=' IDA[$ID.token]  expr);

// Bedingte Zuweisung
condstat:   ^('if' expr  stat stat?);

// Schleifen
whilestat:    ^('while' expr stat);
forstat:      ^('for' assignstat expr assignstat stat);

// Anweisungen
// stat:         nassignstat | sassignstat | condstat | whilestat | forstat | block |;
stat:         assignstat | condstat | whilestat | forstat | block;

// Blöcke
block:        ^(BLOCK stat*);

// Programme
program:      ^('program' ID decl* block);

