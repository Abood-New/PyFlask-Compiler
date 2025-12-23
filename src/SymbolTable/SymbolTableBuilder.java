package SymbolTable;

import AST.*;
import AST.Expressions.*;
import AST.Statements.*;

/**
 * Visitor that builds a symbol table by traversing the AST.
 * Tracks variables, functions, parameters, and imports.
 */
public class SymbolTableBuilder {
    private SymbolTable symbolTable;
    private boolean inIfBlock = false;

    public SymbolTableBuilder() {
        this.symbolTable = new SymbolTable();
    }

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    public void visit(ASTNode node) {
        if (node == null) return;

        if (node instanceof Program) {
            visitProgram((Program) node);
        } else if (node instanceof Block) {
            visitBlock((Block) node);
        } else if (node instanceof FunctionDef) {
            visitFunctionDef((FunctionDef) node);
        } else if (node instanceof AssignStmt) {
            visitAssignStmt((AssignStmt) node);
        } else if (node instanceof IfStmt) {
            visitIfStmt((IfStmt) node);
        } else if (node instanceof WhileStmt) {
            visitWhileStmt((WhileStmt) node);
        } else if (node instanceof ForStmt) {
            visitForStmt((ForStmt) node);
        } else if (node instanceof ImportStmt) {
            visitImportStmt((ImportStmt) node);
        } else if (node instanceof PrintStmt) {
            visitPrintStmt((PrintStmt) node);
        } else if (node instanceof ReturnStmt) {
            visitReturnStmt((ReturnStmt) node);
        } else if (node instanceof ExprStmt) {
            visitExprStmt((ExprStmt) node);
        } else if (node instanceof IdentifierExpr) {
            visitIdentifierExpr((IdentifierExpr) node);
        } else if (node instanceof FunctionCallExpr) {
            visitFunctionCallExpr((FunctionCallExpr) node);
        } else if (node instanceof BinaryExpr) {
            visitBinaryExpr((BinaryExpr) node);
        } else if (node instanceof ArrayLiteral) {
            visitArrayLiteral((ArrayLiteral) node);
        } else if (node instanceof DictLiteral) {
            visitDictLiteral((DictLiteral) node);
        } else if (node instanceof IndexExpr) {
            visitIndexExpr((IndexExpr) node);
        } else if (node instanceof AttributeExpr) {
            visitAttributeExpr((AttributeExpr) node);
        } else if (node instanceof KeyValue) {
            visitKeyValue((KeyValue) node);
        } else if (node instanceof NumberExpr) {
            visitNumberExpr((NumberExpr) node);
        } else if (node instanceof StringExpr) {
            visitStringExpr((StringExpr) node);
        } else if (node instanceof BooleanExpr) {
            visitBooleanExpr((BooleanExpr) node);
        }
    }

    private void visitProgram(Program node) {
        // Visit all statements in the global scope
        for (Statement stmt : node.getStatements()) {
            visit(stmt);
        }
    }

    private void visitBlock(Block node) {
        // Enter a new block scope
        String scopeName = "block_" + node.getLine();
        symbolTable.enterScope(scopeName, Scope.ScopeType.BLOCK, node.getLine());

        // Visit all statements in the block
        for (Statement stmt : node.getStatements()) {
            visit(stmt);
        }

        // Exit the block scope
        symbolTable.exitScope();
    }

    private void visitFunctionDef(FunctionDef node) {
        // Add function to current scope
        symbolTable.addSymbol(node.name, Symbol.SymbolType.FUNCTION, node.getLine());

        // Enter function scope
        String scopeName = "func_" + node.name;
        symbolTable.enterScope(scopeName, Scope.ScopeType.FUNCTION, node.getLine());

        // Add parameters to function scope
        if (node.parameters != null) {
            for (String param : node.parameters) {
                // Parameters might be comma-separated in a single string, need to parse
                String[] params = param.split(",");
                for (String p : params) {
                    String trimmed = p.trim();
                    if (!trimmed.isEmpty()) {
                        symbolTable.addSymbol(trimmed, Symbol.SymbolType.PARAMETER, node.getLine());
                    }
                }
            }
        }

        // Visit function body statements directly without creating a block scope
        // In Python, function bodies don't create separate scopes - they're part of the function scope
        if (node.body != null) {
            for (Statement stmt : node.body.getStatements()) {
                visit(stmt);
            }
        }

        // Exit function scope
        symbolTable.exitScope();
    }

    private void visitAssignStmt(AssignStmt node) {
        // Check if assignment target is an identifier
        if (node.name instanceof IdentifierExpr) {
            IdentifierExpr id = (IdentifierExpr) node.name;

            // If we're in an if block, add to parent scope; otherwise add to current scope
            if (inIfBlock) {
                // Check if variable already exists in parent scope
                Scope parentScope = symbolTable.getCurrentScope().getParent();
                Symbol existing = parentScope != null ? parentScope.lookupLocal(id.name) : null;

                if (existing == null) {
                    // New variable declaration - add to parent scope
                    symbolTable.addSymbolToParent(id.name, Symbol.SymbolType.VARIABLE, node.getLine());
                }
            } else {
                // Check if variable already exists (might be a re-assignment)
                Symbol existing = symbolTable.lookupLocal(id.name);

                if (existing == null) {
                    // New variable declaration
                    symbolTable.addSymbol(id.name, Symbol.SymbolType.VARIABLE, node.getLine());
                }
            }
            // If it exists, it's a re-assignment, which is fine
        }
        // For index expressions (array assignments), we don't add new symbols

        // Visit the value expression
        visit(node.value);
    }

