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

public class ZahlToken extends Token {

	public int value;

	public ZahlToken(int type, int value) {
		this.type = type;
		this.value = value;
	}

	public ZahlToken(int type, int value, int line, int column) {
		this.type = type;
		this.value = value;
		this.line = line;
		this.column = column;
	}

	public String getText() {
		return Integer.toString(value);
	}

	public int getValue() {
		return value;
	}

	public String toString() {
		if (line != 0 || column != 0) {
			return "(" + SymbolTable.getInstance().get(type) + "," + value
					+ "," + line + "," + column + ")";
		} else {
			return "(" + SymbolTable.getInstance().get(type) + "," + value
					+ ")";
		}
	}
}
