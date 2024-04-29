package ast.Definitions;

// import java.util.Collections;
import java.util.List;

import ast.ASTNode;
import ast.Program;
import ast.Instructions.I;
import ast.Instructions.IDeclaration;
import ast.Types.T;
import exc.BindingException;
import exc.GCodingException;
import exc.TypingException;
import ast.Instructions.IReturn;
import ast.Instructions.KindI;
import ast.Types.KindT;
import ast.Instructions.IBlock;
import ast.Types.TBasics;

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
        // if(returnType.kind().equals(KindT.ARRAY) || returnType.kind().equals(KindT.STRUCT)){ AHORA SI QUE LO PERMITIMOS
        //     throw new BindingException("Function " + name + " does not return INT, BOOL or VOID.");
        // }
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
        if(!body.get(body.size() - 1).kind().equals(KindI.RETURN)){
            throw new BindingException("The return instruction must be the last one in the function.");
        }
    }

    @Override
    public void type() throws TypingException {
        for(Parameter p: params){
            p.type();
        }
        for(I i: body){
            i.type();
        }
        // returnType.type(); deberiamos de ponerlo por si acaso devuelve algo de tipo struct?
    }

    public List<Parameter> getParameters(){
        return params;
    }

    public T getReturnType(){
        return returnType;
    }

    public int setDelta(int delta){

        int deltaFunction = 0;
        for(Parameter p: params){
            deltaFunction = p.setDelta(deltaFunction);
        }
        for(I i: body){
            deltaFunction = i.setDelta(deltaFunction);
        }
        return delta;
    }

    public int maxMemory(){
        int c = 0;
        int max = 0;

        for(int i = 0; i < params.size(); i++){
            c += params.get(i).getSize();
        }
        for(int i = 0; i < body.size(); i++){
            if(body.get(i).kind().equals(KindI.DECLARATION)){
                c += ((IDeclaration) body.get(i)).getSize();
            }
            else if(body.get(i) instanceof IBlock){
                int blockSize = ((IBlock) body.get(i)).maxMemory();
                if(c + blockSize > max){
                    max = c + blockSize;
                }
            }
        }
        if(c > max){ //por si acaso lo del final han sido variables
            max = c;
        }
        return max;
    }

    public void generateCode() throws GCodingException {
        Program.getCode().println(" ;; generating code of function " + name);
        int size = maxMemory() + 8; // (params + locals + 2)*4
        Program.getCode().println("(func $" + name);
        if(!returnType.equals(new TBasics(KindT.VOID))){
            Program.getCode().print(" (result i32)");
        }
        Program.getCode().println("");
        
        Program.preFunction(size);
        //algo con los parametros??

        // generamos codigo de las instrucciones
        for(I i: body){
            i.generateCode();
        }
        // como obligamos a que siempre haya return y sea la ultima instruccion, no hace falta hacer nada
        Program.getCode().println(")");
    }   
}
