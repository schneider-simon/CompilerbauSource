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

public class KeyWordToken extends Token {

	public KeyWordToken(int type) {
		this.type = type;
	}
	
	public KeyWordToken(int type, int line, int column) {
		this.type = type;
		this.line = line;
		this.column = column;
	}
	
	@Override
	public String toString() {
			if (line!=0 || column!=0) {
				return "(" +SymbolTable.getInstance().get(type) + ", - , " + line + "," + column + ")";
			} else {
				return "(" + SymbolTable.getInstance().get(type) + ", - )";
			}
		}
	

	@Override
	public String getText() {
		return SymbolTable.getInstance().get(type);
	}
	
}
