package AST.Expressions;

import AST.Expression;

import java.util.List;

public class FunctionCallExpr extends Expression {
    public Expression name;
    public List<Expression> args;

    public FunctionCallExpr(Expression name, List<Expression> args) {
        this.name = name;
        this.args = args;
    }
    @Override public String toString() { return name + "(" + args +  ")"; }
     public String prettyPrint(int level) { return name + "(" + args +  ")"; }
}
