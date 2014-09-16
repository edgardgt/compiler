package compiler.ast;

//import java.util.List;
//import java.util.LinkedList;

public class SentenciaFor extends Node{
	private Node init;
	private Node step;
	private Node bloque;
	
	public SentenciaFor(Node i, Node s, Node b){
		init = i;
		step = s;
		bloque = b;
	}
//Metodos
	public void print(String padding){
		System.out.println(padding + "for");
		init.print(padding + "\t");
		System.out.println(padding + "\t"+"step");
		step.print(padding + "\t\t");
		bloque.print(padding + "\t");
	}
	
	public Node retInit(){
		return init;
	}
	
	public Node retStep(){
		return step;
	}
	
	public Node retBloque(){
		return bloque;
	}
} 
