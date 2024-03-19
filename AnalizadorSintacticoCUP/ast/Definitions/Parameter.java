package ast.Definitions;

import ast.Instructions.Declaration;
import ast.Types.Type;


public class Parameter extends Declaration {

    private boolean ref = false;

    public Parameter(String name, Type t, boolean ref){
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
