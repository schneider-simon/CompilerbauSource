/* **********************************************
 * Duale Hochschule Baden-Württemberg Karlsruhe
 * Prof. Dr. Jörn Eisenbiegler
 * 
 * Vorlesung Übersetzerbau
 * Übungsbeispiel AS-Parser mit JFlex 1
 * 
 * **********************************************
 */

package dhbw.schneider.compilerbau.C_EigenerParser;

import java.io.IOException;
import java.util.ArrayList;

import de.dhbw.compiler.jflexxscanner.JFlexXScanner;
import de.dhbw.compiler.jflexxscanner.Token;


public class TokenReader {
	
	private ArrayList<Token> list = new ArrayList<Token>();
	private int tokenindex = 0;
	
	public TokenReader(JFlexXScanner s) throws IOException {
		Token mytoken;
		do {
			mytoken = s.nextToken();
			list.add(mytoken);
		} while(mytoken.getType()!=Token.EOF);
	}
	
	public Token nextToken() {
		return list.get(tokenindex++);
	}
	
	public int getPosition() {
		return tokenindex;
	}
	
	public void setPosition(int position) {
		tokenindex = position;
	}

}
