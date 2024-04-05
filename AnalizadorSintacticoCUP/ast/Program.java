package ast;

import ast.Definitions.DefinitionList;

public class Program extends ASTNode {

    private DefinitionList list;
    private SymbolsTableStack stack;

    public Program(DefinitionList list){
        this.list = list;
        this.stack = new SymbolsTableStack();
    }

    @Override
    public NodeKind nodeKind() {
        return NodeKind.PROGRAM;
    }

    @Override
    public String toString() {
       return "program {" + list.toString() + "}";
    }

    public SymbolsTableStack getTableStack(){
        return stack;
    }

    public void bind(){
        stack.openBlock();
        list.bind();
        stack.closeBlock();
    }
    
}
