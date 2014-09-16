package compiler.ast;

public class Variable extends Node{
	//campos
	private String tipo;
	private String id;
	private int tamanio;

	//constructor
	public Variable(String t, String i){
		tipo = t;
		id = i;
		tamanio = 0;
	}
	
	public Variable(String t, String i, String s){
		tipo = t;
		id = i;
		tamanio = Integer.parseInt(s);
	}

	//metodos	
	public void print(String padding){
		if (tamanio>0){
			System.out.println(padding + "array");
			System.out.println(padding + "\t" + tipo);
			System.out.println(padding + "\t" + id);
			System.out.println(padding + "\t" + tamanio);
		}else{
			System.out.println(padding + "var");
			System.out.println(padding + "\t" + tipo);
			System.out.println(padding + "\t" + id);
		}
	}
	
	public String retTipo(){
		return tipo;
	}
	
	public String retID(){
		return id;
	}
	
	public int retTamanio(){
		return tamanio;
	}
} 
