package AST.Expressions;

import AST.Expression;

public class BinaryExpr extends Expression {
    public Expression left;
    public String op;
    public Expression right;

    public BinaryExpr(Expression left, String op, Expression right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }
    @Override public String toString() { return "(" + left + " " + op + " " + right + ")"; }
     public String prettyPrint(int level) { return "(" + left + " " + op + " " + right + ")"; }
}
