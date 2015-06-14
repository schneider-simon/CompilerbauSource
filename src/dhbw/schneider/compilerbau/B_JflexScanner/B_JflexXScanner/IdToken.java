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

public class IdToken extends Token {

	private int symbol;

	public IdToken(int type, String text) {
		this.type = type;
		this.symbol = SymbolTable.getInstance().add(text);
	}

	public IdToken(int type, String text, int line, int column) {
		this.type = type;
		this.symbol = SymbolTable.getInstance().add(text);
		this.line = line;
		this.column = column;
	}

	public String getText() {
		return SymbolTable.getInstance().get(symbol);
	}

	public String toString() {
		if (line != 0 || column != 0) {
			return "(" + SymbolTable.getInstance().get(type) + "," + SymbolTable.getInstance().get(symbol)
					+ "," + line + "," + column + ")";
		} else {
			return "(" + SymbolTable.getInstance().get(type) + "," + SymbolTable.getInstance().get(symbol)
					+ ")";
		}
	}
}
