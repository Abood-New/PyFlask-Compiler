package AST.Expressions;

import AST.Expression;

import java.util.List;
import java.util.Map;

public class DictLiteral extends Expression {
    public List<KeyValue> entries;

    public DictLiteral(List<KeyValue> entries) {
        this.entries = entries;
    }
    @Override public String toString(){ return entries.toString(); }
     public String prettyPrint(int level){ return entries.toString(); }
}