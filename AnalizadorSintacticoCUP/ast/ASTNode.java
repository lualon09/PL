package ast;
import exc.*;
import ast.Types.T;

public abstract class ASTNode {

    public ASTNode bindNode;
    private T type;

    public abstract void type() throws TypingException;
    public abstract void bind() throws BindingException;
    public abstract int setDelta(int delta);
    public abstract void generateCode() throws GCodingException;
    public abstract NodeKind nodeKind();
    public abstract String toString();

    public T getType() { return type;}
    public void setType(T t) {
        type = t;
    }
    public void calculateAddress(){
        
    }
}
