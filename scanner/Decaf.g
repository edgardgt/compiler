lexer grammar Decaf;

@header{
    package compiler.scanner;
}

//PALABRAS RESERVADAS
//-----------------------------------------------
CLASE		:  'class' {System.out.println("CLASE");};
VOID		:  'void' {System.out.println("VOID");};
BOOLEAN     :  'boolean' {System.out.println("BOOLEAN");};
TRUE		:  'true' {System.out.println("TRUE");};
FALSE		:  'false' {System.out.println("FALSE");};
INT         :  'int' {System.out.println("INT");};
FLOAT       :  'float' {System.out.println("FLOAT");};
IF			:  'if' {System.out.println("IF");};
ELSE		:  'else' {System.out.println("ELSE");};
FOR			:  'for' {System.out.println("FOR");};
RETURN		:  'return' {System.out.println("RETURN");};
BREAK		:  'break' {System.out.println("BREAK");};
CONTINUE	:  'continue' {System.out.println("CONTINUE");};
CALLOUT		:  'callout' {System.out.println("CALLOUT");};




// OPERADORES ARITMETICOS
//-----------------------------------------------
MAS			:  '+' {System.out.println("MAS");};
MENOS		:  '-' {System.out.println("MENOS");};
PROD		:  '*' {System.out.println("PROD");};
DIV			:  '/' {System.out.println("DIV");};
MOD			:  '%' {System.out.println("MOD");};


// OPERADORES RELACIONALES
//-----------------------------------------------
MENORQ 		:  '<' {System.out.println("MENORQ");};
MAYORQ 		:  '>' {System.out.println("MAYORQ");}; 
MENORIGQ 	:  '<=' {System.out.println("MENORIGQ");};  
MAYORIGQ 	:  '>=' {System.out.println("MAYORIGQ");};


// OPERADORES DE COMPARACION
//-----------------------------------------------
IGUAL 		:  '==' {System.out.println("IGUAL");};
DIFERENTE	:  '!=' {System.out.println("DIFERENTE");};

// OPERADORES LOGICOS
//-----------------------------------------------
AND 		:  '&&' {System.out.println("AND");};
OR 			:  '||' {System.out.println("OR");};
NOT 		:  '!' {System.out.println("NOT");};

// OPERADORES DE ASIGNACION
//-----------------------------------------------
ASIGNACION	:  '=' {System.out.println("ASIGNACION");};
INCREMENTA  :  '+=' {System.out.println("INCREMENTA");};
DECREMENTA  :  '-=' {System.out.println("DECREMENTA");};


// LITERALES
//-----------------------------------------------
CHAR_LITERAL        : ('\'')CHAR('\'') {System.out.println("LITERAL CHAR");};
STRING_LITERAL      : ('"') CHAR CHAR* ('"') {System.out.println("LITERAL STR");};
BOOL_LITERAL        : TRUE | FALSE {System.out.println("LITERAL BOOLEAN");};
INT_LITERAL          : (DECIMAL | HEXA)  {System.out.println("INT_LITERAL");};
HEXA                 : ('0x'|'0X') (DIGITO | 'A'..'F' | 'a'..'f' )+ {System.out.println("HEX");};;

fragment CHAR        :(('\u0020')|('\u0021')|('\u0023'..'\u0026')|('\u0028'..'\u007E'));

  
// AGRUPADORES
//-----------------------------------------------
LBRACE      :  '{' {System.out.println("LLAVE I");};
RBRACE      :  '}' {System.out.println("LLAVE D");};
LBRACKET    :  '[' {System.out.println("CORCHETE I");};
RBRACKET    :  ']' {System.out.println("CORCHETE D");};
LPARENTH    :  '(' {System.out.println("PARENT I");};
RPARENTH    :  ')' {System.out.println("PARENT D");};


// IDENTIFICADOR
//-----------------------------------------------
ID          :   (ALFA)(ALFA|DIGITO)* {System.out.println("ID");};


// OTROS
//-----------------------------------------------
WS          : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
COMMA       :  ',' {System.out.println("COMMA");};
COLON		:  ':' {System.out.println("COLON");};
SEMI        :  ';' {System.out.println("PUNTO Y COMMA");};
DIGITO	    :  '0'..'9' {System.out.println("DIGITO");};
ALFA        :  ('a'..'z' | 'A'..'Z' | '_' ) {System.out.println("ALFA");};
