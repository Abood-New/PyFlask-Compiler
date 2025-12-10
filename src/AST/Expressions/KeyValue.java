package AST.Expressions;

import AST.ASTNode;
import AST.Expression;

public class KeyValue extends ASTNode {
    public final Expression key; // typically StringLiteral
    public final Expression value;
    public KeyValue(Expression key, Expression value) {
        this.key = key;
        this.value = value;
    }
    @Override
    public String toString() {
        return key + ":" + value;
    }
    public String prettyPrint(int level) {
        return key + ":" + value;
    }
}