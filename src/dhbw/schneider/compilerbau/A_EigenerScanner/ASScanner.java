/* **********************************************
 * Duale Hochschule Baden-Württemberg Karlsruhe
 * Prof. Dr. Jörn Eisenbiegler
 * 
 * Vorlesung Übersetzerbau
 * Übungsbeispiel AS-SCanner 5
 * 
 * **********************************************
 */

package dhbw.schneider.compilerbau.A_EigenerScanner;

import java.io.InputStream;
import java.io.InputStreamReader;

public class ASScanner {
		
	private final int ignore = -2;
	
	private LookaheadReader in = null;
	private StringBuffer text = new StringBuffer();
	
	private enum ASState { WS, LSBR, RSBR, COMMA, ZAHL, NAME, N, U, L, NULL, EOF, 
							PUNKT, BRUCHTEIL, HOCH, EXP, BIS1, BIS2, INVALID};
	
	
	private ASState state = ASState.WS;
	private int tokentype = Token.INVALID;
	
	private int line = 1;
	private int column = 1;
	
	private int zahlvalue=0;
	private int bruchvalue=0;
	private int bruchlength=0;
	private int expvalue=0;

	
	public ASScanner(InputStream input) {
		this.in = new LookaheadReader(new InputStreamReader(input));
	}
	
