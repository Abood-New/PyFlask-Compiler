package AST.Statements;

import AST.Expression;
import AST.Statement;

public class ExprStmt extends Statement {
    public final Expression expr;
    public ExprStmt(Expression expr) { this.expr = expr; }


    public String prettyPrint(int level) {
        return "ExprStmt(" + expr + ")";
    }

    @Override public String toString() { return "ExprStmt(" + expr + ")"; }
}
