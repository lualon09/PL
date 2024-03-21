package ast.Types;

public class TBasics extends T{

    private KindT tipo;

    public TBasics(KindT tipo){
        this.tipo = tipo;
    }

    @Override
    public KindT kind() {
        return this.tipo;
    }

    public String toString(){
        return tipo.toString();
    }
    
}
