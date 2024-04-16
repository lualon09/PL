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

    public SymbolsTableStack(){
        blocks = new ArrayList<HashMap<String,ASTNode>>();
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
            System.out.println("Estoy insertando " + id + " en la posición de blocks " + (blocks.size() - 1) + " y soy " + node);
			lastBlock.put(id,node);
		}
    }

    public ASTNode findId(String id){
        for(int i = blocks.size()-1;i>=0;i--) { //iterate over the list
			if(blocks.get(i).containsKey(id)) {
                System.out.println("Soy " + id + " y me asocio con " + blocks.get(i).get(id));
				return blocks.get(i).get(id);
			}
		}
		return null;
    }

    // public ASTNode lastFunctionReturnType(){
    //     for(int i = blocks.size()-1;i>=0;i--) { //iterate over the list
	// 		HashMap<String,ASTNode> aux_map = blocks.get(i);
    //         for(ASTNode a: aux_map.values()){
    //             if(a.nodeKind() == NodeKind.DEFINITION && ((D) a).kindD().equals(KindD.FUNCTION)) {
    //                 return a;
    //             }
	// 		}
	// 	}
	// 	return null;
    // }

    public int getNumberOfAmbits(){
        return blocks.size();
    }
    
}
