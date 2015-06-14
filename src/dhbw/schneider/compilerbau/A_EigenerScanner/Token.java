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

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public abstract class Token {

	public static final int EOF = 0;
	public static final int INVALID = 1;
	public static final int LSBR = 2;
	public static final int RSBR = 3;
	public static final int COMMA = 4;
	public static final int ZAHL = 5;
	public static final int NAME = 6;
	public static final int NULL = 7;
	public static final int BRUCH = 8;
	public static final int BIS = 9;
	public static final int AS = 10;
	public static final int LISTE = 11;
	public static final int WEITERE = 12;
	public static final int ELEMENT = 13;
	public static final int BEREICH = 14;


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
