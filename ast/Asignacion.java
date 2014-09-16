package compiler.ast;

public class Asignacion extends Node{
	//campos
	private Node location;
	private String operator;
	private Node expr;
	
	// constructor
	public Asignacion(Node l, String o, Node e){
		location = l;
		operator = o;
		expr = e;
	}
	
	// metodos
	public void print(String padding){
		System.out.println(padding + operator);
		location.print(padding + "\t");
		expr.print(padding + "\t");
	}

	public Node retLocation(){
		return location;
	}
	
	public String retOperator(){
		return operator;
	}

	public Node retExpr(){
		return expr;
	}	
} 
