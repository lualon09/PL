package ast.Instructions;

import ast.Expressions.EFunction;
import ast.Types.TBasics;
import ast.ASTNode;
import ast.Program;
import exc.*;
import ast.Types.KindT;


public class IFunction extends I{

    private EFunction exp;

    public IFunction(EFunction e){
        this.exp = e;
    }

    @Override
    public KindI kind() {
        return KindI.FUNCTION;
    }

    public String toString(){
        return "Instruction " + exp.toString();
    }

    @Override
    public void bind() throws BindingException {
        exp.bind();
    }

    public void type() throws TypingException {
        exp.type(); 
        setType(exp.getType()); //le asignamos el tipo que devuelve
    }

    public void generateCode() throws GCodingException{
        exp.generateCode();
        Program.getCode().println(" drop"); //quitamos el valor de la pila
        // if(getType().equals(new TBasics(KindT.VOID))){
        //     Program.getCode().println(" drop"); //quitamos el valor en la cima de la pila
        // }
    }
}
