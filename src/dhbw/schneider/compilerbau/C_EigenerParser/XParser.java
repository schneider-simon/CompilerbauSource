package dhbw.schneider.compilerbau.C_EigenerParser;

import de.dhbw.compiler.jflexxscanner.Token;

public class XParser {

	private TokenReader in;
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
			return type;
		}
		in.setPosition(myPosition);

		// type ::= float.
		if (((type = parseToken(Token.FLOAT)) != null)) {
			return type;
		}
		in.setPosition(myPosition);

		// type ::= string.
		if (((type = parseToken(Token.STRING)) != null)) {
			return type;
		}
		in.setPosition(myPosition);

		// fail
		return null;
	}

	public Tree parseDecl() {
		int myPosition = in.getPosition();

		// decl ::= modifier id ":" type ";".
		Tree modifier, id, type;
		if (((modifier = parseModifier()) != null)
				&& ((id = parseToken(Token.ID)) != null)
				&& ((parseToken(Token.COLON)) != null)
				&& ((type = parseType()) != null)
				&& ((parseToken(Token.SEMICOLON)) != null)) {
			Tree tree = new Tree(new InnerToken(Token.DECL));
			tree.addChild(modifier);
			tree.addChild(id);
			tree.addChild(type);
			return tree;
		}
		in.setPosition(myPosition);

		// fail
		return null;
	}

	public Tree parseExpr3() {
		int myPosition = in.getPosition();
		Tree minus, number, id, expr;

		// expr3 ::= "-" int.
		if (((minus = parseToken(Token.MINUS)) != null)
				&& ((number = parseToken(Token.INTCONST)) != null)) {
			minus.addChild(number);
			return minus;
		}
		in.setPosition(myPosition);

		// expr3 ::= int.
		if (((number = parseToken(Token.INTCONST)) != null)) {
			return number;
		}
		in.setPosition(myPosition);

		// expr3 ::= "-" float.
		if (((minus = parseToken(Token.MINUS)) != null)
				&& ((number = parseToken(Token.FLOATCONST)) != null)) {
			minus.addChild(number);
			return minus;
		}
		in.setPosition(myPosition);

		// expr3 ::= float.
		if (((number = parseToken(Token.FLOATCONST)) != null)) {
			return number;
		}
		in.setPosition(myPosition);

		// expr3 ::= id.
		if (((id = parseToken(Token.ID)) != null)) {
			return id;
		}
		in.setPosition(myPosition);

		// expr3 ::= "(" expr ")".
		if (((parseToken(Token.LBR)) != null)
				&& ((expr = parseExpr()) != null)
				&& ((parseToken(Token.RBR)) != null)) {
			Tree tree = new Tree(new InnerToken(Token.BRACKETS));
			tree.addChild(expr);
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
			op.addChild(exprl);
			op.addChild(exprr);
			return op;
		}
		in.setPosition(myPosition);

		// expr2 ::= nexpr3 "/" expr2.
		if (((exprl = parseExpr3()) != null)
				&& ((op = parseToken(Token.DIV)) != null)
				&& ((exprr = parseExpr2()) != null)) {
			op.addChild(exprl);
			op.addChild(exprr);
			return op;
		}
		in.setPosition(myPosition);

		// expr2 ::= nexpr3.
		if (((exprl = parseExpr3()) != null)) {
			return exprl;
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
			op.addChild(exprl);
			op.addChild(exprr);
			return op;
		}
		in.setPosition(myPosition);

		// expr ::= nexpr2 "-" expr.
		if (((exprl = parseExpr2()) != null)
				&& ((op = parseToken(Token.MINUS)) != null)
				&& ((exprr = parseExpr()) != null)) {
			op.addChild(exprl);
			op.addChild(exprr);
			return op;
		}
		in.setPosition(myPosition);

		// expr ::= nexpr2.
		if (((exprl = parseExpr2()) != null)) {
			return exprl;
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
			assign.addChild(id);
			assign.addChild(expr);
			return assign;
		}
		in.setPosition(myPosition);

		// fail
		return null;
	}

	public Tree parseForStat() {
		int myPosition = in.getPosition();
		Tree tfor, init, cond, cont, stat;

		// forstat ::= for "(" assignstat cond ";" assignstat ")" stat.
		if (((tfor = parseToken(Token.FOR)) != null)
				&& ((parseToken(Token.LBR)) != null)
				&& ((init = parseAssignStat()) != null)
				&& ((parseToken(Token.SEMICOLON)) != null)
				&& ((cond = parseCond()) != null)
				&& ((parseToken(Token.SEMICOLON)) != null)
				&& ((cont = parseAssignStat()) != null)
				&& ((parseToken(Token.RBR)) != null)
				&& ((stat = parseStat()) != null)) {
			tfor.addChild(init);
			tfor.addChild(cond);
			tfor.addChild(cont);
			tfor.addChild(stat);
			return tfor;
		}
		in.setPosition(myPosition);

		// fail
		return null;
	}

	public Tree parseWhileStat() {
		int myPosition = in.getPosition();
		Tree twhile, cond, stat;

		// whilestat ::= while "(" cond ")" stat.
		if (((twhile = parseToken(Token.WHILE)) != null)
				&& ((parseToken(Token.LBR)) != null)
				&& ((cond = parseCond()) != null)
				&& ((parseToken(Token.RBR)) != null)
				&& ((stat = parseStat()) != null)) {
			twhile.addChild(cond);
			twhile.addChild(stat);
			return twhile;
		}
		in.setPosition(myPosition);

		// fail
		return null;
	}

	public Tree parseCondStat() {
		int myPosition = in.getPosition();
		Tree tif, cond, thenstat, elsestat;

		// condstat ::= if cond then stat else stat.
		if (((tif = parseToken(Token.IF)) != null)
				&& ((cond = parseCond()) != null)
				&& ((parseToken(Token.THEN)) != null)
				&& ((thenstat = parseStat()) != null)
				&& ((parseToken(Token.ELSE)) != null)
				&& ((elsestat = parseStat()) != null)) {
			tif.addChild(cond);
			tif.addChild(thenstat);
			tif.addChild(elsestat);
			return tif;
		}
		in.setPosition(myPosition);

		// condstat ::= if cond then stat.
		if (((tif = parseToken(Token.IF)) != null)
				&& ((cond = parseCond()) != null)
				&& ((parseToken(Token.THEN)) != null)
				&& ((thenstat = parseStat()) != null)) {
			tif.addChild(cond);
			tif.addChild(thenstat);
			return tif;
		}
		in.setPosition(myPosition);

		// fail
		return null;
	}

	public Tree parseCond() {
		int myPosition = in.getPosition();
		Tree left, comp, right;

		// cond ::= expr "<" expr.
		if (((left = parseExpr()) != null)
				&& ((comp = parseToken(Token.LESS)) != null)
				&& ((right = parseExpr()) != null)) {
			comp.addChild(left);
			comp.addChild(right);
			return comp;
		}
		in.setPosition(myPosition);

		// cond ::= expr ">" expr.
		if (((left = parseExpr()) != null)
				&& ((comp = parseToken(Token.MORE)) != null)
				&& ((right = parseExpr()) != null)) {
			comp.addChild(left);
			comp.addChild(right);
			return comp;
		}
		in.setPosition(myPosition);

		// cond ::= expr "=" expr.
		if (((left = parseExpr()) != null)
				&& ((comp = parseToken(Token.EQUALS)) != null)
				&& ((right = parseExpr()) != null)) {
			comp.addChild(left);
			comp.addChild(right);
			return comp;
		}
		in.setPosition(myPosition);

		// fail
		return null;
	}

	public Tree parseStat() {
		int myPosition = in.getPosition();
		Tree stat;

		// stat ::= assignstat.
		if (((stat = parseAssignStat()) != null)) {
			return stat;
		}
		in.setPosition(myPosition);

		// stat ::= condstat.
		if (((stat = parseCondStat()) != null)) {
			return stat;
		}
		in.setPosition(myPosition);

		// stat ::= whilestat.
		if (((stat = parseWhileStat()) != null)) {
			return stat;
		}
		in.setPosition(myPosition);

		// stat ::= forstat.
		if (((stat = parseForStat()) != null)) {
			return stat;
		}
		in.setPosition(myPosition);

		// stat ::= block.
		if (((stat = parseBlock()) != null)) {
			return stat;
		}
		in.setPosition(myPosition);

		// fail
		return null;
	}

	public Tree parseBlock() {
		int myPosition = in.getPosition();
		Tree statlist;

		// block ::= begin statlist end.
		if (((parseToken(Token.BEGIN)) != null)
				&& ((statlist = parseStatlist()) != null)
				&& ((parseToken(Token.END)) != null)) {
			return statlist;
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
		Tree stat;

		// statwithsemi ::= stat ";"
		if ((((stat = parseStat())) != null)
				&& ((parseToken(Token.SEMICOLON)) != null)) {
			return stat;
		}
		in.setPosition(myPosition);

		// fail
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
		Tree program, id, decllist, block;

		// program ::= program id ";" decllist block ".".
		if (((program = parseToken(Token.PROGRAM)) != null)
				&& (((id = parseToken(Token.ID))) != null)
				&& ((parseToken(Token.SEMICOLON)) != null)
				&& ((decllist = parseDecllist()) != null)
				&& ((block = parseBlock()) != null)
				&& ((parseToken(Token.DOT)) != null)) {
			program.addChild(id);
			program.addChild(decllist);
			program.addChild(block);
			return program;
		}
		in.setPosition(myPosition);

		// fail
		return null;
	}

}
