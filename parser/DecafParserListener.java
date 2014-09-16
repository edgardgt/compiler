// Generated from parser\DecafParser.g by ANTLR 4.1

    package compiler.parser;
    import java.util.LinkedList;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DecafParser}.
 */
public interface DecafParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DecafParser#expr_methodCall}.
	 * @param ctx the parse tree
	 */
	void enterExpr_methodCall(@NotNull DecafParser.Expr_methodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#expr_methodCall}.
	 * @param ctx the parse tree
	 */
	void exitExpr_methodCall(@NotNull DecafParser.Expr_methodCallContext ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#expr_MultiDiv}.
	 * @param ctx the parse tree
	 */
	void enterExpr_MultiDiv(@NotNull DecafParser.Expr_MultiDivContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#expr_MultiDiv}.
	 * @param ctx the parse tree
	 */
	void exitExpr_MultiDiv(@NotNull DecafParser.Expr_MultiDivContext ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull DecafParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull DecafParser.BlockContext ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#bin_op}.
	 * @param ctx the parse tree
	 */
	void enterBin_op(@NotNull DecafParser.Bin_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#bin_op}.
	 * @param ctx the parse tree
	 */
	void exitBin_op(@NotNull DecafParser.Bin_opContext ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#literal_boolean}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_boolean(@NotNull DecafParser.Literal_booleanContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#literal_boolean}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_boolean(@NotNull DecafParser.Literal_booleanContext ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void enterAsignacion(@NotNull DecafParser.AsignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void exitAsignacion(@NotNull DecafParser.AsignacionContext ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#incremento}.
	 * @param ctx the parse tree
	 */
	void enterIncremento(@NotNull DecafParser.IncrementoContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#incremento}.
	 * @param ctx the parse tree
	 */
	void exitIncremento(@NotNull DecafParser.IncrementoContext ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#call_expr}.
	 * @param ctx the parse tree
	 */
	void enterCall_expr(@NotNull DecafParser.Call_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#call_expr}.
	 * @param ctx the parse tree
	 */
	void exitCall_expr(@NotNull DecafParser.Call_exprContext ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#literal_char}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_char(@NotNull DecafParser.Literal_charContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#literal_char}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_char(@NotNull DecafParser.Literal_charContext ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#method_param}.
	 * @param ctx the parse tree
	 */
	void enterMethod_param(@NotNull DecafParser.Method_paramContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#method_param}.
	 * @param ctx the parse tree
	 */
	void exitMethod_param(@NotNull DecafParser.Method_paramContext ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#id2}.
	 * @param ctx the parse tree
	 */
	void enterId2(@NotNull DecafParser.Id2Context ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#id2}.
	 * @param ctx the parse tree
	 */
	void exitId2(@NotNull DecafParser.Id2Context ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#id1}.
	 * @param ctx the parse tree
	 */
	void enterId1(@NotNull DecafParser.Id1Context ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#id1}.
	 * @param ctx the parse tree
	 */
	void exitId1(@NotNull DecafParser.Id1Context ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#method_name}.
	 * @param ctx the parse tree
	 */
	void enterMethod_name(@NotNull DecafParser.Method_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#method_name}.
	 * @param ctx the parse tree
	 */
	void exitMethod_name(@NotNull DecafParser.Method_nameContext ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void enterVar_decl(@NotNull DecafParser.Var_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void exitVar_decl(@NotNull DecafParser.Var_declContext ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#expr_binOp}.
	 * @param ctx the parse tree
	 */
	void enterExpr_binOp(@NotNull DecafParser.Expr_binOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#expr_binOp}.
	 * @param ctx the parse tree
	 */
	void exitExpr_binOp(@NotNull DecafParser.Expr_binOpContext ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#sentencia8}.
	 * @param ctx the parse tree
	 */
	void enterSentencia8(@NotNull DecafParser.Sentencia8Context ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#sentencia8}.
	 * @param ctx the parse tree
	 */
	void exitSentencia8(@NotNull DecafParser.Sentencia8Context ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#expr_notExp}.
	 * @param ctx the parse tree
	 */
	void enterExpr_notExp(@NotNull DecafParser.Expr_notExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#expr_notExp}.
	 * @param ctx the parse tree
	 */
	void exitExpr_notExp(@NotNull DecafParser.Expr_notExpContext ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#sentencia7}.
	 * @param ctx the parse tree
	 */
	void enterSentencia7(@NotNull DecafParser.Sentencia7Context ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#sentencia7}.
	 * @param ctx the parse tree
	 */
	void exitSentencia7(@NotNull DecafParser.Sentencia7Context ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#expr_literal}.
	 * @param ctx the parse tree
	 */
	void enterExpr_literal(@NotNull DecafParser.Expr_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#expr_literal}.
	 * @param ctx the parse tree
	 */
	void exitExpr_literal(@NotNull DecafParser.Expr_literalContext ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#sentencia6}.
	 * @param ctx the parse tree
	 */
	void enterSentencia6(@NotNull DecafParser.Sentencia6Context ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#sentencia6}.
	 * @param ctx the parse tree
	 */
	void exitSentencia6(@NotNull DecafParser.Sentencia6Context ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#sentencia5}.
	 * @param ctx the parse tree
	 */
	void enterSentencia5(@NotNull DecafParser.Sentencia5Context ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#sentencia5}.
	 * @param ctx the parse tree
	 */
	void exitSentencia5(@NotNull DecafParser.Sentencia5Context ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#method_call1}.
	 * @param ctx the parse tree
	 */
	void enterMethod_call1(@NotNull DecafParser.Method_call1Context ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#method_call1}.
	 * @param ctx the parse tree
	 */
	void exitMethod_call1(@NotNull DecafParser.Method_call1Context ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#sentencia4}.
	 * @param ctx the parse tree
	 */
	void enterSentencia4(@NotNull DecafParser.Sentencia4Context ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#sentencia4}.
	 * @param ctx the parse tree
	 */
	void exitSentencia4(@NotNull DecafParser.Sentencia4Context ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(@NotNull DecafParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(@NotNull DecafParser.StartContext ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#sentencia3}.
	 * @param ctx the parse tree
	 */
	void enterSentencia3(@NotNull DecafParser.Sentencia3Context ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#sentencia3}.
	 * @param ctx the parse tree
	 */
	void exitSentencia3(@NotNull DecafParser.Sentencia3Context ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#sentencia2}.
	 * @param ctx the parse tree
	 */
	void enterSentencia2(@NotNull DecafParser.Sentencia2Context ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#sentencia2}.
	 * @param ctx the parse tree
	 */
	void exitSentencia2(@NotNull DecafParser.Sentencia2Context ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#method_call2}.
	 * @param ctx the parse tree
	 */
	void enterMethod_call2(@NotNull DecafParser.Method_call2Context ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#method_call2}.
	 * @param ctx the parse tree
	 */
	void exitMethod_call2(@NotNull DecafParser.Method_call2Context ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#expr_location}.
	 * @param ctx the parse tree
	 */
	void enterExpr_location(@NotNull DecafParser.Expr_locationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#expr_location}.
	 * @param ctx the parse tree
	 */
	void exitExpr_location(@NotNull DecafParser.Expr_locationContext ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#sentencia1}.
	 * @param ctx the parse tree
	 */
	void enterSentencia1(@NotNull DecafParser.Sentencia1Context ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#sentencia1}.
	 * @param ctx the parse tree
	 */
	void exitSentencia1(@NotNull DecafParser.Sentencia1Context ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#decremento}.
	 * @param ctx the parse tree
	 */
	void enterDecremento(@NotNull DecafParser.DecrementoContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#decremento}.
	 * @param ctx the parse tree
	 */
	void exitDecremento(@NotNull DecafParser.DecrementoContext ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#literal_int}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_int(@NotNull DecafParser.Literal_intContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#literal_int}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_int(@NotNull DecafParser.Literal_intContext ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#expr_expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr_expr(@NotNull DecafParser.Expr_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#expr_expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr_expr(@NotNull DecafParser.Expr_exprContext ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#field_decl}.
	 * @param ctx the parse tree
	 */
	void enterField_decl(@NotNull DecafParser.Field_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#field_decl}.
	 * @param ctx the parse tree
	 */
	void exitField_decl(@NotNull DecafParser.Field_declContext ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#call_strlit}.
	 * @param ctx the parse tree
	 */
	void enterCall_strlit(@NotNull DecafParser.Call_strlitContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#call_strlit}.
	 * @param ctx the parse tree
	 */
	void exitCall_strlit(@NotNull DecafParser.Call_strlitContext ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#expr_menosExp}.
	 * @param ctx the parse tree
	 */
	void enterExpr_menosExp(@NotNull DecafParser.Expr_menosExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#expr_menosExp}.
	 * @param ctx the parse tree
	 */
	void exitExpr_menosExp(@NotNull DecafParser.Expr_menosExpContext ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#method_decl}.
	 * @param ctx the parse tree
	 */
	void enterMethod_decl(@NotNull DecafParser.Method_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#method_decl}.
	 * @param ctx the parse tree
	 */
	void exitMethod_decl(@NotNull DecafParser.Method_declContext ctx);

	/**
	 * Enter a parse tree produced by {@link DecafParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(@NotNull DecafParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(@NotNull DecafParser.ArrayContext ctx);
}