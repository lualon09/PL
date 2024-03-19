package ast.Expressions;

public class EConst extends E{
    private String name; //nombre de la constante

    public EConst(String c){
        this.name = c;  
    }

    @Override
    public KindE kindExp() {
        return KindE.CONST;
    }

    public String toString(){
        return "const" + name; //las constantes no tienen tipo porque solo pueden ser enteras
    }
}
