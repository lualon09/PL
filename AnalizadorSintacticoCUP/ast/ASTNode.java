package ast;
import exc.*;
import ast.Types.T;
import java.util.List;
import ast.Definitions.DTypedef;

public abstract class ASTNode {

    public ASTNode bindNode;
    private T type;

    public abstract void typedef(List<DTypedef> typedefs);
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
    public void calculateAddress(){}
    public DTypedef findTypedef(List<DTypedef> typedefs, T t){
        for(int i = 0; i < typedefs.size(); i++){
            if(typedefs.get(i).getName().equals(t.toString())){
                return typedefs.get(i);
            }
        }
        return null;
    }
}
