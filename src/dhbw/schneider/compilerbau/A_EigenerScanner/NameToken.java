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

public class NameToken extends Token {

	private int symbol;

	public NameToken(int type, String text) {
		this.type = type;
		this.symbol = SymbolTable.getInstance().add(text);
	}

	public NameToken(int type, String text, int line, int column) {
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
