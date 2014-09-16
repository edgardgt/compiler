parser grammar DecafParser;

options {
    tokenVocab=Decaf;
}

@header{
    package compiler.parser;
    import java.util.LinkedList;
}

@members {
LinkedList arbol = new LinkedList();
int linea = 0;
}
start       : CLASE ID LBRACE (field_decl)* (method_decl)* RBRACE             { linea++; arbol.add("Inicio "+linea);} ;

field_decl  : TIPO ( ID | array ) 
                     (COMMA ( ID | array ))* SEMI  { linea++; arbol.add("Declara Campos " + linea);} ;

array		: ID LBRACKET INT_LITERAL RBRACKET     { linea++; arbol.add("Arreglo " + linea);};
					 
method_decl : (TIPO | VOID) ID LPARENTH (method_param)? 
                     RPARENTH block                                         { linea++; arbol.add("Declarar Metodos " + linea);} ;

method_param : TIPO ID (COMMA TIPO ID)*
					 ;
					 
block       : LBRACE (var_decl)* (statement)* RBRACE                        { linea++; arbol.add("Bloque "+linea);} ;

var_decl    : TIPO (ID) (COMMA ID)* SEMI                                    { linea++; arbol.add("Declara Variable " + linea);} ;

statement   : location assign_op expr SEMI									{ linea++; arbol.add("Asigna exp "+linea);}    #sentencia1
            |  method_call SEMI												{ linea++; arbol.add("Sentencia Call "+linea);} #sentencia2
            |  IF LPARENTH expr RPARENTH block (ELSE block)?				{ linea++; arbol.add("Sentencia If "+linea);}  #sentencia3
            |  FOR ID ASIGNACION expr COMMA expr block	 					{ linea++; arbol.add("Sentencia For "+linea);} #sentencia4
            |  RETURN (expr)? SEMI											{ linea++; arbol.add("Retorno "+linea);}       #sentencia5
            |  BREAK SEMI													{ linea++; arbol.add("Break "+linea);}         #sentencia6
            |  CONTINUE SEMI												{ linea++; arbol.add("Continue "+linea);}      #sentencia7
            |  block                                                       	{ linea++; arbol.add("Bloque "+linea);}        #sentencia8
			;
			//{ linea++; arbol.add("Statement "+linea);};

assign_op   : ASIGNACION													{ linea++; arbol.add("Asignacion "+linea);}    #asignacion
            |  INCREMENTA													{ linea++; arbol.add("Incremento "+linea);}    #incremento
            |  DECREMENTA                                                   { linea++; arbol.add("Decremento "+linea);}    #decremento
			;
			//{ linea++; arbol.add("ASSIGN_Op "+linea);} ;

method_call : method_name LPARENTH (expr (COMMA expr)*)? RPARENTH			{ linea++; arbol.add("Llama Metodo "+linea);}    #method_call1
            |  CALLOUT LPARENTH STRING_LITERAL COMMA
                     (callout_arg (COMMA callout_arg)*)? RPARENTH			{ linea++; arbol.add("Llama Metodo "+linea);}    #method_call2
			;
			//{ linea++; arbol.add("Method_Call "+linea);} ;

method_name : ID                                                            { linea++; arbol.add("Method_name "+linea);} ;

location    : ID															#id1
            | ID LBRACKET expr RBRACKET                                		#id2
			;
			//{ linea++; arbol.add("Location "+linea);} ;

expr     :  location														{ linea++; arbol.add("Expr Location "+linea);} #expr_location
            |  method_call 													{ linea++; arbol.add("Expr Method Call "+linea);} #expr_methodCall
			|  literal														{ linea++; arbol.add("Expr Literal "+linea);} #expr_literal
			|  expr (PROD | DIV | MOD) expr									{ linea++; arbol.add("Expr MultiDiv "+linea);} #expr_MultiDiv
			|  expr bin_op expr												{ linea++; arbol.add("Expr BinOp "+linea);} #expr_binOp
			|  MENOS expr													{ linea++; arbol.add("Expr Menos Expr "+linea);} #expr_menosExp
			|  NOT expr 													{ linea++; arbol.add("Expr NOT Expr "+linea);} #expr_notExp
			|  LPARENTH expr RPARENTH                                		{ linea++; arbol.add("Expr () "+linea);} #expr_expr
			;
			//{ linea++; arbol.add("Expr   "+linea);} ;

callout_arg : expr 															{ linea++; arbol.add("Args Expr "+linea);} #call_expr
            | STRING_LITERAL                                                { linea++; arbol.add("Args Literal "+linea);} #call_strlit
			;
			//{ linea++; arbol.add("String_Literal "+linea);} ;

bin_op  :  ARITH_OP                                                         { linea++; arbol.add("Bin_Op arith "+linea);}
            |  REL_OP                                                       { linea++; arbol.add("Bin_Op RelOp "+linea);}
			|  EQ_OP                                                        { linea++; arbol.add("Bin_Op Eq_Op "+linea);}
			|  COND_OP                                                      { linea++; arbol.add("Bin_Op CondOp "+linea);}
			|  MENOS                                                        { linea++; arbol.add("Bin_Op Menos "+linea);};

literal     : INT_LITERAL 													{ linea++; arbol.add("Int Literal "+linea);}  #literal_int
            |  CHAR_LITERAL 												{ linea++; arbol.add("Char Literal "+linea);} #literal_char
            |  BOOL_LITERAL                                                 { linea++; arbol.add("Bool Literal "+linea);} #literal_boolean
			;
			//{ linea++; arbol.add("Literal "+linea);} ;

