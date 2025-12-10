package AST.Expressions;

import AST.Expression;

public class AttributeExpr extends Expression {
    public final Expression target;
    public final String attr;
    public AttributeExpr(Expression target, String attr) { this.target = target; this.attr = attr; }
    @Override public String toString(){ return target + "." + attr; }
     public String prettyPrint(int level){ return target + "." + attr; }
}
