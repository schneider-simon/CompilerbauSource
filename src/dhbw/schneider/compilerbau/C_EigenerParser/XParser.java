package dhbw.schneider.compilerbau.C_EigenerParser;

import de.dhbw.compiler.jflexxscanner.Token;

public class XParser {

	TokenReader in = null;
	
	private long comparecount = 0;

	public XParser(TokenReader in) {
		this.in = in;
	}

	public Tree parseToken(int type) {
		comparecount++;
		int myPosition = in.getPosition();
		
		Token t = in.nextToken();
		if (t.getType() == type) {
			return new Tree(t);
		} else {
			in.setPosition(myPosition);
			return null;
		}
	}

	public long getComprecount() {
		return comparecount;
	}

	public Tree parsType() {
		int myPosition = in.getPosition();
		Tree type;

		// type ::= int | float | string.

		// type ::= int.
		if (((type = parseToken(Token.INT)) != null)) {
			Tree tree = new Tree(new InnerToken(Token.TYPE));
			tree.addChild(type);
			return tree;
		}
		in.setPosition(myPosition);

		// type ::= float.
		if (((type = parseToken(Token.FLOAT)) != null)) {
			Tree tree = new Tree(new InnerToken(Token.TYPE));
			tree.addChild(type);
			return tree;
		}
		in.setPosition(myPosition);

		// type ::= string.
		if (((type = parseToken(Token.STRING)) != null)) {
			Tree tree = new Tree(new InnerToken(Token.TYPE));
			tree.addChild(type);
			return tree;
		}

		// fail
		in.setPosition(myPosition);
		return null;
	}

	public Tree parseModifier() {
		int myPosition = in.getPosition();
		Tree read, print;

		// modifier ::= read print | read | print | .

		// modifier ::= read print.
		if (((read = parseToken(Token.READ)) != null)
				&& ((print = parseToken(Token.PRINT)) != null)) {
			Tree tree = new Tree(new InnerToken(Token.MODIFIER));
			tree.addChild(read);
			tree.addChild(print);
			return tree;
		}
		in.setPosition(myPosition);

		// modifier ::= read.
		if (((read = parseToken(Token.READ)) != null)) {
			Tree tree = new Tree(new InnerToken(Token.MODIFIER));
			tree.addChild(read);
			return tree;
		}
		in.setPosition(myPosition);

		// modifier ::= print.
		if (((print = parseToken(Token.PRINT)) != null)) {
			Tree tree = new Tree(new InnerToken(Token.MODIFIER));
			tree.addChild(print);
			return tree;
		}
		in.setPosition(myPosition);

		// modifier ::= .
		return new Tree(new InnerToken(Token.MODIFIER));
	}

	public Tree parseType() {
		int myPosition = in.getPosition();
		Tree type;

		// type ::= int.
		if (((type = parseToken(Token.INT)) != null)) {
			Tree tree = new Tree(new InnerToken(Token.TYPE));
			tree.addChild(type);
			return tree;
		}
		in.setPosition(myPosition);

		// type ::= float.
		if (((type = parseToken(Token.FLOAT)) != null)) {
			Tree tree = new Tree(new InnerToken(Token.TYPE));
			tree.addChild(type);
			return tree;
		}
		in.setPosition(myPosition);

		// type ::= string.
		if (((type = parseToken(Token.STRING)) != null)) {
			Tree tree = new Tree(new InnerToken(Token.TYPE));
			tree.addChild(type);
			return tree;
		}
		in.setPosition(myPosition);

		// fail
		return null;
	}

	public Tree parseDecl() {
		int myPosition = in.getPosition();

		// decl ::= modifier id ":" type ";".
		Tree modifier, id, colon, type, semicolon;
		if (((modifier = parseModifier()) != null)
				&& ((id = parseToken(Token.ID)) != null)
				&& ((colon = parseToken(Token.COLON)) != null)
				&& ((type = parseType()) != null)
				&& ((semicolon = parseToken(Token.SEMICOLON)) != null)) {
			Tree tree = new Tree(new InnerToken(Token.DECL));
			tree.addChild(modifier);
			tree.addChild(id);
			tree.addChild(colon);
			tree.addChild(type);
			tree.addChild(semicolon);
			return tree;
		}
		in.setPosition(myPosition);

		// fail
		return null;
	}

