/* **********************************************
 * Duale Hochschule Baden-Württemberg Karlsruhe
 * Prof. Dr. Jörn Eisenbiegler
 * 
 * Vorlesung Übersetzerbau
 * Übungsbeispiel X-Parser mit JFlex
 * 
 * **********************************************
 */

package dhbw.schneider.compilerbau.C_EigenerParser;

import de.dhbw.compiler.jflexxscanner.SymbolTable;
import de.dhbw.compiler.jflexxscanner.Token;

public class InnerToken extends Token {
	
	public InnerToken(int type) {
		this.type = type;
	}
	
	public InnerToken(int type, int line, int column) {
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
