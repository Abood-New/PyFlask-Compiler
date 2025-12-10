package AST.Expressions;

import AST.Expression;

import java.util.List;

public class ArrayLiteral extends Expression {
    public List<Expression> elements;

    public ArrayLiteral(List<Expression> elements) {
        this.elements = elements;
    }

    @Override public String toString(){ return elements.toString(); }
     public String prettyPrint(int level){ return elements.toString(); }
}
