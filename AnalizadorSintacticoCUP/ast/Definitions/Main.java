package ast.Definitions;

import java.util.List;

import ast.Instructions.I;
import ast.Types.*;

public class Main extends DFunction {

    public Main(String name, List<I> body, T returnType) {
        super("main", body, null, new TBasics(KindT.INT));
    }
    
}
