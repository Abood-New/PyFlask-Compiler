package AST.Expressions;

import AST.Expression;

public class BooleanExpr extends Expression {
    public boolean value;

    public BooleanExpr(int line, boolean value) {
        super(line, "BooleanExpr");
        this.value = value;
    }

    @Override
    public String toString() {
        return Boolean.toString(value);
    }

    public String prettyPrint(int level) {
        return indent(level) + nodeName + " (line " + line + ") " + value + "\n";
    }
}
