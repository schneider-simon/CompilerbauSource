/* **********************************************
 * Duale Hochschule Baden-Württemberg Karlsruhe
 * Prof. Dr. Jörn Eisenbiegler
 * 
 * Vorlesung Übersetzerbau
 * Übungsbeispiel ASScanner mit JFlex 2
 * 
 * **********************************************
 */


package de.dhbw.compiler.JFlexASScanner2;

import de.dhbw.compiler.ASScanner5.Token;
import de.dhbw.compiler.ASScanner5.KeyWordToken;
import de.dhbw.compiler.ASScanner5.ZahlToken;
import de.dhbw.compiler.ASScanner5.NameToken;
import de.dhbw.compiler.ASScanner5.BruchToken;
import de.dhbw.compiler.ASScanner5.InvalidToken;

%%

%class JFlexASScanner
%function nextToken
%type  Token 

%eofval{ 
	return new KeyWordToken(Token.EOF, yyline+1, yycolumn+1); 
%eofval}

%unicode
%line
%column

%public
%final

%xstate ZAHL, BRUCHTEIL, EXP1, EXP

%{
	private int zahlvalue=0;
	private StringBuffer textvalue = new StringBuffer();
	private int bruchvalue=0;
	private int bruchlength=0;
	private int expvalue=0;
	private int startline =0;
	private int startcolumn =0;
%}

%%

\[							{ return new KeyWordToken(Token.LSBR, yyline+1, yycolumn+1); }
\]							{ return new KeyWordToken(Token.RSBR, yyline+1, yycolumn+1); }
\,							{ return new KeyWordToken(Token.COMMA, yyline+1, yycolumn+1); }
\.\.						{ return new KeyWordToken(Token.BIS, yyline+1, yycolumn+1); }
null						{ return new KeyWordToken(Token.NULL, yyline+1, yycolumn+1); }
[0-9]						{ 	yybegin(ZAHL); 
								zahlvalue=yytext().charAt(0)-'0';
								textvalue= new StringBuffer();
								bruchvalue=0;
								bruchlength=0;
								expvalue=0;
								startline=yyline+1;
								startcolumn=yycolumn+1; }

[a-zA-Z][0-9a-zA-Z]*		{ return new NameToken(Token.NAME, yytext(), yyline+1, yycolumn+1); }
[\ \t\b\f\r\n]+				{ /* eat whitespace */ }
[^]							{ return new InvalidToken(Token.INVALID, yytext(), yyline+1, yycolumn+1); }

<ZAHL> {
	[0-9]					{ zahlvalue = 10*zahlvalue + yytext().charAt(0)-'0'; 
							  textvalue = new StringBuffer();}
	\./(\.\.)*				{ yybegin(BRUCHTEIL); }
	\.\./(\.\.)*			{ yybegin(YYINITIAL); 
							  yypushback(2); 
					  		  return new ZahlToken(Token.ZAHL,zahlvalue, startline, startcolumn);}
	[a-zA-Z][a-zA-Z0-9]*	{ yybegin(YYINITIAL); 
							  return new NameToken(Token.NAME, textvalue+yytext(), startline, startcolumn); }
	.						{ yybegin(YYINITIAL); 
					  		  yypushback(1); 
					  		  return new ZahlToken(Token.ZAHL,zahlvalue, startline, startcolumn); }
	<<EOF>>					{ yybegin(YYINITIAL); 
					  		  return new ZahlToken(Token.ZAHL,zahlvalue, startline, startcolumn);}
}

<BRUCHTEIL> {
	[0-9]					{ bruchvalue= 10*bruchvalue+ yytext().charAt(0)-'0'; 
							  bruchlength++; }
	\^						{ yybegin(EXP1); }
	.						{ yybegin(YYINITIAL); 
					  		  yypushback(1); 
					  		  return new BruchToken(Token.BRUCH,zahlvalue+bruchvalue/Math.pow(10,bruchlength), startline, startcolumn); }
	<<EOF>>					{ yybegin(YYINITIAL); 
					  		  yypushback(1); 
					  		  return new BruchToken(Token.BRUCH,zahlvalue+bruchvalue/Math.pow(10,bruchlength), startline, startcolumn); }
}

<EXP1> {
	[0-9]					{ expvalue= 10*expvalue+ yytext().charAt(0)-'0';
							  yybegin(EXP); }
	.						{ yybegin(YYINITIAL);
							  yypushback(1);
							  return new InvalidToken(Token.INVALID, textvalue.toString(), startline, startcolumn); }
	<<EOF>>					{ yybegin(YYINITIAL);
							  yypushback(1);
							  return new InvalidToken(Token.INVALID, textvalue.toString(), startline, startcolumn); }
}

<EXP> {
	[0-9]					{ expvalue= 10*expvalue+ yytext().charAt(0)-'0';
							  yybegin(EXP); }
	.						{ yybegin(YYINITIAL); 
							  yypushback(1);
							  return new BruchToken(Token.BRUCH, (zahlvalue+bruchvalue/Math.pow(10,bruchlength))*Math.pow(10,expvalue), startline, startcolumn); }
	<<EOF>>					{ yybegin(YYINITIAL); 
							  yypushback(1);
							  return new BruchToken(Token.BRUCH, (zahlvalue+bruchvalue/Math.pow(10,bruchlength))*Math.pow(10,expvalue), startline, startcolumn); }
}

