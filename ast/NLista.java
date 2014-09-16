package compiler.ast;

import java.util.List;
import java.util.LinkedList;

public class NLista extends Node{
	private List<Node> list;
	
	public NLista(){
		list = new LinkedList<Node>();
	}
	
	public void add(Node node){
		list.add(node);
	}
//Metodos
	public void print(String padding){
		for(Node n : list){
			//System.out.println("exp ->");
			n.print(padding);
		}
	}
	
	public void print(){
		print("");
	}
	
	public List<Node> retList(){
		return  list;
	}
	
	public Node ItemLista(int i){
		if (i <list.size()) {
			return list.get(i);
		}else{
			return null;
		}
	}
} 
 
 
