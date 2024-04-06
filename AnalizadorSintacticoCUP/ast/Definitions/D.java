package ast.Definitions;

import ast.ASTNode;
import ast.NodeKind;
import exc.BindingException;

public abstract class D extends ASTNode {

    public abstract KindD kindD();
    public String toString() {return "";}
    @Override
    public NodeKind nodeKind() {
        return NodeKind.DEFINITION;
    }
    @Override
    public void bind() throws BindingException {}
}
