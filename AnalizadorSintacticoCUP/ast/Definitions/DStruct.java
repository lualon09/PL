package ast.Definitions;

import java.util.List;

import javax.naming.Binding;

import ast.ASTNode;
import ast.Program;
import ast.Instructions.IDeclaration;
import exc.BindingException;
import exc.TypingException;

public class DStruct extends D{
    private String name;
    private List<IDeclaration> fields;
    
    public DStruct(String name, List<IDeclaration> fields){
        this.name = name;
        this.fields = fields;
        Program.addType(name);
    }
    @Override
    public KindD kindD() {
        return KindD.STRUCT;
    }
    public String toString(){
        return "struct " + name.toString() + "{" + fields.toString() + "}";
    }

    public String getName(){
        return this.name;
    }

    public List<IDeclaration> getFields() {
        return fields;
    }

    public void bind() throws BindingException {  
        Program.getTableStack().insertId(name, this); 
        Program.getTableStack().openBlock(); //comprobamos que no haya dos campos que se llamen igual en la declaracion del struct 
        for(IDeclaration i: fields){
            i.bind();
        }
        Program.getTableStack().closeBlock();
    }

    public void type() throws TypingException {
        for(IDeclaration d: fields){
            d.type();
        }
    }

    public int setDelta(int delta) {
        int deltaStruct = 0;
        for(IDeclaration i: fields){
            deltaStruct = i.setDelta(deltaStruct);
            System.out.println("Somos los deltas del struct y valgo " + deltaStruct);
        }
        return delta;
    }
}
