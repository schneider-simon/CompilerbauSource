/* **********************************************
 * Duale Hochschule Baden-Württemberg Karlsruhe
 * Prof. Dr. Jörn Eisenbiegler
 * 
 * Vorlesung Übersetzerbau
 * Übungsbeispiel X-SCanner mit JFlex
 * 
 * **********************************************
 */

package dhbw.schneider.compilerbau.B_JflexScanner.B_JflexXScanner;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public abstract class Token {

	public static final int EOF = 0;
	public static final int INVALID = 1;
	public static final int LBR = 2;
	public static final int RBR = 3;
	public static final int COMMA = 4;
	public static final int INTCONST = 5;
	public static final int ID = 6;
	public static final int FLOATCONST = 8;
	public static final int STRINGCONST = 9;
	public static final int READ = 10;
	public static final int PRINT = 11;
	public static final int INT = 12;
	public static final int FLOAT = 13;
	public static final int STRING = 14;
	public static final int PLUS = 15;
	public static final int MINUS = 16;
	public static final int MULT = 17;
	public static final int DIV = 18;
	public static final int ASSIGN = 19;
	public static final int LESS = 20;
	public static final int MORE = 21;
	public static final int EQUALS = 22;
	public static final int IF = 23;
	public static final int THEN = 24;
	public static final int ELSE = 25;
	public static final int WHILE = 26;
	public static final int FOR = 27;
	public static final int SEMICOLON = 28;
	public static final int BEGIN = 29;
	public static final int END = 30;
	public static final int PROGRAM = 31;
	public static final int DOT = 32;
	public static final int COLON = 33;
	public static final int TYPE = 34;
	public static final int MODIFIER = 35;
	public static final int DECL = 36;
	public static final int EXPR3 = 37;
	public static final int EXPR2 = 38;
	public static final int EXPR = 39;
	public static final int ASSIGNSTAT = 40;
	public static final int FORSTAT = 41;
	public static final int WHILESTAT = 42;
	public static final int CONDSTAT = 43;
	public static final int BLOCK = 44;
	public static final int STAT = 45;
	public static final int COND = 46;
	public static final int STATLIST = 47;
	public static final int STATWITHSEMI = 48;
	public static final int DECLLIST = 49;
	public static final int APROGRAM = 50;
	public static final int BRACKETS = 51;


	static {
		SymbolTable symbols = SymbolTable.getInstance();
		try {
			// symbols.add("EOF", Token.EOF);
			// ...
			
			for (Field field : Token.class.getDeclaredFields()) {
				if (Modifier.isStatic(field.getModifiers())
						&& field.getType().equals(int.class)) {
					
					symbols.add(field.getName(), field.getInt(field));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected int type;
	protected int line = 0;
	protected int column = 0;
	
	public static String getSymbol(int type) {
		return SymbolTable.getInstance().get(type);
	}

	public int getType() {
		return type;
	}

	public abstract String getText();

	public abstract String toString(); /* --- */

	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}

}
