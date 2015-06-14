package dhbw.schneider.compilerbau.D_AntlrParser;

import java.io.FileInputStream;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import de.dhbw.compiler.help.Utils;

public class AntlrXParserMain {

	public static void main(String[] args) throws Exception {
		
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(args[0]));
		
		AntlrXLexer lexer = new AntlrXLexer(input);
		
		CommonTokenStream tokens = new XTokenStream(lexer);
		
		AntlrXParser parser = new AntlrXParser(tokens);

		AntlrXParser.program_return result = parser.program();
		
		CommonTree tree = (CommonTree) result.getTree();
		
		System.out.println(tree.toStringTree());
		
		Utils.saveToGrapvizDOT(tree, args[0], "AST");
		
	}
}
