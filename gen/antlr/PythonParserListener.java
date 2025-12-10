// Generated from C:/Users/msi/Desktop/antlr/untitled/src/antlr/PythonParser.g4 by ANTLR 4.13.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PythonParser}.
 */
public interface PythonParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PythonParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(PythonParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(PythonParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printState}
	 * labeled alternative in {@link PythonParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintState(PythonParser.PrintStateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printState}
	 * labeled alternative in {@link PythonParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintState(PythonParser.PrintStateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newLine}
	 * labeled alternative in {@link PythonParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterNewLine(PythonParser.NewLineContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newLine}
	 * labeled alternative in {@link PythonParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitNewLine(PythonParser.NewLineContext ctx);
}