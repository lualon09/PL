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

    public ArrayList<IDeclaration> getFields(){
        // if(fields == null){
        //     for(DStruct s: Program.getDefinitionList().getStructs()){
        //         if(name.equals(s.getName())) {
        //             fields = s;
        //         }
        //     }
        // }
        // else return fields;
        return null;
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
}
