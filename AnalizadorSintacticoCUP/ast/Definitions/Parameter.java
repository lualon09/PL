package ast.Definitions;

import ast.Instructions.IDeclaration;
import ast.types.T;


public class Parameter extends IDeclaration {

    private boolean ref = false;

    public Parameter(String name, T t, boolean ref){
        super(t, name);
        this.ref = ref;
    }

    public String toString(){
        if(!ref){
            return name.toString() + ":" + type.toString();
        }
        return name.toString() + ":&" + type.toString();
    }
}
