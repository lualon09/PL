package ast;

public abstract class ASTNode {

    public ASTNode bindNode;

    // public ?? type() // for the future
    public abstract void bind(); // for the future
    // public ?? generateCode() // for the future
    public abstract NodeKind nodeKind();
    public abstract String toString();
}
