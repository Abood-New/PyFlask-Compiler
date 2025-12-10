package AST.Statements;

import AST.Block;
import AST.Statement;

import java.util.List;

public class FunctionDef extends Statement {
    public String name;
    public List<String> parameters;
    public Block body;

    public FunctionDef(String name, List<String> parameters, Block body) {
        this.name = name;
        this.parameters = parameters;
        this.body = body;
    }
//    public String prettyPrint(int level) {
//        String p = String.join(", ", parameters);
//        return indent(level) + "Func " + name + "(" + p + ") =>\n" +
//                body.prettyPrint(level + 1);
//    }
    @Override public String toString() { return "Func " + name + parameters + " => " + body; }
}
