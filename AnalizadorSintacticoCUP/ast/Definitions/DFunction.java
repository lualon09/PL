package ast.Definitions;

// import java.util.Collections;
import java.util.List;

import ast.ASTNode;
import ast.Program;
import ast.Instructions.I;
import ast.Instructions.IDeclaration;
import ast.Types.T;
import exc.BindingException;
import exc.TypingException;
import ast.Instructions.IReturn;
import ast.Instructions.KindI;

public class DFunction extends D {

    private String name;
    private List<I> body;
    private List<Parameter> params;
    private T returnType;
    private int numberOfReturns;

    public DFunction(String name, List<I> body, List<Parameter> params, T returnType){
        this.name = name;
        this.body = body;
        this.params = params;
        this.returnType = returnType;
        this.numberOfReturns = 0;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("func " + name.toString() + "(");
        if(!params.isEmpty()){
            s.append(params.toString());
        }
        s.append(")->" + returnType.toString() + "{" + body.toString() + "}");
        return s.toString();
    }

    @Override
    public KindD kindD() {
        return KindD.FUNCTION;
    }

    public void bind() throws BindingException{

        Program.getTableStack().insertId(name, this);
        Program.getTableStack().openBlock();
        for(Parameter p: params){
            p.bind();
        }
        returnType.bind(); //deberiamos de ponerlo por si acaso devuelve algo de tipo struct?
        for(I i: body){
            if(i.kind().equals(KindI.RETURN)){
                ((IReturn) i).setFunction(this);
                numberOfReturns++;
            }
            i.bind();
        }
        Program.getTableStack().closeBlock();
        if(numberOfReturns != 1){
            throw new BindingException("There is no return or more than one return in " + name + " function.");
        }
    }

    @Override
    public void type() throws TypingException {
        for(I i: body){
            i.type();
        }
        for(Parameter p: params){
            p.type();
        }
        // returnType.type(); deberiamos de ponerlo por si acaso devuelve algo de tipo struct?
    }

    public List<Parameter> getParameters(){
        return params;
    }

    public T getReturnType(){
        return returnType;
    }


    
}
