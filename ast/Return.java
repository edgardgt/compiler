package compiler.ast;

public class Return extends Node{
	private Node expr;
	
	public Return(Node e){
		expr = e;
	}
//Metodos
	public void print(String padding){
		System.out.println(padding + "return");
		expr.print(padding + "\t");
	}
	

	public Node retExpr(){
		return expr;
	}
}
