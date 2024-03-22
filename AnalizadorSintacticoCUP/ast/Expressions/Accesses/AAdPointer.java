package ast.Expressions.Accesses;

public class AAdPointer extends A{
    
    private A access;

    public AAdPointer(A ac){
          this.access = ac;
    }

    @Override
    public String toString(){
        return "AAdPointer (&" +  access.toString() + ")";
    }
}
