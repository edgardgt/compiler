package compiler.ast;

public class Identificador extends Node{
	//campos
	private String value;
	
	//constructor
	public Identificador(String v){
		value = v;
	}
	
	//metodos
	public void print(String padding){
		System.out.println(padding + value);
	}
	
	public String retValue(){
		return value;
	}
}
