package ast;

import ast.Definitions.DefinitionList;
import exc.BindingException;

public class Program extends ASTNode {

    private DefinitionList list;
    public static SymbolsTableStack stack;

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

    public static SymbolsTableStack getTableStack(){
        return stack;
    }

    public void bind() throws BindingException{
        stack.openBlock();
        list.bind();
        stack.closeBlock();
    }
    
}
