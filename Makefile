make: Compiler.class scanner\ScannerCLI.class parser\CC4Parser.class ast\Ast.class semantic\Semantic.class irt\Irt.class codegen\Codegen.class opt\Algebraic.class opt\ConstantFolding.class lib\Debug.class lib\ErrorHandler.class
	
Compiler.class: Compiler.java
	javac Compiler.java
	
scanner\ScannerCLI.class: scanner\ScannerCLI.java
	javac scanner\ScannerCLI.java

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
	del scanner\ScannerCLI.class
	del parser\CC4Parser.class
	del ast\Ast.class
	del semantic\Semantic.class
	del irt\Irt.class
	del codegen\Codegen.class
	del opt\Algebraic.class
	del opt\ConstantFolding.class
	del lib\Debug.class
	del lib\ErrorHandler.class