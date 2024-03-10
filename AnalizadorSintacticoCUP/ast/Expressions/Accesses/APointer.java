package ast.Expressions.Accesses;

public class APointer extends A {

    public APointer(A ac){
        this.bondNode = ac;  
    }

    @Override
    public String toString(){
        return "APointer (*" + bondNode + ")";
    }
}
