/* **********************************************
 * Duale Hochschule Baden-W�rttemberg Karlsruhe
 * Prof. Dr. J�rn Eisenbiegler
 * 
 * Vorlesung �bersetzerbau
 * �bungsbeispiel AS-SCanner 3
 * 
 * **********************************************
 */

package dhbw.schneider.compilerbau.A_EigenerScanner;

import java.io.FileInputStream;


public class ASScannerMain {
	
	public static void main(String[] args) throws Exception {
		
		ASScanner lexer = new ASScanner(new FileInputStream(args[0]));
		
		Token mytoken = lexer.nextToken();
		
		while (mytoken.getType()!=Token.EOF) {
			System.out.println(mytoken);
			mytoken = lexer.nextToken();
		}

		System.out.println(mytoken);

	}

}
