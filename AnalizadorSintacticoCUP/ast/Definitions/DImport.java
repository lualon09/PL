package ast.Definitions;

import java.util.List;

import ast.ASTNode;
import ast.NodeKind;
import exc.BindingException;
import exc.TypingException;
import exc.GCodingException;

public class DImport extends D {

    private String name;

    public DImport(String name){
        this.name = "examples/" + name + ".txt";
    }

    public String getModuleName(){
        return this.name;
    }

    public String toString(){
        return "import " + name;
    }

    @Override
    public KindD kindD() {
        return KindD.IMPORT;
    }
}
