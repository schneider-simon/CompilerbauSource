package dhbw.schneider.compilerbau.F_ZielsprachenKonverter;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;


public class XTree extends CommonTree {
	
	public static final int NOTYPE = 0;
	public static final int INVALIDTYPE = 1;
	public static final int INTTYPE = 2;
	public static final int FLOATTYPE = 3;
	public static final int STRINGTYPE = 4;
	
	public int exprType = NOTYPE;
	
	public XTree() {
		super();
	};

	public XTree(Token t) {
		super(t);
	}
	
	public XTree(int type, String stringValue) {
		super();
		token = new XToken(type, stringValue);
		((XToken)token).stringValue = stringValue;
	}
	
	public XTree(int type, int intValue) {
		super();
		token = new XToken(type, Integer.toString(intValue));
		((XToken)token).intValue = intValue;
	}
	
	public XTree(int type, double floatValue) {
		super();
		token = new XToken(type, Double.toString(floatValue));
		((XToken)token).floatValue = floatValue;
	}
	
	@Override
	public XToken getToken() {
		return (XToken)this.token;
	}
	
	public String getExprTypeString() {
		switch (exprType) {
		case INVALIDTYPE: return "invalid";
		case INTTYPE: return "int";
		case FLOATTYPE: return "float";
		case STRINGTYPE: return "string";
		default: return "";
		}
	}
	
	@Override
	public String toString() {
		String s = super.toString();
		if (exprType!=0) {
			s+="<"+getExprTypeString()+">";
		}
		return s;
	}

}
