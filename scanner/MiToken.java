package compiler.scanner;

// clase MiToken
public class MiToken {
	//Atributos
	private int linea;
	private int tipo;
	private String texto;
	
	public MiToken(int linea, int tipo, String texto) {
		//constructor
		this.linea = linea;
		this.tipo = tipo;
		this.texto = new String(texto);
	}
	// metodos
	public int getLinea(){return this.linea;}
	public int getTipo(){return this.tipo;}
	public String getTexto(){return this.texto;}
	
	public String toString(){
		return "Linea: " + this.linea + ", rol: " + this.tipo + ", lexema: " + this.texto + "\n";
	}
}