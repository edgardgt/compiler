package compiler.ast;

public class ClassMain extends Node{
	//campos
	private String id;
	private Node field_dcl;
	private Node method_dcl;
	
	// constructor
	public ClassMain(String i, Node fd, Node md){
		id = i;
		field_dcl = fd;
		method_dcl = md;
	}
	
	// metodos
	public void print(String padding){
		
		System.out.println("programa");
		System.out.println("\t" + id);
		field_dcl.print("\t");
		method_dcl.print("\t");

	}
	
	public String retId(){
		return id;
	}
	
	public Node retField_dcl(){
		return field_dcl;
	}
	
	public Node retMethod_dcl(){
		return method_dcl;
	}
} 
