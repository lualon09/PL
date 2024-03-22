package ast.Definitions;

import ast.Instructions.*;

import java.util.ArrayList;
import java.util.List;

public class DefinitionList {

    private List<IDeclaration> variables;
    private List<DFunction> functions;
    private List<DStruct> structs;
    private List<DTypedef> typedefs;
    
    public DefinitionList(){
        variables = new ArrayList<IDeclaration>();
        functions = new ArrayList<DFunction>();
        structs = new ArrayList<DStruct>();
        typedefs = new ArrayList<DTypedef>();
    }

    public void addVar(IDeclaration d){
        variables.add(d);
    }
    public void addFunc(DFunction f){
        functions.add(f);
    }
    public void addStruct(DStruct s){
        structs.add(s);
    }
    public void addTypedef(DTypedef t){
        typedefs.add(t);
    }
}
