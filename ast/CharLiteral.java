package compiler.ast;

public class CharLiteral extends Node{
	//campos
	private String value;
	
	// constructor
	public CharLiteral(String v){
		value = v;
	}
	
	// metodos
	public void print(String padding){
		System.out.println(padding + value);
	}
	
	public String retValue(){
		return value;
	}
}
