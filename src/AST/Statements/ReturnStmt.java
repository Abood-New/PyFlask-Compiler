package AST.Statements;

import AST.Expression;
import AST.Statement;

public class ReturnStmt extends Statement {
    public Expression expr;
    public ReturnStmt(Expression expr) {
        this.expr = expr;
    }
//    public String prettyPrint(int level) {
//        return indent(level) + "Return(" + expr.prettyPrint(0) + ")";
//    }
    @Override public String toString() { return "Return(" + expr + ")"; }
}