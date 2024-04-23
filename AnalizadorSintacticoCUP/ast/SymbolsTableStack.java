package ast;

import java.net.BindException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ast.Definitions.KindD;
import errors.GestionErroresTiny;
import exc.BindingException;

import ast.Types.T;
import ast.ASTNode;

import ast.Definitions.*;

public class SymbolsTableStack {

    private List<HashMap<String,ASTNode>> blocks; 
    private int totalDelta;

    public SymbolsTableStack(){
        this.blocks = new ArrayList<HashMap<String,ASTNode>>();
        this.totalDelta = 0;
    }

    public void openBlock(){
        blocks.add(new HashMap<>());
    }

    public void closeBlock(){
        blocks.remove(blocks.size()-1);
    }

    public void insertId(String id, ASTNode node) throws BindingException{
        HashMap<String,ASTNode> lastBlock = blocks.get(blocks.size()-1); //take the last block
		if(lastBlock.containsKey(id)) {
			throw new BindingException("Error. Variable " + id + " has already been declared.");
		}else {
			lastBlock.put(id,node);
		}
    }

    public ASTNode findId(String id){
        for(int i = blocks.size()-1;i>=0;i--) { //iterate over the list
			if(blocks.get(i).containsKey(id)) {
				return blocks.get(i).get(id);
			}
		}
		return null;
    }
    public int getNumberOfAmbits(){
        return blocks.size();
    }
}
