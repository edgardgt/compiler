// Generated from scanner\Decaf.g by ANTLR 4.1

    package compiler.scanner;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Decaf extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CLASE=1, VOID=2, TRUE=3, FALSE=4, IF=5, ELSE=6, FOR=7, RETURN=8, BREAK=9, 
		CONTINUE=10, CALLOUT=11, BOOLEAN=12, INT=13;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'class'", "'void'", "'true'", "'false'", "'if'", "'else'", "'for'", "'return'", 
		"'break'", "'continue'", "'callout'", "'boolean'", "'int'"
	};
	public static final String[] ruleNames = {
		"CLASE", "VOID", "TRUE", "FALSE", "IF", "ELSE", "FOR", "RETURN", "BREAK", 
		"CONTINUE", "CALLOUT", "BOOLEAN", "INT"
	};


	public Decaf(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Decaf.g"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\17i\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\2"+
		"\17\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1"+
		"\27\r\1\31\16\1\33\17\1\3\2\2h\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\3\35\3\2\2\2\5"+
		"#\3\2\2\2\7(\3\2\2\2\t-\3\2\2\2\13\63\3\2\2\2\r\66\3\2\2\2\17;\3\2\2\2"+
		"\21?\3\2\2\2\23F\3\2\2\2\25L\3\2\2\2\27U\3\2\2\2\31]\3\2\2\2\33e\3\2\2"+
		"\2\35\36\7e\2\2\36\37\7n\2\2\37 \7c\2\2 !\7u\2\2!\"\7u\2\2\"\4\3\2\2\2"+
		"#$\7x\2\2$%\7q\2\2%&\7k\2\2&\'\7f\2\2\'\6\3\2\2\2()\7v\2\2)*\7t\2\2*+"+
		"\7w\2\2+,\7g\2\2,\b\3\2\2\2-.\7h\2\2./\7c\2\2/\60\7n\2\2\60\61\7u\2\2"+
		"\61\62\7g\2\2\62\n\3\2\2\2\63\64\7k\2\2\64\65\7h\2\2\65\f\3\2\2\2\66\67"+
		"\7g\2\2\678\7n\2\289\7u\2\29:\7g\2\2:\16\3\2\2\2;<\7h\2\2<=\7q\2\2=>\7"+
		"t\2\2>\20\3\2\2\2?@\7t\2\2@A\7g\2\2AB\7v\2\2BC\7w\2\2CD\7t\2\2DE\7p\2"+
		"\2E\22\3\2\2\2FG\7d\2\2GH\7t\2\2HI\7g\2\2IJ\7c\2\2JK\7m\2\2K\24\3\2\2"+
		"\2LM\7e\2\2MN\7q\2\2NO\7p\2\2OP\7v\2\2PQ\7k\2\2QR\7p\2\2RS\7w\2\2ST\7"+
		"g\2\2T\26\3\2\2\2UV\7e\2\2VW\7c\2\2WX\7n\2\2XY\7n\2\2YZ\7q\2\2Z[\7w\2"+
		"\2[\\\7v\2\2\\\30\3\2\2\2]^\7d\2\2^_\7q\2\2_`\7q\2\2`a\7n\2\2ab\7g\2\2"+
		"bc\7c\2\2cd\7p\2\2d\32\3\2\2\2ef\7k\2\2fg\7p\2\2gh\7v\2\2h\34\3\2\2\2"+
		"\3\2";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}