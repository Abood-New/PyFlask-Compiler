package AST.Statements;

import AST.Statement;

import java.util.List;

public class ImportStmt extends Statement {
    public final String module;
    public final List<String> names; // for from-import, names may be empty
    public final boolean isFrom; // true if "from X import Y"
    public ImportStmt(boolean isFrom, String module, java.util.List<String> names) {
        this.isFrom = isFrom; this.module = module; this.names = names;
    }
    @Override public String toString() { return (isFrom?"From ":"Import ") + module + " " + names; }
//    public String prettyPrint(int level) {
//        return indent(level) + "Import " + module + " [" + String.join(", ", names) + "]";
//    }
}
