package ast.Definitions;

import ast.Instructions.*;

import java.util.ArrayList;
import java.util.List;

public class DefinitionList {

    private List<IDeclaration> variables;
    private List<DFunction> functions;
    private List<DStruct> structs;
    private List<DTypedef> typedefs;
    private List<DConst> consts;
    
    public DefinitionList(){
        variables = new ArrayList<IDeclaration>(); //variables globales
        functions = new ArrayList<DFunction>();
        structs = new ArrayList<DStruct>();
        typedefs = new ArrayList<DTypedef>();
        consts = new ArrayList<DConst>();
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
    public void addConst(DConst c){
        consts.add(c);
    }
    public String toString(){
        return "Variables globales" + variables.toString() + 
                "Functiones" + functions.toString() + 
                "Structs" + structs.toString() + 
                "Typdedefs" + typedefs.toString() + 
                "Consts" + consts.toString();
    }
}
