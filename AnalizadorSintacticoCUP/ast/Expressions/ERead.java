package ast.Expressions;

import exc.BindingException;

public class ERead extends E{

    public ERead(){
        // this.type = new BasicTypes(KindTypes.INT); //solo leemos enteros
    }

    @Override
    public KindE kindExp() {
        return KindE.READ;
    }

    public String toString(){
        return "read()"; 
    }
    
    public void bind() throws BindingException{}
}
