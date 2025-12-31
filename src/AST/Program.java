package AST;

import java.util.List;

public class Program extends ASTNode {
    private final List<Statement> statements;

    public Program(int line, List<Statement> statements) {
        super(line, "Program");
        this.statements = statements;
    }

    public List<Statement> getStatements() {

        return statements;
    }

    @Override
    public String prettyPrint(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent(indent))
                .append(nodeName)
                .append(" (line ")
                .append(line)
                .append(")\n");

        for (Statement st : statements) {
            if (st != null) {
                sb.append(st.prettyPrint(indent + 1));
            }
        }
        return sb.toString();
    }
}