	public Tree parseExpr3() {
		int myPosition = in.getPosition();
		Tree minus, number, id, lbr, rbr, expr;

		// expr3 ::= "-" int.
		if (((minus = parseToken(Token.MINUS)) != null)
				&& ((number = parseToken(Token.INTCONST)) != null)) {
			Tree tree = new Tree(new InnerToken(Token.EXPR3));
			tree.addChild(minus);
			tree.addChild(number);
			return tree;
		}
		in.setPosition(myPosition);

		// expr3 ::= int.
		if (((number = parseToken(Token.INTCONST)) != null)) {
			Tree tree = new Tree(new InnerToken(Token.EXPR3));
			tree.addChild(number);
			return tree;
		}
		in.setPosition(myPosition);

		// expr3 ::= "-" float.
		if (((minus = parseToken(Token.MINUS)) != null)
				&& ((number = parseToken(Token.FLOATCONST)) != null)) {
			Tree tree = new Tree(new InnerToken(Token.EXPR3));
			tree.addChild(minus);
			tree.addChild(number);
			return tree;
		}
		in.setPosition(myPosition);

		// expr3 ::= float.
		if (((number = parseToken(Token.FLOATCONST)) != null)) {
			Tree tree = new Tree(new InnerToken(Token.EXPR3));
			tree.addChild(number);
			return tree;
		}
		in.setPosition(myPosition);

		// expr3 ::= id.
		if (((id = parseToken(Token.ID)) != null)) {
			Tree tree = new Tree(new InnerToken(Token.EXPR3));
			tree.addChild(id);
			return tree;
		}
		in.setPosition(myPosition);

		// expr3 ::= "(" expr ")".
		if (((lbr = parseToken(Token.LBR)) != null)
				&& ((expr = parseExpr()) != null)
				&& ((rbr = parseToken(Token.RBR)) != null)) {
			Tree tree = new Tree(new InnerToken(Token.EXPR3));
			tree.addChild(lbr);
			tree.addChild(expr);
			tree.addChild(rbr);
			return tree;
		}
		in.setPosition(myPosition);

		// expr3 ::= string.
		if (((number = parseToken(Token.STRINGCONST)) != null)) {
			Tree tree = new Tree(new InnerToken(Token.EXPR3));
			tree.addChild(number);
			return tree;
		}
		in.setPosition(myPosition);

		// fail
		return null;
	}

	public Tree parseExpr2() {
		int myPosition = in.getPosition();
		Tree exprl, op, exprr;

		// expr2 ::= nexpr3 "*" expr2.
		if (((exprl = parseExpr3()) != null)
				&& ((op = parseToken(Token.MULT)) != null)
				&& ((exprr = parseExpr2()) != null)) {
			Tree tree = new Tree(new InnerToken(Token.EXPR2));
			tree.addChild(exprl);
			tree.addChild(op);
			tree.addChild(exprr);
			return tree;
		}
		in.setPosition(myPosition);

		// expr2 ::= nexpr3 "/" expr2.
		if (((exprl = parseExpr3()) != null)
				&& ((op = parseToken(Token.DIV)) != null)
				&& ((exprr = parseExpr2()) != null)) {
			Tree tree = new Tree(new InnerToken(Token.EXPR2));
			tree.addChild(exprl);
			tree.addChild(op);
			tree.addChild(exprr);
			return tree;
		}
		in.setPosition(myPosition);

		// expr2 ::= nexpr3.
		if (((exprl = parseExpr3()) != null)) {
			Tree tree = new Tree(new InnerToken(Token.EXPR2));
			tree.addChild(exprl);
			return tree;
		}

		in.setPosition(myPosition);
		// fail
		return null;
	}

	public Tree parseExpr() {
		int myPosition = in.getPosition();
		Tree exprl, op, exprr;

		// expr ::= expr2 "+" expr.
		if (((exprl = parseExpr2()) != null)
				&& ((op = parseToken(Token.PLUS)) != null)
				&& ((exprr = parseExpr()) != null)) {
			Tree tree = new Tree(new InnerToken(Token.EXPR));
			tree.addChild(exprl);
			tree.addChild(op);
			tree.addChild(exprr);
			return tree;
		}
		in.setPosition(myPosition);

		// expr ::= nexpr2 "-" expr.
		if (((exprl = parseExpr2()) != null)
				&& ((op = parseToken(Token.MINUS)) != null)
				&& ((exprr = parseExpr()) != null)) {
			Tree tree = new Tree(new InnerToken(Token.EXPR));
			tree.addChild(exprl);
			tree.addChild(op);
			tree.addChild(exprr);
			return tree;
		}
		in.setPosition(myPosition);

		// expr ::= nexpr2.
		if (((exprl = parseExpr2()) != null)) {
			Tree tree = new Tree(new InnerToken(Token.EXPR));
			tree.addChild(exprl);
			return tree;
		}

		in.setPosition(myPosition);
		// fail
		return null;
	}

