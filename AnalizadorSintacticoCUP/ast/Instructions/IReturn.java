package ast.Instructions;

import ast.Program;
import ast.Definitions.DFunction;
import ast.Expressions.E;
import ast.Types.KindT;
import ast.Types.T;
import ast.Types.TArray;
import ast.Types.TBasics;
import exc.BindingException;
import exc.GCodingException;
import exc.TypingException;

public class IReturn extends I{

    private E expReturn;
    private DFunction function;

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

    public void setFunction(DFunction f){
        function = f;
    }

    public void bind() throws BindingException {
        if(expReturn != null){ //Si tiene tipo de retorno
            expReturn.bind();
        }
        int ambit = Program.getTableStack().getNumberOfAmbits();
        if(ambit > 2){
            throw new BindingException("There is a return instruction not in ambit 1.");
        }
    }

    public void type() throws TypingException {

        if(expReturn != null){
            expReturn.type();
            setType(expReturn.getType());
        }
        T functionReturnType = function.getReturnType();
        functionReturnType.type();
        if(functionReturnType == null) {
            throw new TypingException("Error. Function not found. Return shouldn't be there");
        }
        else{  
            if(expReturn == null && !functionReturnType.equals(new TBasics(KindT.VOID))){
                throw new TypingException("Error. Function doesn't return void.");
            }
            else if(expReturn != null && !functionReturnType.equals(expReturn.getType())){
                throw new TypingException("Error. Function returns " + functionReturnType.toString() + " and got " + expReturn.getType().toString());
            }
        }
    }

    public void generateCode() throws GCodingException {
        Program.getCode().println(" ;; generating code for IReturn");
        if(expReturn != null){
            if(expReturn.getType().kind().equals(KindT.ARRAY) || expReturn.getType().kind().equals(KindT.STRUCT)){
                expReturn.calculateAddress();
            }
            else{
                expReturn.generateCode();
            }
        }
        Program.endFunction();
        Program.getCode().println(" return");
    }
}
