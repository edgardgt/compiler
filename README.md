compiler
========

Proyecto de compiladores 2014

CLI: MANUAL DE USUARIO

FORMA DE EJECUTAR:
	java Compiler [-o out_filename] [-target stage] [-opt optimization] [-debug stage] [-h] <in_filename>

	-o out_filename:	Nombre el archivo en el que se almacenara la salida. 
	-target stage:		Compila hasta cualquiera de las fases del compilador:
							scan
							parse
							ast
							semantic
							irt
							codegen
						Se puede selecconar uno o mas fases en una misma ejecucion para lo cual se deben separar por medio de dos puntos ":"
	-opt optmizacion: 	Selecciona el metodo e optimizacion. Sus valors pueen ser:
							constant 
							algebra
	-debug stage:		Permite visualizar en pantalla el estado de la ejecucion, para el stage seleccionado.
	-h					Permite visualizar esta ayuda
