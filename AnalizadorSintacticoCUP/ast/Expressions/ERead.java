package ast.Expressions;

import ast.Program;
import exc.BindingException;
import exc.GCodingException;

public class ERead extends E{

    public ERead(){}

    @Override
    public KindE kindExp() {
        return KindE.READ;
    }

    public String toString(){
        return "read()"; 
    }
    
    public void bind() throws BindingException{}

    public void generateCode() throws GCodingException {
        Program.getCode().println(" call $read");
    }
}