	public Tree parseAssignStat() {
		int myPosition = in.getPosition();
		Tree id, assign, expr;

		// assignStat ::= id ":=" expr ";".
		if (((id = parseToken(Token.ID)) != null)
				&& ((assign = parseToken(Token.ASSIGN)) != null)
				&& ((expr = parseExpr()) != null)) {
			Tree tree = new Tree(new InnerToken(Token.ASSIGNSTAT));
			tree.addChild(id);
			tree.addChild(assign);
			tree.addChild(expr);
			return tree;
		}
		in.setPosition(myPosition);

		// fail
		in.setPosition(myPosition);
		return null;
	}

	public Tree parseForStat() {
		int myPosition = in.getPosition();
		Tree tfor, lbr, init, cond, semicolon1, cont, semicolon2, rbr, stat;

		// forstat ::= for "(" assignstat cond ";" assignstat ")" stat.
		if (((tfor = parseToken(Token.FOR)) != null)
				&& ((lbr = parseToken(Token.LBR)) != null)
				&& ((init = parseAssignStat()) != null)
				&& ((semicolon1 = parseToken(Token.SEMICOLON)) != null)
				&& ((cond = parseCond()) != null)
				&& ((semicolon2 = parseToken(Token.SEMICOLON)) != null)
				&& ((cont = parseAssignStat()) != null)
				&& ((rbr = parseToken(Token.RBR)) != null)
				&& ((stat = parseStat()) != null)) {
			Tree tree = new Tree(new InnerToken(Token.FORSTAT));
			tree.addChild(tfor);
			tree.addChild(lbr);
			tree.addChild(init);
			tree.addChild(semicolon1);
			tree.addChild(cond);
			tree.addChild(semicolon2);
			tree.addChild(cont);
			tree.addChild(rbr);
			tree.addChild(stat);
			return tree;
		}
		in.setPosition(myPosition);

		// fail
		in.setPosition(myPosition);
		return null;
	}

	public Tree parseWhileStat() {
		int myPosition = in.getPosition();
		Tree twhile, lbr, cond, rbr, stat;

		// whilestat ::= while "(" cond ")" stat.
		if (((twhile = parseToken(Token.WHILE)) != null)
				&& ((lbr = parseToken(Token.LBR)) != null)
				&& ((cond = parseCond()) != null)
				&& ((rbr = parseToken(Token.RBR)) != null)
				&& ((stat = parseStat()) != null)) {
			Tree tree = new Tree(new InnerToken(Token.WHILESTAT));
			tree.addChild(twhile);
			tree.addChild(lbr);
			tree.addChild(cond);
			tree.addChild(rbr);
			tree.addChild(stat);
			return tree;
		}
		in.setPosition(myPosition);

		// fail
		in.setPosition(myPosition);
		return null;
	}

	public Tree parseCondStat() {
		int myPosition = in.getPosition();
		Tree tif, cond, tthen, thenstat, telse, elsestat;

		// condstat ::= if cond then stat else stat.
		if (((tif = parseToken(Token.IF)) != null)
				&& ((cond = parseCond()) != null)
				&& ((tthen = parseToken(Token.THEN)) != null)
				&& ((thenstat = parseStat()) != null)
				&& ((telse = parseToken(Token.ELSE)) != null)
				&& ((elsestat = parseStat()) != null)) {
			Tree tree = new Tree(new InnerToken(Token.CONDSTAT));
			tree.addChild(tif);
			tree.addChild(cond);
			tree.addChild(tthen);
			tree.addChild(thenstat);
			tree.addChild(telse);
			tree.addChild(elsestat);
			return tree;
		}
		in.setPosition(myPosition);

		// condstat ::= if cond then stat.
		if (((tif = parseToken(Token.IF)) != null)
				&& ((cond = parseCond()) != null)
				&& ((tthen = parseToken(Token.THEN)) != null)
				&& ((thenstat = parseStat()) != null)) {
			Tree tree = new Tree(new InnerToken(Token.CONDSTAT));
			tree.addChild(tif);
			tree.addChild(cond);
			tree.addChild(tthen);
			tree.addChild(thenstat);
			return tree;
		}
		in.setPosition(myPosition);

		// fail
		in.setPosition(myPosition);
		return null;
	}

	public Tree parseCond() {
		int myPosition = in.getPosition();
		Tree left, comp, right;

		// cond ::= expr "<" expr.
		if (((left = parseExpr()) != null)
				&& ((comp = parseToken(Token.LESS)) != null)
				&& ((right = parseExpr()) != null)) {
			Tree tree = new Tree(new InnerToken(Token.COND));
			tree.addChild(left);
			tree.addChild(comp);
			tree.addChild(right);
			return tree;
		}
		in.setPosition(myPosition);

		// cond ::= expr ">" expr.
		if (((left = parseExpr()) != null)
				&& ((comp = parseToken(Token.MORE)) != null)
				&& ((right = parseExpr()) != null)) {
			Tree tree = new Tree(new InnerToken(Token.COND));
			tree.addChild(left);
			tree.addChild(comp);
			tree.addChild(right);
			return tree;
		}
		in.setPosition(myPosition);

		// cond ::= expr "=" expr.
		if (((left = parseExpr()) != null)
				&& ((comp = parseToken(Token.EQUALS)) != null)
				&& ((right = parseExpr()) != null)) {
			Tree tree = new Tree(new InnerToken(Token.COND));
			tree.addChild(left);
			tree.addChild(comp);
			tree.addChild(right);
			return tree;
		}
		in.setPosition(myPosition);

		// fail
		in.setPosition(myPosition);
		return null;
	}

