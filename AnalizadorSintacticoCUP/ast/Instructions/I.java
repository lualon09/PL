package ast.Instructions;
import ast.ASTNode;
import ast.NodeKind;

public abstract class I extends ASTNode {

    public abstract KindI kind();
    public String num() {throw new UnsupportedOperationException("num");}
    public NodeKind nodeKind() {return NodeKind.INSTRUCTION;}
    public String toString() {return "";}
    
}