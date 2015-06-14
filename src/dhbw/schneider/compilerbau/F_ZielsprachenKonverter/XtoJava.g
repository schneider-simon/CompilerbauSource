tree grammar XtoJava;

options {
  language = Java;
  output = template;
  tokenVocab = XOptimizer;
  TokenLabelType = XToken;
  ASTLabelType = XTree;
}
@header {
    package de.dhbw.compiler.xantlrparser2;
}
@members {

  class Variable {
    public String name;
    public int varType;
    public Variable(String name, int varType) {
      this.name = name;
      this.varType = varType;
    }
  }

  ArrayList<Variable> readVars = new ArrayList<Variable>();
  ArrayList<Variable> printVars = new ArrayList<Variable>();
  
  private StringTemplate printCode() {
    StringBuffer res = new StringBuffer();
    for(Variable var : printVars) {
      res.append("  System.out.println(\""+var.name+": \"+"+var.name+");\n");
    }
    return new StringTemplate(res.toString());
  }
  
  private StringTemplate readCode() {
    StringBuffer res = new StringBuffer();
    res.append("  Scanner _Scanner = new Scanner(System.in);\n");
    for(Variable var : readVars) {
      res.append("  System.out.print(\""+var.name+": \");\n");
      switch(var.varType) {
        case XTree.INTTYPE: res.append("  "+var.name+" = _Scanner.nextInt();\n"); break;
        case XTree.FLOATTYPE: res.append("  "+var.name+" = _Scanner.nextDouble();\n"); break;
        case XTree.STRINGTYPE: res.append("  "+var.name+" = _Scanner.next;\n"); break;
      }
    }
    res.append("  _Scanner.close();");
    return new StringTemplate( res.toString());
  }
  
  
}
// Deklarationen
decl: ^(DECLARE ID 'int' ('read' { readVars.add(new Variable($ID.text,XTree.INTTYPE));}
		| 'print' { printVars.add(new Variable($ID.text,XTree.INTTYPE));})*) 
      -> template(id={$ID.text}) "private static int <id>=0;"
	  
    | ^(DECLARE ID 'float' ('read' { readVars.add(new Variable($ID.text,XTree.FLOATTYPE));}
	| 'print' { printVars.add(new Variable($ID.text,XTree.FLOATTYPE));})*) 
      -> template(id={$ID.text}) "private static double <id>=0.0;"
	  
    | ^(DECLARE ID 'string' ('read' { readVars.add(new Variable($ID.text,XTree.STRINGTYPE));}
	| 'print' { printVars.add(new Variable($ID.text,XTree.STRINGTYPE));})*) 
      -> template(id={$ID.text}) "private static string <id>=\"\";";

// Expr
expr:       ^(UMINUS e=expr)  -> template(e={$e.st}) "-(<e>)" 
          | ^(ITOF e=expr) -> template(e={$e.st}) "((double)<e>)"
          | ^((op='+' | op='-' | op='/' | op='*') e1=expr e2=expr) 
                -> template(op={$op.text}, e1={$e1.st}, e2={$e2.st}) "(<e1><op><e2>)" 
          | (x=INT | x=FLOAT | x=STRING | x=ID) -> template(x={$x.text}) "<x>";
          

// assignstat:  ^(':=' ID  expr);
assignstat:  ^(':=' IDA expr) -> template(id={$IDA.text}, expr={$expr.st}) "<id> = <expr>";
assignwithsemi:  ^(':=' IDA expr) -> template(id={$IDA.text}, expr={$expr.st}) "<id> = <expr>;";


// Bedingungen
cond:       ^(( op='<' |op='>') e1=expr e2=expr) 
            -> template(op={$op.text}, e1={$e1.st}, e2={$e2.st})  "(<e1><op><e2>)"
          | ^('=' e1=expr e2=expr) 
             -> template(e1={$e1.st}, e2={$e2.st})  "(<e1>==<e2>)";

// Bedingte Zuweisung
condstat:   ^('if' cond  s1=stat s2=stat?) -> template(c={$cond.st}, s1={$s1.st}, s2={$s2.st})
<<
if <c> {
  <s1>
} else {
  <s2>
}
>>;

// Schleifen
whilestat:    ^('while' cond stat) -> template(c={$cond.st}, s={$stat.st}) 
<<
while <c> {
  <s>
}
>>;

forstat:      ^('for' i=assignstat c=cond p=assignstat s=stat) -> template(i={$i.st}, c={$c.st}, p={$p.st}, s={$s.st})
<<
for (<i>; <c>; <p>) {
   <s>
}
>>;

// Anweisungen
stat:         (s=assignwithsemi | s=condstat | s=whilestat | s=forstat | s=block) -> template(stat={$s.st}) "<stat>";

// Blöcke
block:        ^(BLOCK (s+=stat)*) -> template(m={$s})
<<
{
    <stat; separator="\n">
}
>>;

// Programme Hole ID, Deklaration und Block aus Variable heraus
// Readcode ist Code um Variable einzulesen, Print um auszulesen.
program:      ^('program' ID (d+=decl)* block) 
              -> template(id={$ID}, decl={$d}, block={$block.st}, print={printCode()}, read={readCode()})
<<
import java.util.Scanner;

public class <id> {

  <decl; separator="\n">
  
  public static void main(String[] args) {
    <read>
    <block>
    <print>
  }
} 
>>;

