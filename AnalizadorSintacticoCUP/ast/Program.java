package ast;

import ast.Definitions.DefinitionList;

public class Program extends ASTNode {

    private DefinitionList list;

    public Program(DefinitionList list){
        this.list = list;
    }

    @Override
    public NodeKind nodeKind() {
        return NodeKind.PROGRAM;
    }

    @Override
    public String toString() {
       return "program" + list.toString();
    }
    
}
