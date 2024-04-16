package ast.Types;


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
        return super.equals(type2) && this.getT().equals(type2);
    }
}
