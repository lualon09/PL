package ast;

public abstract class ASTNode {

    public ASTNode bondNode;

    // public ?? type() // for the future
    // public ?? bind() // for the future
    // public ?? generateCode() // for the future
    public abstract NodeKind nodeKind();
    public abstract String toString();
}
