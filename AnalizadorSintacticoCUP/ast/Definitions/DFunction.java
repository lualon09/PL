package ast.Definitions;

// import java.util.Collections;
import java.util.List;

import ast.ASTNode;
import ast.Program;
import ast.Instructions.I;
import ast.Instructions.IDeclaration;
import ast.Types.T;
import exc.BindingException;

public class DFunction extends D {

    private String name;
    private List<I> body;
    private List<Parameter> params;
    private T returnType;

    public DFunction(String name, List<I> body, List<Parameter> params, T returnType){
        this.name = name;
        // Collections.reverse(this.body);
        this.body = body;
        this.params = params;
        this.returnType = returnType;
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
        ASTNode node = Program.getTableStack().findId(name);
        if(node != null){
            throw new BindingException("Function " + name + " already declared.");
        }
        else{
            Program.getTableStack().insertId(name, this);
            Program.getTableStack().openBlock();
            for(Parameter p: params){
                p.bind();
            }
            for(I i: body){
                i.bind();
            }
            Program.getTableStack().closeBlock();
        }
    }
    
}
