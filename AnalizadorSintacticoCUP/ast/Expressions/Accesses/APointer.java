package ast.Expressions.Accesses;

public class APointer extends A {

    private A access;

    public APointer(A ac){
          this.access = ac;
    }

    @Override
    public String toString(){
        return "APointer (*" +  access.toString() + ")";
    }
}
