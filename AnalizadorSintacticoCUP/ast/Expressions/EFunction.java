package ast.Expressions;

import java.util.ArrayList;

import ast.ASTNode;
import ast.Program;
import exc.BindingException;

public class EFunction extends E{

    private String functionName;
    public ArrayList<E> p; //lista de parámetros de la funcion

    public EFunction(String f, ArrayList<E> p){
        this.functionName = f; 
        this.p = p;
    }

    @Override
    public KindE kindExp() {
        return KindE.FUNCTION;
    }

    public String toString(){
        return "call:" + functionName + "(" + p.toString() + ")";
    }
    @Override
    public void bind() throws BindingException {
        ASTNode node = Program.getTableStack().findId(functionName); //search the function
        if(node == null){
            throw new BindingException("Function " + functionName + " not in stack.");
        }
        else{
            this.bindNode = node;
            for(E arg : p){
                arg.bind();
            }
        }
    }
}
