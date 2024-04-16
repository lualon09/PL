package ast.Instructions;

import ast.Program;
import ast.Expressions.E;
import ast.Types.KindT;
import ast.Types.T;
import ast.Types.TBasics;
import exc.BindingException;
import exc.TypingException;

public class IReturn extends I{

    private E expReturn;

    public IReturn (E exp){
        this.expReturn = exp;
    }
    public IReturn (){
        this.expReturn = null;
    }

    @Override
    public KindI kind() {
        return KindI.RETURN;
    }
    
    public String toString(){
        if(expReturn == null){
            return "return VOID";
        }
        return "return " + expReturn.toString();
    }

    public void bind() throws BindingException {
        if(expReturn != null){ //Si tiene tipo de retorno
            expReturn.bind();
        }
        // buscamos a que función se vincula el return
    }

    public void type() throws TypingException {
        expReturn.type();
        setType(expReturn.getType());
        T typeReturn = Program.getTableStack().lastFunctionReturnType();
        if(typeReturn == null) {
            throw new TypingException("Error. Function not found. Return shouldn't be there");
        }
        else{
            if(expReturn == null && !typeReturn.equals(new TBasics(KindT.VOID))){
                throw new TypingException("Error. Function doesn't return void.");
            }
            else if(expReturn != null && !typeReturn.equals(expReturn.getType())){
                throw new TypingException("Error. Function returns " + typeReturn.toString() + " and got " + expReturn.getType().toString());
            }
        }
    }
}
