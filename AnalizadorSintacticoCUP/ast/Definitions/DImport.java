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
        this.name = name;
    }

    public String getModuleName(){
        return this.name;
    }
}
