package ast;

public class Program extends ASTNode {

    public Program(){}

    @Override
    public NodeKind nodeKind() {
        return NodeKind.PROGRAM;
    }

    @Override
    public String toString() {
       return "program";
    }
    
}
