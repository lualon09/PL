package ast.Definitions;

import ast.ASTNode;
import ast.NodeKind;
import exc.BindingException;
import exc.TypingException;
import exc.GCodingException;

public abstract class D extends ASTNode {

    public abstract KindD kindD();
    public String toString() {return "";}
    @Override
    public NodeKind nodeKind() {
        return NodeKind.DEFINITION;
    }
    @Override
    public void bind() throws BindingException {}

    @Override
    public void type() throws TypingException {}

    public void generateCode() throws GCodingException{}
}
