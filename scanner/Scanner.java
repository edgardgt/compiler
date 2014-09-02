package compiler.scanner;/* Scanner.java */import org.antlr.v4.runtime.*;import java.util.LinkedList;public class Scanner{	//Atributos Scanner	private Decaf lexer1; //lexer que se puede utilizar desde la clase Parser	private Decaf lexer2;	private String file;	private LinkedList<MiToken> miListadeTokens = new LinkedList<MiToken>();		public Scanner (String archivoEntrada)throws Exception  {		//Constructor		lexer1 = new Decaf(new ANTLRFileStream(archivoEntrada));		lexer2 = new Decaf(new ANTLRFileStream(archivoEntrada));		file = new String (archivoEntrada);	}	public void Start(){ 		//Obtiene el listado de tokens del archivoEntrada, lexer1 apunta a dicha lista		while (lexer1.nextToken().getType() != Token.EOF);	}		public Decaf lexer(){ 		//Retorna un apuntador a la lista de tokens		return lexer1;	}	public LinkedList<MiToken> ListaDeTokens(){		// Recorre el archivo de entrada y arma una lista de tokens en miListadeTokens		Token token;		MiToken tokenTmp;		while (lexer1.nextToken().getType() != Token.EOF){			token = lexer2.nextToken();			tokenTmp = new MiToken(token.getLine(), token.getType(), token.getText());			miListadeTokens.add(tokenTmp);		}			lexer1.reset();		return miListadeTokens;	}}