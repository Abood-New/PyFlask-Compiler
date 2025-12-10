package AST.Expressions;

import AST.Expression;

public class IndexExpr extends Expression {
    public Expression array;
    public Expression index;

    public IndexExpr(Expression array, Expression index) {
        this.array = array;
        this.index = index;
    }
    @Override public String toString(){ return array + "[" + index + "]"; }
     public String prettyPrint(int level){ return array + "[" + index + "]"; }
}