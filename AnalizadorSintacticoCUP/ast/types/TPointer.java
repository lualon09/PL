package ast.Types;

import exc.*;
import ast.Program;
import ast.Definitions.DStruct;

public class TPointer extends T {

    
    public TPointer(T t){
        setT(t);
    }

    @Override
    public KindT kind() {
        return KindT.POINTER;
    }

    public String toString(){
        return getT().toString() + "*";
    }

    public boolean equals(Object type2){
        return super.equals(type2) && this.getT().equals(((T) type2).getT());
    }

    // eso no tengo claro si va a aqui, pero habría que hacer binding del tipo de arriba
    public void bind() throws BindingException{
        if(getT().kind().equals(KindT.STRUCT)){ //en el caso de que sea struct hacemos binding con el struct
            getT().bind();
            bindNode = getT().bindNode;
        }
    }

    public int getSize(){
        return 4;
    }
}
