package antlr;

import AST.Program;
import SymbolTable.SymbolTableBuilder;
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
            PythonVisitor ProgramVisitor = new PythonVisitor();
            Program program = (Program) ProgramVisitor.visit(tree);
            
            // Build symbol table
            SymbolTableBuilder symbolTableBuilder = new SymbolTableBuilder();
            symbolTableBuilder.visit(program);
            
            // Print program AST
            System.out.println("=== AST ===");
            System.out.println(program);
            
            // Print symbol table
            System.out.println("meow meow symbol table");
            System.out.println("\n" + symbolTableBuilder.getSymbolTable().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
