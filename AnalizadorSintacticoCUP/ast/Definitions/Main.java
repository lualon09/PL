package ast.Definitions;

import java.util.List;

import ast.Instructions.I;
import ast.Types.*;

public class Main extends DFunction {

    public Main(String name, List<I> body, Type returnType) {
        super("main", body, null, new BasicTypes(KindTypes.INT));
    }
    
}
