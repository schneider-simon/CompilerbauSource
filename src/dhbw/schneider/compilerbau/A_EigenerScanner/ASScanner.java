/* **********************************************
 * Duale Hochschule Baden-Württemberg Karlsruhe
 * Prof. Dr. Jörn Eisenbiegler
 * 
 * Vorlesung Übersetzerbau
 * Übungsbeispiel AS-SCanner 1
 * 
 * **********************************************
 */

package dhbw.schneider.compilerbau.A_EigenerScanner;

import java.io.InputStream;
import java.io.InputStreamReader;

public class ASScanner {
		
	private final int ignore = -2;
	
	private InputStreamReader in = null;
	private StringBuffer text = new StringBuffer();
	
	private enum ASState { WS, LSBR, RSBR, COMMA, ZAHL, NAME, N, U, L, NULL, EOF};
	
	private ASState state = ASState.WS;
	private int tokentype = Token.INVALID;

	
	public ASScanner(InputStream input) {
		this.in = new InputStreamReader(input);
	}
	
	private Token step(int c, ASState newState, boolean create, int newTokenType) {
		Token res = null;
		if (create) {
			res = new Token(tokentype, text.toString());
			text = new StringBuffer();
		}
		if (c!=ignore) {
			text.append((char)c);
		}
		state = newState;
		tokentype = newTokenType;
		return res;
	}
	
