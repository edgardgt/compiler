// Generated from parser\DecafParser.g by ANTLR 4.1

    package compiler.parser;
    import java.util.LinkedList;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DecafParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DecafParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DecafParser#expr_methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_methodCall(@NotNull DecafParser.Expr_methodCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#expr_MultiDiv}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_MultiDiv(@NotNull DecafParser.Expr_MultiDivContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull DecafParser.BlockContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#bin_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBin_op(@NotNull DecafParser.Bin_opContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#literal_boolean}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_boolean(@NotNull DecafParser.Literal_booleanContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacion(@NotNull DecafParser.AsignacionContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#incremento}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncremento(@NotNull DecafParser.IncrementoContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#call_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall_expr(@NotNull DecafParser.Call_exprContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#literal_char}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_char(@NotNull DecafParser.Literal_charContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#method_param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_param(@NotNull DecafParser.Method_paramContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#id2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId2(@NotNull DecafParser.Id2Context ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#id1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId1(@NotNull DecafParser.Id1Context ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#method_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_name(@NotNull DecafParser.Method_nameContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#var_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_decl(@NotNull DecafParser.Var_declContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#expr_binOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_binOp(@NotNull DecafParser.Expr_binOpContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#sentencia8}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentencia8(@NotNull DecafParser.Sentencia8Context ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#expr_notExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_notExp(@NotNull DecafParser.Expr_notExpContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#sentencia7}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentencia7(@NotNull DecafParser.Sentencia7Context ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#expr_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_literal(@NotNull DecafParser.Expr_literalContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#sentencia6}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentencia6(@NotNull DecafParser.Sentencia6Context ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#sentencia5}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentencia5(@NotNull DecafParser.Sentencia5Context ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#method_call1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_call1(@NotNull DecafParser.Method_call1Context ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#sentencia4}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentencia4(@NotNull DecafParser.Sentencia4Context ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(@NotNull DecafParser.StartContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#sentencia3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentencia3(@NotNull DecafParser.Sentencia3Context ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#sentencia2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentencia2(@NotNull DecafParser.Sentencia2Context ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#method_call2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_call2(@NotNull DecafParser.Method_call2Context ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#expr_location}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_location(@NotNull DecafParser.Expr_locationContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#sentencia1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentencia1(@NotNull DecafParser.Sentencia1Context ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#decremento}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecremento(@NotNull DecafParser.DecrementoContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#literal_int}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_int(@NotNull DecafParser.Literal_intContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#expr_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_expr(@NotNull DecafParser.Expr_exprContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#field_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField_decl(@NotNull DecafParser.Field_declContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#call_strlit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall_strlit(@NotNull DecafParser.Call_strlitContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#expr_menosExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_menosExp(@NotNull DecafParser.Expr_menosExpContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#method_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_decl(@NotNull DecafParser.Method_declContext ctx);

	/**
	 * Visit a parse tree produced by {@link DecafParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(@NotNull DecafParser.ArrayContext ctx);
}