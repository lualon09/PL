package ast.Expressions;
import ast.ASTNode;
import ast.NodeKind;

public abstract class E extends ASTNode {
    public abstract KindE kindExp();
    public E opnd1() {throw new UnsupportedOperationException("opnd1");} 
    public E opnd2() {throw new UnsupportedOperationException("opnd2");} 
    public String num() {throw new UnsupportedOperationException("num");}
    public NodeKind nodeKind() {return NodeKind.EXPRESSION;}
    public String toString() {return "";}

}
