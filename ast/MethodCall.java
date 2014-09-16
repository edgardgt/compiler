package compiler.ast;

//import java.util.List;
//import java.util.LinkedList;

public class MethodCall extends Node{
	private String id;
	private Node expr;
	
	public MethodCall(String n, Node e){
		id = n;
		expr = e;
	}
// Metodos	
	public void print(String padding){
		System.out.println(padding + "metodo_call");
		System.out.println(padding + "\t" + id);
		expr.print(padding + "\t");
	}

	public String retId(){
		return id;
	}
	
	public Node retExpr(){
		return expr;
	}
} 
