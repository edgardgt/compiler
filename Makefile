make: scanner\Decaf.java scanner\Decaf.class scanner\Scanner.class parser\DecafParser.java parser\DecafParser.class parser\CC4Parser.class ast\Node.class ast\Root.class ast\AstVisitor.class ast\Ast.class lib\ErrorHandler.class Compiler.class
	
Compiler.class: Compiler.java
	javac Compiler.java

scanner\Decaf.java: scanner\Decaf.g
	java -jar c:\Javalib\antlr-4.1-complete.jar scanner\Decaf.g
	
scanner\Decaf.class: scanner\Decaf.java
	javac scanner\Decaf.java
	
scanner\Scanner.class: scanner\Scanner.java
	javac scanner\Scanner.java

parser\DecafParser.java: parser\DecafParser.g
	java -jar c:\Javalib\antlr-4.1-complete.jar  parser\DecafParser.g -visitor -lib scanner\
	
parser\DecafParser.class: parser\DecafParser.java
	javac parser\DecafParser.java

parser\CC4Parser.class: parser\CC4Parser.java
	javac parser\CC4Parser.java

ast\Node.class: ast\Node.java
	javac ast\Node.java
	
ast\Root.class: ast\Root.java
	javac ast\Root.java
	javac ast\BinOp.java
	javac ast\IntLiteral.java
	javac ast\CharLiteral.java
	javac ast\Identificador.java
	javac ast\MethodDcl.java
	javac ast\Parametro.java
	javac ast\Nulo.java
	javac ast\Bloque.java
	javac ast\NLista.java
	javac ast\ClassMain.java
	javac ast\SentenciaIF.java
	javac ast\Location.java
	javac ast\Return.java
	javac ast\MethodCall.java
	javac ast\Asignacion.java
	javac ast\SentenciaFor.java
	
ast\AstVisitor.class: ast\AstVisitor.java
	javac ast\AstVisitor.java
	
ast\Ast.class: ast\Ast.java
	javac ast\Ast.java

lib\ErrorHandler.class: lib\ErrorHandler.java
	javac lib\ErrorHandler.java

clean:
	del Compiler.class
	del scanner\Scanner.class
	del scanner\*.class scanner\Decaf.java scanner\*.tokens
	del parser\*.class parser\Decaf*.java parser\Decaf*.tokens
	del ast\*.class
	del semantic\Semantic.class
	del irt\Irt.class
	del codegen\Codegen.class
	del opt\Algebraic.class
	del opt\ConstantFolding.class
	del lib\Debug.class
	del lib\ErrorHandler.class