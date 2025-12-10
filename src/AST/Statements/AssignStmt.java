package AST.Statements;

import AST.Expression;
import AST.Statement;

public class AssignStmt extends Statement {
    public Expression name;
    public Expression value;
    public AssignStmt(Expression name,Expression value) {
        this.name = name;
        this.value = value;
    }
//    public String prettyPrint(int level) {
//        return indent(level) + "Assign(" + name + " = " + value.prettyPrint(0) + ")";
//    }
    @Override public String toString() { return "Assign(" + name + " = " + value + ")"; }
}
