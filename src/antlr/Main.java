package antlr;

import AST.Program;
import SymbolTable.Scope;
import SymbolTable.SymbolTableBuilder;
import Visitor.PythonVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
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
            Program ast = (Program) programVisitor.visit(tree);

            System.out.println(ast);

            // Build symbol table
//            SymbolTableBuilder symbolTableBuilder = new SymbolTableBuilder();
//            symbolTableBuilder.visit(ast);

            // Print symbol table
//            System.out.println("symbol table");
//            System.out.println("\n" + symbolTableBuilder.getSymbolTable().toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
