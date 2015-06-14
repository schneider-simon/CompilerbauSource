tree grammar XOptimizer;

options {
  language = Java;
  output = AST;
  tokenVocab = TypeCheck;
  TokenLabelType = XToken;
  ASTLabelType = XTree;
  filter=true;
}

tokens{
  FLOWBLOCK;
  FLOWFOR;
  FLOWWHILE;
  FLOWIF;
}


@header {
    package de.dhbw.compiler.xantlrparser2;
    
    import java.util.HashSet;
    
}

@members {
    HashMap<String, String> constStrings = new HashMap<String,String>();
    HashMap<String, Integer> constInts = new HashMap<String,Integer>();
    HashMap<String, Double> constFloats = new HashMap<String,Double>();
    
    private void clearConstTables() {
       constStrings = new HashMap<String,String>();
       constInts = new HashMap<String,Integer>();
       constFloats = new HashMap<String,Double>();
       System.out.println("Consts cleared.");
    }
    
 }


topdown: buildBlocks | clear;

bottomup: combineConst | multZ | clear | saveConsts | unbuildBlocks;


combineConst:   ^('+' x=STRING y=STRING) -> STRING<XTree>[$x.getToken().stringValue + $y.getToken().stringValue]
              | ^('+' x=INT y=INT) -> INT<XTree>[$x.getToken().intValue + $y.getToken().intValue]
              | ^('-' x=INT y=INT) -> INT<XTree>[$x.getToken().intValue - $y.getToken().intValue]
              | ^('*' x=INT y=INT) -> INT<XTree>[$x.getToken().intValue * $y.getToken().intValue]
              | ^('/' x=INT y=INT) -> INT<XTree>[$x.getToken().intValue / $y.getToken().intValue]
              | ^('+' x=FLOAT y=FLOAT) -> FLOAT<XTree>[$x.getToken().floatValue + $y.getToken().floatValue]
              | ^('-' x=FLOAT y=FLOAT) -> FLOAT<XTree>[$x.getToken().floatValue - $y.getToken().floatValue]
              | ^('*' x=FLOAT y=FLOAT) -> FLOAT<XTree>[$x.getToken().floatValue * $y.getToken().floatValue]
              | ^('/' x=FLOAT y=FLOAT) -> FLOAT<XTree>[$x.getToken().floatValue / $y.getToken().floatValue]
              | ^(ITOF x=INT) -> FLOAT<XTree>[(double)$x.getToken().intValue]
              | ^(UMINUS x=INT) -> INT<XTree>[-$x.getToken().intValue]
              | ^(UMINUS x=FLOAT) -> FLOAT<XTree>[-$x.getToken().floatValue]
              | ID {constStrings.containsKey($ID.text) || constInts.containsKey($ID.text) || constFloats.containsKey($ID.text) }? 
                   -> { constStrings.containsKey($ID.text)}? STRING<XTree>[constStrings.get($ID.text)]
                   -> { constInts.containsKey($ID.text)}? INT<XTree>[constInts.get($ID.text)]
                   -> { constFloats.containsKey($ID.text)}? FLOAT<XTree>[constFloats.get($ID.text)]
                   -> INVALID["Invalid ID-Node for constant-folding"]
;

multZ:    ^('*' x=INT {$x.getToken().intValue==0}? y=. ) -> INT<XTree>[0]
        | ^('*' . x=INT {$x.getToken().intValue==0}?) -> INT<XTree>[0];

saveConsts:     ^(':=' n=IDA x=STRING) { constStrings.put($n.text, $x.getToken().stringValue); System.out.println("save "+$n.text+"="+$x.text);}
              | ^(':=' n=IDA x=INT)    { constInts.put($n.text, $x.getToken().intValue); System.out.println("save "+$n.text+"="+$x.text);}
              | ^(':=' n=IDA x=FLOAT)  { constFloats.put($n.text, $x.getToken().floatValue); System.out.println("save "+$n.text+"="+$x.text);};
              
buildBlocks:    ^('for' init=. cond=. cont=. stats=.) -> ^(FLOWFOR $init ^(FLOWBLOCK $cond) ^(FLOWBLOCK $cont) ^(FLOWBLOCK $stats))
              | ^('while' cond=. stats=.) -> ^(FLOWWHILE ^(FLOWBLOCK $cond) ^(FLOWBLOCK $stats))
              | ^('if' cond=. s1=. s2=.?) -> ^(FLOWIF ^(FLOWBLOCK $cond) ^(FLOWBLOCK $s1) ^(FLOWBLOCK $s2)?);
              

unbuildBlocks:   ^(FLOWFOR init=. ^(FLOWBLOCK cond=.) ^(FLOWBLOCK cont=.) ^(FLOWBLOCK stats=.)) -> ^('for' $init $cond $cont $stats)
               | ^(FLOWWHILE ^(FLOWBLOCK cond=.) ^(FLOWBLOCK stats=.)) -> ^('while' $cond $stats)
               | ^(FLOWIF ^(FLOWBLOCK cond=.) ^(FLOWBLOCK s1=.) ^(FLOWBLOCK s2=.)) ->  ^('if' $cond $s1 $s2?)
               | ^(FLOWIF ^(FLOWBLOCK cond=.) ^(FLOWBLOCK s1=.)) ->  ^('if' $cond $s1);

clear:  ^(FLOWBLOCK .*) { clearConstTables();};
              
                      

