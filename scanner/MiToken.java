package compiler.scanner;

// clase MiToken
public class MiToken {
	//campos
	private int linea;
	private String tipo;
	private String texto;

	//constructores
	public MiToken(int linea, String tipo, String texto) {
		this.linea = linea;
		this.tipo = new String(tipo);
		this.texto = new String(texto);
	}
	// metodos
	public int getLinea(){return this.linea;}
	public String getTipo(){return this.tipo;}
	public String getTexto(){return this.texto;}
	
	public String toString(){
		return "Linea: " + this.linea + ", rol: " + this.tipo + ", lexema: " + this.texto + "\n";
	}
}