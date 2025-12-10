package AST.Expressions;

import AST.Expression;

public class StringExpr extends Expression {
    public String value;
    public StringExpr(String value) {
        this.value = value;
    }
    @Override public String toString(){ return "\"" + value + "\""; }
     public String prettyPrint(int level){ return "\"" + value + "\""; }
}