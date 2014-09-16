import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Iterator;
import java.io.*;
import compiler.scanner.*;
import compiler.parser.*;
import compiler.ast.*;
import compiler.semantic.*;
import compiler.irt.*;
import compiler.codegen.*;
import compiler.opt.*;

public class Compiler{

	public static void main(String[] args) throws Exception {
		Boolean argsValidos = true; // Indica si los argumentos de entrada son validos o no. Si son validos esta variable se utiliza para permitir la ejecucion del programa
		String archivoEntrada = new String(""); //almacena el nombre del archivo de entrada
		String archivoSalida = new String(""); //almacena el nombre del archivo donde quedara la salida
		String argTarget = new String(""); //almacena argumnto -target
		String argOpt = new String(""); //almacena argumento -opt
		ArrayList<String> fasesDebug = new ArrayList<String>(); //almacena parametro(s) de opcion debug, se usa un ArrayList porque pueden ser uno o mas
		ArrayList<String> accionesEjecutar = new ArrayList<String>(); //almacena que opciones del compilador deben ser ejecutadas. Depende de los argumentos ingresados en opcion -target
		LinkedList<MiToken> miListadeTokens = new LinkedList<MiToken>(); //almacena lista de tokens
		LinkedList<String> miListadeReglas = new LinkedList<String>(); //almacena lista de reglas del parser

		//ArrayList<String> fasesCompilador = new ArrayList<String>(); //lista de las fases del compilador
		Scanner scnnr=null;
		CC4Parser prsr=null;
		Ast ast=null;
		Semantic smntc=null;
		Irt irt=null;
		Codegen cdgn=null;

		

		
		File fileSalida; // variable para archivo de salida
		
		// Inicia analisis del argumento args
		int argsAnalizar = args.length - 1;
		
		if (argsAnalizar < 0){ // si el numero de argumentos a analizar es menor a 0, no debe continuar con el analisis de args
			argsValidos = false;
			//System.exit(0);
		}else if (argsAnalizar == 0){ //si tiene un unico parametro debe ser el archivo de entrada, por lo tanto los argumentos a analizar es 0
			archivoEntrada = args[0];
		}else{ // si el numero de argumentos a analizar es >= 1, puede continuar con el analisis de args
			boolean continuar = true; int i = 0;
			// lectura del ultimo argumento, se asume que es el archivo de entrada
			if (args[args.length-1].charAt(0) != '-'){ archivoEntrada = args[args.length-1];
			}else{ continuar = false; argsValidos = false;
			}
			
			// analisis de los argumentos del primero hasta el penultimo, (no se analiza el ultimo debido a que es el archivo de entrada)
			while (continuar && i<argsAnalizar){
				if (args[i].equals("-o")){  
					if (argsAnalizar-i == 1){ // analiza que aun se pueda leer otro parametro
						continuar = false; argsValidos = false; // si no hay mas parametros, se termina el analisis
						}else{
							i++; //avanza una posicion para leer el siguiente parametro (debe ser el nombre del archivo de salida)
							if (args[i].charAt(0) == '-'){ //si este parametro empieza con '-', se termina la ejecucion porque no es una entrada valida
								archivoSalida = "";
								continuar = false; argsValidos = false;
							}else{ // si el paramerto es valido, se almacena en archivoSalida
								archivoSalida = args[i];
								}
						}
				} else if(args[i].equals("-target") || args[i].equals("-opt") || args[i].equals("-debug") ){
					if (argsAnalizar-i == 1){ // analiza que aun se pueda leer otro parametro
						continuar = false; argsValidos = false; // si no hay mas parametros, se termina el analisis
						}else{ // si hay mas parametros que leer:
							if (args[i].equals("-target")){
								if(args[i+1].equals("scan") || args[i+1].equals("parse") || args[i+1].equals("ast") || args[i+1].equals("semantic") || args[i+1].equals("irt") || args[i+1].equals("codegen")){
									argTarget = args[i+1]; //almacena en argTarget, el valor recibido de parametro
									if (accionesEjecutar.contains("-target")){ 
										 accionesEjecutar.remove("-target");
									}
									accionesEjecutar.add("-target");
									i++;
								}else{
									argTarget = "";
									continuar = false; argsValidos = false;
								}
							} else if (args[i].equals("-opt")){
								if(args[i+1].equals("constant") || args[i+1].equals("algebraic")){
									argOpt = args[i+1];
									if (accionesEjecutar.contains("-opt")){
										 accionesEjecutar.remove("-opt");
									}
									accionesEjecutar.add("-opt");
									i++;
								}else{
									argOpt = "";
									continuar = false; argsValidos = false;
								}
							} else if (args[i].equals("-debug")){
								fasesDebug.clear(); //limpia ArrayList de opciones Debug
								boolean puedeDebuguear = true; String tokenActual ="";
								StringTokenizer st = new StringTokenizer(args[i+1], ":");
								while (st.hasMoreTokens() && puedeDebuguear) {
									tokenActual = st.nextToken();
									if (tokenActual.equals("scan") || tokenActual.equals("parse") || tokenActual.equals("ast") || tokenActual.equals("semantic") || tokenActual.equals("irt") || tokenActual.equals("codegen")){
										if (fasesDebug.contains(tokenActual)){
											fasesDebug.remove(tokenActual);
										}
										fasesDebug.add(tokenActual); // si es un valor valido para -debug, lo ingresa a ArrayList de opciones Debug
										if (accionesEjecutar.contains("-debug")){
											accionesEjecutar.remove("-debug");
										}
										accionesEjecutar.add("-debug");
									}else{ // si hay un valor que no es valido, debe terminar el analisis.
										fasesDebug.clear();
										argsValidos = false; puedeDebuguear = false;
										continuar = false; argsValidos = false; puedeDebuguear = false;
									}
								}
								i++;
							}
						}
				} else{
					continuar = false; argsValidos = false;
				}
				i++;
			}
		}
		
		File fichero = new File(archivoEntrada);


		if (!fichero.exists()){
			argsValidos = false;
			System.out.println("");
			System.out.println("El archivo de entrada '" + fichero + "' no existe.\n");



			} //si no existe archivo de entrada, no debe ejecutar.
		
		if (!(argsValidos)){
			Help();
		}else {
			
			//descomentar el codigo de abajo solo para debug del programa
			/*
			System.out.println("acciones a Ejecutar: " + accionesEjecutar);
			if (archivoSalida != "") {System.out.println("-o: --->" + archivoSalida);}
			if (argTarget != "") {System.out.println("-target: --->" + argTarget);}
			if (argOpt != "") {System.out.println("-opt: --->" + argOpt);}
			if (!(fasesDebug.isEmpty())) {System.out.println("-debug: --->" + fasesDebug);}
			if (archivoEntrada != "") {System.out.println("entrada: --->" + archivoEntrada);}
			System.out.println("puede ejecutar: " + argsValidos);
			*/

			//prepara el archivo de salida para escritura
			if (archivoSalida.equals("")){archivoSalida = "salidadefault.txt";} // escribe salida a archivo default
			if (argTarget.equals("")){argTarget = "scan";} //si el usuario no coloca target, el default para esta fase es "scan"
			fileSalida = new File(archivoSalida);
			FileWriter w = new FileWriter(fileSalida);
			BufferedWriter bw = new BufferedWriter(w);
			PrintWriter wr = new PrintWriter(bw);				
			
			System.out.print(argTarget);
			if (argTarget.equals("scan") | argTarget.equals("parse") | argTarget.equals("ast") | argTarget.equals("semantic") | argTarget.equals("irt") | argTarget.equals("codegen")){

				scnnr = new Scanner(archivoEntrada);
				miListadeTokens = scnnr.ListaDeTokens();
				//System.out.println("Lista de Tokens:" + miListadeTokens);
				if (argTarget.equals("scan")){
					for (Iterator i = miListadeTokens.iterator(); i.hasNext();) {
						MiToken tokenI = (MiToken) i.next();
						wr.write(tokenI.toString()); // impresion a archivo
						}
					}
				if (fasesDebug.contains("scan")) {
					System.out.println("Debugging scan");
					for (Iterator i = miListadeTokens.iterator(); i.hasNext();) {
						MiToken tokenI = (MiToken) i.next();
						System.out.print(tokenI.toString()); // debug a pantalla
						}				
					} //imprime debug <stage> a pantalla
				}				
			if (argTarget.equals("parse") | argTarget.equals("ast") | argTarget.equals("semantic") | argTarget.equals("irt") | argTarget.equals("codegen")){
				prsr = new CC4Parser(scnnr); //wr.write("stage:parse \n"); //escribimos <stage> en archivo de salida
				miListadeReglas = prsr.ListaDeReglas();
				//System.out.println("Lista de Reglas:" + miListadeReglas + "\n\r");
				if (argTarget.equals("parse")){
					for (Iterator i = miListadeReglas.iterator(); i.hasNext();) {
						String reglaI = (String) i.next();
						wr.write(reglaI+"\n"); // impresion a archivo
						}
					}
				if (fasesDebug.contains("parse")) {
					System.out.println("Debugging parse");
					for (Iterator i = miListadeReglas.iterator(); i.hasNext();) {
						String reglaI = (String) i.next();
						System.out.println(reglaI); // debug a pantalla
						}
					} //imprime debug <stage> a pantalla
				}
			if (argTarget.equals("ast") | argTarget.equals("semantic") | argTarget.equals("irt") | argTarget.equals("codegen")){
				ast = new Ast(prsr); //wr.write("stage:ast \n"); //escribimos <stage> en archivo de salida
				if (argTarget.equals("ast")){
						wr.write(ast.arbolSTR()); // impresion a archivo
					}
				if (fasesDebug.contains("ast")) {
					//System.out.println(ast.arbolSTR());
					ast.arbolAST().print();
					//System.out.println("Debugging ast");
					} //imprime debug <stage> a pantalla
				}
				
			if (argTarget.equals("semantic") | argTarget.equals("irt") | argTarget.equals("codegen")){
				/*smntc = new Semantic(ast); wr.write("stage:semantic \n"); //escribimos <stage> en archivo de salida
				if (fasesDebug.contains("semantic")) {System.out.println("Debugging semantic");} //imprime debug <stage> a pantalla
				*/
				}
				
			if (argTarget.equals("irt") | argTarget.equals("codegen")){
				/*irt = new Irt(smntc); wr.write("stage:irt \n"); //escribimos <stage> en archivo de salida
				if (fasesDebug.contains("irt")) {System.out.println("Debugging irt");} //imprime debug <stage> a pantalla
				*/
				}
				
			if (argTarget.equals("codegen")){
				/*
				cdgn = new Codegen(irt); wr.write("stage:codegen \n"); //escribimos <stage> en archivo de salida
				if (fasesDebug.contains("codegen")) {System.out.println("Debugging codegen");} //imprime debug <stage> a pantalla
				*/
				}
			
			if (argOpt.equals("constant")){
				/*
				ConstantFolding  cf = new ConstantFolding(); wr.write("optimizing: constant folding \n"); //escribimos <optimizing> en archivo de salida
			}else if(argOpt.equals("algebraic")){
				Algebraic  algb = new Algebraic(); wr.write("optimizing: algebraic simplification \n"); //escribimos <optimizing> en archivo de salida
				*/
			}
			
			wr.close(); //cierra archivo
			bw.close(); //cierra bufferwriter
			System.out.println ("\nArchivo " + archivoSalida + " generado.");
		}
		
	}
	
	private static void Help() throws Exception{
		System.out.println("Compiler, debe ejecutarse de la siguiente manera: ");
		System.out.println("");
		System.out.println("java Compiler [-o out_filename] [-target stage] [-opt optimization] [-debug stage] [-h] <in_filename>");






		System.out.println("");
		
		System.out.println("-o out_filename:   Nombre el archivo en el que se almacenara la salida. ");



		System.out.println("-target stage:     Compila hasta cualquiera de las fases del compilador:");
		System.out.println("                        scan");
		System.out.println("                        parse");
		System.out.println("                        ast");
		System.out.println("                        semantic");
		System.out.println("                        irt");
		System.out.println("                        codegen");
		System.out.println("                   Se puede selecconar uno o mas fases en una misma ejecucion para lo cual se deben separar por medio de dos puntos (:)");
		System.out.println("-opt optmizacion:  Selecciona el metodo e optimizacion. Sus valores pueden ser:");
		System.out.println("                        constant ");
		System.out.println("                        algebra");
		System.out.println("-debug stage:      Permite visualizar en pantalla el estado de la ejecucion, para el stage seleccionado.");
		System.out.println("-h                 Permite visualizar esta ayuda");
	} //fin de Help	
}