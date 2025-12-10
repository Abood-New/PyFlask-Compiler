package AST.Statements;

import AST.Block;
import AST.Expression;
import AST.Statement;

import java.util.List;

public class IfStmt extends Statement {
    public Expression condition;
    public Block thenBlock;
    public Block elseBlock; // may be null

    public IfStmt(Expression condition, Block thenBlock, Block elseBlock) {
        this.condition = condition;
        this.thenBlock = thenBlock;
        this.elseBlock = elseBlock;
    }


    public String prettyPrint(int level) {
        return "If(" + condition + ", then=" + thenBlock + ", else=" + elseBlock + ")";
    }

    @Override public String toString() { return "If(" + condition + ", then=" + thenBlock + ", else=" + elseBlock + ")"; }
}
