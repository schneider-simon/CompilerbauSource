/* **********************************************
 * Duale Hochschule Baden-Württemberg Karlsruhe
 * Prof. Dr. Jörn Eisenbiegler
 * 
 * Vorlesung Übersetzerbau
 * Übungsbeispiel AS-Scanner 1
 * 
 * **********************************************
 */

package dhbw.schneider.compilerbau.A_EigenerScanner;

public class Token {
	
	public static final int EOF = 0;
	public static final int INVALID = -1;
	public static final int LSBR = 1;
	public static final int RSBR = 2;
	public static final int COMMA = 3;
	public static final int ZAHL = 4;
	public static final int ID = 5;
	public static final int NULL = 6;
	
	private int type;
	private String text;
	
	public Token(int type, String text) {
		this.type = type;
		this.text = text;
	}
	
	public int getType() {
		return type;
	}

	public String getText() {
		return text;
	}

	public String toString() {
		return "(" + type + "," + text + ")";
	}

}
