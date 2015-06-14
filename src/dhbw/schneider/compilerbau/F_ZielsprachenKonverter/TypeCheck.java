// $ANTLR 3.5.2 C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g 2015-06-07 21:58:06

    package dhbw.schneider.compilerbau.F_ZielsprachenKonverter;
    
    import java.util.HashMap;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


@SuppressWarnings("all")
public class TypeCheck extends TreeParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "BLOCK", "COMMENT", "DECLARE", 
		"DIGIT", "FLOAT", "ID", "INT", "INVALID", "LETTER", "NUMBER", "OTHER", 
		"POSDIGIT", "STRING", "UMINUS", "WS", "ZERO", "'('", "')'", "'*'", "'+'", 
		"'-'", "'.'", "'/'", "':'", "':='", "';'", "'<'", "'='", "'>'", "'begin'", 
		"'else'", "'end'", "'float'", "'for'", "'if'", "'int'", "'print'", "'program'", 
		"'read'", "'string'", "'then'", "'while'", "IDA", "ITOF"
	};
	public static final int EOF=-1;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int T__37=37;
	public static final int T__38=38;
	public static final int T__39=39;
	public static final int T__40=40;
	public static final int T__41=41;
	public static final int T__42=42;
	public static final int T__43=43;
	public static final int T__44=44;
	public static final int T__45=45;
	public static final int BLOCK=4;
	public static final int COMMENT=5;
	public static final int DECLARE=6;
	public static final int DIGIT=7;
	public static final int FLOAT=8;
	public static final int ID=9;
	public static final int INT=10;
	public static final int INVALID=11;
	public static final int LETTER=12;
	public static final int NUMBER=13;
	public static final int OTHER=14;
	public static final int POSDIGIT=15;
	public static final int STRING=16;
	public static final int UMINUS=17;
	public static final int WS=18;
	public static final int ZERO=19;
	public static final int IDA=46;
	public static final int ITOF=47;
	public static final int PLUS=23;

	// delegates
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public TypeCheck(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public TypeCheck(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return TypeCheck.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g"; }



	    private HashMap<String, Integer>  varTypes = new HashMap<String, Integer>();



	public static class decl_return extends TreeRuleReturnScope {
		XTree tree;
		@Override
		public XTree getTree() { return tree; }
	};


	// $ANTLR start "decl"
	// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:32:1: decl : ( ^( DECLARE ID 'int' ( . )* ) | ^( DECLARE ID 'float' ( . )* ) | ^( DECLARE ID 'string' ( . )* ) );
	public final decl_return decl() throws RecognitionException {
		decl_return retval = new decl_return();
		retval.start = input.LT(1);

		XTree root_0 = null;

		XTree _first_0 = null;
		XTree _last = null;


		XTree DECLARE1=null;
		XTree ID2=null;
		XTree string_literal3=null;
		XTree wildcard4=null;
		XTree DECLARE5=null;
		XTree ID6=null;
		XTree string_literal7=null;
		XTree wildcard8=null;
		XTree DECLARE9=null;
		XTree ID10=null;
		XTree string_literal11=null;
		XTree wildcard12=null;

		XTree DECLARE1_tree=null;
		XTree ID2_tree=null;
		XTree string_literal3_tree=null;
		XTree wildcard4_tree=null;
		XTree DECLARE5_tree=null;
		XTree ID6_tree=null;
		XTree string_literal7_tree=null;
		XTree wildcard8_tree=null;
		XTree DECLARE9_tree=null;
		XTree ID10_tree=null;
		XTree string_literal11_tree=null;
		XTree wildcard12_tree=null;

		try {
			// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:32:5: ( ^( DECLARE ID 'int' ( . )* ) | ^( DECLARE ID 'float' ( . )* ) | ^( DECLARE ID 'string' ( . )* ) )
			int alt4=3;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==DECLARE) ) {
				int LA4_1 = input.LA(2);
				if ( (LA4_1==DOWN) ) {
					int LA4_2 = input.LA(3);
					if ( (LA4_2==ID) ) {
						switch ( input.LA(4) ) {
						case 39:
							{
							alt4=1;
							}
							break;
						case 36:
							{
							alt4=2;
							}
							break;
						case 43:
							{
							alt4=3;
							}
							break;
						default:
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 4, 3, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 4, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 4, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:32:13: ^( DECLARE ID 'int' ( . )* )
					{
					_last = (XTree)input.LT(1);
					{
					XTree _save_last_1 = _last;
					XTree _first_1 = null;
					_last = (XTree)input.LT(1);
					DECLARE1=(XTree)match(input,DECLARE,FOLLOW_DECLARE_in_decl111); 

					if ( _first_0==null ) _first_0 = DECLARE1;
					match(input, Token.DOWN, null); 
					_last = (XTree)input.LT(1);
					ID2=(XTree)match(input,ID,FOLLOW_ID_in_decl113); 
					 
					if ( _first_1==null ) _first_1 = ID2;

					_last = (XTree)input.LT(1);
					string_literal3=(XTree)match(input,39,FOLLOW_39_in_decl115); 
					 
					if ( _first_1==null ) _first_1 = string_literal3;

					// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:32:32: ( . )*
					loop1:
					while (true) {
						int alt1=2;
						int LA1_0 = input.LA(1);
						if ( ((LA1_0 >= BLOCK && LA1_0 <= ITOF)) ) {
							alt1=1;
						}
						else if ( (LA1_0==UP) ) {
							alt1=2;
						}

						switch (alt1) {
						case 1 :
							// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:32:32: .
							{
							_last = (XTree)input.LT(1);
							wildcard4=(XTree)input.LT(1);
							matchAny(input); 
							 
							if ( _first_1==null ) _first_1 = wildcard4;

							retval.tree = _first_0;
							if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
								retval.tree = (XTree)adaptor.getParent(retval.tree);

							}
							break;

						default :
							break loop1;
						}
					}

					match(input, Token.UP, null); 
					_last = _save_last_1;
					}


					 varTypes.put((ID2!=null?ID2.getText():null), XTree.INTTYPE); 
					retval.tree = _first_0;
					if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
						retval.tree = (XTree)adaptor.getParent(retval.tree);

					}
					break;
				case 2 :
					// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:33:13: ^( DECLARE ID 'float' ( . )* )
					{
					_last = (XTree)input.LT(1);
					{
					XTree _save_last_1 = _last;
					XTree _first_1 = null;
					_last = (XTree)input.LT(1);
					DECLARE5=(XTree)match(input,DECLARE,FOLLOW_DECLARE_in_decl138); 

					if ( _first_0==null ) _first_0 = DECLARE5;
					match(input, Token.DOWN, null); 
					_last = (XTree)input.LT(1);
					ID6=(XTree)match(input,ID,FOLLOW_ID_in_decl140); 
					 
					if ( _first_1==null ) _first_1 = ID6;

					_last = (XTree)input.LT(1);
					string_literal7=(XTree)match(input,36,FOLLOW_36_in_decl142); 
					 
					if ( _first_1==null ) _first_1 = string_literal7;

					// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:33:34: ( . )*
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( ((LA2_0 >= BLOCK && LA2_0 <= ITOF)) ) {
							alt2=1;
						}
						else if ( (LA2_0==UP) ) {
							alt2=2;
						}

						switch (alt2) {
						case 1 :
							// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:33:34: .
							{
							_last = (XTree)input.LT(1);
							wildcard8=(XTree)input.LT(1);
							matchAny(input); 
							 
							if ( _first_1==null ) _first_1 = wildcard8;

							retval.tree = _first_0;
							if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
								retval.tree = (XTree)adaptor.getParent(retval.tree);

							}
							break;

						default :
							break loop2;
						}
					}

					match(input, Token.UP, null); 
					_last = _save_last_1;
					}


					 varTypes.put((ID6!=null?ID6.getText():null), XTree.FLOATTYPE); 
					retval.tree = _first_0;
					if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
						retval.tree = (XTree)adaptor.getParent(retval.tree);

					}
					break;
				case 3 :
					// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:34:14: ^( DECLARE ID 'string' ( . )* )
					{
					_last = (XTree)input.LT(1);
					{
					XTree _save_last_1 = _last;
					XTree _first_1 = null;
					_last = (XTree)input.LT(1);
					DECLARE9=(XTree)match(input,DECLARE,FOLLOW_DECLARE_in_decl165); 

					if ( _first_0==null ) _first_0 = DECLARE9;
					match(input, Token.DOWN, null); 
					_last = (XTree)input.LT(1);
					ID10=(XTree)match(input,ID,FOLLOW_ID_in_decl167); 
					 
					if ( _first_1==null ) _first_1 = ID10;

					_last = (XTree)input.LT(1);
					string_literal11=(XTree)match(input,43,FOLLOW_43_in_decl169); 
					 
					if ( _first_1==null ) _first_1 = string_literal11;

					// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:34:36: ( . )*
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( ((LA3_0 >= BLOCK && LA3_0 <= ITOF)) ) {
							alt3=1;
						}
						else if ( (LA3_0==UP) ) {
							alt3=2;
						}

						switch (alt3) {
						case 1 :
							// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:34:36: .
							{
							_last = (XTree)input.LT(1);
							wildcard12=(XTree)input.LT(1);
							matchAny(input); 
							 
							if ( _first_1==null ) _first_1 = wildcard12;

							retval.tree = _first_0;
							if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
								retval.tree = (XTree)adaptor.getParent(retval.tree);

							}
							break;

						default :
							break loop3;
						}
					}

					match(input, Token.UP, null); 
					_last = _save_last_1;
					}


					 varTypes.put((ID10!=null?ID10.getText():null), XTree.STRINGTYPE); 
					retval.tree = _first_0;
					if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
						retval.tree = (XTree)adaptor.getParent(retval.tree);

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "decl"


	public static class expr_return extends TreeRuleReturnScope {
		XTree tree;
		@Override
		public XTree getTree() { return tree; }
	};


	// $ANTLR start "expr"
	// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:37:1: expr : ( ^(u= UMINUS x= expr ) | ^( (op= '+' |op= '-' |op= '/' |op= '*' |op= '<' |op= '>' |op= '=' ) l= expr r= expr ) -> {$l.start.exprType == XTree.INTTYPE && $r.start.exprType == XTree.FLOATTYPE}? ^( $op ^( ITOF $l) $r) -> {$l.start.exprType == XTree.FLOATTYPE && $r.start.exprType == XTree.INTTYPE}? ^( $op $l ^( ITOF $r) ) -> ^( $op $l $r) |i= INT |f= FLOAT |s= STRING |v= ID );
	public final expr_return expr() throws RecognitionException {
		expr_return retval = new expr_return();
		retval.start = input.LT(1);

		XTree root_0 = null;

		XTree _first_0 = null;
		XTree _last = null;


		XTree u=null;
		XTree op=null;
		XTree i=null;
		XTree f=null;
		XTree s=null;
		XTree v=null;
		TreeRuleReturnScope x =null;
		TreeRuleReturnScope l =null;
		TreeRuleReturnScope r =null;

		XTree u_tree=null;
		XTree op_tree=null;
		XTree i_tree=null;
		XTree f_tree=null;
		XTree s_tree=null;
		XTree v_tree=null;
		RewriteRuleNodeStream stream_22=new RewriteRuleNodeStream(adaptor,"token 22");
		RewriteRuleNodeStream stream_23=new RewriteRuleNodeStream(adaptor,"token 23");
		RewriteRuleNodeStream stream_24=new RewriteRuleNodeStream(adaptor,"token 24");
		RewriteRuleNodeStream stream_26=new RewriteRuleNodeStream(adaptor,"token 26");
		RewriteRuleNodeStream stream_30=new RewriteRuleNodeStream(adaptor,"token 30");
		RewriteRuleNodeStream stream_31=new RewriteRuleNodeStream(adaptor,"token 31");
		RewriteRuleNodeStream stream_32=new RewriteRuleNodeStream(adaptor,"token 32");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:37:5: ( ^(u= UMINUS x= expr ) | ^( (op= '+' |op= '-' |op= '/' |op= '*' |op= '<' |op= '>' |op= '=' ) l= expr r= expr ) -> {$l.start.exprType == XTree.INTTYPE && $r.start.exprType == XTree.FLOATTYPE}? ^( $op ^( ITOF $l) $r) -> {$l.start.exprType == XTree.FLOATTYPE && $r.start.exprType == XTree.INTTYPE}? ^( $op $l ^( ITOF $r) ) -> ^( $op $l $r) |i= INT |f= FLOAT |s= STRING |v= ID )
			int alt6=6;
			switch ( input.LA(1) ) {
			case UMINUS:
				{
				alt6=1;
				}
				break;
			case 22:
			case 23:
			case 24:
			case 26:
			case 30:
			case 31:
			case 32:
				{
				alt6=2;
				}
				break;
			case INT:
				{
				alt6=3;
				}
				break;
			case FLOAT:
				{
				alt6=4;
				}
				break;
			case STRING:
				{
				alt6=5;
				}
				break;
			case ID:
				{
				alt6=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}
			switch (alt6) {
				case 1 :
					// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:38:13: ^(u= UMINUS x= expr )
					{
					_last = (XTree)input.LT(1);
					{
					XTree _save_last_1 = _last;
					XTree _first_1 = null;
					_last = (XTree)input.LT(1);
					u=(XTree)match(input,UMINUS,FOLLOW_UMINUS_in_expr206); 

					if ( _first_0==null ) _first_0 = u;
					match(input, Token.DOWN, null); 
					_last = (XTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_expr210);
					x=expr();
					state._fsp--;

					 
					if ( _first_1==null ) _first_1 = (XTree)x.getTree();

					match(input, Token.UP, null); 
					_last = _save_last_1;
					}


					 if ((x!=null?((XTree)x.start):null).exprType == XTree.STRINGTYPE) {
					                  System.err.println("Error at "+(op!=null?op.getLine():0)+","+op.getCharPositionInLine()+": Operand '-' is not valid for string operands.");
					                } else {  
					                  u.exprType=(x!=null?((XTree)x.start):null).exprType; 
					                }
					              
					retval.tree = _first_0;
					if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
						retval.tree = (XTree)adaptor.getParent(retval.tree);

					}
					break;
				case 2 :
					// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:45:13: ^( (op= '+' |op= '-' |op= '/' |op= '*' |op= '<' |op= '>' |op= '=' ) l= expr r= expr )
					{
					_last = (XTree)input.LT(1);
					{
					XTree _save_last_1 = _last;
					XTree _first_1 = null;
					// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:45:15: (op= '+' |op= '-' |op= '/' |op= '*' |op= '<' |op= '>' |op= '=' )
					int alt5=7;
					switch ( input.LA(1) ) {
					case 23:
						{
						alt5=1;
						}
						break;
					case 24:
						{
						alt5=2;
						}
						break;
					case 26:
						{
						alt5=3;
						}
						break;
					case 22:
						{
						alt5=4;
						}
						break;
					case 30:
						{
						alt5=5;
						}
						break;
					case 32:
						{
						alt5=6;
						}
						break;
					case 31:
						{
						alt5=7;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 5, 0, input);
						throw nvae;
					}
					switch (alt5) {
						case 1 :
							// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:45:16: op= '+'
							{
							_last = (XTree)input.LT(1);
							op=(XTree)match(input,23,FOLLOW_23_in_expr246); 
							 
							stream_23.add(op);

							retval.tree = _first_0;
							if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
								retval.tree = (XTree)adaptor.getParent(retval.tree);

							}
							break;
						case 2 :
							// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:45:25: op= '-'
							{
							_last = (XTree)input.LT(1);
							op=(XTree)match(input,24,FOLLOW_24_in_expr252); 
							 
							stream_24.add(op);

							retval.tree = _first_0;
							if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
								retval.tree = (XTree)adaptor.getParent(retval.tree);

							}
							break;
						case 3 :
							// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:45:34: op= '/'
							{
							_last = (XTree)input.LT(1);
							op=(XTree)match(input,26,FOLLOW_26_in_expr258); 
							 
							stream_26.add(op);

							retval.tree = _first_0;
							if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
								retval.tree = (XTree)adaptor.getParent(retval.tree);

							}
							break;
						case 4 :
							// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:45:43: op= '*'
							{
							_last = (XTree)input.LT(1);
							op=(XTree)match(input,22,FOLLOW_22_in_expr264); 
							 
							stream_22.add(op);

							retval.tree = _first_0;
							if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
								retval.tree = (XTree)adaptor.getParent(retval.tree);

							}
							break;
						case 5 :
							// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:45:52: op= '<'
							{
							_last = (XTree)input.LT(1);
							op=(XTree)match(input,30,FOLLOW_30_in_expr270); 
							 
							stream_30.add(op);

							retval.tree = _first_0;
							if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
								retval.tree = (XTree)adaptor.getParent(retval.tree);

							}
							break;
						case 6 :
							// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:45:61: op= '>'
							{
							_last = (XTree)input.LT(1);
							op=(XTree)match(input,32,FOLLOW_32_in_expr276); 
							 
							stream_32.add(op);

							retval.tree = _first_0;
							if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
								retval.tree = (XTree)adaptor.getParent(retval.tree);

							}
							break;
						case 7 :
							// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:45:70: op= '='
							{
							_last = (XTree)input.LT(1);
							op=(XTree)match(input,31,FOLLOW_31_in_expr282); 
							 
							stream_31.add(op);

							retval.tree = _first_0;
							if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
								retval.tree = (XTree)adaptor.getParent(retval.tree);

							}
							break;

					}

					match(input, Token.DOWN, null); 
					_last = (XTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_expr287);
					l=expr();
					state._fsp--;

					stream_expr.add(l.getTree());
					_last = (XTree)input.LT(1);
					pushFollow(FOLLOW_expr_in_expr291);
					r=expr();
					state._fsp--;

					stream_expr.add(r.getTree());
					match(input, Token.UP, null); 
					_last = _save_last_1;
					}


					 if ((l!=null?((XTree)l.start):null).exprType == XTree.STRINGTYPE || (r!=null?((XTree)r.start):null).exprType == XTree.STRINGTYPE) {
					                  if ((l!=null?((XTree)l.start):null).exprType ==  (r!=null?((XTree)r.start):null).exprType) {
					                     if ((op!=null?op.getType():0) == PLUS) {
					                        // Beide String und op ist +
					                        op.exprType=XTree.STRINGTYPE;
					                     } else {
					                        // Beide String aber op kein +
					                        op.exprType=XTree.INVALIDTYPE;
					                        System.err.println("Error at "+(op!=null?op.getLine():0)+","+op.getCharPositionInLine()+": "+(op!=null?op.getText():null)+" ("+op.token.getType()+") is not valid for string operands.");
					                     }
					                  } else {
					                    // Einer von beiden kein String
					                    op.exprType=XTree.INVALIDTYPE;
					                    System.err.println("Error at "+(op!=null?op.getLine():0)+","+op.getCharPositionInLine()+": A string operand cannot be combined with a non-string operand.");
					                  }
					                } else if ((l!=null?((XTree)l.start):null).exprType == (r!=null?((XTree)r.start):null).exprType) { 
					                   // Typen gleich
					                   op.exprType=(l!=null?((XTree)l.start):null).exprType; 
					                } else {
					                   // Typen ungleich aber kein String
					                   op.exprType=XTree.FLOATTYPE; 
					                }
					              
					// AST REWRITE
					// elements: op, op, r, r, r, l, l, l, op
					// token labels: op
					// rule labels: r, l, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleNodeStream stream_op=new RewriteRuleNodeStream(adaptor,"token op",op);
					RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"rule r",r!=null?r.getTree():null);
					RewriteRuleSubtreeStream stream_l=new RewriteRuleSubtreeStream(adaptor,"rule l",l!=null?l.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (XTree)adaptor.nil();
					// 71:15: -> {$l.start.exprType == XTree.INTTYPE && $r.start.exprType == XTree.FLOATTYPE}? ^( $op ^( ITOF $l) $r)
					if ((l!=null?((XTree)l.start):null).exprType == XTree.INTTYPE && (r!=null?((XTree)r.start):null).exprType == XTree.FLOATTYPE) {
						// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:71:96: ^( $op ^( ITOF $l) $r)
						{
						XTree root_1 = (XTree)adaptor.nil();
						root_1 = (XTree)adaptor.becomeRoot(stream_op.nextNode(), root_1);
						// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:71:102: ^( ITOF $l)
						{
						XTree root_2 = (XTree)adaptor.nil();
						root_2 = (XTree)adaptor.becomeRoot((XTree)adaptor.create(ITOF, "ITOF"), root_2);
						adaptor.addChild(root_2, stream_l.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_1, stream_r.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}

					else // 72:15: -> {$l.start.exprType == XTree.FLOATTYPE && $r.start.exprType == XTree.INTTYPE}? ^( $op $l ^( ITOF $r) )
					if ((l!=null?((XTree)l.start):null).exprType == XTree.FLOATTYPE && (r!=null?((XTree)r.start):null).exprType == XTree.INTTYPE) {
						// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:72:96: ^( $op $l ^( ITOF $r) )
						{
						XTree root_1 = (XTree)adaptor.nil();
						root_1 = (XTree)adaptor.becomeRoot(stream_op.nextNode(), root_1);
						adaptor.addChild(root_1, stream_l.nextTree());
						// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:72:105: ^( ITOF $r)
						{
						XTree root_2 = (XTree)adaptor.nil();
						root_2 = (XTree)adaptor.becomeRoot((XTree)adaptor.create(ITOF, "ITOF"), root_2);
						adaptor.addChild(root_2, stream_r.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}

					else // 73:15: -> ^( $op $l $r)
					{
						// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:73:18: ^( $op $l $r)
						{
						XTree root_1 = (XTree)adaptor.nil();
						root_1 = (XTree)adaptor.becomeRoot(stream_op.nextNode(), root_1);
						adaptor.addChild(root_1, stream_l.nextTree());
						adaptor.addChild(root_1, stream_r.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = (XTree)adaptor.rulePostProcessing(root_0);
					input.replaceChildren(adaptor.getParent(retval.start),
										  adaptor.getChildIndex(retval.start),
										  adaptor.getChildIndex(_last),
										  retval.tree);

					}
					break;
				case 3 :
					// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:75:13: i= INT
					{
					_last = (XTree)input.LT(1);
					i=(XTree)match(input,INT,FOLLOW_INT_in_expr455); 
					 
					if ( _first_0==null ) _first_0 = i;

					i.exprType=XTree.INTTYPE; 
					retval.tree = _first_0;
					if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
						retval.tree = (XTree)adaptor.getParent(retval.tree);

					}
					break;
				case 4 :
					// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:76:13: f= FLOAT
					{
					_last = (XTree)input.LT(1);
					f=(XTree)match(input,FLOAT,FOLLOW_FLOAT_in_expr477); 
					 
					if ( _first_0==null ) _first_0 = f;

					f.exprType=XTree.FLOATTYPE; 
					retval.tree = _first_0;
					if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
						retval.tree = (XTree)adaptor.getParent(retval.tree);

					}
					break;
				case 5 :
					// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:77:13: s= STRING
					{
					_last = (XTree)input.LT(1);
					s=(XTree)match(input,STRING,FOLLOW_STRING_in_expr497); 
					 
					if ( _first_0==null ) _first_0 = s;

					s.exprType=XTree.STRINGTYPE; 
					retval.tree = _first_0;
					if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
						retval.tree = (XTree)adaptor.getParent(retval.tree);

					}
					break;
				case 6 :
					// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:78:13: v= ID
					{
					_last = (XTree)input.LT(1);
					v=(XTree)match(input,ID,FOLLOW_ID_in_expr516); 
					 
					if ( _first_0==null ) _first_0 = v;

					if (varTypes.containsKey((v!=null?v.getText():null))) { 
					                        v.exprType=varTypes.get((v!=null?v.getText():null));
					                       } else {
					                        v.exprType=XTree.INVALIDTYPE;
					                        System.err.println("Error at "+(v!=null?v.getLine():0)+","+v.getCharPositionInLine()+": Variable "+(v!=null?v.getText():null)+" is not defined.");
					                       }
					                      
					retval.tree = _first_0;
					if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
						retval.tree = (XTree)adaptor.getParent(retval.tree);

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr"


	public static class assignstat_return extends TreeRuleReturnScope {
		XTree tree;
		@Override
		public XTree getTree() { return tree; }
	};


	// $ANTLR start "assignstat"
	// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:86:1: assignstat : ^(op= ':=' ID expr ) -> {$expr.start.exprType==XTree.INTTYPE && $ID.exprType==XTree.FLOATTYPE }? ^( ':=' IDA[$ID.token] ^( ITOF expr ) ) -> ^( ':=' IDA[$ID.token] expr ) ;
	public final assignstat_return assignstat() throws RecognitionException {
		assignstat_return retval = new assignstat_return();
		retval.start = input.LT(1);

		XTree root_0 = null;

		XTree _first_0 = null;
		XTree _last = null;


		XTree op=null;
		XTree ID13=null;
		TreeRuleReturnScope expr14 =null;

		XTree op_tree=null;
		XTree ID13_tree=null;
		RewriteRuleNodeStream stream_28=new RewriteRuleNodeStream(adaptor,"token 28");
		RewriteRuleNodeStream stream_ID=new RewriteRuleNodeStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:86:11: ( ^(op= ':=' ID expr ) -> {$expr.start.exprType==XTree.INTTYPE && $ID.exprType==XTree.FLOATTYPE }? ^( ':=' IDA[$ID.token] ^( ITOF expr ) ) -> ^( ':=' IDA[$ID.token] expr ) )
			// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:86:14: ^(op= ':=' ID expr )
			{
			_last = (XTree)input.LT(1);
			{
			XTree _save_last_1 = _last;
			XTree _first_1 = null;
			_last = (XTree)input.LT(1);
			op=(XTree)match(input,28,FOLLOW_28_in_assignstat534); 
			 
			stream_28.add(op);

			if ( _first_0==null ) _first_0 = op;
			match(input, Token.DOWN, null); 
			_last = (XTree)input.LT(1);
			ID13=(XTree)match(input,ID,FOLLOW_ID_in_assignstat536); 
			 
			stream_ID.add(ID13);

			_last = (XTree)input.LT(1);
			pushFollow(FOLLOW_expr_in_assignstat539);
			expr14=expr();
			state._fsp--;

			stream_expr.add(expr14.getTree());
			match(input, Token.UP, null); 
			_last = _save_last_1;
			}



			              if (varTypes.containsKey((ID13!=null?ID13.getText():null))) {
			                ID13.exprType = varTypes.get((ID13!=null?ID13.getText():null));
				              if (ID13.exprType != (expr14!=null?((XTree)expr14.start):null).exprType && !((expr14!=null?((XTree)expr14.start):null).exprType==XTree.INVALIDTYPE  || (expr14!=null?((XTree)expr14.start):null).exprType==XTree.INTTYPE && ID13.exprType==XTree.FLOATTYPE)) {
				                System.err.println("Error at "+(op!=null?op.getLine():0)+","+op.getCharPositionInLine()+": An expression of type "+(expr14!=null?((XTree)expr14.start):null).getExprTypeString()+" cannot be assigned to a variable of type "+ID13.getExprTypeString()+".");       
				              }
			              } else {
			                System.err.println("Error at "+(op!=null?op.getLine():0)+","+op.getCharPositionInLine()+": variable "+(ID13!=null?ID13.getText():null)+" is not defined.");
			                ID13.exprType = XTree.INVALIDTYPE; 
			              }
			             
			// AST REWRITE
			// elements: expr, 28, 28, expr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (XTree)adaptor.nil();
			// 97:14: -> {$expr.start.exprType==XTree.INTTYPE && $ID.exprType==XTree.FLOATTYPE }? ^( ':=' IDA[$ID.token] ^( ITOF expr ) )
			if ((expr14!=null?((XTree)expr14.start):null).exprType==XTree.INTTYPE && ID13.exprType==XTree.FLOATTYPE ) {
				// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:97:90: ^( ':=' IDA[$ID.token] ^( ITOF expr ) )
				{
				XTree root_1 = (XTree)adaptor.nil();
				root_1 = (XTree)adaptor.becomeRoot(
				stream_28.nextNode()
				, root_1);
				adaptor.addChild(root_1, (XTree)adaptor.create(IDA, ID13.token));
				// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:97:113: ^( ITOF expr )
				{
				XTree root_2 = (XTree)adaptor.nil();
				root_2 = (XTree)adaptor.becomeRoot((XTree)adaptor.create(ITOF, "ITOF"), root_2);
				adaptor.addChild(root_2, stream_expr.nextTree());
				adaptor.addChild(root_1, root_2);
				}

				adaptor.addChild(root_0, root_1);
				}

			}

			else // 98:14: -> ^( ':=' IDA[$ID.token] expr )
			{
				// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:98:17: ^( ':=' IDA[$ID.token] expr )
				{
				XTree root_1 = (XTree)adaptor.nil();
				root_1 = (XTree)adaptor.becomeRoot(
				stream_28.nextNode()
				, root_1);
				adaptor.addChild(root_1, (XTree)adaptor.create(IDA, ID13.token));
				adaptor.addChild(root_1, stream_expr.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = (XTree)adaptor.rulePostProcessing(root_0);
			input.replaceChildren(adaptor.getParent(retval.start),
								  adaptor.getChildIndex(retval.start),
								  adaptor.getChildIndex(_last),
								  retval.tree);

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "assignstat"


	public static class condstat_return extends TreeRuleReturnScope {
		XTree tree;
		@Override
		public XTree getTree() { return tree; }
	};


	// $ANTLR start "condstat"
	// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:101:1: condstat : ^( 'if' expr stat ( stat )? ) ;
	public final condstat_return condstat() throws RecognitionException {
		condstat_return retval = new condstat_return();
		retval.start = input.LT(1);

		XTree root_0 = null;

		XTree _first_0 = null;
		XTree _last = null;


		XTree string_literal15=null;
		TreeRuleReturnScope expr16 =null;
		TreeRuleReturnScope stat17 =null;
		TreeRuleReturnScope stat18 =null;

		XTree string_literal15_tree=null;

		try {
			// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:101:9: ( ^( 'if' expr stat ( stat )? ) )
			// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:101:13: ^( 'if' expr stat ( stat )? )
			{
			_last = (XTree)input.LT(1);
			{
			XTree _save_last_1 = _last;
			XTree _first_1 = null;
			_last = (XTree)input.LT(1);
			string_literal15=(XTree)match(input,38,FOLLOW_38_in_condstat609); 

			if ( _first_0==null ) _first_0 = string_literal15;
			match(input, Token.DOWN, null); 
			_last = (XTree)input.LT(1);
			pushFollow(FOLLOW_expr_in_condstat611);
			expr16=expr();
			state._fsp--;

			 
			if ( _first_1==null ) _first_1 = (XTree)expr16.getTree();

			_last = (XTree)input.LT(1);
			pushFollow(FOLLOW_stat_in_condstat614);
			stat17=stat();
			state._fsp--;

			 
			if ( _first_1==null ) _first_1 = (XTree)stat17.getTree();

			// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:101:31: ( stat )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==BLOCK||LA7_0==28||(LA7_0 >= 37 && LA7_0 <= 38)||LA7_0==45) ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:101:31: stat
					{
					_last = (XTree)input.LT(1);
					pushFollow(FOLLOW_stat_in_condstat616);
					stat18=stat();
					state._fsp--;

					 
					if ( _first_1==null ) _first_1 = (XTree)stat18.getTree();

					retval.tree = _first_0;
					if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
						retval.tree = (XTree)adaptor.getParent(retval.tree);

					}
					break;

			}

			match(input, Token.UP, null); 
			_last = _save_last_1;
			}


			retval.tree = _first_0;
			if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
				retval.tree = (XTree)adaptor.getParent(retval.tree);

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "condstat"


	public static class whilestat_return extends TreeRuleReturnScope {
		XTree tree;
		@Override
		public XTree getTree() { return tree; }
	};


	// $ANTLR start "whilestat"
	// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:104:1: whilestat : ^( 'while' expr stat ) ;
	public final whilestat_return whilestat() throws RecognitionException {
		whilestat_return retval = new whilestat_return();
		retval.start = input.LT(1);

		XTree root_0 = null;

		XTree _first_0 = null;
		XTree _last = null;


		XTree string_literal19=null;
		TreeRuleReturnScope expr20 =null;
		TreeRuleReturnScope stat21 =null;

		XTree string_literal19_tree=null;

		try {
			// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:104:10: ( ^( 'while' expr stat ) )
			// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:104:15: ^( 'while' expr stat )
			{
			_last = (XTree)input.LT(1);
			{
			XTree _save_last_1 = _last;
			XTree _first_1 = null;
			_last = (XTree)input.LT(1);
			string_literal19=(XTree)match(input,45,FOLLOW_45_in_whilestat630); 

			if ( _first_0==null ) _first_0 = string_literal19;
			match(input, Token.DOWN, null); 
			_last = (XTree)input.LT(1);
			pushFollow(FOLLOW_expr_in_whilestat632);
			expr20=expr();
			state._fsp--;

			 
			if ( _first_1==null ) _first_1 = (XTree)expr20.getTree();

			_last = (XTree)input.LT(1);
			pushFollow(FOLLOW_stat_in_whilestat634);
			stat21=stat();
			state._fsp--;

			 
			if ( _first_1==null ) _first_1 = (XTree)stat21.getTree();

			match(input, Token.UP, null); 
			_last = _save_last_1;
			}


			retval.tree = _first_0;
			if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
				retval.tree = (XTree)adaptor.getParent(retval.tree);

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "whilestat"


	public static class forstat_return extends TreeRuleReturnScope {
		XTree tree;
		@Override
		public XTree getTree() { return tree; }
	};


	// $ANTLR start "forstat"
	// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:105:1: forstat : ^( 'for' assignstat expr assignstat stat ) ;
	public final forstat_return forstat() throws RecognitionException {
		forstat_return retval = new forstat_return();
		retval.start = input.LT(1);

		XTree root_0 = null;

		XTree _first_0 = null;
		XTree _last = null;


		XTree string_literal22=null;
		TreeRuleReturnScope assignstat23 =null;
		TreeRuleReturnScope expr24 =null;
		TreeRuleReturnScope assignstat25 =null;
		TreeRuleReturnScope stat26 =null;

		XTree string_literal22_tree=null;

		try {
			// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:105:8: ( ^( 'for' assignstat expr assignstat stat ) )
			// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:105:15: ^( 'for' assignstat expr assignstat stat )
			{
			_last = (XTree)input.LT(1);
			{
			XTree _save_last_1 = _last;
			XTree _first_1 = null;
			_last = (XTree)input.LT(1);
			string_literal22=(XTree)match(input,37,FOLLOW_37_in_forstat647); 

			if ( _first_0==null ) _first_0 = string_literal22;
			match(input, Token.DOWN, null); 
			_last = (XTree)input.LT(1);
			pushFollow(FOLLOW_assignstat_in_forstat649);
			assignstat23=assignstat();
			state._fsp--;

			 
			if ( _first_1==null ) _first_1 = (XTree)assignstat23.getTree();

			_last = (XTree)input.LT(1);
			pushFollow(FOLLOW_expr_in_forstat651);
			expr24=expr();
			state._fsp--;

			 
			if ( _first_1==null ) _first_1 = (XTree)expr24.getTree();

			_last = (XTree)input.LT(1);
			pushFollow(FOLLOW_assignstat_in_forstat653);
			assignstat25=assignstat();
			state._fsp--;

			 
			if ( _first_1==null ) _first_1 = (XTree)assignstat25.getTree();

			_last = (XTree)input.LT(1);
			pushFollow(FOLLOW_stat_in_forstat655);
			stat26=stat();
			state._fsp--;

			 
			if ( _first_1==null ) _first_1 = (XTree)stat26.getTree();

			match(input, Token.UP, null); 
			_last = _save_last_1;
			}


			retval.tree = _first_0;
			if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
				retval.tree = (XTree)adaptor.getParent(retval.tree);

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "forstat"


	public static class stat_return extends TreeRuleReturnScope {
		XTree tree;
		@Override
		public XTree getTree() { return tree; }
	};


	// $ANTLR start "stat"
	// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:109:1: stat : ( assignstat | condstat | whilestat | forstat | block );
	public final stat_return stat() throws RecognitionException {
		stat_return retval = new stat_return();
		retval.start = input.LT(1);

		XTree root_0 = null;

		XTree _first_0 = null;
		XTree _last = null;


		TreeRuleReturnScope assignstat27 =null;
		TreeRuleReturnScope condstat28 =null;
		TreeRuleReturnScope whilestat29 =null;
		TreeRuleReturnScope forstat30 =null;
		TreeRuleReturnScope block31 =null;


		try {
			// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:109:5: ( assignstat | condstat | whilestat | forstat | block )
			int alt8=5;
			switch ( input.LA(1) ) {
			case 28:
				{
				alt8=1;
				}
				break;
			case 38:
				{
				alt8=2;
				}
				break;
			case 45:
				{
				alt8=3;
				}
				break;
			case 37:
				{
				alt8=4;
				}
				break;
			case BLOCK:
				{
				alt8=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:109:15: assignstat
					{
					_last = (XTree)input.LT(1);
					pushFollow(FOLLOW_assignstat_in_stat673);
					assignstat27=assignstat();
					state._fsp--;

					 
					if ( _first_0==null ) _first_0 = (XTree)assignstat27.getTree();

					retval.tree = _first_0;
					if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
						retval.tree = (XTree)adaptor.getParent(retval.tree);

					}
					break;
				case 2 :
					// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:109:28: condstat
					{
					_last = (XTree)input.LT(1);
					pushFollow(FOLLOW_condstat_in_stat677);
					condstat28=condstat();
					state._fsp--;

					 
					if ( _first_0==null ) _first_0 = (XTree)condstat28.getTree();

					retval.tree = _first_0;
					if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
						retval.tree = (XTree)adaptor.getParent(retval.tree);

					}
					break;
				case 3 :
					// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:109:39: whilestat
					{
					_last = (XTree)input.LT(1);
					pushFollow(FOLLOW_whilestat_in_stat681);
					whilestat29=whilestat();
					state._fsp--;

					 
					if ( _first_0==null ) _first_0 = (XTree)whilestat29.getTree();

					retval.tree = _first_0;
					if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
						retval.tree = (XTree)adaptor.getParent(retval.tree);

					}
					break;
				case 4 :
					// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:109:51: forstat
					{
					_last = (XTree)input.LT(1);
					pushFollow(FOLLOW_forstat_in_stat685);
					forstat30=forstat();
					state._fsp--;

					 
					if ( _first_0==null ) _first_0 = (XTree)forstat30.getTree();

					retval.tree = _first_0;
					if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
						retval.tree = (XTree)adaptor.getParent(retval.tree);

					}
					break;
				case 5 :
					// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:109:61: block
					{
					_last = (XTree)input.LT(1);
					pushFollow(FOLLOW_block_in_stat689);
					block31=block();
					state._fsp--;

					 
					if ( _first_0==null ) _first_0 = (XTree)block31.getTree();

					retval.tree = _first_0;
					if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
						retval.tree = (XTree)adaptor.getParent(retval.tree);

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "stat"


	public static class block_return extends TreeRuleReturnScope {
		XTree tree;
		@Override
		public XTree getTree() { return tree; }
	};


	// $ANTLR start "block"
	// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:112:1: block : ^( BLOCK ( stat )* ) ;
	public final block_return block() throws RecognitionException {
		block_return retval = new block_return();
		retval.start = input.LT(1);

		XTree root_0 = null;

		XTree _first_0 = null;
		XTree _last = null;


		XTree BLOCK32=null;
		TreeRuleReturnScope stat33 =null;

		XTree BLOCK32_tree=null;

		try {
			// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:112:6: ( ^( BLOCK ( stat )* ) )
			// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:112:15: ^( BLOCK ( stat )* )
			{
			_last = (XTree)input.LT(1);
			{
			XTree _save_last_1 = _last;
			XTree _first_1 = null;
			_last = (XTree)input.LT(1);
			BLOCK32=(XTree)match(input,BLOCK,FOLLOW_BLOCK_in_block705); 

			if ( _first_0==null ) _first_0 = BLOCK32;
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:112:23: ( stat )*
				loop9:
				while (true) {
					int alt9=2;
					int LA9_0 = input.LA(1);
					if ( (LA9_0==BLOCK||LA9_0==28||(LA9_0 >= 37 && LA9_0 <= 38)||LA9_0==45) ) {
						alt9=1;
					}

					switch (alt9) {
					case 1 :
						// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:112:23: stat
						{
						_last = (XTree)input.LT(1);
						pushFollow(FOLLOW_stat_in_block707);
						stat33=stat();
						state._fsp--;

						 
						if ( _first_1==null ) _first_1 = (XTree)stat33.getTree();

						retval.tree = _first_0;
						if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
							retval.tree = (XTree)adaptor.getParent(retval.tree);

						}
						break;

					default :
						break loop9;
					}
				}

				match(input, Token.UP, null); 
			}
			_last = _save_last_1;
			}


			retval.tree = _first_0;
			if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
				retval.tree = (XTree)adaptor.getParent(retval.tree);

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "block"


	public static class program_return extends TreeRuleReturnScope {
		XTree tree;
		@Override
		public XTree getTree() { return tree; }
	};


	// $ANTLR start "program"
	// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:115:1: program : ^( 'program' ID ( decl )* block ) ;
	public final program_return program() throws RecognitionException {
		program_return retval = new program_return();
		retval.start = input.LT(1);

		XTree root_0 = null;

		XTree _first_0 = null;
		XTree _last = null;


		XTree string_literal34=null;
		XTree ID35=null;
		TreeRuleReturnScope decl36 =null;
		TreeRuleReturnScope block37 =null;

		XTree string_literal34_tree=null;
		XTree ID35_tree=null;

		try {
			// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:115:8: ( ^( 'program' ID ( decl )* block ) )
			// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:115:15: ^( 'program' ID ( decl )* block )
			{
			_last = (XTree)input.LT(1);
			{
			XTree _save_last_1 = _last;
			XTree _first_1 = null;
			_last = (XTree)input.LT(1);
			string_literal34=(XTree)match(input,41,FOLLOW_41_in_program723); 

			if ( _first_0==null ) _first_0 = string_literal34;
			match(input, Token.DOWN, null); 
			_last = (XTree)input.LT(1);
			ID35=(XTree)match(input,ID,FOLLOW_ID_in_program725); 
			 
			if ( _first_1==null ) _first_1 = ID35;

			// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:115:30: ( decl )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==DECLARE) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// C:\\Users\\eisenbiegler\\Dropbox\\workspace\\ÜB-X\\src\\de\\dhbw\\compiler\\xantlrparser2\\TypeCheck.g:115:30: decl
					{
					_last = (XTree)input.LT(1);
					pushFollow(FOLLOW_decl_in_program727);
					decl36=decl();
					state._fsp--;

					 
					if ( _first_1==null ) _first_1 = (XTree)decl36.getTree();

					retval.tree = _first_0;
					if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
						retval.tree = (XTree)adaptor.getParent(retval.tree);

					}
					break;

				default :
					break loop10;
				}
			}

			_last = (XTree)input.LT(1);
			pushFollow(FOLLOW_block_in_program730);
			block37=block();
			state._fsp--;

			 
			if ( _first_1==null ) _first_1 = (XTree)block37.getTree();

			match(input, Token.UP, null); 
			_last = _save_last_1;
			}


			retval.tree = _first_0;
			if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
				retval.tree = (XTree)adaptor.getParent(retval.tree);

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "program"

	// Delegated rules



	public static final BitSet FOLLOW_DECLARE_in_decl111 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_decl113 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_39_in_decl115 = new BitSet(new long[]{0x0000FFFFFFFFFFF8L});
	public static final BitSet FOLLOW_DECLARE_in_decl138 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_decl140 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_decl142 = new BitSet(new long[]{0x0000FFFFFFFFFFF8L});
	public static final BitSet FOLLOW_DECLARE_in_decl165 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_decl167 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_43_in_decl169 = new BitSet(new long[]{0x0000FFFFFFFFFFF8L});
	public static final BitSet FOLLOW_UMINUS_in_expr206 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr210 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_23_in_expr246 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_24_in_expr252 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_26_in_expr258 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_22_in_expr264 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_30_in_expr270 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_32_in_expr276 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_31_in_expr282 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr287 = new BitSet(new long[]{0x00000001C5C30700L});
	public static final BitSet FOLLOW_expr_in_expr291 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INT_in_expr455 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLOAT_in_expr477 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_expr497 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_expr516 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_assignstat534 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_assignstat536 = new BitSet(new long[]{0x00000001C5C30700L});
	public static final BitSet FOLLOW_expr_in_assignstat539 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_38_in_condstat609 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_condstat611 = new BitSet(new long[]{0x0000206010000010L});
	public static final BitSet FOLLOW_stat_in_condstat614 = new BitSet(new long[]{0x0000206010000018L});
	public static final BitSet FOLLOW_stat_in_condstat616 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_45_in_whilestat630 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_whilestat632 = new BitSet(new long[]{0x0000206010000010L});
	public static final BitSet FOLLOW_stat_in_whilestat634 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_37_in_forstat647 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_assignstat_in_forstat649 = new BitSet(new long[]{0x00000001C5C30700L});
	public static final BitSet FOLLOW_expr_in_forstat651 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_assignstat_in_forstat653 = new BitSet(new long[]{0x0000206010000010L});
	public static final BitSet FOLLOW_stat_in_forstat655 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_assignstat_in_stat673 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_condstat_in_stat677 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_whilestat_in_stat681 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_forstat_in_stat685 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_stat689 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BLOCK_in_block705 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_stat_in_block707 = new BitSet(new long[]{0x0000206010000018L});
	public static final BitSet FOLLOW_41_in_program723 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_program725 = new BitSet(new long[]{0x0000000000000050L});
	public static final BitSet FOLLOW_decl_in_program727 = new BitSet(new long[]{0x0000000000000050L});
	public static final BitSet FOLLOW_block_in_program730 = new BitSet(new long[]{0x0000000000000008L});
}
