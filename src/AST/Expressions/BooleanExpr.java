package AST.Expressions;

import AST.Expression;

public class BooleanExpr extends Expression {
    public boolean value;
    public BooleanExpr(boolean value) {
        this.value = value;
    }
    @Override public String toString(){ return Boolean.toString(value); }
     public String prettyPrint(int level){ return Boolean.toString(value); }
}
