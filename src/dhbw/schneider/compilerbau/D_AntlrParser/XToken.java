package dhbw.schneider.compilerbau.D_AntlrParser;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;

public class XToken extends CommonToken {

	private static final long serialVersionUID = 1L;
	
	public int intValue = 0;
	public double floatValue= 0.0;
	public String stringValue = "";

	public XToken(int type) {
		super(type);
	}

	public XToken(Token oldToken) {
		super(oldToken);
	}

	public XToken(int type, String text) {
		super(type, text);
	}

	public XToken(CharStream input, int type, int channel, int start, int stop) {
		super(input, type, channel, start, stop);
	}

}
