/* **********************************************
 * Duale Hochschule Baden-W�rttemberg Karlsruhe
 * Prof. Dr. J�rn Eisenbiegler
 * 
 * Vorlesung �bersetzerbau
 * �bungsbeispiel AS-SCanner 1
 * 
 * **********************************************
 */

package dhbw.schneider.compilerbau.A_EigenerScanner;

import java.io.FileInputStream;


public class ASScannerMain {
	
	public static void main(String[] args) throws Exception {
		
		ASScanner lexer = new ASScanner(new FileInputStream(args[0]));
		
		int count =0;
		long t1 = System.currentTimeMillis();
		
		Token mytoken = lexer.nextToken();
		count++;
		
		while (mytoken.getType()!=Token.EOF) {
			System.out.println(mytoken);
			mytoken = lexer.nextToken();
			count++;
		}

		// System.out.println(mytoken);
		long t2 = System.currentTimeMillis();
		System.out.println(count + "Token");
		System.out.println((t2-t1) + "Millisekunden");
		
	}

}
