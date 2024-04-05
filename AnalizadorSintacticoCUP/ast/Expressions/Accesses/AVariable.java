package ast.Expressions.Accesses;

public class AVariable extends A {

    private String var;

    public AVariable(String v){
        this.var = v;
    }

    @Override
    public String toString(){
        return "AVar(" + var + ")";
    }
    @Override
    public void bind(){
        ASTNode node = Program.getTableStack().findId(var);
        if(node == null){
            System.out.println("Error. Variable " + var + " not in stack.");
        }
        else{
            this.bindNode = node;
        }
    }
}
