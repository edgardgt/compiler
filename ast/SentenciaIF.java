package compiler.ast;

//import java.util.List;
//import java.util.LinkedList;

public class SentenciaIF extends Node{
	private Node condicion;
	private Node consecuencia;
	private Node alternativa;
	
	public SentenciaIF(Node cond, Node cons, Node altr){
		condicion = cond;
		consecuencia = cons;
		alternativa = altr;
	}
	
	public void print(String padding){
		System.out.println(padding + "condicion");
		condicion.print(padding + "\t");
		consecuencia.print(padding + "\t");
		alternativa.print(padding + "\t");
	}
	
	public Node retCondicion(){
		return condicion;
	}
	
	public Node retConsecuencia(){
		return consecuencia;
	}
	
	public Node retAlternativa(){
		return alternativa;
	}
} 
