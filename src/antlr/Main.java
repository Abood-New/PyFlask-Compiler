package antlr;

import AST.Program;
import Visitor.PythonVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            String path = "samples/file.txt";
            CharStream input = fromFileName(path);
            PythonLexer lexer = new PythonLexer(input);
            CommonTokenStream token = new CommonTokenStream(lexer);

            PythonParser parser = new PythonParser(token);
            ParseTree tree = parser.prog();
            PythonVisitor programVisitor = new PythonVisitor();
            Program program = (Program) programVisitor.visit(tree);

            // Pretty-print AST
            System.out.println(program);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