	public Token nextToken() throws Exception {
		Token token = null;
		while (token == null) {
			int c =	in.read();
			switch (state) {
			case WS:
				switch(c) {
				case -1:
					token = step(ignore, ASState.EOF, false, Token.EOF); break;
				case ' ': case '\t': case '\n': case '\r':
					token = step(ignore, ASState.WS, false, Token.INVALID); break;
				case '[':
					token = step(c, ASState.LSBR, false, Token.LSBR); break;
				case ']':
					token = step(c, ASState.RSBR, false, Token.RSBR); break;
				case ',':
					token = step(c, ASState.COMMA, false, Token.COMMA); break;
				case '0': case '1': case '2': case '3': case '4':
				case '5': case '6': case '7': case '8': case '9':
					token = step(c, ASState.ZAHL, false, Token.ZAHL); break;
				case 'n':
					token = step(c, ASState.N, false, Token.ID); break;
				default:
					if (('a'<=c && c<='z') || ('A'<=c && c<='Z')) {
						token = step(c, ASState.NAME, false, Token.ID);
					} else {
						throw new Exception("Unexpected character: '"+(char) c+"' ("+c+")");
					}
					
				}
				break;
			case LSBR: case RSBR: case COMMA:
				switch(c) {
				case -1:
					token = step(ignore, ASState.EOF, true, Token.EOF); break;
				case ' ': case '\t': case '\n': case '\r':
					token = step(ignore, ASState.WS, true, Token.INVALID); break;
				case '[':
					token = step(c, ASState.LSBR, true, Token.LSBR); break;
				case ']':
					token = step(c, ASState.RSBR, true, Token.RSBR); break;
				case ',':
					token = step(c, ASState.COMMA, true, Token.COMMA); break;
				case '0': case '1': case '2': case '3': case '4':
				case '5': case '6': case '7': case '8': case '9':
					token = step(c, ASState.ZAHL, true, Token.ZAHL); break;
				case 'n':
					token = step(c, ASState.N, true, Token.ID); break;
				default:
					if (('a'<=c && c<='z') || ('A'<=c && c<='Z')) {
						token = step(c, ASState.NAME, true, Token.ID);
					} else {
						throw new Exception("Unexpected character: '"+(char) c+"' ("+c+")");
					}
					
				}
				break;
			case ZAHL:
				switch(c) {
				case -1:
					token = step(ignore, ASState.EOF, true, Token.EOF); break;
				case ' ': case '\t': case '\n': case '\r':
					token = step(ignore, ASState.WS, true, Token.INVALID); break;
				case '[':
					token = step(c, ASState.LSBR, true, Token.LSBR); break;
				case ']':
					token = step(c, ASState.RSBR, true, Token.RSBR); break;
				case ',':
					token = step(c, ASState.COMMA, true, Token.COMMA); break;
				case '0': case '1': case '2': case '3': case '4':
				case '5': case '6': case '7': case '8': case '9':
					token = step(c, ASState.ZAHL, false, Token.ZAHL); break;
				default:
					if (('a'<=c && c<='z') || ('A'<=c && c<='Z')) {
						token = step(c, ASState.NAME, false, Token.ID);
					} else {
						throw new Exception("Unexpected character: '"+(char) c+"' ("+c+")");
					}
					
				}
				break;
			case NAME:
				switch(c) {
				case -1:
					token = step(ignore, ASState.EOF, true, Token.EOF); break;
				case ' ': case '\t': case '\n': case '\r':
					token = step(ignore, ASState.WS, true, Token.INVALID); break;
				case '[':
					token = step(c, ASState.LSBR, true, Token.LSBR); break;
				case ']':
					token = step(c, ASState.RSBR, true, Token.RSBR); break;
				case ',':
					token = step(c, ASState.COMMA, true, Token.COMMA); break;
				case '0': case '1': case '2': case '3': case '4':
				case '5': case '6': case '7': case '8': case '9':
					token = step(c, ASState.NAME, false, Token.ID); break;
				default:
					if (('a'<=c && c<='z') || ('A'<=c && c<='Z')) {
						token = step(c, ASState.NAME, false, Token.ID);
					} else {
						throw new Exception("Unexpected character: '"+(char) c+"' ("+c+")");
					}
					
				}
				break;
			case N:
				switch(c) {
				case -1:
					token = step(ignore, ASState.EOF, true, Token.EOF); break;
				case ' ': case '\t': case '\n': case '\r':
					token = step(ignore, ASState.WS, true, Token.INVALID); break;
				case '[':
					token = step(c, ASState.LSBR, true, Token.LSBR); break;
				case ']':
					token = step(c, ASState.RSBR, true, Token.RSBR); break;
				case ',':
					token = step(c, ASState.COMMA, true, Token.COMMA); break;
				case '0': case '1': case '2': case '3': case '4':
				case '5': case '6': case '7': case '8': case '9':
					token = step(c, ASState.NAME, false, Token.ID); break;
				case 'u':
					token = step(c, ASState.U, false, Token.ID); break;
				default:
					if (('a'<=c && c<='z') || ('A'<=c && c<='Z')) {
						token = step(c, ASState.NAME, false, Token.ID);
					} else {
						throw new Exception("Unexpected character: '"+(char) c+"' ("+c+")");
					}
					
				}
				break;
			case U:
				switch(c) {
				case -1:
					token = step(ignore, ASState.EOF, true, Token.EOF); break;
				case ' ': case '\t': case '\n': case '\r':
					token = step(ignore, ASState.WS, true, Token.INVALID); break;
				case '[':
					token = step(c, ASState.LSBR, true, Token.LSBR); break;
				case ']':
					token = step(c, ASState.RSBR, true, Token.RSBR); break;
				case ',':
					token = step(c, ASState.COMMA, true, Token.COMMA); break;
				case '0': case '1': case '2': case '3': case '4':
				case '5': case '6': case '7': case '8': case '9':
					token = step(c, ASState.NAME, false, Token.ID); break;
				case 'l':
					token = step(c, ASState.L, false, Token.ID); break;
				default:
					if (('a'<=c && c<='z') || ('A'<=c && c<='Z')) {
						token = step(c, ASState.NAME, false, Token.ID);
					} else {
						throw new Exception("Unexpected character: '"+(char) c+"' ("+c+")");
					}
					
				}
				break;
			case L:
				switch(c) {
				case -1:
					token = step(ignore, ASState.EOF, true, Token.EOF); break;
				case ' ': case '\t': case '\n': case '\r':
					token = step(ignore, ASState.WS, true, Token.INVALID); break;
				case '[':
					token = step(c, ASState.LSBR, true, Token.LSBR); break;
				case ']':
					token = step(c, ASState.RSBR, true, Token.RSBR); break;
				case ',':
					token = step(c, ASState.COMMA, true, Token.COMMA); break;
				case '0': case '1': case '2': case '3': case '4':
				case '5': case '6': case '7': case '8': case '9':
					token = step(c, ASState.NAME, false, Token.ID); break;
				case 'l':
					token = step(c, ASState.NULL, false, Token.NULL); break;
				default:
					if (('a'<=c && c<='z') || ('A'<=c && c<='Z')) {
						token = step(c, ASState.NAME, false, Token.ID);
					} else {
						throw new Exception("Unexpected character: '"+(char) c+"' ("+c+")");
					}
					
				}
				break;
			case NULL:
				switch(c) {
				case -1:
					token = step(ignore, ASState.EOF, true, Token.EOF); break;
				case ' ': case '\t': case '\n': case '\r':
					token = step(ignore, ASState.WS, true, Token.INVALID); break;
				case '[':
					token = step(c, ASState.LSBR, true, Token.LSBR); break;
				case ']':
					token = step(c, ASState.RSBR, true, Token.RSBR); break;
				case ',':
					token = step(c, ASState.COMMA, true, Token.COMMA); break;
				case '0': case '1': case '2': case '3': case '4':
				case '5': case '6': case '7': case '8': case '9':
					token = step(c, ASState.NAME, false, Token.ID); break;
				default:
					if (('a'<=c && c<='z') || ('A'<=c && c<='Z')) {
						token = step(c, ASState.NAME, false, Token.ID);
					} else {
						throw new Exception("Unexpected character: '"+(char) c+"' ("+c+")");
					}
					
				}
				break;
			case EOF:
				token = step(ignore, ASState.EOF, true, Token.EOF); break;
			default:
				throw new Exception("Unexpected state: "+state);
			}
		}
		return token;
	}

}
