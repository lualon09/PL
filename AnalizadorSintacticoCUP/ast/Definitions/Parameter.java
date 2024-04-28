package ast.Definitions;

import ast.Program;
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

    public void calculateAddress(){
        Program.getCode().println(";; loading param" + name);
        super.calculateAddress(); //calculamos la direccion
        if(isRef()){
            Program.getCode().println("i32.load"); //si es por referencia es la direccion de lo que haya en donde el parametro. es el valor como tal
        }
    }

    @Override
    public int setDelta(int delta){ //los parametros siempre ocupan 4, como si fueran un puntero
        if(isRef()){
            this.delta = delta;
            return delta + 4;
        }
        return super.setDelta(delta);
    }
}
