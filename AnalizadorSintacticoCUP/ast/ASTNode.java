package ast;
import exc.BindingException;
import exc.TypingException;
import ast.Types.T;

public abstract class ASTNode {

    public ASTNode bindNode;
    private T type;

    public abstract void type() throws TypingException;
    public abstract void bind() throws BindingException;
    // public ?? generateCode() // for the future
    public abstract NodeKind nodeKind();
    public abstract String toString();

    public T getType() { return type;}
    public void setType(T t) {
        type = t;
        System.out.println("tengo el tipo " + type.toString());
    }
}
