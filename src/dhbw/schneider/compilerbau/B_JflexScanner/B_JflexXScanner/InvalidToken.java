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

public class InvalidToken extends Token {

	public String text = null;

	public InvalidToken(int type, String text) {
		this.type = type;
		this.text = text;
	}

	public InvalidToken(int type, String text, int line, int column) {
		this.type = type;
		this.text = text;
		this.line = line;
		this.column = column;
	}

	public String getText() {
		return text;
	}

	public String toString() {
		if (line != 0 || column != 0) {
			return "(" + SymbolTable.getInstance().get(type) + "," + text + ","
					+ line + "," + column + ")";
		} else {
			return "(" + SymbolTable.getInstance().get(type) + "," + text + ")";
		}
	}
}
