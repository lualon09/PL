package ast.Definitions;

import ast.Instructions.*;
import exc.BindingException;
import exc.TypingException;

import java.net.BindException;
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
            variables.add(0, d);
    }
    public void addFunc(DFunction f){
        functions.add(0, f);
    }
    public void addStruct(DStruct s){
        structs.add(0, s);
    }
    public void addTypedef(DTypedef t){
        typedefs.add(0, t);
    }
    public void addConst(DConst c){
        consts.add(0, c);
    }
    public String toString(){
        StringBuilder s = new StringBuilder();
        if(!variables.isEmpty()){
            s.append("Global variables" + variables.toString() + " ");
        }
        if (!consts.isEmpty()){
            s.append("Consts" + consts.toString()+ " ");
        }
        if (!typedefs.isEmpty()){
            s.append("Typedefs" + typedefs.toString()+ " ");
        }
        if (!structs.isEmpty()){
            s.append("Structs" + structs.toString()+ " ");
        }
        if (!functions.isEmpty()){
            s.append("Functions" + functions.toString()+ " ");
        }
        return s.toString();
    }

    public void bind() throws BindingException {
        for(IDeclaration var: variables){ //vinculamos las variables globales
            var.bind();
        }
        for(DConst c: consts){ //vinculamos las constantes
            c.bind();
        }
        for(DTypedef t: typedefs){ //vinculamos los typedefs
            t.bind();
        }
        for(DStruct s: structs){ //vinculamos los structs
            s.bind();
        }
        for(DFunction f: functions){ //vinculamos las funciones
            f.bind();
        }
    }

    public void type() throws TypingException {
        for(IDeclaration var: variables){ //chequeamos tipos las variables globales
            var.type();
        }
        for(DConst c: consts){ //chequeamos las constantes
            c.type();
        }
        for(DTypedef t: typedefs){ //chequeamos los typedefs
            t.type();
        }
        for(DStruct s: structs){ //chequeamos los structs
            s.type();
        }
        for(DFunction f: functions){ //chequeamos las funciones
            f.type();
        }
    }

    public List<DStruct> getStructs(){
        return structs;
    }
}
