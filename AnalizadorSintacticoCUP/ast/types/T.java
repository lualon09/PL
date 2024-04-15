package ast.Types;

import ast.NodeKind;
import exc.BindingException;
import exc.TypingException;
import ast.ASTNode;

public abstract class T extends ASTNode {

    public T type;

    public abstract KindT kind();
    public NodeKind nodeKind() {
        return NodeKind.TYPE;
    }
    public String toString(){
        return "";
    }
    
    public T getT(){
        return type;
    }

    public void setT(T t){
        type = t;
    }

    public void bind() throws BindingException{}
    public void type() throws TypingException{}
}
