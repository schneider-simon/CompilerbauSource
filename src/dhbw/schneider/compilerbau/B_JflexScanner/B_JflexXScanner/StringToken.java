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

public class StringToken extends Token {

	private String string;

	public StringToken(int type, String text) {
		this.type = type;
		this.string = text;
	}

	public StringToken(int type, String text, int line, int column) {
		this.type = type;
		this.string = text;
		this.line = line;
		this.column = column;
	}

	public String getText() {
		return string;
	}

	public String toString() {
		if (line != 0 || column != 0) {
			return "(" + SymbolTable.getInstance().get(type) + "," + string
					+ "," + line + "," + column + ")";
		} else {
			return "(" + SymbolTable.getInstance().get(type) + "," + string
					+ ")";
		}
	}
}
