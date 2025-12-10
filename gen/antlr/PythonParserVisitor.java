// Generated from C:/Users/msi/Desktop/antlr/untitled/src/antlr/PythonParser.g4 by ANTLR 4.13.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PythonParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PythonParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PythonParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(PythonParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printState}
	 * labeled alternative in {@link PythonParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintState(PythonParser.PrintStateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newLine}
	 * labeled alternative in {@link PythonParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewLine(PythonParser.NewLineContext ctx);
}