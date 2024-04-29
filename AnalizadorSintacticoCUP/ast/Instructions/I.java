package ast.Instructions;
import java.util.List;

import ast.ASTNode;
import ast.NodeKind;
import ast.Definitions.DTypedef;
import exc.BindingException;
import exc.GCodingException;
import exc.TypingException;

public abstract class I extends ASTNode {

    public abstract KindI kind();
    public String num() {throw new UnsupportedOperationException("num");}
    public NodeKind nodeKind() {return NodeKind.INSTRUCTION;}
    public String toString() {return "";}

    public void bind() throws BindingException {}
    public void type() throws TypingException {}
    public void generateCode() throws GCodingException{}
    public void typedef(List<DTypedef> typedefs){}

    public int setDelta(int delta){
        return delta;
    }
    
}