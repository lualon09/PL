package ast.Expressions;

import java.util.ArrayList;

import ast.ASTNode;
import ast.Program;

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
    public void bind(){
        ASTNode node = Program.getTableStack().findId(functionName); //search the function
        if(node == null){
            System.out.println("Error. Function " + functionName + " not in stack.");
        }
        else{
            this.bindNode = node;
            for(E arg : p){
                arg.bind();
            }
        }
    }
}
