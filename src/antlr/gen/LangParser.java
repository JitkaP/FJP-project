// Generated from C:/Users/Jitka/Desktop/1920-ZS/FJP/FJP-project/src/antlr\Lang.g4 by ANTLR 4.7.2
package antlr.gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, CALL=14, PROCEDURE=15, VAR=16, 
		THEN=17, BEGIN=18, END=19, ELSE=20, WHILE=21, DO=22, FOR=23, TO=24, IF=25, 
		READ=26, WRITE=27, CONST=28, TYPE=29, STRING_VALUE=30, BOOLEAN=31, LETTER=32, 
		NUMBER=33, LESS=34, LESS_EQ=35, GREATER=36, GREATER_EQ=37, EQ=38, NOT_EQ=39, 
		NEG=40, AND=41, OR=42, MUL=43, DIV=44, PLUS=45, MINUS=46, WS=47, LINE_COMMENT=48;
	public static final int
		RULE_program = 0, RULE_block = 1, RULE_declaration = 2, RULE_procedure = 3, 
		RULE_consts = 4, RULE_constarrays = 5, RULE_vars = 6, RULE_statement = 7, 
		RULE_assignstmt = 8, RULE_callstmt = 9, RULE_beginstmt = 10, RULE_ifstmt = 11, 
		RULE_whilestmt = 12, RULE_dowhilestmt = 13, RULE_forstmt = 14, RULE_ternarstmt = 15, 
		RULE_writestmt = 16, RULE_readstmt = 17, RULE_condition = 18, RULE_expression = 19, 
		RULE_bool_expression = 20, RULE_string_expression = 21, RULE_number_expression = 22, 
		RULE_term = 23, RULE_factor = 24, RULE_ident_arr = 25, RULE_ident = 26, 
		RULE_value = 27;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "block", "declaration", "procedure", "consts", "constarrays", 
			"vars", "statement", "assignstmt", "callstmt", "beginstmt", "ifstmt", 
			"whilestmt", "dowhilestmt", "forstmt", "ternarstmt", "writestmt", "readstmt", 
			"condition", "expression", "bool_expression", "string_expression", "number_expression", 
			"term", "factor", "ident_arr", "ident", "value"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'", "';'", "':='", "'[]'", "'{'", "','", "'}'", "'?'", "':'", 
			"'('", "')'", "'['", "']'", "'call'", "'procedure'", "'var'", "'then'", 
			"'begin'", "'end'", "'else'", "'while'", "'do'", "'for'", "'to'", "'if'", 
			"'read'", "'write'", "'const'", null, null, null, null, null, "'<'", 
			"'<='", "'>'", "'>='", "'='", "'!='", "'!'", "'&&'", "'||'", "'*'", "'/'", 
			"'+'", "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "CALL", "PROCEDURE", "VAR", "THEN", "BEGIN", "END", "ELSE", 
			"WHILE", "DO", "FOR", "TO", "IF", "READ", "WRITE", "CONST", "TYPE", "STRING_VALUE", 
			"BOOLEAN", "LETTER", "NUMBER", "LESS", "LESS_EQ", "GREATER", "GREATER_EQ", 
			"EQ", "NOT_EQ", "NEG", "AND", "OR", "MUL", "DIV", "PLUS", "MINUS", "WS", 
			"LINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Lang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			block();
			setState(57);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<ProcedureContext> procedure() {
			return getRuleContexts(ProcedureContext.class);
		}
		public ProcedureContext procedure(int i) {
			return getRuleContext(ProcedureContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VAR || _la==CONST) {
				{
				{
				setState(59);
				declaration();
				}
				}
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PROCEDURE) {
				{
				{
				setState(65);
				procedure();
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(71);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public ConstsContext consts() {
			return getRuleContext(ConstsContext.class,0);
		}
		public ConstarraysContext constarrays() {
			return getRuleContext(ConstarraysContext.class,0);
		}
		public VarsContext vars() {
			return getRuleContext(VarsContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(73);
				consts();
				}
				break;
			case 2:
				{
				setState(74);
				constarrays();
				}
				break;
			case 3:
				{
				setState(75);
				vars();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProcedureContext extends ParserRuleContext {
		public TerminalNode PROCEDURE() { return getToken(LangParser.PROCEDURE, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ProcedureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterProcedure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitProcedure(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitProcedure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcedureContext procedure() throws RecognitionException {
		ProcedureContext _localctx = new ProcedureContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_procedure);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(PROCEDURE);
			setState(79);
			ident();
			setState(80);
			match(T__1);
			setState(81);
			block();
			setState(82);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstsContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(LangParser.CONST, 0); }
		public TerminalNode TYPE() { return getToken(LangParser.TYPE, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ConstsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_consts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterConsts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitConsts(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitConsts(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstsContext consts() throws RecognitionException {
		ConstsContext _localctx = new ConstsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_consts);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(CONST);
			setState(85);
			match(TYPE);
			setState(86);
			ident();
			setState(87);
			match(T__2);
			setState(88);
			value();
			setState(89);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstarraysContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(LangParser.CONST, 0); }
		public TerminalNode TYPE() { return getToken(LangParser.TYPE, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public ConstarraysContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constarrays; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterConstarrays(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitConstarrays(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitConstarrays(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstarraysContext constarrays() throws RecognitionException {
		ConstarraysContext _localctx = new ConstarraysContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_constarrays);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(CONST);
			setState(92);
			match(TYPE);
			setState(93);
			ident();
			setState(94);
			match(T__3);
			setState(95);
			match(T__2);
			setState(96);
			match(T__4);
			setState(97);
			value();
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(98);
				match(T__5);
				setState(99);
				value();
				}
				}
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(105);
			match(T__6);
			setState(106);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarsContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(LangParser.VAR, 0); }
		public TerminalNode TYPE() { return getToken(LangParser.TYPE, 0); }
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public List<Ident_arrContext> ident_arr() {
			return getRuleContexts(Ident_arrContext.class);
		}
		public Ident_arrContext ident_arr(int i) {
			return getRuleContext(Ident_arrContext.class,i);
		}
		public VarsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vars; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterVars(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitVars(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitVars(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarsContext vars() throws RecognitionException {
		VarsContext _localctx = new VarsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_vars);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(VAR);
			setState(109);
			match(TYPE);
			setState(112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(110);
				ident();
				}
				break;
			case 2:
				{
				setState(111);
				ident_arr();
				}
				break;
			}
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(114);
				match(T__5);
				setState(117);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(115);
					ident();
					}
					break;
				case 2:
					{
					setState(116);
					ident_arr();
					}
					break;
				}
				}
				}
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(124);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public AssignstmtContext assignstmt() {
			return getRuleContext(AssignstmtContext.class,0);
		}
		public CallstmtContext callstmt() {
			return getRuleContext(CallstmtContext.class,0);
		}
		public BeginstmtContext beginstmt() {
			return getRuleContext(BeginstmtContext.class,0);
		}
		public IfstmtContext ifstmt() {
			return getRuleContext(IfstmtContext.class,0);
		}
		public WhilestmtContext whilestmt() {
			return getRuleContext(WhilestmtContext.class,0);
		}
		public DowhilestmtContext dowhilestmt() {
			return getRuleContext(DowhilestmtContext.class,0);
		}
		public ForstmtContext forstmt() {
			return getRuleContext(ForstmtContext.class,0);
		}
		public TernarstmtContext ternarstmt() {
			return getRuleContext(TernarstmtContext.class,0);
		}
		public WritestmtContext writestmt() {
			return getRuleContext(WritestmtContext.class,0);
		}
		public ReadstmtContext readstmt() {
			return getRuleContext(ReadstmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(126);
				assignstmt();
				}
				break;
			case 2:
				{
				setState(127);
				callstmt();
				}
				break;
			case 3:
				{
				setState(128);
				beginstmt();
				}
				break;
			case 4:
				{
				setState(129);
				ifstmt();
				}
				break;
			case 5:
				{
				setState(130);
				whilestmt();
				}
				break;
			case 6:
				{
				setState(131);
				dowhilestmt();
				}
				break;
			case 7:
				{
				setState(132);
				forstmt();
				}
				break;
			case 8:
				{
				setState(133);
				ternarstmt();
				}
				break;
			case 9:
				{
				setState(134);
				writestmt();
				}
				break;
			case 10:
				{
				setState(135);
				readstmt();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignstmtContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public List<Ident_arrContext> ident_arr() {
			return getRuleContexts(Ident_arrContext.class);
		}
		public Ident_arrContext ident_arr(int i) {
			return getRuleContext(Ident_arrContext.class,i);
		}
		public AssignstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterAssignstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitAssignstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitAssignstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignstmtContext assignstmt() throws RecognitionException {
		AssignstmtContext _localctx = new AssignstmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_assignstmt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(138);
				ident();
				}
				break;
			case 2:
				{
				setState(139);
				ident_arr();
				}
				break;
			}
			setState(149);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(142);
					match(T__2);
					setState(145);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						setState(143);
						ident();
						}
						break;
					case 2:
						{
						setState(144);
						ident_arr();
						}
						break;
					}
					}
					} 
				}
				setState(151);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			setState(152);
			match(T__2);
			setState(153);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CallstmtContext extends ParserRuleContext {
		public TerminalNode CALL() { return getToken(LangParser.CALL, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public CallstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterCallstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitCallstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitCallstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallstmtContext callstmt() throws RecognitionException {
		CallstmtContext _localctx = new CallstmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_callstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(CALL);
			setState(156);
			ident();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BeginstmtContext extends ParserRuleContext {
		public TerminalNode BEGIN() { return getToken(LangParser.BEGIN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode END() { return getToken(LangParser.END, 0); }
		public BeginstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_beginstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterBeginstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitBeginstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitBeginstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BeginstmtContext beginstmt() throws RecognitionException {
		BeginstmtContext _localctx = new BeginstmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_beginstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(BEGIN);
			setState(159);
			statement();
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(160);
				match(T__1);
				setState(161);
				statement();
				}
				}
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(167);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfstmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(LangParser.IF, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode THEN() { return getToken(LangParser.THEN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(LangParser.ELSE, 0); }
		public IfstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterIfstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitIfstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitIfstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfstmtContext ifstmt() throws RecognitionException {
		IfstmtContext _localctx = new IfstmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_ifstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(IF);
			setState(170);
			condition();
			setState(171);
			match(THEN);
			setState(172);
			statement();
			setState(175);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(173);
				match(ELSE);
				setState(174);
				statement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhilestmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(LangParser.WHILE, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode DO() { return getToken(LangParser.DO, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhilestmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whilestmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterWhilestmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitWhilestmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitWhilestmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhilestmtContext whilestmt() throws RecognitionException {
		WhilestmtContext _localctx = new WhilestmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_whilestmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(WHILE);
			setState(178);
			condition();
			setState(179);
			match(DO);
			setState(180);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DowhilestmtContext extends ParserRuleContext {
		public TerminalNode DO() { return getToken(LangParser.DO, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(LangParser.WHILE, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public DowhilestmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dowhilestmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterDowhilestmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitDowhilestmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitDowhilestmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DowhilestmtContext dowhilestmt() throws RecognitionException {
		DowhilestmtContext _localctx = new DowhilestmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_dowhilestmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(DO);
			setState(183);
			statement();
			setState(184);
			match(WHILE);
			setState(185);
			condition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForstmtContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(LangParser.FOR, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public List<Number_expressionContext> number_expression() {
			return getRuleContexts(Number_expressionContext.class);
		}
		public Number_expressionContext number_expression(int i) {
			return getRuleContext(Number_expressionContext.class,i);
		}
		public TerminalNode TO() { return getToken(LangParser.TO, 0); }
		public TerminalNode DO() { return getToken(LangParser.DO, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterForstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitForstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitForstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForstmtContext forstmt() throws RecognitionException {
		ForstmtContext _localctx = new ForstmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_forstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(FOR);
			setState(188);
			ident();
			setState(189);
			match(T__2);
			setState(190);
			number_expression();
			setState(191);
			match(TO);
			setState(192);
			number_expression();
			setState(193);
			match(DO);
			setState(194);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TernarstmtContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public Ident_arrContext ident_arr() {
			return getRuleContext(Ident_arrContext.class,0);
		}
		public TernarstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ternarstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterTernarstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitTernarstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitTernarstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TernarstmtContext ternarstmt() throws RecognitionException {
		TernarstmtContext _localctx = new TernarstmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ternarstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(196);
				ident();
				}
				break;
			case 2:
				{
				setState(197);
				ident_arr();
				}
				break;
			}
			setState(200);
			match(T__2);
			setState(201);
			condition();
			setState(202);
			match(T__7);
			setState(203);
			expression();
			setState(204);
			match(T__8);
			setState(205);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WritestmtContext extends ParserRuleContext {
		public TerminalNode WRITE() { return getToken(LangParser.WRITE, 0); }
		public String_expressionContext string_expression() {
			return getRuleContext(String_expressionContext.class,0);
		}
		public WritestmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writestmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterWritestmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitWritestmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitWritestmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WritestmtContext writestmt() throws RecognitionException {
		WritestmtContext _localctx = new WritestmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_writestmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(WRITE);
			setState(208);
			match(T__9);
			setState(209);
			string_expression();
			setState(210);
			match(T__10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReadstmtContext extends ParserRuleContext {
		public TerminalNode READ() { return getToken(LangParser.READ, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public Ident_arrContext ident_arr() {
			return getRuleContext(Ident_arrContext.class,0);
		}
		public ReadstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterReadstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitReadstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitReadstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadstmtContext readstmt() throws RecognitionException {
		ReadstmtContext _localctx = new ReadstmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_readstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(READ);
			setState(213);
			match(T__9);
			setState(216);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(214);
				ident();
				}
				break;
			case 2:
				{
				setState(215);
				ident_arr();
				}
				break;
			}
			setState(218);
			match(T__10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public List<Number_expressionContext> number_expression() {
			return getRuleContexts(Number_expressionContext.class);
		}
		public Number_expressionContext number_expression(int i) {
			return getRuleContext(Number_expressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Bool_expressionContext bool_expression() {
			return getRuleContext(Bool_expressionContext.class,0);
		}
		public TerminalNode LESS() { return getToken(LangParser.LESS, 0); }
		public TerminalNode LESS_EQ() { return getToken(LangParser.LESS_EQ, 0); }
		public TerminalNode GREATER() { return getToken(LangParser.GREATER, 0); }
		public TerminalNode GREATER_EQ() { return getToken(LangParser.GREATER_EQ, 0); }
		public TerminalNode EQ() { return getToken(LangParser.EQ, 0); }
		public TerminalNode NOT_EQ() { return getToken(LangParser.NOT_EQ, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(T__9);
			setState(230);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				{
				setState(221);
				number_expression();
				setState(222);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LESS) | (1L << LESS_EQ) | (1L << GREATER) | (1L << GREATER_EQ))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(223);
				number_expression();
				}
				}
				break;
			case 2:
				{
				{
				setState(225);
				expression();
				setState(226);
				_la = _input.LA(1);
				if ( !(_la==EQ || _la==NOT_EQ) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(227);
				expression();
				}
				}
				break;
			case 3:
				{
				{
				setState(229);
				bool_expression();
				}
				}
				break;
			}
			setState(232);
			match(T__10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Number_expressionContext number_expression() {
			return getRuleContext(Number_expressionContext.class,0);
		}
		public Bool_expressionContext bool_expression() {
			return getRuleContext(Bool_expressionContext.class,0);
		}
		public String_expressionContext string_expression() {
			return getRuleContext(String_expressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(234);
				number_expression();
				}
				break;
			case 2:
				{
				setState(235);
				bool_expression();
				}
				break;
			case 3:
				{
				setState(236);
				string_expression();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Bool_expressionContext extends ParserRuleContext {
		public List<TerminalNode> BOOLEAN() { return getTokens(LangParser.BOOLEAN); }
		public TerminalNode BOOLEAN(int i) {
			return getToken(LangParser.BOOLEAN, i);
		}
		public List<TerminalNode> NEG() { return getTokens(LangParser.NEG); }
		public TerminalNode NEG(int i) {
			return getToken(LangParser.NEG, i);
		}
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public List<Ident_arrContext> ident_arr() {
			return getRuleContexts(Ident_arrContext.class);
		}
		public Ident_arrContext ident_arr(int i) {
			return getRuleContext(Ident_arrContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(LangParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(LangParser.AND, i);
		}
		public List<TerminalNode> OR() { return getTokens(LangParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(LangParser.OR, i);
		}
		public Bool_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterBool_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitBool_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitBool_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bool_expressionContext bool_expression() throws RecognitionException {
		Bool_expressionContext _localctx = new Bool_expressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_bool_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEG) {
				{
				setState(239);
				match(NEG);
				}
			}

			setState(247);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
				{
				setState(242);
				match(BOOLEAN);
				}
				break;
			case LETTER:
				{
				setState(245);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(243);
					ident();
					}
					break;
				case 2:
					{
					setState(244);
					ident_arr();
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND || _la==OR) {
				{
				{
				setState(249);
				_la = _input.LA(1);
				if ( !(_la==AND || _la==OR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEG) {
					{
					setState(250);
					match(NEG);
					}
				}

				setState(258);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOLEAN:
					{
					setState(253);
					match(BOOLEAN);
					}
					break;
				case LETTER:
					{
					setState(256);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						setState(254);
						ident();
						}
						break;
					case 2:
						{
						setState(255);
						ident_arr();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(264);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class String_expressionContext extends ParserRuleContext {
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public List<TerminalNode> STRING_VALUE() { return getTokens(LangParser.STRING_VALUE); }
		public TerminalNode STRING_VALUE(int i) {
			return getToken(LangParser.STRING_VALUE, i);
		}
		public List<TerminalNode> PLUS() { return getTokens(LangParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(LangParser.PLUS, i);
		}
		public String_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterString_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitString_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitString_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final String_expressionContext string_expression() throws RecognitionException {
		String_expressionContext _localctx = new String_expressionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_string_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LETTER:
				{
				setState(265);
				ident();
				}
				break;
			case STRING_VALUE:
				{
				setState(266);
				match(STRING_VALUE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(276);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS) {
				{
				{
				setState(269);
				match(PLUS);
				setState(272);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LETTER:
					{
					setState(270);
					ident();
					}
					break;
				case STRING_VALUE:
					{
					setState(271);
					match(STRING_VALUE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(278);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Number_expressionContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(LangParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(LangParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(LangParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(LangParser.MINUS, i);
		}
		public Number_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterNumber_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitNumber_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitNumber_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Number_expressionContext number_expression() throws RecognitionException {
		Number_expressionContext _localctx = new Number_expressionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_number_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(279);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(282);
			term();
			setState(287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(283);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(284);
				term();
				}
				}
				setState(289);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> MUL() { return getTokens(LangParser.MUL); }
		public TerminalNode MUL(int i) {
			return getToken(LangParser.MUL, i);
		}
		public List<TerminalNode> DIV() { return getTokens(LangParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(LangParser.DIV, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			factor();
			setState(295);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MUL || _la==DIV) {
				{
				{
				setState(291);
				_la = _input.LA(1);
				if ( !(_la==MUL || _la==DIV) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(292);
				factor();
				}
				}
				setState(297);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(LangParser.NUMBER, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public Ident_arrContext ident_arr() {
			return getRuleContext(Ident_arrContext.class,0);
		}
		public Number_expressionContext number_expression() {
			return getRuleContext(Number_expressionContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_factor);
		try {
			setState(305);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(298);
				match(NUMBER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(299);
				ident();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(300);
				ident_arr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(301);
				match(T__9);
				setState(302);
				number_expression();
				setState(303);
				match(T__10);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ident_arrContext extends ParserRuleContext {
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public TerminalNode NUMBER() { return getToken(LangParser.NUMBER, 0); }
		public Ident_arrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ident_arr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterIdent_arr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitIdent_arr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitIdent_arr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ident_arrContext ident_arr() throws RecognitionException {
		Ident_arrContext _localctx = new Ident_arrContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_ident_arr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			ident();
			setState(308);
			match(T__11);
			setState(311);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				{
				setState(309);
				match(NUMBER);
				}
				break;
			case LETTER:
				{
				setState(310);
				ident();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(313);
			match(T__12);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentContext extends ParserRuleContext {
		public List<TerminalNode> LETTER() { return getTokens(LangParser.LETTER); }
		public TerminalNode LETTER(int i) {
			return getToken(LangParser.LETTER, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(LangParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(LangParser.NUMBER, i);
		}
		public IdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ident; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitIdent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitIdent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentContext ident() throws RecognitionException {
		IdentContext _localctx = new IdentContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_ident);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			match(LETTER);
			setState(319);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LETTER || _la==NUMBER) {
				{
				{
				setState(316);
				_la = _input.LA(1);
				if ( !(_la==LETTER || _la==NUMBER) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(321);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(LangParser.NUMBER, 0); }
		public TerminalNode BOOLEAN() { return getToken(LangParser.BOOLEAN, 0); }
		public TerminalNode STRING_VALUE() { return getToken(LangParser.STRING_VALUE, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING_VALUE) | (1L << BOOLEAN) | (1L << NUMBER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\62\u0147\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\2\3\3\7\3?\n\3\f\3"+
		"\16\3B\13\3\3\3\7\3E\n\3\f\3\16\3H\13\3\3\3\3\3\3\4\3\4\3\4\5\4O\n\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\7\7g\n\7\f\7\16\7j\13\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\5"+
		"\bs\n\b\3\b\3\b\3\b\5\bx\n\b\7\bz\n\b\f\b\16\b}\13\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u008b\n\t\3\n\3\n\5\n\u008f\n\n\3\n"+
		"\3\n\3\n\5\n\u0094\n\n\7\n\u0096\n\n\f\n\16\n\u0099\13\n\3\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\7\f\u00a5\n\f\f\f\16\f\u00a8\13\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00b2\n\r\3\16\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\5\21\u00c9\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\5\23\u00db\n\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00e9\n\24\3\24\3\24\3\25\3\25"+
		"\3\25\5\25\u00f0\n\25\3\26\5\26\u00f3\n\26\3\26\3\26\3\26\5\26\u00f8\n"+
		"\26\5\26\u00fa\n\26\3\26\3\26\5\26\u00fe\n\26\3\26\3\26\3\26\5\26\u0103"+
		"\n\26\5\26\u0105\n\26\7\26\u0107\n\26\f\26\16\26\u010a\13\26\3\27\3\27"+
		"\5\27\u010e\n\27\3\27\3\27\3\27\5\27\u0113\n\27\7\27\u0115\n\27\f\27\16"+
		"\27\u0118\13\27\3\30\5\30\u011b\n\30\3\30\3\30\3\30\7\30\u0120\n\30\f"+
		"\30\16\30\u0123\13\30\3\31\3\31\3\31\7\31\u0128\n\31\f\31\16\31\u012b"+
		"\13\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0134\n\32\3\33\3\33\3"+
		"\33\3\33\5\33\u013a\n\33\3\33\3\33\3\34\3\34\7\34\u0140\n\34\f\34\16\34"+
		"\u0143\13\34\3\35\3\35\3\35\2\2\36\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,.\60\62\64\668\2\t\3\2$\'\3\2()\3\2+,\3\2/\60\3\2-.\3\2\"#"+
		"\4\2 !##\2\u0159\2:\3\2\2\2\4@\3\2\2\2\6N\3\2\2\2\bP\3\2\2\2\nV\3\2\2"+
		"\2\f]\3\2\2\2\16n\3\2\2\2\20\u008a\3\2\2\2\22\u008e\3\2\2\2\24\u009d\3"+
		"\2\2\2\26\u00a0\3\2\2\2\30\u00ab\3\2\2\2\32\u00b3\3\2\2\2\34\u00b8\3\2"+
		"\2\2\36\u00bd\3\2\2\2 \u00c8\3\2\2\2\"\u00d1\3\2\2\2$\u00d6\3\2\2\2&\u00de"+
		"\3\2\2\2(\u00ef\3\2\2\2*\u00f2\3\2\2\2,\u010d\3\2\2\2.\u011a\3\2\2\2\60"+
		"\u0124\3\2\2\2\62\u0133\3\2\2\2\64\u0135\3\2\2\2\66\u013d\3\2\2\28\u0144"+
		"\3\2\2\2:;\5\4\3\2;<\7\3\2\2<\3\3\2\2\2=?\5\6\4\2>=\3\2\2\2?B\3\2\2\2"+
		"@>\3\2\2\2@A\3\2\2\2AF\3\2\2\2B@\3\2\2\2CE\5\b\5\2DC\3\2\2\2EH\3\2\2\2"+
		"FD\3\2\2\2FG\3\2\2\2GI\3\2\2\2HF\3\2\2\2IJ\5\20\t\2J\5\3\2\2\2KO\5\n\6"+
		"\2LO\5\f\7\2MO\5\16\b\2NK\3\2\2\2NL\3\2\2\2NM\3\2\2\2O\7\3\2\2\2PQ\7\21"+
		"\2\2QR\5\66\34\2RS\7\4\2\2ST\5\4\3\2TU\7\4\2\2U\t\3\2\2\2VW\7\36\2\2W"+
		"X\7\37\2\2XY\5\66\34\2YZ\7\5\2\2Z[\58\35\2[\\\7\4\2\2\\\13\3\2\2\2]^\7"+
		"\36\2\2^_\7\37\2\2_`\5\66\34\2`a\7\6\2\2ab\7\5\2\2bc\7\7\2\2ch\58\35\2"+
		"de\7\b\2\2eg\58\35\2fd\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2ik\3\2\2\2"+
		"jh\3\2\2\2kl\7\t\2\2lm\7\4\2\2m\r\3\2\2\2no\7\22\2\2or\7\37\2\2ps\5\66"+
		"\34\2qs\5\64\33\2rp\3\2\2\2rq\3\2\2\2s{\3\2\2\2tw\7\b\2\2ux\5\66\34\2"+
		"vx\5\64\33\2wu\3\2\2\2wv\3\2\2\2xz\3\2\2\2yt\3\2\2\2z}\3\2\2\2{y\3\2\2"+
		"\2{|\3\2\2\2|~\3\2\2\2}{\3\2\2\2~\177\7\4\2\2\177\17\3\2\2\2\u0080\u008b"+
		"\5\22\n\2\u0081\u008b\5\24\13\2\u0082\u008b\5\26\f\2\u0083\u008b\5\30"+
		"\r\2\u0084\u008b\5\32\16\2\u0085\u008b\5\34\17\2\u0086\u008b\5\36\20\2"+
		"\u0087\u008b\5 \21\2\u0088\u008b\5\"\22\2\u0089\u008b\5$\23\2\u008a\u0080"+
		"\3\2\2\2\u008a\u0081\3\2\2\2\u008a\u0082\3\2\2\2\u008a\u0083\3\2\2\2\u008a"+
		"\u0084\3\2\2\2\u008a\u0085\3\2\2\2\u008a\u0086\3\2\2\2\u008a\u0087\3\2"+
		"\2\2\u008a\u0088\3\2\2\2\u008a\u0089\3\2\2\2\u008a\u008b\3\2\2\2\u008b"+
		"\21\3\2\2\2\u008c\u008f\5\66\34\2\u008d\u008f\5\64\33\2\u008e\u008c\3"+
		"\2\2\2\u008e\u008d\3\2\2\2\u008f\u0097\3\2\2\2\u0090\u0093\7\5\2\2\u0091"+
		"\u0094\5\66\34\2\u0092\u0094\5\64\33\2\u0093\u0091\3\2\2\2\u0093\u0092"+
		"\3\2\2\2\u0094\u0096\3\2\2\2\u0095\u0090\3\2\2\2\u0096\u0099\3\2\2\2\u0097"+
		"\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009a\3\2\2\2\u0099\u0097\3\2"+
		"\2\2\u009a\u009b\7\5\2\2\u009b\u009c\5(\25\2\u009c\23\3\2\2\2\u009d\u009e"+
		"\7\20\2\2\u009e\u009f\5\66\34\2\u009f\25\3\2\2\2\u00a0\u00a1\7\24\2\2"+
		"\u00a1\u00a6\5\20\t\2\u00a2\u00a3\7\4\2\2\u00a3\u00a5\5\20\t\2\u00a4\u00a2"+
		"\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7"+
		"\u00a9\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00aa\7\25\2\2\u00aa\27\3\2\2"+
		"\2\u00ab\u00ac\7\33\2\2\u00ac\u00ad\5&\24\2\u00ad\u00ae\7\23\2\2\u00ae"+
		"\u00b1\5\20\t\2\u00af\u00b0\7\26\2\2\u00b0\u00b2\5\20\t\2\u00b1\u00af"+
		"\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\31\3\2\2\2\u00b3\u00b4\7\27\2\2\u00b4"+
		"\u00b5\5&\24\2\u00b5\u00b6\7\30\2\2\u00b6\u00b7\5\20\t\2\u00b7\33\3\2"+
		"\2\2\u00b8\u00b9\7\30\2\2\u00b9\u00ba\5\20\t\2\u00ba\u00bb\7\27\2\2\u00bb"+
		"\u00bc\5&\24\2\u00bc\35\3\2\2\2\u00bd\u00be\7\31\2\2\u00be\u00bf\5\66"+
		"\34\2\u00bf\u00c0\7\5\2\2\u00c0\u00c1\5.\30\2\u00c1\u00c2\7\32\2\2\u00c2"+
		"\u00c3\5.\30\2\u00c3\u00c4\7\30\2\2\u00c4\u00c5\5\20\t\2\u00c5\37\3\2"+
		"\2\2\u00c6\u00c9\5\66\34\2\u00c7\u00c9\5\64\33\2\u00c8\u00c6\3\2\2\2\u00c8"+
		"\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\7\5\2\2\u00cb\u00cc\5&"+
		"\24\2\u00cc\u00cd\7\n\2\2\u00cd\u00ce\5(\25\2\u00ce\u00cf\7\13\2\2\u00cf"+
		"\u00d0\5(\25\2\u00d0!\3\2\2\2\u00d1\u00d2\7\35\2\2\u00d2\u00d3\7\f\2\2"+
		"\u00d3\u00d4\5,\27\2\u00d4\u00d5\7\r\2\2\u00d5#\3\2\2\2\u00d6\u00d7\7"+
		"\34\2\2\u00d7\u00da\7\f\2\2\u00d8\u00db\5\66\34\2\u00d9\u00db\5\64\33"+
		"\2\u00da\u00d8\3\2\2\2\u00da\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd"+
		"\7\r\2\2\u00dd%\3\2\2\2\u00de\u00e8\7\f\2\2\u00df\u00e0\5.\30\2\u00e0"+
		"\u00e1\t\2\2\2\u00e1\u00e2\5.\30\2\u00e2\u00e9\3\2\2\2\u00e3\u00e4\5("+
		"\25\2\u00e4\u00e5\t\3\2\2\u00e5\u00e6\5(\25\2\u00e6\u00e9\3\2\2\2\u00e7"+
		"\u00e9\5*\26\2\u00e8\u00df\3\2\2\2\u00e8\u00e3\3\2\2\2\u00e8\u00e7\3\2"+
		"\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\7\r\2\2\u00eb\'\3\2\2\2\u00ec\u00f0"+
		"\5.\30\2\u00ed\u00f0\5*\26\2\u00ee\u00f0\5,\27\2\u00ef\u00ec\3\2\2\2\u00ef"+
		"\u00ed\3\2\2\2\u00ef\u00ee\3\2\2\2\u00f0)\3\2\2\2\u00f1\u00f3\7*\2\2\u00f2"+
		"\u00f1\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f9\3\2\2\2\u00f4\u00fa\7!"+
		"\2\2\u00f5\u00f8\5\66\34\2\u00f6\u00f8\5\64\33\2\u00f7\u00f5\3\2\2\2\u00f7"+
		"\u00f6\3\2\2\2\u00f8\u00fa\3\2\2\2\u00f9\u00f4\3\2\2\2\u00f9\u00f7\3\2"+
		"\2\2\u00fa\u0108\3\2\2\2\u00fb\u00fd\t\4\2\2\u00fc\u00fe\7*\2\2\u00fd"+
		"\u00fc\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u0104\3\2\2\2\u00ff\u0105\7!"+
		"\2\2\u0100\u0103\5\66\34\2\u0101\u0103\5\64\33\2\u0102\u0100\3\2\2\2\u0102"+
		"\u0101\3\2\2\2\u0103\u0105\3\2\2\2\u0104\u00ff\3\2\2\2\u0104\u0102\3\2"+
		"\2\2\u0105\u0107\3\2\2\2\u0106\u00fb\3\2\2\2\u0107\u010a\3\2\2\2\u0108"+
		"\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109+\3\2\2\2\u010a\u0108\3\2\2\2"+
		"\u010b\u010e\5\66\34\2\u010c\u010e\7 \2\2\u010d\u010b\3\2\2\2\u010d\u010c"+
		"\3\2\2\2\u010e\u0116\3\2\2\2\u010f\u0112\7/\2\2\u0110\u0113\5\66\34\2"+
		"\u0111\u0113\7 \2\2\u0112\u0110\3\2\2\2\u0112\u0111\3\2\2\2\u0113\u0115"+
		"\3\2\2\2\u0114\u010f\3\2\2\2\u0115\u0118\3\2\2\2\u0116\u0114\3\2\2\2\u0116"+
		"\u0117\3\2\2\2\u0117-\3\2\2\2\u0118\u0116\3\2\2\2\u0119\u011b\t\5\2\2"+
		"\u011a\u0119\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u0121"+
		"\5\60\31\2\u011d\u011e\t\5\2\2\u011e\u0120\5\60\31\2\u011f\u011d\3\2\2"+
		"\2\u0120\u0123\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122/"+
		"\3\2\2\2\u0123\u0121\3\2\2\2\u0124\u0129\5\62\32\2\u0125\u0126\t\6\2\2"+
		"\u0126\u0128\5\62\32\2\u0127\u0125\3\2\2\2\u0128\u012b\3\2\2\2\u0129\u0127"+
		"\3\2\2\2\u0129\u012a\3\2\2\2\u012a\61\3\2\2\2\u012b\u0129\3\2\2\2\u012c"+
		"\u0134\7#\2\2\u012d\u0134\5\66\34\2\u012e\u0134\5\64\33\2\u012f\u0130"+
		"\7\f\2\2\u0130\u0131\5.\30\2\u0131\u0132\7\r\2\2\u0132\u0134\3\2\2\2\u0133"+
		"\u012c\3\2\2\2\u0133\u012d\3\2\2\2\u0133\u012e\3\2\2\2\u0133\u012f\3\2"+
		"\2\2\u0134\63\3\2\2\2\u0135\u0136\5\66\34\2\u0136\u0139\7\16\2\2\u0137"+
		"\u013a\7#\2\2\u0138\u013a\5\66\34\2\u0139\u0137\3\2\2\2\u0139\u0138\3"+
		"\2\2\2\u013a\u013b\3\2\2\2\u013b\u013c\7\17\2\2\u013c\65\3\2\2\2\u013d"+
		"\u0141\7\"\2\2\u013e\u0140\t\7\2\2\u013f\u013e\3\2\2\2\u0140\u0143\3\2"+
		"\2\2\u0141\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142\67\3\2\2\2\u0143\u0141"+
		"\3\2\2\2\u0144\u0145\t\b\2\2\u01459\3\2\2\2#@FNhrw{\u008a\u008e\u0093"+
		"\u0097\u00a6\u00b1\u00c8\u00da\u00e8\u00ef\u00f2\u00f7\u00f9\u00fd\u0102"+
		"\u0104\u0108\u010d\u0112\u0116\u011a\u0121\u0129\u0133\u0139\u0141";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}