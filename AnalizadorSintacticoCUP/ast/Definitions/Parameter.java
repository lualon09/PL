package ast.Definitions;

import ast.Instructions.IDeclaration;
import ast.Types.T;
import exc.BindingException;


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

    public boolean isRef(){
        return ref;
    }

    // @Override
    // public int setDelta(int delta){ //los parametros siempre ocupan 4, como si fueran un puntero
    //     if(isRef()){
    //         this.delta = delta;
    //         return delta + 4;
    //     }
    //     return super.setDelta(delta);
    // }
}
