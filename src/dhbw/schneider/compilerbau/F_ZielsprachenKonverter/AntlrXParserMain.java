package dhbw.schneider.compilerbau.F_ZielsprachenKonverter;

import java.io.FileInputStream;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.TreeAdaptor;
import org.antlr.stringtemplate.StringTemplate;

import de.dhbw.compiler.help.Utils;

public class AntlrXParserMain {

	public static void main(String[] args) throws Exception {
		
		TreeAdaptor xtreeAdaptor = new XTreeAdaptor();
		
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(
				args[0]));
		AntlrXLexer lexer = new AntlrXLexer(input);
		
		CommonTokenStream tokens = new XTokenStream(lexer);
		
		AntlrXParser parser = new AntlrXParser(tokens);
		parser.setTreeAdaptor(xtreeAdaptor);

		System.out.println("PARSER");

		AntlrXParser.program_return result = parser.program();
		
		CommonTree tree = (CommonTree) result.getTree();
		
		System.out.println(tree.toStringTree());
		
		Utils.saveToGrapvizDOT(tree, args[0], "AST");
		
		System.out.println("TYPECHECK");

		TypeCheck check = new TypeCheck(new CommonTreeNodeStream(xtreeAdaptor,tree));
		check.setTreeAdaptor(xtreeAdaptor);
		
		tree = (XTree)check.program().getTree();

		Utils.saveToGrapvizDOT(tree, args[0], "CHECK");
				
		System.out.println(tree.toStringTree());
		
		System.out.println("OPTIMIZER");

		XOptimizer opt = new XOptimizer(new CommonTreeNodeStream(xtreeAdaptor,tree));
		opt.setTreeAdaptor(xtreeAdaptor);
		
		opt.downup(tree, true);

		Utils.saveToGrapvizDOT(tree, args[0], "OPT");
				
		System.out.println(tree.toStringTree());
		
		System.out.println("OUTPUT");
		
		XtoJava toJava = new XtoJava(new CommonTreeNodeStream(xtreeAdaptor,tree));
		
		StringTemplate template = (StringTemplate)toJava.program().getTemplate();
		
		
		Utils.saveToJavaFile(template, args[0]);
		System.out.println(template.toString());
		

	}
}
