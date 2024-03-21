package ast.Types;

import ast.NodeKind;

public abstract class T {

    public T type;

    public abstract KindT kind();
    public NodeKind nodeKind() {
        return NodeKind.TYPE;
    }
    public String toString(){
        return "";
    }
    
}
