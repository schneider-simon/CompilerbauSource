/* **********************************************
 * Duale Hochschule Baden-W�rttemberg Karlsruhe
 * Prof. Dr. J�rn Eisenbiegler
 * 
 * Vorlesung �bersetzerbau
 * �bungsbeispiel X-SCanner mit JFlex
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
