package AST.Statements;

import AST.Expression;
import AST.Statement;

public class PrintStmt extends Statement {
    public Expression expr;
    public PrintStmt(Expression expr) {
        this.expr = expr;
    }

    public String prettyPrint(int level) {
        return "Print(" + expr + ")";
    }

    @Override public String toString() { return "Print(" + expr + ")"; }
}
