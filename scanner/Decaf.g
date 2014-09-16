lexer grammar Decaf;

@header{
    package compiler.scanner;
}




//PALABRAS RESERVADAS
//-----------------------------------------------
CLASE		:  'class';
VOID		:  'void';
TRUE		:  'true';
FALSE		:  'false';
IF			:  'if';
ELSE		:  'else';
FOR		    :  'for';
RETURN		:  'return';
BREAK		:  'break';
CONTINUE	:  'continue';
CALLOUT	    :  'callout';
COMMA       : ',';
//-----------------------------------------------
TIPO        :  INT | BOOLEAN ;

// LITERALES
//-----------------------------------------------
//CHAR_LITERAL        : ('\'')(('\u0020')|('\u0021')|('\u0023'..'\u0026')|('\u0028'..'\u007E'))('\'') ;
//STRING_LITERAL      : ('"') (('\u0020')|('\u0021')|('\u0023'..'\u0026')|('\u0028'..'\u007E'))(('\u0020')|('\u0021')|('\u0023'..'\u0026')|('\u0028'..'\u007E'))* ('"') ;

CHAR_LITERAL        : ('\'')CHAR('\'') ;
STRING_LITERAL      : ('"') CHAR CHAR* ('"') ;
BOOL_LITERAL        : TRUE | FALSE;
INT_LITERAL          : (DECIMAL | HEXA);   //{System.out.println("INT_LITERAL");};
HEXA                 : ('0x'|'0X') (DIGITO | 'A'..'F' | 'a'..'f' )+ ;

fragment CHAR        :(('\u0020')|('\u0021')|('\u0023'..'\u0026')|('\u0028'..'\u007E'));


// OPERADORES ARITMETICOS
//-----------------------------------------------
ARITH_OP    : ( MAS );   //{System.out.println("ARITH_OP");};
REL_OP       : MENORQ | MAYORQ | MENORIGQ | MAYORIGQ;
EQ_OP         : IGUAL | DIFERENTE;

// OPERADORES LOGICOS
NOT :  '!';
COND_OP     : AND | OR | NOT;

// OPERADORES DE ASIGNACION
//-----------------------------------------------
ASIGNACION	:  '=';
INCREMENTA  :  '+=';
DECREMENTA  :  '-=';
  
// AGRUPADORES
//-----------------------------------------------
LBRACE      :  '{' ;
RBRACE      :  '}' ;
LBRACKET    :  '[' ;
RBRACKET    :  ']' ;
LPARENTH    :  '(' ;
RPARENTH    :  ')' ;

// IDENTIFICADOR
//-----------------------------------------------
ID          : (ALFA)(ALFA|DIGITO)*;

// OTROS
//-----------------------------------------------
WS          : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

COLON		: ':';
SEMI        : ';';

COMMENTLIN: '//' (~('\n'| '\r'))* {skip();};

fragment DIGITO	    : '0'..'9';
fragment ALFA        : ('a'..'z' | 'A'..'Z' | '_' );
fragment BOOLEAN     :  'boolean';
fragment INT         :  'int';
fragment DECIMAL    : (DIGITO) (DIGITO)* ;
fragment MAS		:  '+';
MENOS      :  '-';                //{System.out.println("MENOS");};
PROD		:  '*';
DIV		:  '/';
MOD		:  '%';
// OPERADORES RELACIONALES
//-----------------------------------------------
fragment MENORQ 		:  '<';
fragment MAYORQ 		:  '>'; 
fragment MENORIGQ 	:  '<=';  
fragment MAYORIGQ 	:  '>=';
// OPERADORES DE COMPARACION
//-----------------------------------------------
fragment IGUAL 		:  '==';
fragment DIFERENTE	:  '!=';
// OPERADORES LOGICOS
//-----------------------------------------------
fragment AND :  '&&';
fragment OR  :  '||';