	private Token step(int c, ASState newState, boolean create, int newTokenType) {
		Token res = null;
		if (create) {
			switch (tokentype) {
			case Token.NAME:
				res = new NameToken(tokentype, text.toString(), line, column); break;
			/* Aufgabe 5 */
			case Token.ZAHL:
				res = new ZahlToken(tokentype, zahlvalue, line, column); break;
			case Token.BRUCH:
				res = new BruchToken(tokentype, (zahlvalue+bruchvalue/Math.pow(10,bruchlength))*Math.pow(10,expvalue), line, column); break;
			/* --- */
			case Token.INVALID:
				res = new InvalidToken(tokentype, text.toString(), line, column); break;
			default:
				res = new KeyWordToken(tokentype, line, column);
			}
			text = new StringBuffer();
			line = in.getLine();
			column = in.getColumn();
		}
		if (c!=ignore) {
			text.append((char)c);
		}
		if (state.equals(ASState.WS)) {
			line = in.getLine();
			column = in.getColumn();			
		}
		
		/* Aufgabe 5 */
		switch (newState) {
		case ZAHL:
			if (!state.equals(ASState.ZAHL)) {
				zahlvalue 	=0;
				bruchvalue =0;
				expvalue  =0;
				bruchlength =0;
			}
			zahlvalue = 10 * zahlvalue + c-'0';
			break;
		case BRUCHTEIL:
			bruchvalue = 10 * bruchvalue + c-'0';
			bruchlength++;
			break;
		case EXP:
			expvalue = 10 * expvalue + c-'0';
			break;
		default: /* Keine Typkonvertierung nötig */
		}
		/* --- */
		
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
					token = step(c, ASState.N, false, Token.NAME); break;
				case '.':
					token = step(c, ASState.BIS1, false, Token.INVALID); break;
				default:
					if (('a'<=c && c<='z') || ('A'<=c && c<='Z')) {
						token = step(c, ASState.NAME, false, Token.NAME);
					} else {
						token = step(c, ASState.INVALID, false, Token.INVALID);
					}
					
				}
				break;
			case INVALID:
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
					token = step(c, ASState.N, true, Token.NAME); break;
				case '.':
					token = step(c, ASState.BIS1, true, Token.INVALID); break;
				default:
					if (('a'<=c && c<='z') || ('A'<=c && c<='Z')) {
						token = step(c, ASState.NAME, true, Token.NAME);
					} else {
						token = step(c, ASState.INVALID, false, Token.INVALID);
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
					token = step(c, ASState.N, true, Token.NAME); break;
				case '.':
					token = step(c, ASState.BIS1, true, Token.INVALID); break;
				default:
					if (('a'<=c && c<='z') || ('A'<=c && c<='Z')) {
						token = step(c, ASState.NAME, true, Token.NAME);
					} else {
						token = step(c, ASState.INVALID, true, Token.INVALID);
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
				case '.':
					int count =1;
					while (in.lookahead(count)=='.') { count++;}
					count--;
					if (count%2==0) {
						token = step(c, ASState.PUNKT, false, Token.BRUCH);
					} else if (in.lookahead(1)=='.') {
						token = step(c, ASState.BIS1, true, Token.INVALID);
					} else {
						token = step(c, ASState.PUNKT, false, Token.BRUCH);
					}
					break;
				default:
					if (('a'<=c && c<='z') || ('A'<=c && c<='Z')) {
						token = step(c, ASState.NAME, false, Token.NAME);
					} else {
						token = step(c, ASState.INVALID, true, Token.INVALID);
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
					token = step(c, ASState.NAME, false, Token.NAME); break;
				case '.':
					token = step(c, ASState.BIS1, true, Token.INVALID); break;
				default:
					if (('a'<=c && c<='z') || ('A'<=c && c<='Z')) {
						token = step(c, ASState.NAME, false, Token.NAME);
					} else {
						token = step(c, ASState.INVALID, true, Token.INVALID);
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
					token = step(c, ASState.NAME, false, Token.NAME); break;
				case 'u':
					token = step(c, ASState.U, false, Token.NAME); break;
				case '.':
					token = step(c, ASState.BIS1, true, Token.INVALID); break;
				default:
					if (('a'<=c && c<='z') || ('A'<=c && c<='Z')) {
						token = step(c, ASState.NAME, false, Token.NAME);
					} else {
						token = step(c, ASState.INVALID, true, Token.INVALID);
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
					token = step(c, ASState.NAME, false, Token.NAME); break;
				case 'l':
					token = step(c, ASState.L, false, Token.NAME); break;
				case '.':
					token = step(c, ASState.BIS1, true, Token.INVALID); break;
				default:
					if (('a'<=c && c<='z') || ('A'<=c && c<='Z')) {
						token = step(c, ASState.NAME, false, Token.NAME);
					} else {
						token = step(c, ASState.INVALID, true, Token.INVALID);
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
					token = step(c, ASState.NAME, false, Token.NAME); break;
				case 'l':
					token = step(c, ASState.NULL, false, Token.NULL); break;
				case '.':
					token = step(c, ASState.BIS1, true, Token.INVALID); break;
				default:
					if (('a'<=c && c<='z') || ('A'<=c && c<='Z')) {
						token = step(c, ASState.NAME, false, Token.NAME);
					} else {
						token = step(c, ASState.INVALID, true, Token.INVALID);
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
					token = step(c, ASState.NAME, false, Token.NAME); break;
				case '.':
					token = step(c, ASState.BIS1, true, Token.INVALID); break;
				default:
					if (('a'<=c && c<='z') || ('A'<=c && c<='Z')) {
						token = step(c, ASState.NAME, false, Token.NAME);
					} else {
						token = step(c, ASState.INVALID, true, Token.INVALID);
					}
					
				}
				break;
			case EOF:
				token = step(ignore, ASState.EOF, true, Token.EOF); break;
			case PUNKT:
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
					token = step(c, ASState.BRUCHTEIL, false, Token.BRUCH); break;
				case '^':
					token = step(c, ASState.HOCH, false, Token.INVALID); break;
				case '.':
					token = step(c, ASState.BIS1, true, Token.INVALID); break;
				default:
					if (('a'<=c && c<='z') || ('A'<=c && c<='Z')) {
						token = step(c, ASState.NAME, true, Token.NAME);
					} else {
						token = step(c, ASState.INVALID, true, Token.INVALID);
					}
				} 
				break;
			case BRUCHTEIL:
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
					token = step(c, ASState.BRUCHTEIL, false, Token.BRUCH); break;
				case '^':
					token = step(c, ASState.HOCH, false, Token.INVALID); break;
				case '.':
					token = step(c, ASState.BIS1, true, Token.INVALID); break;
				default:
					if (('a'<=c && c<='z') || ('A'<=c && c<='Z')) {
						token = step(c, ASState.NAME, true, Token.NAME);
					} else {
						token = step(c, ASState.INVALID, true, Token.INVALID);
					}
				} 
				break;
			case HOCH:
				switch(c) {
				case -1:
					throw new Exception("Unexpected end of file!"); 
				case '0': case '1': case '2': case '3': case '4':
				case '5': case '6': case '7': case '8': case '9':
					token = step(c, ASState.EXP, false, Token.BRUCH); break;
				default:
					token = step(c, ASState.INVALID, false, Token.INVALID);
				} 
				break;
			case EXP:
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
					token = step(c, ASState.EXP, false, Token.BRUCH); break;
				case '.':
					token = step(c, ASState.BIS1, true, Token.INVALID); break;
				default:
					if (('a'<=c && c<='z') || ('A'<=c && c<='Z')) {
						token = step(c, ASState.NAME, true, Token.NAME);
					} else {
						token = step(c, ASState.INVALID, true, Token.INVALID);
					}
				} 
				break;
			case BIS1:
				switch(c) {
				case -1:
					throw new Exception("Unexpected end of file!"); 
				case '.': 
					token = step(c, ASState.BIS2, false, Token.BIS); break;
				default:
					token = step(c, ASState.INVALID, true, Token.INVALID);
				} 
				break;
			case BIS2:
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
					token = step(c, ASState.N, true, Token.NAME); break;
				case '.':
					token = step(c, ASState.BIS1, true, Token.INVALID); break;
				default:
					if (('a'<=c && c<='z') || ('A'<=c && c<='Z')) {
						token = step(c, ASState.NAME, true, Token.NAME);
					} else {
						token = step(c, ASState.INVALID, true, Token.INVALID);
					}
					
				}
				break;
			default:
				throw new Exception("Unexpected state: "+state);
			}
		}
		return token;
	}

}
