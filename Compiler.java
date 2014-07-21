import java.util.*;
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
		Boolean puedeEjecutar = true; // flag que indica si el programa puede ejecutarse (esto es posible si todos los argumentos son validos)
		String archivoSalida = new String(""); //almacena el nombre del archivo donde quedara la salida
		String opcionTarget = new String(""); //almacena el parametro de la opcion -target
		String opcionOpt = new String(""); //almacena el parametro de la opcion -opt
		ArrayList<String> opcionDebug = new ArrayList<String>(); //almacena parametro(s) de opcion debug, se usa un ArrayList porque pueden ser uno o mas
		ArrayList<String> accionesEjecutar = new ArrayList<String>(); //almacena que opciones del compilador deben ser ejecutadas. Depende de los argumentos ingresados
		String archivoEntrada = new String(""); //almacena el nombre del archivo de entrada

		ArrayList<String> fasesCompilador = new ArrayList<String>(); //lista de las fases del compilador
		fasesCompilador.add("scan");
		fasesCompilador.add("parse");
		fasesCompilador.add("ast");
		fasesCompilador.add("semantic");
		fasesCompilador.add("irt");
		fasesCompilador.add("codegen");
		File fileSalida; // variable para archivo de salida
		
		// Inicia analisis del argumento args
		int argsAnalizar = args.length - 1;
		
		if (argsAnalizar < 0){ // si el numero de argumentos a analizar es menor a 0, no debe continuar con el analisis de args
			puedeEjecutar = false;
			//System.exit(0);
		}else if (argsAnalizar == 0){ //si tiene un unico parametro debe ser el archivo de entrada, por lo tanto los argumentos a analizar es 0
			archivoEntrada = args[0];
		}else{ // si el numero de argumentos a analizar es >= 1, puede continuar con el analisis de args
			boolean continuar = true; int i = 0;
			// lectura del ultimo argumento, se asume que es el archivo de entrada
			if (args[args.length-1].charAt(0) != '-'){ archivoEntrada = args[args.length-1];
			}else{ continuar = false; puedeEjecutar = false;
			}
			
			// analisis de los argumentos del primero hasta el penultimo, (no se analiza el ultimo debido a que es el archivo de entrada)
			while (continuar && i<argsAnalizar){
				if (args[i].equals("-o")){  
					if (argsAnalizar-i == 1){ // analiza que aun se pueda leer otro parametro
						continuar = false; puedeEjecutar = false; // si no hay mas parametros, se termina el analisis
						}else{
							i++; //avanza una posicion para leer el siguiente parametro (debe ser el nombre del archivo de salida)
							if (args[i].charAt(0) == '-'){ //si este parametro empieza con '-', se termina la ejecucion porque no es una entrada valida
								archivoSalida = "";
								continuar = false; puedeEjecutar = false;
							}else{ // si el paramerto es valido, se almacena en archivoSalida
								archivoSalida = args[i];
								}
						}
				} else if(args[i].equals("-target") || args[i].equals("-opt") || args[i].equals("-debug") ){
					if (argsAnalizar-i == 1){ // analiza que aun se pueda leer otro parametro
						continuar = false; puedeEjecutar = false; // si no hay mas parametros, se termina el analisis
						}else{ // si hay mas parametros que leer:
							if (args[i].equals("-target")){
								if(args[i+1].equals("scan") || args[i+1].equals("parse") || args[i+1].equals("ast") || args[i+1].equals("semantic") || args[i+1].equals("irt") || args[i+1].equals("codegen")){
									opcionTarget = args[i+1]; //almacena en opcionTarget, el valor recibido de parametro
									if (accionesEjecutar.contains("-target")){ 
										 accionesEjecutar.remove("-target");
									}
									accionesEjecutar.add("-target");
									i++;
								}else{
									opcionTarget = "";
									continuar = false; puedeEjecutar = false;
								}
							} else if (args[i].equals("-opt")){
								if(args[i+1].equals("constant") || args[i+1].equals("algebraic")){
									opcionOpt = args[i+1];
									if (accionesEjecutar.contains("-opt")){
										 accionesEjecutar.remove("-opt");
									}
									accionesEjecutar.add("-opt");
									i++;
								}else{
									opcionOpt = "";
									continuar = false; puedeEjecutar = false;
								}
							} else if (args[i].equals("-debug")){
								opcionDebug.clear(); //limpia ArrayList de opciones Debug
								boolean puedeDebuguear = true; String tokenActual ="";
								StringTokenizer st = new StringTokenizer(args[i+1], ":");
								while (st.hasMoreTokens() && puedeDebuguear) {
									tokenActual = st.nextToken();
									if (tokenActual.equals("scan") || tokenActual.equals("parse") || tokenActual.equals("ast") || tokenActual.equals("semantic") || tokenActual.equals("irt") || tokenActual.equals("codegen")){
										if (opcionDebug.contains(tokenActual)){
											opcionDebug.remove(tokenActual);
										}
										opcionDebug.add(tokenActual); // si es un valor valido para -debug, lo ingresa a ArrayList de opciones Debug
										if (accionesEjecutar.contains("-debug")){
											accionesEjecutar.remove("-debug");
										}
										accionesEjecutar.add("-debug");
									}else{ // si hay un valor que no es valido, debe terminar el analisis.
										opcionDebug.clear();
										puedeEjecutar = false; puedeDebuguear = false;
										continuar = false; puedeEjecutar = false; puedeDebuguear = false;
									}
								}
								i++;
							}
						}
				} else{
					continuar = false; puedeEjecutar = false;
				}
				i++;
			}
		}
		
		File fichero = new File(archivoEntrada);
		if (!fichero.exists()){
			puedeEjecutar = false;
			System.out.println("");
			System.out.println("El archivo de entrada '" + fichero + "' no existe.\n");
			} //si no existe archivo de entrada, no debe ejecutar.
		
		if (!(puedeEjecutar)){
			Help();
		}else {
			
			//descomentar el codigo de abajo solo para debug del programa
			/*
			System.out.println("acciones a Ejecutar: " + accionesEjecutar);
			if (archivoSalida != "") {System.out.println("-o: --->" + archivoSalida);}
			if (opcionTarget != "") {System.out.println("-target: --->" + opcionTarget);}
			if (opcionOpt != "") {System.out.println("-opt: --->" + opcionOpt);}
			if (!(opcionDebug.isEmpty())) {System.out.println("-debug: --->" + opcionDebug);}
			if (archivoEntrada != "") {System.out.println("entrada: --->" + archivoEntrada);}
			System.out.println("puede ejecutar: " + puedeEjecutar);
			*/

			//prepara el archivo de salida para escritura
			if (archivoSalida.equals("")){archivoSalida = "salidadefault.txt";} // escribe salida a archivo default
			if (opcionTarget.equals("")){opcionTarget = "scan";} //si el usuario no coloca target, el default para esta fase es "scan"
			fileSalida = new File(archivoSalida);
			FileWriter w = new FileWriter(fileSalida);
			BufferedWriter bw = new BufferedWriter(w);
			PrintWriter wr = new PrintWriter(bw);				
			
			if (opcionTarget.equals("scan")){
				ScannerCLI scnnr = new ScannerCLI(archivoEntrada); wr.write("stage:scan \n"); //escribimos <stage> en archivo de salida
				if (opcionDebug.contains("scan")) {System.out.println("Debugging scan");} //imprime debug <stage> a pantalla
			}else if (opcionTarget.equals("parse")){
				ScannerCLI scnnr = new ScannerCLI(archivoEntrada); wr.write("stage:scan \n"); //escribimos <stage> en archivo de salida
				if (opcionDebug.contains("scan")) {System.out.println("Debugging scan");} //imprime debug <stage> a pantalla
				
				CC4Parser prsr = new CC4Parser(scnnr); wr.write("stage:parse \n"); //escribimos <stage> en archivo de salida
				if (opcionDebug.contains("parse")) {System.out.println("Debugging parse");} //imprime debug <stage> a pantalla
			}else if (opcionTarget.equals("ast")){
				ScannerCLI scnnr = new ScannerCLI(archivoEntrada); wr.write("stage:scan \n"); //escribimos <stage> en archivo de salida
				if (opcionDebug.contains("scan")) {System.out.println("Debugging scan");} //imprime debug <stage> a pantalla
				
				CC4Parser prsr = new CC4Parser(scnnr); wr.write("stage:parse \n"); //escribimos <stage> en archivo de salida
				if (opcionDebug.contains("parse")) {System.out.println("Debugging parse");} //imprime debug <stage> a pantalla
				
				Ast ast = new Ast(prsr); wr.write("stage:ast \n"); //escribimos <stage> en archivo de salida
				if (opcionDebug.contains("ast")) {System.out.println("Debugging ast");} //imprime debug <stage> a pantalla
			}else if (opcionTarget.equals("semantic")){
				ScannerCLI scnnr = new ScannerCLI(archivoEntrada); wr.write("stage:scan \n"); //escribimos <stage> en archivo de salida
				if (opcionDebug.contains("scan")) {System.out.println("Debugging scan");} //imprime debug <stage> a pantalla
				CC4Parser prsr = new CC4Parser(scnnr); wr.write("stage:parse \n"); //escribimos <stage> en archivo de salida
				if (opcionDebug.contains("parse")) {System.out.println("Debugging parse");} //imprime debug <stage> a pantalla
				Ast ast = new Ast(prsr); wr.write("stage:ast \n"); //escribimos <stage> en archivo de salida
				if (opcionDebug.contains("ast")) {System.out.println("Debugging ast");} //imprime debug <stage> a pantalla
				
				Semantic smntc = new Semantic(ast); wr.write("stage:semantic \n"); //escribimos <stage> en archivo de salida
				if (opcionDebug.contains("semantic")) {System.out.println("Debugging semantic");} //imprime debug <stage> a pantalla
			}else if (opcionTarget.equals("irt")){
				ScannerCLI scnnr = new ScannerCLI(archivoEntrada); wr.write("stage:scan \n"); //escribimos <stage> en archivo de salida
				if (opcionDebug.contains("scan")) {System.out.println("Debugging scan");} //imprime debug <stage> a pantalla
				
				CC4Parser prsr = new CC4Parser(scnnr); wr.write("stage:parse \n"); //escribimos <stage> en archivo de salida
				if (opcionDebug.contains("parse")) {System.out.println("Debugging parse");} //imprime debug <stage> a pantalla
				
				Ast ast = new Ast(prsr); wr.write("stage:ast \n"); //escribimos <stage> en archivo de salida
				if (opcionDebug.contains("ast")) {System.out.println("Debugging ast");} //imprime debug <stage> a pantalla
				
				Semantic smntc = new Semantic(ast); wr.write("stage:semantic \n"); //escribimos <stage> en archivo de salida
				if (opcionDebug.contains("semantic")) {System.out.println("Debugging semantic");} //imprime debug <stage> a pantalla
				
				Irt irt = new Irt(smntc); wr.write("stage:irt \n"); //escribimos <stage> en archivo de salida
				if (opcionDebug.contains("irt")) {System.out.println("Debugging irt");} //imprime debug <stage> a pantalla
			}else if (opcionTarget.equals("codegen")){
				ScannerCLI scnnr = new ScannerCLI(archivoEntrada); wr.write("stage:scan \n"); //escribimos <stage> en archivo de salida
				if (opcionDebug.contains("scan")) {System.out.println("Debugging scan");} //imprime debug <stage> a pantalla
				
				CC4Parser prsr = new CC4Parser(scnnr); wr.write("stage:parse \n"); //escribimos <stage> en archivo de salida
				if (opcionDebug.contains("parse")) {System.out.println("Debugging parse");} //imprime debug <stage> a pantalla
				
				Ast ast = new Ast(prsr); wr.write("stage:ast \n"); //escribimos <stage> en archivo de salida
				if (opcionDebug.contains("ast")) {System.out.println("Debugging ast");} //imprime debug <stage> a pantalla
				
				Semantic smntc = new Semantic(ast); wr.write("stage:semantic \n"); //escribimos <stage> en archivo de salida
				if (opcionDebug.contains("semantic")) {System.out.println("Debugging semantic");} //imprime debug <stage> a pantalla
				
				Irt irt = new Irt(smntc); wr.write("stage:irt \n"); //escribimos <stage> en archivo de salida
				if (opcionDebug.contains("irt")) {System.out.println("Debugging irt");} //imprime debug <stage> a pantalla
				
				Codegen cdgn = new Codegen(irt); wr.write("stage:codegen \n"); //escribimos <stage> en archivo de salida
				if (opcionDebug.contains("codegen")) {System.out.println("Debugging codegen");} //imprime debug <stage> a pantalla
				}
			
			if (opcionOpt.equals("constant")){
				ConstantFolding  cf = new ConstantFolding(); wr.write("optimizing: constant folding \n"); //escribimos <optimizing> en archivo de salida
			}else if(opcionOpt.equals("algebraic")){
				Algebraic  algb = new Algebraic(); wr.write("optimizing: algebraic simplification \n"); //escribimos <optimizing> en archivo de salida
			}
			wr.close(); //cierra archivo
			bw.close(); //cierra bufferwriter
		}
	}
	
	private static void Help() throws Exception{
		System.out.println("Compiler, debe ejecutarse de la siguiente manera: ");
		System.out.println("");
		System.out.println("java Compiler [option] <filename>");
		System.out.println("Donde [option] es la accion a realizar.");
		System.out.println("-o <outname>:		<outname> -> archivo de salida;");
		System.out.println("-target <stage>:	<stage> -> scan, parse, ast, semantic, irt, codegen;");
		System.out.println("-opt <optimization>:<optimization> -> constant, algebraic ");
		System.out.println("-debug <stage>:		<stage> -> uno o varios de scan, parse, ast, semantic, irt, codegen;");
		System.out.println("-h:			Muestra esta ayuda al usuario.");
		System.out.println("");
		System.out.println("ejemplo: java Compiler -o prueba.txt -target codegen -opt algebraic -debug semantic:ast:codegen:scan entrada.txt");
	} //fin de Help	
}