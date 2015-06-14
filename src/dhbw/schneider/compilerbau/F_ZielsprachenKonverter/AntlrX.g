grammar AntlrX;

options {
  backtrack=false;
  language = Java;
  output = AST;
  TokenLabelType = XToken;
  ASTLabelType = XTree;
}

// AST-Tokens
tokens { 
  DECLARE;
  BLOCK;
  UMINUS;
}

@parser::header {package de.dhbw.compiler.xantlrparser2;}
@lexer::header  {package de.dhbw.compiler.xantlrparser2;}

@lexer::members {

 @Override
 public Token emit() {
    XToken t = new XToken(input, state.type, state.channel, 
        state.tokenStartCharIndex, getCharIndex()-1);
    t.setLine(state.tokenStartLine);
    t.setText(state.text);
    t.setCharPositionInLine(state.tokenStartCharPositionInLine);
    switch(state.type) {
      case INT: 
        t.intValue = intValue; 
        break;
      case FLOAT: 
        t.floatValue = (cardinalValue+fractionValue/Math.pow(10,fractionLength))*Math.pow(10,exponentSign*exponentValue); 
        break;
      case STRING: 
        t.stringValue = stringValue.toString();
        break;
    }
    emit(t);
    return t;
  }
  
  private int intValue;
  private int cardinalValue;
  private int fractionValue;
  private int fractionLength;
  private int exponentValue;
  private int exponentSign;
  private StringBuffer stringValue;
  
}

@parser::members {
}

// Ignore Whitespace
WS:     ( '\t' | ' ' | '\r' | '\n' | '\f')+   { skip(); };
COMMENT: '/*' .* '*/' { skip(); };

// Zeichensatz
fragment LETTER:   'a'..'z' | 'A'..'Z';
fragment POSDIGIT: '1'..'9';
fragment ZERO:     '0';
fragment DIGIT:    '0'..'9';
fragment OTHER:    ' ' | '.' | ':' | '\\"';


// Konstanten und Namen
INT: ZERO {intValue=0; } | 
     POSDIGIT {intValue = $text.charAt(0)-'0'; } (DIGIT {intValue = 10*intValue + $text.charAt($text.length()-1)-'0';})*;
     
fragment NUMBER:  DIGIT {intValue = $text.charAt(0)-'0'; } (DIGIT {intValue = 10*intValue + $text.charAt($text.length()-1)-'0';})*;
    
FLOAT:    INT { cardinalValue=intValue; fractionValue=0; fractionLength=0; exponentValue=0; exponentSign=1; }
          ('.' (NUMBER {fractionValue=intValue; fractionLength=$text.length(); })?)? 
          (('e'|'E')('+' {exponentSign=1; }|'-' {exponentSign=-1; })? INT { exponentValue=intValue; })?;
          
STRING:   '"' { stringValue=new StringBuffer(); } ((LETTER|DIGIT|OTHER) {stringValue.append($text.charAt($text.length()-1));})* '"';

ID:       LETTER (LETTER|DIGIT)*;


INVALID:  .;



// Deklarationen
decl:        ID ':' (type='int' | type='float' | type='string') ';' -> ^(DECLARE ID $type)
           | 'read' ID ':' (type='int' | type='float' | type='string') ';' -> ^(DECLARE ID $type 'read')
           | 'print' ID ':' (type='int' | type='float' | type='string') ';' -> ^(DECLARE ID $type 'print')
           | 'read' 'print' ID ':' (type='int' | type='float' | type='string') ';' -> ^(DECLARE ID $type 'read' 'print');

// Ausdrücke
expr:         multexpr (('+'^ | '-'^) multexpr)*;
multexpr:    simpleexpr (('*'^ | '/'^) simpleexpr)*;
simpleexpr:   '('! expr ')'! 
            | INT | '-' INT -> ^(UMINUS INT) 
            | FLOAT | '-' FLOAT -> ^(UMINUS FLOAT)
            | ID | STRING;

// Zuweisung
assignstat:   ID ':='^ expr;


// Bedingungen
cond:         expr ('<'^ |'>'^ |'='^ ) expr;


// Bedingte Zuweisung
condstat:     'if'^ cond 'then'! stat  (options {greedy=true;}: 'else'! stat)?;
// condstat:     'if' cond 'then' s1=stat  (options {greedy=true;}: 'else' s2=stat)? -> ^('if' cond stat stat);

// Schleifen
// whilestat:    'while'^ '('! cond ')'! stat;
whilestat:    'while' '(' cond ')' stat -> ^('while' cond stat);
forstat:      'for'^ '('! assignstat ';'! cond ';'! assignstat ')'! stat;


// Anweisungen
// stat:         nassignstat | sassignstat | condstat | whilestat | forstat | block |;
stat:         assignstat | condstat | whilestat | forstat | block;


// Blöcke
block:        'begin' (stat ';')* 'end'  -> ^(BLOCK stat*);


// Programme
program:      'program' ID ';' decl* block '.' EOF -> ^('program' ID decl* block);


