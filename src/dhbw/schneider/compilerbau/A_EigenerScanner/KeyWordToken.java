/* **********************************************
 * Duale Hochschule Baden-W�rttemberg Karlsruhe
 * Prof. Dr. J�rn Eisenbiegler
 * 
 * Vorlesung �bersetzerbau
 * �bungsbeispiel AS-SCanner 5
 * 
 * **********************************************
 */

package dhbw.schneider.compilerbau.A_EigenerScanner;

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
