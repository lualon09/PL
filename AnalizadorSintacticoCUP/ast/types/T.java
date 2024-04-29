package ast.Types;

import ast.NodeKind;
import ast.Definitions.DTypedef;
import exc.BindingException;
import exc.GCodingException;
import exc.TypingException;

import java.util.List;

import ast.ASTNode;

public abstract class T extends ASTNode {

    private T type;

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
    public void generateCode() throws GCodingException {}
    public void typedef(List<DTypedef> typedefs){}
    public int setDelta(int delta) { return delta; }

    @Override
    public boolean equals(Object type2){
        boolean equals = false;
        try{
            equals = ((T) this).kind() == ((T) type2).kind();
        }catch(Exception e){
            return false;
        }
        return equals;
    }

    public abstract int getSize();
}
