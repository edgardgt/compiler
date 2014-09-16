package compiler.ast;

import java.util.List;
import java.util.LinkedList;

public class MethodDcl extends Node{
	private String tipo;
	private String id;
	private Node params;
	private Node bloque;
	
	public MethodDcl(String t, String i, Node p, Node b){
		tipo = t;
		id = i;
		params = p;
		bloque = b;
	}
// Metodos	
	public void print(String padding){
		System.out.println(padding + "metodo");
		System.out.println(padding + "\t" + tipo);
		System.out.println(padding + "\t" + id);
		params.print(padding + "\t");
		bloque.print(padding + "\t");
	}
	
	public String retTipo(){
		return tipo;
	}
	
	public String retId(){
		return id;
	}
	
	public Node retParams(){
		return params;
	}	
	public Node retBloque(){
		return bloque;
	}
} 
