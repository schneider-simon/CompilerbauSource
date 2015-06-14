/* **********************************************
 * Duale Hochschule Baden-Württemberg Karlsruhe
 * Prof. Dr. Jörn Eisenbiegler
 * 
 * Vorlesung Übersetzerbau
 * Übungsbeispiel ASScanner mit JFlex 2
 * 
 * **********************************************
 */

package dhbw.schneider.compilerbau.B_JflexScanner.A_JFlexAssScanner;

import java.io.FileInputStream;

import de.dhbw.compiler.ASScanner5.Token;


public class JFlexASScannerMain {
	
	public static void main(String[] args) throws Exception {
		
		JFlexASScanner lexer = new JFlexASScanner(new FileInputStream(args[0]));
		
		Token mytoken = lexer.nextToken();
		
		while (mytoken.getType()!=Token.EOF) {
			System.out.println(mytoken);
			mytoken = lexer.nextToken();
		}

		System.out.println(mytoken);

	}

}
