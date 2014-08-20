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
start       : CLASE ID LBRACE (field_decl)* (method_decl)* RBRACE;

field_decl  : TIPO ( ID | array ) 
                     (COMMA ( ID | array ))* SEMI   ;

array		: ID LBRACKET INT_LITERAL RBRACKET    ;
					 
method_decl : (TIPO | VOID) ID LPARENTH (method_param)? 
                     RPARENTH block                                    ;

method_param : TIPO ID (COMMA TIPO ID)*
					 ;
					 
block       : LBRACE (var_decl)* (statement)* RBRACE                  ;

var_decl    : TIPO (ID) (COMMA ID)* SEMI                                  ;

statement   : location assign_op expr SEMI									 
            |  method_call SEMI												
            |  IF LPARENTH expr RPARENTH block (ELSE block)?				
            |  FOR ID ASIGNACION expr COMMA expr block	 					
            |  RETURN (expr)? SEMI											
            |  BREAK SEMI													
            |  CONTINUE SEMI												
            |  block                                                       	
			;

assign_op   : ASIGNACION													
            |  INCREMENTA													
            |  DECREMENTA                                                   
			;
			//{ linea++; arbol.add("ASSIGN_Op "+linea);} ;

method_call : method_name LPARENTH (expr (COMMA expr)*)? RPARENTH			
            |  CALLOUT LPARENTH STRING_LITERAL COMMA
                     (callout_arg (COMMA callout_arg)*)? RPARENTH			
			;

method_name : ID;

location    : ID															
            | ID LBRACKET expr RBRACKET                                		
			;

expr     :  location														
            |  method_call 													
			|  literal														
			|  expr bin_op expr												
			|  MENOS expr													
			|  NOT expr 													
			|  LPARENTH expr RPARENTH                                		
			;

callout_arg : expr 															
            | STRING_LITERAL                                                
			;

bin_op  :  ARITH_OP                                                         
            |  REL_OP                                                       
			|  EQ_OP                                                        
			|  COND_OP                                                      
			|  MENOS                                                        
			;

literal     : INT_LITERAL 													
            |  CHAR_LITERAL 												
            |  BOOL_LITERAL                                                 
			;
