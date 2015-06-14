tree grammar Count;

options {
  language = Java;
  output = AST;
  tokenVocab = AntlrX;
  TokenLabelType = XToken;
  ASTLabelType = CommonTree;
  rewrite=true;
}


@header {
    package de.dhbw.compiler.xantlrparser1a;
    
    import java.util.HashMap;
}

@members {

  int count =0;
}


// Deklarationen (was deklariert wird ist egal, ob int float, string)
decl:       ^(DECLARE .*);
// Expr und Cond!!
expr:       ^(UMINUS expr)
          | ^(('+' | '-' | '/' | '*' | '<' | '>' | '=') expr expr)           
          | INT  
          | FLOAT
          | STRING 
          | ID;  

//Wie häufig komme ich beim Ablauf an einem Assign vorbei
assignstat:  ^(':=' ID  expr) {count++;};
// Bedingte Zuweisung (else nur optional)
condstat:   ^('if' expr  stat stat?);
// Schleifen
whilestat:    ^('while' expr stat);
forstat:      ^('for' assignstat expr assignstat stat);
// Anweisungen
stat:         assignstat | condstat | whilestat | forstat | block;
// Blöcke
block:        ^(BLOCK stat*);
// Programme, Ausgabe der Zuweisungen am Ende des Durchlaufs
program:      ^('program' ID decl* block) {System.out.println("Anzahl Zuweisungen: "+count);};

