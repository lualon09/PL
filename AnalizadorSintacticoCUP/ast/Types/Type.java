package ast.Types;

import ast.NodeKind;

public abstract class Type {

    public Type type;

    public abstract KindTypes kind();
    public NodeKind nodeKind() {
        return NodeKind.TYPE;
    }
    public String toString(){
        return "";
    }
    
}
