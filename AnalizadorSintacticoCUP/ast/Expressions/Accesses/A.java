package ast.Expressions.Accesses;

import ast.Expressions.E;
import ast.Expressions.KindE;

public abstract class A extends E{
    
    public KindE kindExp(){
        return KindE.ACCESS;
    }
}
