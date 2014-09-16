package compiler.ast;

public class Bloque extends Node{
	//campos
	private Node var_decl;
	private Node sentencia;
	
	// constructor
	public Bloque(Node vd, Node st){
		var_decl = vd;
		sentencia = st;
	}
	
	// metodos
	public void print(String padding){
		System.out.println(padding + "bloque");
		var_decl.print(padding + "\t");
		sentencia.print(padding + "\t");
	}
	
	public Node retVar_decl(){
		return var_decl;
	}

	public Node retSentencia(){
		return sentencia;
	}
	
} 
