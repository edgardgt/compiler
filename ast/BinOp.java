package compiler.ast;

public class BinOp extends Node{
	//campos
	private String operator;
	private Node left;
	private Node right;
	
	// constructor
	public BinOp(String op, Node l, Node r){
		operator = op;
		left = l;
		right = r;
	}
	
	// metodos
	public void print(String padding){
		System.out.println(padding + operator);
		left.print(padding + "\t");
		right.print(padding + "\t");
	}
	
	public String retOperator(){
		return operator;
	}
	
	public Node retLeft(){
		return left;
	}
	
	public Node retRight(){
		return right;
	}
} 
