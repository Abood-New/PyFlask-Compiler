package AST.Statements;

import AST.Block;
import AST.Expression;
import AST.Statement;

import java.util.List;

public class WhileStmt extends Statement {
    public Expression condition;
    public Block body;
    public WhileStmt(Expression condition, Block body) {
        this.condition = condition;
        this.body = body;
    }

    public String prettyPrint(int level) {
        return "While(" + condition + ", " + body + ")";
    }

    @Override public String toString() { return "While(" + condition + ", " + body + ")"; }
}