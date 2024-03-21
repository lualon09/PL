package ast.types;


public class TPointer extends T {

    
    public TPointer(T t){
        this.type = t;
    }

    @Override
    public KindT kind() {
        return KindT.POINTER;
    }

    public String toString(){
        return type.toString() + "*";
    }
}
