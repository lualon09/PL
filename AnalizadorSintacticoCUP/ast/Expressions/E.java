package ast.Expressions;
import ast.ASTNode;
import ast.NodeKind;

import exc.*;

public abstract class E extends ASTNode {
    public abstract KindE kindExp();
    public E opnd1() {throw new UnsupportedOperationException("opnd1");} 
    public E opnd2() {throw new UnsupportedOperationException("opnd2");} 
    public String num() {throw new UnsupportedOperationException("num");}
    public NodeKind nodeKind() {return NodeKind.EXPRESSION;}
    public String toString() {return "";}

    public void bind() throws BindingException {}
    public void type() throws TypingException {}
    public void generateCode() throws GCodingException{}

    public int setDelta(int delta){
        return delta;
    }

}
