package Visitor;

import AST.*;
import AST.Expressions.*;
import AST.Statements.*;
import antlr.PythonParser;
import antlr.PythonParserBaseVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PythonVisitor extends PythonParserBaseVisitor<ASTNode> {
    @Override
    public ASTNode visitProg(PythonParser.ProgContext ctx) {
        List<Statement> stmts = new ArrayList<>();
        for(PythonParser.StatContext stat : ctx.stat()) {
            ASTNode stmt = visit(stat);
            if(stmt instanceof Statement) stmts.add((Statement)stmt);
        }
        return new Program(stmts);
    }

    @Override
    public ASTNode visitPrintStatement(PythonParser.PrintStatementContext ctx) {
        Expression expr = (Expression)  visit(ctx.expr());
        return new PrintStmt(expr);
    }

    @Override
    public ASTNode visitAssignment(PythonParser.AssignmentContext ctx) {
        Expression target;
        if (ctx.ID() != null) {
            target = new IdentifierExpr(ctx.ID().getText());
        } else {
            // fallback
            target = (Expression) visit(ctx.getChild(0));
        }
        Expression value = (Expression) visit(ctx.expr());
        return new AssignStmt(target, value);
    }

    @Override
    public ASTNode visitArrayAssignment(PythonParser.ArrayAssignmentContext ctx) {
        Expression target = (Expression) visit(ctx.expr(0));
        Expression index = (Expression) visit(ctx.expr(1));
        Expression value = (Expression) visit(ctx.expr(2));
        IndexExpr idxTarget = new IndexExpr(target, index);
        return new AssignStmt(idxTarget, value);
    }

    @Override
    public ASTNode visitExprStat(PythonParser.ExprStatContext ctx) {
        Expression e = (Expression) visit(ctx.expr());
        return new ExprStmt(e);
    }

    @Override
    public ASTNode visitReturnStatement(PythonParser.ReturnStatementContext ctx) {
        Expression e = (Expression) visit(ctx.expr());
        return new ReturnStmt(e);
    }

    @Override
    public ASTNode visitIfStat(PythonParser.IfStatContext ctx) {
        Expression condition = (Expression) visit(ctx.expr());
        Block thenBlock = (Block) visit(ctx.block(0));
        Block elseBlock = null;
        if (ctx.block().size() > 1) {
            elseBlock = (Block) visit(ctx.block(1));
        }
        return new IfStmt(condition, thenBlock, elseBlock);
    }

    @Override
    public ASTNode visitWhileStatement(PythonParser.WhileStatementContext ctx) {
        Expression cond = (Expression) visit(ctx.expr());
        Block block = (Block) visit(ctx.block());
        return new WhileStmt(cond, block);
    }

    @Override
    public ASTNode visitFunctionDefinition(PythonParser.FunctionDefinitionContext ctx) {
        String name = ctx.ID().getText();
        List<String> params = new ArrayList<>();
        if (ctx.paramList() != null) {
            params.add(ctx.paramList().getText());
        }
        Block body = (Block) visit(ctx.block());
        return new FunctionDef(name, params, body);
    }

    @Override
    public ASTNode visitImportFrom(PythonParser.ImportFromContext ctx) {
        String module = ctx.dottedName().getText();
        List<String> names = new ArrayList<>();
        for (TerminalNode id : ctx.ID()) names.add(id.getText());
        return new ImportStmt(true, module, names);
    }

    @Override
    public ASTNode visitBlock(PythonParser.BlockContext ctx) {
            List<Statement> statements = new ArrayList<>();
            for (PythonParser.StatContext s : ctx.stat()) {
                statements.add((Statement) visit(s));
            }
            return new Block(statements);
    }

    @Override
    public ASTNode visitNumberLiteral(PythonParser.NumberLiteralContext ctx) {
        return new NumberExpr(ctx.getText());
    }

    @Override
    public ASTNode visitStringLiteral(PythonParser.StringLiteralContext ctx) {
        String raw = ctx.STRING().getText();
        String inner = raw.substring(1, raw.length()-1);
        return new StringExpr(unescape(inner));
    }

    @Override
        public ASTNode visitBooleanLiteral(PythonParser.BooleanLiteralContext ctx) {
            return new BooleanExpr(Boolean.parseBoolean(ctx.BOOL().getText()));
    }

    @Override
    public ASTNode visitIdentifierExpr(PythonParser.IdentifierExprContext ctx) {
        return new IdentifierExpr(ctx.ID().getText());
    }

    @Override
    public ASTNode visitFunctionCallExpr(PythonParser.FunctionCallExprContext ctx) {
        Expression callee;
        callee = (Expression) visit(ctx.ID() != null ? ctx.ID() : ctx.getChild(0));
        List<Expression> args = new ArrayList<>();
        if (ctx.argList() != null) {
            for (PythonParser.ArgContext ectx : ctx.argList().arg()) {
                args.add((Expression) visit(ectx));
            }
        }
        return new FunctionCallExpr(callee, args);
    }

    @Override
    public ASTNode visitAttributeExpr(PythonParser.AttributeExprContext ctx) {
        Expression target = (Expression) visit(ctx.expr());
        String attr = ctx.ID().getText();
        return new AttributeExpr(target, attr);
    }

    @Override
    public ASTNode visitIndexExpr(PythonParser.IndexExprContext ctx) {
        Expression target = (Expression) visit(ctx.expr(0));
        Expression index = (Expression) visit(ctx.expr(1));
        return new IndexExpr(target, index);
    }

    @Override
    public ASTNode visitArrayLiteral(PythonParser.ArrayLiteralContext ctx) {
        List<Expression> items = new ArrayList<>();
        if (ctx.argList() != null) {
            for (PythonParser.ArgContext e : ctx.argList().arg()) items.add((Expression) visit(e));
        }
        return new ArrayLiteral(items);
    }

    @Override
    public ASTNode visitDictLiteral(PythonParser.DictLiteralContext ctx) {
        List<KeyValue> pairs = new ArrayList<>();
        if (ctx.dictBody() != null) {
            for (PythonParser.PairContext p : ctx.dictBody().pair()) {
                Expression key = (Expression) visit(p.STRING());
                Expression value = (Expression) visit(p.expr());
                pairs.add(new KeyValue(key, value));
            }
        }
        return new DictLiteral(pairs);
    }
    @Override
    public ASTNode visitMultDivExpr(PythonParser.MultDivExprContext ctx) {
        Expression left = (Expression) visit(ctx.expr(0));
        Expression right = (Expression) visit(ctx.expr(1));
        return new BinaryExpr(left, ctx.op.getText(), right);
    }

    @Override
    public ASTNode visitAddSubExpr(PythonParser.AddSubExprContext ctx) {
        Expression left = (Expression) visit(ctx.expr(0));
        Expression right = (Expression) visit(ctx.expr(1));
        return new BinaryExpr(left,ctx.op.getText(),  right);
    }

    @Override
    public ASTNode visitComparisonExpr(PythonParser.ComparisonExprContext ctx) {
        Expression left = (Expression) visit(ctx.expr(0));
        Expression right = (Expression) visit(ctx.expr(1));
        return new BinaryExpr( left, ctx.op.getText(),right);
    }

    @Override
    public ASTNode visitParenExpr(PythonParser.ParenExprContext ctx) {
        return visit(ctx.expr());
    }

    private String unescape(String s) {
        return s.replace("\\n", "\n").replace("\\t", "\t").replace("\\\"", "\"").replace("\\\\", "\\");
    }
}
