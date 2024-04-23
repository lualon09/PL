package ast.Definitions;

import ast.Instructions.*;
import exc.BindingException;
import exc.TypingException;

import java.net.BindException;
import java.util.ArrayList;
import java.util.List;
import ast.ASTNode;

public class DefinitionList {

    private List<IDeclaration> variables;
    private List<DFunction> functions;
    private List<DStruct> structs;
    private List<DTypedef> typedefs;
    private List<DConst> consts;
    private List<ASTNode> tree;
    
    public DefinitionList(){
        variables = new ArrayList<IDeclaration>(); //variables globales
        functions = new ArrayList<DFunction>();
        structs = new ArrayList<DStruct>();
        typedefs = new ArrayList<DTypedef>();
        consts = new ArrayList<DConst>();
        tree = new ArrayList<ASTNode>();
    }

    public void addNode(ASTNode a){
        tree.add(0,a);
    }

    public void addVar(IDeclaration d){
        // variables.add(0, d);
        addNode(d);
    }
    public void addFunc(DFunction f){
        // functions.add(0, f);
        addNode(f);
    }
    public void addStruct(DStruct s){
        structs.add(0, s);
        addNode(s);
    }
    public void addTypedef(DTypedef t){
        // typedefs.add(0, t);
        addNode(t);
    }
    public void addConst(DConst c){
        //consts.add(0, c);
        addNode(c);
    }
    public String toString(){
        StringBuilder s = new StringBuilder();
        for(ASTNode a: tree){
            s.append(a.toString());
        }
        // if(!variables.isEmpty()){
        //     s.append("Global variables" + variables.toString() + " ");
        // }
        // if (!consts.isEmpty()){
        //     s.append("Consts" + consts.toString()+ " ");
        // }
        // if (!typedefs.isEmpty()){
        //     s.append("Typedefs" + typedefs.toString()+ " ");
        // }
        // if (!structs.isEmpty()){
        //     s.append("Structs" + structs.toString()+ " ");
        // }
        // if (!functions.isEmpty()){
        //     s.append("Functions" + functions.toString()+ " ");
        // }
        return s.toString();
    }

    public void bind() throws BindingException {
        for(ASTNode a: tree){
            a.bind();
        }
        // for(IDeclaration var: variables){ //vinculamos las variables globales
        //     var.bind();
        // }
        // for(DConst c: consts){ //vinculamos las constantes
        //     c.bind();
        // }
        // for(DTypedef t: typedefs){ //vinculamos los typedefs
        //     t.bind();
        // }
        // for(DStruct s: structs){ //vinculamos los structs
        //     s.bind();
        // }
        // for(DFunction f: functions){ //vinculamos las funciones
        //     f.bind();
        // }
    }

    public void type() throws TypingException {
        for(ASTNode a: tree){
            a.type();
        }
        // for(IDeclaration var: variables){ //chequeamos tipos las variables globales
        //     var.type();
        // }
        // for(DConst c: consts){ //chequeamos las constantes
        //     c.type();
        // }
        // for(DTypedef t: typedefs){ //chequeamos los typedefs
        //     t.type();
        // }
        // for(DStruct s: structs){ //chequeamos los structs
        //     s.type();
        // }
        // for(DFunction f: functions){ //chequeamos las funciones
        //     f.type();
        // }
    }

    public List<DStruct> getStructs(){
        return structs;
    }

    public int setDelta(int delta){
        int aux = delta;
        for(ASTNode a: tree){
            aux = a.setDelta(aux);
        }
        return aux;
    }
}
