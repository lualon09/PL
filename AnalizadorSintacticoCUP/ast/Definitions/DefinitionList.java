package ast.Definitions;

import ast.Instructions.*;
import exc.BindingException;
import exc.GCodingException;
import exc.TypingException;

import java.net.BindException;
import java.util.ArrayList;
import java.util.List;
import ast.ASTNode;
import ast.NodeKind;
import ast.Program;

public class DefinitionList {

    private List<IDeclaration> variables;
    private List<DFunction> functions;
    private List<DStruct> structs;
    private List<DTypedef> typedefs;
    private List<DConst> consts;
    private List<ASTNode> tree;
    
    public DefinitionList(){
        variables = new ArrayList<IDeclaration>(); //variables globales
        structs = new ArrayList<DStruct>(); //structs
        typedefs = new ArrayList<DTypedef>(); //typedefs
        consts = new ArrayList<DConst>(); //constantes
        tree = new ArrayList<ASTNode>(); //arbol general
        functions = new ArrayList<DFunction>(); //funciones
    }

    public void addNode(ASTNode a){
        tree.add(0,a);
    }

    public void addVar(IDeclaration d){
        variables.add(0, d);
        addNode(d);
    }
    public void addFunc(DFunction f){
        functions.add(0,f);
        addNode(f);
    }
    public void addStruct(DStruct s){
        structs.add(0, s);
        addNode(s);
    }
    public void addTypedef(DTypedef t){
        typedefs.add(0, t);
        addNode(t);
    }
    public void addConst(DConst c){
        consts.add(0, c);
        addNode(c);
    }
    public String toString(){
        StringBuilder s = new StringBuilder();
        for(ASTNode a: tree){
            s.append(a.toString() + ", "); //añadir para que para el ultimo no salga??
        }
        return s.toString();
    }

    public void bind() throws BindingException {
        for(ASTNode a: tree){
            a.bind();
        }
    }

    public void type() throws TypingException {
        for(ASTNode a: tree){
            a.type();
        }
    }

    public void generateCodeGlobal() throws GCodingException {
        for(IDeclaration i: variables){
            i.generateCode();
        }
        for(DConst c: consts){
            c.generateCode();
        }
    }

    public boolean isConst(ASTNode a){
        return a.nodeKind().equals(NodeKind.DEFINITION) && ((D) a).kindD().equals(KindD.CONST);
    }

    public boolean isGlobalVar(ASTNode a){
        return a.nodeKind().equals(NodeKind.INSTRUCTION) && ((I) a).kind().equals(KindI.DECLARATION) && ((IDeclaration) a).getGlobal();
    }

    public void generateCode() throws GCodingException {
        for(ASTNode a: tree){
            if(!isConst(a) && !isGlobalVar(a)){
                a.generateCode();
            }
        }
    }

    public int getMaxMemoryGlobal(){
        int c= 0;
        for(IDeclaration i: variables){
            c += i.getSize();
        }
        for(DConst ct: consts){
            c += ct.getType().getSize();
        }
        return c;
    }

    public int setDelta(int delta){
        int aux = delta;
        for(ASTNode a: tree){
            aux = a.setDelta(aux);
        }
        return aux;
    }

    public void simplifyTypedefs(int p){
        for(int j = p - 1; j >= 0; j--){
            if(typedefs.get(p).getTypedefType().toString().equals(typedefs.get(j).getName())){ //Es igual a uno de los alias definido anteriormente
                simplifyTypedefs(j);
                typedefs.get(p).setType(typedefs.get(j).getType()); //le damos el mismo tipo que al anterior
                return ;
            }
        }
        //si estamos aqui es porque es un tipo basico. no otro alias.
        typedefs.get(p).setType(typedefs.get(p).getTypedefType());
    }

    public void typedefs(){
        for(int i = typedefs.size()-1; i >= 0; i--){
            simplifyTypedefs(i); //simplificamos todos los typedefs
        }
        for(int i = 0; i < tree.size(); i++){
            tree.get(i).typedef(typedefs);
        }
    }

    public void addAll(DefinitionList list){
        List<DStruct> structsImport = list.getStructs();
        for(int i = structsImport.size() - 1; i >= 0; i--){
            addStruct(structsImport.get(i));
        }
        List<ASTNode> treeImport = list.getASTNodes();
        for(int i = treeImport.size() - 1; i >= 0; i--){
            addNode(treeImport.get(i));
        }
        List<IDeclaration> varImport = list.getVar();
        for(int i = varImport.size() - 1; i >= 0; i--){
            addVar(varImport.get(i));
        }
        List<DConst> constImport = list.getConst();
        for(int i = constImport.size() - 1; i >= 0; i--){
            addConst(constImport.get(i));
        }
        List<DTypedef> typedefsImport = list.getTypedefs();
        for(int i = typedefsImport.size() - 1; i >= 0; i--){
            addTypedef(typedefsImport.get(i));
        }
    }

    public List<DStruct> getStructs(){
        return structs;
    }
    public List<ASTNode> getASTNodes(){
       return tree;
    }
    public List<IDeclaration> getVar(){
        return variables;
    }
    public List<DTypedef> getTypedefs(){
        return typedefs;
    }
    public List<DConst> getConst(){
        return consts;
    }

    public boolean thereIsMain(){
        for(DFunction f: functions){
            if(f.getName().equals("main")){
                return true;
            }
        }
        return false;
    }
}
