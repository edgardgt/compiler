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
start       : CLASE ID LBRACE (field_decl)* (method_decl)* RBRACE             { linea++; arbol.add("start "+linea);} ;

field_decl  : TIPO ( ID | ID LBRACKET INT_LITERAL RBRACKET ) 
                     (COMMA ( ID | ID LBRACKET INT_LITERAL RBRACKET ))* SEMI  { linea++; arbol.add("field_decl " + linea);} ;

method_decl : (TIPO | VOID) ID LPARENTH (TIPO ID (COMMA TIPO ID)*)? 
                     RPARENTH block                                           { linea++; arbol.add("method_decl " + linea);} ;

block       : LBRACE (var_decl)* (statement)* RBRACE                          { linea++; arbol.add("block "+linea);} ;

var_decl    : TIPO (ID) (COMMA ID)* SEMI                                      { linea++; arbol.add("var_decl " + linea);} ;

statement   : (location assign_op expr SEMI
            |  method_call SEMI
            |  IF LPARENTH expr RPARENTH block (ELSE block)?
            |  FOR ID ASIGNACION expr COMMA expr block 
            |  RETURN (expr)? SEMI
            |  BREAK SEMI
            |  CONTINUE SEMI
            |  block)                                                         { linea++; arbol.add("statement "+linea);} ;

assign_op   : (ASIGNACION
            |  INCREMENTA
            |  DECREMENTA)                                                    { linea++; arbol.add("assign_op "+linea);} ;

method_call : (method_name LPARENTH expr (COMMA expr)* RPARENTH
            |  CALLOUT LPARENTH STRING_LITERAL COMMA 
                     callout_arg (COMMA callout_arg)* RPARENTH)               { linea++; arbol.add("method_call "+linea);} ;

method_name : ID                                                              { linea++; arbol.add("method_name "+linea);} ;

location    : ID
            | ID LBRACKET INT_LITERAL RBRACKET                                { linea++; arbol.add("location "+linea);} ;

expr        : ((location 
            |  method_call 
			|  literal 
			|  MENOS expr 
			|  NOT expr 
			|  LPARENTH expr RPARENTH) expr_2)                                { linea++; arbol.add("expr   "+linea);} ;

expr_2      : bin_op expr expr_2
            |                                                                 { linea++; arbol.add("expr_2 "+linea);} ;

callout_arg : expr 
            | STRING_LITERAL                                                  { linea++; arbol.add("callout_arg "+linea);} ;

bin_op      : (ARITH_OP 
            |  REL_OP 
			|  EQ_OP 
			|  COND_OP)                                                       { linea++; arbol.add("bin_op "+linea);} ;

literal     : (INT_LITERAL 
            |  CHAR_LITERAL 
            |  BOOL_LITERAL)                                                  { linea++; arbol.add("literal "+linea);} ;

