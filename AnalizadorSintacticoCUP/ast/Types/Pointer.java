package ast.Types;


public class Pointer extends Type {

    
    public Pointer(Type t){
        this.type = t;
    }

    @Override
    public KindTypes kind() {
        return KindTypes.POINTER;
    }

    public String toString(){
        return type.toString() + "*";
    }
}
