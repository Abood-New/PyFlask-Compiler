package AST.Expressions;

import AST.Expression;

public class IdentifierExpr extends Expression {
    public String name;

    public IdentifierExpr(String name) {
        this.name = name;
    }
    @Override public String toString() { return name; }
     public String prettyPrint(int level) { return name; }
}
