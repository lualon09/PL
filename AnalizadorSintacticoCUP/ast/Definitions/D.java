package ast.Definitions;

import ast.ASTNode;
import ast.NodeKind;

public abstract class D extends ASTNode {

    public abstract KindD kindD();
    public String toString() {return "";}
    @Override
    public NodeKind nodeKind() {
        return NodeKind.DEFINITION;
    }
    @Override
    public void bind(){}
}
