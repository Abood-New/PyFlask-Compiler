package AST.Expressions;

import AST.Expression;

public class NumberExpr extends Expression {
    public String value;
    public NumberExpr(String value) {
        this.value = value;
    }
    @Override public String toString(){ return value; }
     public String prettyPrint(int level){ return value; }
}
