make: scanner\Decaf.java parser\DecafParser.java parser\DecafParser.class ast\Root.class ast\AstVisitor.class ast\Ast.class Compiler.class

Compiler.class: Compiler.java
	javac Compiler.java

scanner\Decaf.java: scanner\Decaf.g
	java -jar c:\Javalib\antlr-4.1-complete.jar scanner\Decaf.g
	javac scanner\Decaf.java
	javac scanner\Scanner.java

parser\DecafParser.java: parser\DecafParser.g
	java -jar c:\Javalib\antlr-4.1-complete.jar parser\DecafParser.g -visitor -lib scanner\
	
parser\DecafParser.class: parser\DecafParser.java
	javac parser\DecafParser.java
	javac parser\CC4Parser.java
	
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
	
semantic\Semantic.class: semantic\Semantic.java
	javac semantic\Semantic.java

irt\Irt.class: irt\Irt.java
	javac irt\Irt.java

codegen\Codegen.class: codegen\Codegen.java
	javac codegen\Codegen.java
	
opt\Algebraic.class: opt\Algebraic.java
	javac opt\Algebraic.java
	
opt\ConstantFolding.class: opt\ConstantFolding.java
	javac opt\ConstantFolding.java

lib\Debug.class: lib\Debug.java
	javac lib\Debug.java

lib\ErrorHandler.class: lib\ErrorHandler.java
	javac lib\ErrorHandler.java

clean:
	del Compiler.class
	del scanner\*.class scanner\Decaf.java scanner\*.tokens
	del parser\*.class parser\Decaf*.java parser\Decaf*.tokens
	del ast\Ast.class
	del semantic\Semantic.class
	del irt\Irt.class
	del codegen\Codegen.class
	del opt\Algebraic.class
	del opt\ConstantFolding.class
	del lib\Debug.class
	del lib\ErrorHandler.class