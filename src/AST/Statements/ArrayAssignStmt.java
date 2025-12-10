package AST.Statements;

import AST.Expression;
import AST.Statement;

public class ArrayAssignStmt extends Statement {
    public Expression array;
    public Expression index;
    public Expression value;
    public ArrayAssignStmt(Expression array, Expression index, Expression value) {
        this.array = array;
        this.index = index;
        this.value = value;
    }

    @Override
    public String toString() {
        return "ArrayAssignStmt [array=" + array + ", index=" + index + ", value=" + value + "]";
    }

    public String prettyPrint(int level) {
        return "ArrayAssignStmt [array=" + array + ", index=" + index + ", value=" + value + "]";
    }
}
