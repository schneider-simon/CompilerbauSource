package dhbw.schneider.compilerbau.D_AntlrParser;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;

public class XTokenStream extends CommonTokenStream {
		
	public XTokenStream() {
		super();
	}

	public XTokenStream(TokenSource tokenSource, int channel) {
		super(tokenSource, channel);
	}

	public XTokenStream(TokenSource tokenSource) {
		super(tokenSource);
	}

	@Override
	public Token LT(int k) {
		Token t = super.LT(k);
		if (t.getType()==Token.EOF) {
			t = new XToken(Token.EOF);
		}
		return t;
	}

}
