lexer grammar Decaf;

@header{
    package compiler.scanner;
}

// OTROS
//-----------------------------------------------
WS          : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

COLON		: ':';
SEMI        : ';';

COMMENTLIN: '//' (~('\n'| '\r'))* {skip();};


//PALABRAS RESERVADAS
//-----------------------------------------------
CLASE		:  'class'   {System.out.println("CLASE");};
VOID		:  'void'    {System.out.println("VOID");};
TRUE		:  'true'    {System.out.println("TRUE");};
FALSE		:  'false'   {System.out.println("FALSE");};
IF			:  'if'      {System.out.println("IF");};
ELSE		:  'else'    {System.out.println("ELSE");};
FOR		    :  'for'     {System.out.println("FOR");};
RETURN		:  'return'  {System.out.println("RETURN");};
BREAK		:  'break'   {System.out.println("BREAK");};
CONTINUE	:  'continue'{System.out.println("CONTINUE");};
CALLOUT	    :  'callout' {System.out.println("CALLOUT");};
COMMA       :  ','       {System.out.println("COMMA");};
//-----------------------------------------------
TIPO        :  INT | BOOLEAN ;

// LITERALES
//-----------------------------------------------
CHAR_LITERAL        : ('\'')(('\u0020')|('\u0021')|('\u0023'..'\u0026')|('\u0028'..'\u007E'))('\'') ;
//STRING_LITERAL      : ('"') (('\u0020')|('\u0021')|('\u0023'..'\u0026')|('\u0028'..'\u007E'))(('\u0020')|('\u0021')|('\u0023'..'\u0026')|('\u0028'..'\u007E'))* ('"') ;

//CHAR_LITERAL        : ('\'')CHAR('\'') ;
STRING_LITERAL      : ('"') CHAR CHAR* ('"') ;
BOOL_LITERAL        : TRUE | FALSE;
INT_LITERAL          : (DECIMAL | HEXA);   //{System.out.println("INT_LITERAL");};
HEXA                 : ('0x'|'0X') (DIGITO | 'A'..'F' | 'a'..'f' )+ ;

//fragment CHAR        :(('\u0020')|('\u0021')|('\u0023'..'\u0026')|('\u0028'..'\u007E'));
fragment CHAR        :(('\u0021')|('\u0023'..'\u0026')|('\u0028'..'\u007E'));


// OPERADORES ARITMETICOS
//-----------------------------------------------
ARITH_OP    : ( MAS | PROD | DIV | MOD)             {System.out.println("ARITH_OP");};
REL_OP      : MENORQ | MAYORQ | MENORIGQ | MAYORIGQ {System.out.println("ARITH_REL");};
EQ_OP       : IGUAL | DIFERENTE                     {System.out.println("EQ_OP");};

// OPERADORES LOGICOS
NOT     :  '!'             {System.out.println("NOT");};
COND_OP : AND | OR | NOT   {System.out.println("COND_OP");};

// OPERADORES DE ASIGNACION
//-----------------------------------------------
ASIGNACION	:  '='  {System.out.println("ASIGNACION");};
INCREMENTA  :  '+=' {System.out.println("INCREMENTA");};
DECREMENTA  :  '-=' {System.out.println("DECREMENTA");};
  
// AGRUPADORES
//-----------------------------------------------
LBRACE      :  '{' {System.out.println("LBRACE");};
RBRACE      :  '}' {System.out.println("RBRACE");};
LBRACKET    :  '[' {System.out.println("LBRACKET");};
RBRACKET    :  ']' {System.out.println("RBRACKET");};
LPARENTH    :  '(' {System.out.println("LPARENTH");};
RPARENTH    :  ')' {System.out.println("RPARENTH");};

// IDENTIFICADOR
//-----------------------------------------------
ID          : (ALFA)(ALFA|DIGITO)*   {System.out.println("IDENTIFICADOR");};



fragment DIGITO	    : '0'..'9';
fragment ALFA       : ('a'..'z' | 'A'..'Z' | '_' );
fragment BOOLEAN    :  'boolean';
fragment INT        :  'int';
fragment DECIMAL    : (DIGITO) (DIGITO)* ;
fragment MAS		:  '+';
MENOS               :  '-'                {System.out.println("MENOS");};
fragment PROD		:  '*';
fragment DIV		:  '/';
fragment MOD		:  '%';
// OPERADORES RELACIONALES
//-----------------------------------------------
fragment MENORQ     :  '<';
fragment MAYORQ     :  '>'; 
fragment MENORIGQ   :  '<=';  
fragment MAYORIGQ   :  '>=';
// OPERADORES DE COMPARACION
//-----------------------------------------------
fragment IGUAL 		:  '==';
fragment DIFERENTE	:  '!=';
// OPERADORES LOGICOS
//-----------------------------------------------
fragment AND :  '&&';
fragment OR  :  '||';