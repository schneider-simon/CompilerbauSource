/* **********************************************
 * Duale Hochschule Baden-Württemberg Karlsruhe
 * Prof. Dr. Jörn Eisenbiegler
 * 
 * Vorlesung Übersetzerbau
 * Übungsbeispiel AS-SCanner 5
 * 
 * **********************************************
 */

package dhbw.schneider.compilerbau.C_EigenerParser;

import java.io.FileInputStream;
import de.dhbw.compiler.jflexxscanner.JFlexXScanner;


public class XParserMain {
	
	public static void main(String[] args) throws Exception {
		
		JFlexXScanner lexer = new JFlexXScanner(new FileInputStream(args[0]));
		TokenReader reader = new TokenReader(lexer);
		XParser parser = new XParser(reader);
		
		Tree tree = parser.parseProgram();
		
		System.out.println(tree.toGraphvizDot());
		// System.err.println(parser.getComprecount()+" Token-Tests bei "+token.size()+" Token.");

	}

}
