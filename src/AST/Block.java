package AST;

import java.util.List;

public class Block extends Statement {
    List<Statement> statements;
    public Block(List<Statement> statements) {
        this.statements = statements;
    }

//    public String prettyPrint(int level) {
//        StringBuilder sb = new StringBuilder(indent(level) + "Block[\n");
//        for (ASTNode st : statements) {
//            sb.append(st.prettyPrint(level + 1)).append("\n");
//        }
//        sb.append(indent(level)).append("]");
//        return sb.toString();
//    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Block[\n");
        for (Statement s : statements) {
            sb.append("  ").append(s).append("\n");
        }
        sb.append("]");
        return sb.toString();
    }
}
