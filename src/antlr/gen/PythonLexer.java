// Generated from C:/Users/msi/Desktop/antlr/untitled/src/antlr/PythonLexer.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class PythonLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PRINT=1, LBK=2, RBK=3, EQ=4, ADD=5, SUB=6, MUL=7, DIV=8, ID=9, NUMBER=10, 
		MULDIV=11, ADDSUB=12, STRING=13, NEWLINE=14, WS=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PRINT", "LBK", "RBK", "EQ", "ADD", "SUB", "MUL", "DIV", "ID", "NUMBER", 
			"MULDIV", "ADDSUB", "STRING", "NEWLINE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'print'", "'('", "')'", "'='", "'+'", "'-'", "'*'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PRINT", "LBK", "RBK", "EQ", "ADD", "SUB", "MUL", "DIV", "ID", 
			"NUMBER", "MULDIV", "ADDSUB", "STRING", "NEWLINE", "WS"
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


	public PythonLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PythonLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u000f\\\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0005\b6\b\b\n\b\f\b9\t\b\u0001\t\u0001"+
		"\t\u0005\t=\b\t\n\t\f\t@\t\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0005\fJ\b\f\n\f\f\fM\t\f\u0001\f\u0001\f\u0001"+
		"\r\u0003\rR\b\r\u0001\r\u0001\r\u0001\u000e\u0004\u000eW\b\u000e\u000b"+
		"\u000e\f\u000eX\u0001\u000e\u0001\u000e\u0000\u0000\u000f\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f"+
		"\u0001\u0000\b\u0003\u0000AZ__az\u0004\u000009AZ__az\u0001\u000019\u0001"+
		"\u000009\u0002\u0000**//\u0002\u0000++--\u0002\u0000\"\"\\\\\u0002\u0000"+
		"\t\t  a\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000"+
		"\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000"+
		"\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000"+
		"\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000"+
		"\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000"+
		"\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000"+
		"\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000"+
		"\u001d\u0001\u0000\u0000\u0000\u0001\u001f\u0001\u0000\u0000\u0000\u0003"+
		"%\u0001\u0000\u0000\u0000\u0005\'\u0001\u0000\u0000\u0000\u0007)\u0001"+
		"\u0000\u0000\u0000\t+\u0001\u0000\u0000\u0000\u000b-\u0001\u0000\u0000"+
		"\u0000\r/\u0001\u0000\u0000\u0000\u000f1\u0001\u0000\u0000\u0000\u0011"+
		"3\u0001\u0000\u0000\u0000\u0013:\u0001\u0000\u0000\u0000\u0015A\u0001"+
		"\u0000\u0000\u0000\u0017C\u0001\u0000\u0000\u0000\u0019E\u0001\u0000\u0000"+
		"\u0000\u001bQ\u0001\u0000\u0000\u0000\u001dV\u0001\u0000\u0000\u0000\u001f"+
		" \u0005p\u0000\u0000 !\u0005r\u0000\u0000!\"\u0005i\u0000\u0000\"#\u0005"+
		"n\u0000\u0000#$\u0005t\u0000\u0000$\u0002\u0001\u0000\u0000\u0000%&\u0005"+
		"(\u0000\u0000&\u0004\u0001\u0000\u0000\u0000\'(\u0005)\u0000\u0000(\u0006"+
		"\u0001\u0000\u0000\u0000)*\u0005=\u0000\u0000*\b\u0001\u0000\u0000\u0000"+
		"+,\u0005+\u0000\u0000,\n\u0001\u0000\u0000\u0000-.\u0005-\u0000\u0000"+
		".\f\u0001\u0000\u0000\u0000/0\u0005*\u0000\u00000\u000e\u0001\u0000\u0000"+
		"\u000012\u0005/\u0000\u00002\u0010\u0001\u0000\u0000\u000037\u0007\u0000"+
		"\u0000\u000046\u0007\u0001\u0000\u000054\u0001\u0000\u0000\u000069\u0001"+
		"\u0000\u0000\u000075\u0001\u0000\u0000\u000078\u0001\u0000\u0000\u0000"+
		"8\u0012\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u0000:>\u0007\u0002"+
		"\u0000\u0000;=\u0007\u0003\u0000\u0000<;\u0001\u0000\u0000\u0000=@\u0001"+
		"\u0000\u0000\u0000><\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000"+
		"?\u0014\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000AB\u0007\u0004"+
		"\u0000\u0000B\u0016\u0001\u0000\u0000\u0000CD\u0007\u0005\u0000\u0000"+
		"D\u0018\u0001\u0000\u0000\u0000EK\u0005\"\u0000\u0000FJ\b\u0006\u0000"+
		"\u0000GH\u0005\\\u0000\u0000HJ\t\u0000\u0000\u0000IF\u0001\u0000\u0000"+
		"\u0000IG\u0001\u0000\u0000\u0000JM\u0001\u0000\u0000\u0000KI\u0001\u0000"+
		"\u0000\u0000KL\u0001\u0000\u0000\u0000LN\u0001\u0000\u0000\u0000MK\u0001"+
		"\u0000\u0000\u0000NO\u0005\"\u0000\u0000O\u001a\u0001\u0000\u0000\u0000"+
		"PR\u0005\r\u0000\u0000QP\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000"+
		"RS\u0001\u0000\u0000\u0000ST\u0005\n\u0000\u0000T\u001c\u0001\u0000\u0000"+
		"\u0000UW\u0007\u0007\u0000\u0000VU\u0001\u0000\u0000\u0000WX\u0001\u0000"+
		"\u0000\u0000XV\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000YZ\u0001"+
		"\u0000\u0000\u0000Z[\u0006\u000e\u0000\u0000[\u001e\u0001\u0000\u0000"+
		"\u0000\u0007\u00007>IKQX\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}