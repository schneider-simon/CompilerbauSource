package dhbw.schneider.compilerbau.C_EigenerParser;

import java.util.ArrayList;
import java.util.List;

import de.dhbw.compiler.jflexxscanner.Token;

public class Tree {
	
	private Token token = null;
	private ArrayList<Tree> children = null;
	
	public Tree(Token token) {
		this.token=token;
		this.children= new ArrayList<Tree>();
	}
	
	public Token getToken() {
		return token;
	}
	
	public void addChild(Tree child) {
		this.children.add(child);
	}
	
	public Tree getChild(int n) {
		return this.children.get(n);
	}
	
	public int getChildCount() {
		return this.children.size();
	}
	
	public List<Tree> getChildren() {
		return children;
	}
	
	public String toGraphvizDot() {
		StringBuffer dot = new StringBuffer();
		dot.append("digraph{ \n");
		this.appendNode(dot);
		this.appendEdges(dot);
		dot.append("}");
		return dot.toString();
	}
	
	private void appendNode(StringBuffer dot) {
		dot.append("n"+this.hashCode());
		dot.append(" [label=\""+token.getText()+"\"]\n");
		for (Tree c: children) {
			c.appendNode(dot);
		}
	}
	
	private void appendEdges(StringBuffer dot) {
		for (Tree c: children) {
			dot.append("n"+this.hashCode()+" -> n"+c.hashCode()+"\n");
		}
		for (Tree c: children) {
			c.appendEdges(dot);
		}
		
	}
	
	public String toString() {
		StringBuffer res = new StringBuffer(); 
		res.append("("+this.token.getText());
		for (Tree c: children) {
			res.append(" "+c.toString());
		}
		res.append(")");
		return res.toString();
		
	}

}
