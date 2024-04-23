package ast.Instructions;
import ast.ASTNode;
import ast.NodeKind;
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
    
}