    private void visitIfStmt(IfStmt node) {
        // Visit condition
        visit(node.condition);

        // In Python, if blocks don't create new scopes for variables - variables are in the parent scope
        // However, we create a block scope for structural visibility (to show the if block in the symbol table)
        if (node.thenBlock != null) {
            // Create a block scope for structural visibility
            String scopeName = "block_" + node.thenBlock.getLine();
            symbolTable.enterScope(scopeName, Scope.ScopeType.BLOCK, node.thenBlock.getLine());

            // Set flag so variables are added to parent scope
            boolean oldInIfBlock = inIfBlock;
            inIfBlock = true;

            // Visit statements - variables will be added to parent scope due to flag
            for (Statement stmt : node.thenBlock.getStatements()) {
                visit(stmt);
            }

            // Restore flag
            inIfBlock = oldInIfBlock;

            // Exit block scope
            symbolTable.exitScope();
        }

        // Visit else block - same approach
        if (node.elseBlock != null) {
            String scopeName = "block_" + node.elseBlock.getLine();
            symbolTable.enterScope(scopeName, Scope.ScopeType.BLOCK, node.elseBlock.getLine());

            boolean oldInIfBlock = inIfBlock;
            inIfBlock = true;

            for (Statement stmt : node.elseBlock.getStatements()) {
                visit(stmt);
            }

            inIfBlock = oldInIfBlock;
            symbolTable.exitScope();
        }
    }

    private void visitWhileStmt(WhileStmt node) {
        // Visit condition
        visit(node.condition);

        // In Python, while loop bodies don't create new scopes - variables are in the parent scope
        // So we visit the statements directly without creating a new scope
        if (node.body != null) {
            for (Statement stmt : node.body.getStatements()) {
                visit(stmt);
            }
        }
    }

    private void visitForStmt(ForStmt node) {
        // Add loop variable to current scope BEFORE visiting it
        // This prevents "undefined identifier" warnings
        if (node.loopVariable instanceof IdentifierExpr) {
            IdentifierExpr loopVar = (IdentifierExpr) node.loopVariable;
            // Check if variable already exists (might be a re-assignment)
            Symbol existing = symbolTable.lookupLocal(loopVar.name);
            if (existing == null) {
                // New loop variable - use LOOP_VAR type
                symbolTable.addSymbol(loopVar.name, Symbol.SymbolType.LOOP_VAR, node.getLine());
            }
        }

        // Visit iterable expression (may reference the loop variable in nested cases, but usually doesn't)
        visit(node.iterable);

        // In Python, for loop bodies don't create new scopes - variables are in the parent scope
        // So we visit the statements directly without creating a new scope
        if (node.body != null) {
            for (Statement stmt : node.body.getStatements()) {
                visit(stmt);
            }
        }
    }

    private void visitImportStmt(ImportStmt node) {
        // Add imported names to symbol table
        if (node.names != null) {
            for (String name : node.names) {
                symbolTable.addSymbol(name, Symbol.SymbolType.IMPORT, node.getLine());
            }
        }
    }

    private void visitIdentifierExpr(IdentifierExpr node) {
        // Handle built-in variables like __name__
        if ("__name__".equals(node.name)) {
            // Check if __name__ is already in the symbol table
            Symbol existing = symbolTable.getGlobalScope().lookupLocal("__name__");
            if (existing == null) {
                // Add __name__ as a BUILTIN to the global scope
                symbolTable.addSymbolToGlobal("__name__", Symbol.SymbolType.BUILTIN, node.getLine());
            }
            return; // Don't check for undefined error for built-ins
        }

        // Check if identifier is defined
        Symbol symbol = symbolTable.lookup(node.name);
        if (symbol == null) {
            // Undefined variable - add error
            symbolTable.addError(String.format("Warning at line %d: Undefined identifier '%s'",
                    node.getLine(), node.name));
        }
    }

    private void visitFunctionCallExpr(FunctionCallExpr node) {
        // Check if function is defined
        if (node.callee instanceof IdentifierExpr) {
            IdentifierExpr id = (IdentifierExpr) node.callee;
            Symbol symbol = symbolTable.lookup(id.name);
            if (symbol == null || symbol.getType() != Symbol.SymbolType.FUNCTION) {
                symbolTable.addError(String.format("Warning at line %d: Function '%s' may not be defined",
                        node.getLine(), id.name));
            }
        }

        // Visit arguments
        if (node.args != null) {
            for (Expression arg : node.args) {
                visit(arg);
            }
        }
    }

    private void visitBinaryExpr(BinaryExpr node) {
        visit(node.left);
        visit(node.right);
    }

    private void visitArrayLiteral(ArrayLiteral node) {
        if (node.elements != null) {
            for (Expression item : node.elements) {
                visit(item);
            }
        }
    }

    private void visitDictLiteral(DictLiteral node) {
        if (node.entries != null) {
            for (KeyValue pair : node.entries) {
                visit(pair.key);
                visit(pair.value);
            }
        }
    }

    private void visitIndexExpr(IndexExpr node) {
        visit(node.array);
        visit(node.index);
    }

    private void visitAttributeExpr(AttributeExpr node) {
        visit(node.target);
    }

    private void visitKeyValue(KeyValue node) {
        visit(node.key);
        visit(node.value);
    }

    private void visitNumberExpr(NumberExpr node) {
        // No children
    }

    private void visitStringExpr(StringExpr node) {
        // No children
    }

    private void visitBooleanExpr(BooleanExpr node) {
        // No children
    }

    private void visitPrintStmt(PrintStmt node) {
        visit(node.expr);
    }

    private void visitReturnStmt(ReturnStmt node) {
        if (node.expr != null) {
            visit(node.expr);
        }
    }

    private void visitExprStmt(ExprStmt node) {
        visit(node.expr);
    }
}