	public Tree parseStat() {
		int myPosition = in.getPosition();
		Tree stat;

		// stat ::= assignstat.
		if (((stat = parseAssignStat()) != null)) {
			Tree tree = new Tree(new InnerToken(Token.STAT));
			tree.addChild(stat);
			return tree;
		}
		in.setPosition(myPosition);

		// stat ::= condstat.
		if (((stat = parseCondStat()) != null)) {
			Tree tree = new Tree(new InnerToken(Token.STAT));
			tree.addChild(stat);
			return tree;
		}
		in.setPosition(myPosition);

		// stat ::= whilestat.
		if (((stat = parseWhileStat()) != null)) {
			Tree tree = new Tree(new InnerToken(Token.STAT));
			tree.addChild(stat);
			return tree;
		}
		in.setPosition(myPosition);

		// stat ::= forstat.
		if (((stat = parseForStat()) != null)) {
			Tree tree = new Tree(new InnerToken(Token.STAT));
			tree.addChild(stat);
			return tree;
		}
		in.setPosition(myPosition);

		// stat ::= block.
		if (((stat = parseBlock()) != null)) {
			Tree tree = new Tree(new InnerToken(Token.STAT));
			tree.addChild(stat);
			return tree;
		}
		in.setPosition(myPosition);

		// fail
		in.setPosition(myPosition);
		return null;
	}

	public Tree parseBlock() {
		int myPosition = in.getPosition();
		Tree tbegin, statlist, tend;

		// block ::= begin statlist end.
		if (((tbegin = parseToken(Token.BEGIN)) != null)
				&& ((statlist = parseStatlist()) != null)
				&& ((tend = parseToken(Token.END)) != null)) {
			Tree tree = new Tree(new InnerToken(Token.BLOCK));
			tree.addChild(tbegin);
			tree.addChild(statlist);
			tree.addChild(tend);
			return tree;
		}
		in.setPosition(myPosition);

		// fail
		in.setPosition(myPosition);
		return null;
	}

	public Tree parseStatlist() {
		Tree stat;

		Tree tree = new Tree(new InnerToken(Token.STATLIST));
		// statlist ::= { statwithsemi }.
		while (((stat = parseStatwithsemi())) != null) {
			tree.addChild(stat);
		}
		return tree;
	}

	public Tree parseStatwithsemi() {
		int myPosition = in.getPosition();
		Tree stat, semicolon;

		// statwithsemi ::= stat ";"
		if ((((stat = parseStat())) != null)
				&& ((semicolon = parseToken(Token.SEMICOLON)) != null)) {
			Tree tree = new Tree(new InnerToken(Token.STATWITHSEMI));
			tree.addChild(stat);
			tree.addChild(semicolon);
			return tree;
		}
		in.setPosition(myPosition);

		// fail
		in.setPosition(myPosition);
		return null;
	}

	public Tree parseDecllist() {
		Tree decl;

		Tree tree = new Tree(new InnerToken(Token.DECLLIST));
		// decllist ::= { decl }.
		while (((decl = parseDecl())) != null) {
			tree.addChild(decl);
		}
		return tree;
	}

	public Tree parseProgram() {
		int myPosition = in.getPosition();
		Tree program, id, semicolon, decllist, block, dot;

		// program ::= program id ";" decllist block ".".
		if (((program = parseToken(Token.PROGRAM)) != null)
				&& (((id = parseToken(Token.ID))) != null)
				&& ((semicolon = parseToken(Token.SEMICOLON)) != null)
				&& ((decllist = parseDecllist()) != null)
				&& ((block = parseBlock()) != null)
				&& ((dot = parseToken(Token.DOT)) != null)) {
			Tree tree = new Tree(new InnerToken(Token.APROGRAM));
			tree.addChild(program);
			tree.addChild(id);
			tree.addChild(semicolon);
			tree.addChild(decllist);
			tree.addChild(block);
			tree.addChild(dot);
			return tree;
		}
		in.setPosition(myPosition);

		// fail
		in.setPosition(myPosition);
		return null;
	}

}
