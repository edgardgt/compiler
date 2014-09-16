package compiler.ast;

public class IntLiteral extends Node{
	//campos
	private int value;
	
	//constructor
	public IntLiteral(String v){
		value = Integer.parseInt(v);
	}
	
	//metodos
	public void print(String padding){
		System.out.println(padding + value);
	}
	
	public int retValue(){
		return value;
	}
}
