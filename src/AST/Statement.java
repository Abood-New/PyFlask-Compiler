package AST;

public abstract class Statement extends ASTNode {
    protected Statement(int line, String name) {
        super(line, name);
    }
}
