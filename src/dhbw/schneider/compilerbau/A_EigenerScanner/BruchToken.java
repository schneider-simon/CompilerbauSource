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

public class BruchToken extends Token {

	public double value;

	public BruchToken(int type, double value) {
		this.type = type;
		this.value = value;
	}

	public BruchToken(int type, double value, int line, int column) {
		this.type = type;
		this.value = value;
		this.line = line;
		this.column = column;
	}

	public String getText() {
		return Double.toString(value);
	}

	public double getValue() {
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
