package ast;
import exc.BindingException;
import exc.TypingException;
import ast.Types.T;

public abstract class ASTNode {

    public ASTNode bindNode;
    private T type;
    private int delta;

    public abstract void type() throws TypingException;
    public abstract void bind() throws BindingException;
    // public abstract void generateCode() throws GCodingException;
    public abstract NodeKind nodeKind();
    public abstract String toString();

    public T getType() { return type;}
    public void setType(T t) {
        type = t;
    }

    public int getDelta(){
        return delta;
    }

    public void setDelta(){
        this.delta = Program.getTableStack().getTotalDelta();
        Program.getTableStack().updateTotalDelta(type.getSize());
    }
}
