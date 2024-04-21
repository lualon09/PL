package ast;

import ast.Definitions.DefinitionList;
import exc.BindingException;
import exc.TypingException;
import java.util.ArrayList;

public class Program extends ASTNode {

    private static DefinitionList definitionList;
    private static SymbolsTableStack stack;
    private static ArrayList<String> typeList = new ArrayList<String>(); //yo creo que esto puede sobrar

    public Program(DefinitionList list){
        this.definitionList = list;
        this.stack = new SymbolsTableStack();
    }

    @Override
    public NodeKind nodeKind() {
        return NodeKind.PROGRAM;
    }

    @Override
    public String toString() {
       return "program {" + definitionList.toString() + "}";
    }

    public static SymbolsTableStack getTableStack(){
        return stack;
    }

    public void bind() throws BindingException{
        stack.openBlock();
        definitionList.bind();
        stack.closeBlock();
    }

    public void type() throws TypingException {
        definitionList.type();
    }

    public static void addType(String t) {
        typeList.add(t);
    }

    public static DefinitionList getDefinitionList() {
        return definitionList;
    }
}
