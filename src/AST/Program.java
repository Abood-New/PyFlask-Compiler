package AST;

import java.util.List;

public class Program extends ASTNode{
    List<Statement> statements;
    public Program(List<Statement> statements) {
        this.statements = statements;
    }

    @Override public String toString() { return "Program" + statements; }

//    public String prettyPrint(int level) {
//        StringBuilder sb = new StringBuilder("Program[\n");
//        for (ASTNode st : statements) {
//            sb.append(st.prettyPrint(level + 1)).append("\n");
//        }
//        sb.append("]");
//        return sb.toString();
//    }
}
