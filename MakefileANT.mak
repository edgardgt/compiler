make: scanner\Decaf.java scanner\Decaf.class scanner\Scanner.class parser\DecafParser.java parser\DecafParser.class Compiler.class parser\CC4Parser.class ast\Ast.class semantic\Semantic.class irt\Irt.class codegen\Codegen.class opt\Algebraic.class opt\ConstantFolding.class lib\Debug.class lib\ErrorHandler.class
	
Compiler.class: Compiler.java
	javac Compiler.java

scanner\Decaf.java: scanner\Decaf.g
	java -jar c:\Javalib\antlr-4.1-complete.jar scanner\Decaf.g
	
scanner\Decaf.class: scanner\Decaf.java
	javac scanner\Decaf.java
	
scanner\Scanner.class: scanner\Scanner.java
	javac scanner\Scanner.java

parser\DecafParser.java: parser\DecafParser.g
	java -jar c:\Javalib\antlr-4.1-complete.jar parser\DecafParser.g -lib \parser\Decaf.tokens

parser\CC4Parser.class: parser\CC4Parser.java
	javac parser\CC4Parser.java
	
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
	del parser\*.class parser\Decaf*.java parser\CC4Parser*
	del ast\Ast.class
	del semantic\Semantic.class
	del irt\Irt.class
	del codegen\Codegen.class
	del opt\Algebraic.class
	del opt\ConstantFolding.class
	del lib\Debug.class
	del lib\ErrorHandler.class