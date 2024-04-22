package ast.Types;

import ast.Program;
import ast.Definitions.DStruct;
import ast.ASTNode;
import ast.Instructions.IDeclaration;
import java.util.ArrayList;
import exc.BindingException;

public class TStruct extends T {

    private String name;
    
    public TStruct(String name){
        this.name = name;
    }

    @Override
    public KindT kind() {
        return KindT.STRUCT;
    }

    public String toString(){
        return name;
    }

    public void bind() throws BindingException{
        boolean found = false;
        for(DStruct s: Program.getDefinitionList().getStructs()){
            if(name.equals(s.getName())) {
                bindNode = s;
                found = true;
            }
        }
        if(!found) throw new BindingException("Error. Struct name " + name + " not found.");
    }

    @Override
    public boolean equals(Object type2){
        return super.equals(type2) && this.toString().equals(type2.toString()); //comprobamos que ambos sean structs y que se llamen igual
    }

    public int getSize(){
        // ya tenemos los campos porque se habrá hecho el binding antes
        int size = 0;
        for(IDeclaration d: ((DStruct) bindNode).getFields()){ 
            size += d.getSize();
        }

        return size;
    }
}
