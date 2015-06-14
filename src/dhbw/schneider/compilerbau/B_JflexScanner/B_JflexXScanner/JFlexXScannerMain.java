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

import java.io.FileInputStream;


public class JFlexXScannerMain {
	
	public static void main(String[] args) throws Exception {
		
		JFlexXScanner lexer = new JFlexXScanner(new FileInputStream(args[0]));
		
		Token mytoken = lexer.nextToken();
		
		while (mytoken.getType()!=Token.EOF) {
			System.out.println(mytoken);
			mytoken = lexer.nextToken();
		}

		System.out.println(mytoken);

	}

}
