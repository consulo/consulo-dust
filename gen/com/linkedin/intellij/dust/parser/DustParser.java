// This is a generated file. Not intended for manual editing.
package com.linkedin.intellij.dust.parser;

import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import static com.linkedin.intellij.dust.psi.DustTypes.*;

import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.lang.PsiParser;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.psi.tree.IElementType;
import consulo.lang.LanguageVersion;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class DustParser implements PsiParser {

  public static final Logger LOG_ = Logger.getInstance("com.linkedin.intellij.dust.parser.DustParser");

  public ASTNode parse(IElementType root_, PsiBuilder builder_, LanguageVersion _languageVersion) {
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this, null);
    Marker marker_ = enter_section_(builder_, 0, _COLLAPSE_, null);
    if (root_ == ATTR_STRING) {
      result_ = attrString(builder_, 0);
    }
    else if (root_ == ATTRIBUTE) {
      result_ = attribute(builder_, 0);
    }
    else if (root_ == CLOSE_TAG) {
      result_ = close_tag(builder_, 0);
    }
    else if (root_ == CONTEXT) {
      result_ = context(builder_, 0);
    }
    else if (root_ == ELSE_TAG) {
      result_ = else_tag(builder_, 0);
    }
    else if (root_ == FILTER) {
      result_ = filter(builder_, 0);
    }
    else if (root_ == I1_8N_FORMAT) {
      result_ = i18nFormat(builder_, 0);
    }
    else if (root_ == INDEX_DEREF) {
      result_ = index_deref(builder_, 0);
    }
    else if (root_ == JSON) {
      result_ = json(builder_, 0);
    }
    else if (root_ == KEY_TAG) {
      result_ = key_tag(builder_, 0);
    }
    else if (root_ == OPEN_TAG) {
      result_ = open_tag(builder_, 0);
    }
    else if (root_ == PATH) {
      result_ = path(builder_, 0);
    }
    else if (root_ == SELF_CLOSE_TAG) {
      result_ = self_close_tag(builder_, 0);
    }
    else if (root_ == STATEMENTS) {
      result_ = statements(builder_, 0);
    }
    else if (root_ == TAG) {
      result_ = tag(builder_, 0);
    }
    else if (root_ == TAG_BLOCK) {
      result_ = tag_block(builder_, 0);
    }
    else if (root_ == TAG_CONTENT) {
      result_ = tag_content(builder_, 0);
    }
    else if (root_ == TAG_NAME) {
      result_ = tag_name(builder_, 0);
    }
    else {
      result_ = parse_root_(root_, builder_, 0);
    }
    exit_section_(builder_, 0, marker_, root_, result_, true, TRUE_CONDITION);
    return builder_.getTreeBuilt();
  }

  protected boolean parse_root_(final IElementType root_, final PsiBuilder builder_, final int level_) {
    return dustFile(builder_, level_ + 1);
  }

  /* ********************************************************** */
  // (STRING_START ((tag_block|tag|i18nFormat) | STRING+)+ STRING_END) | (STRING_START STRING_END)
  public static boolean attrString(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "attrString")) return false;
    if (!nextTokenIs(builder_, STRING_START)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = attrString_0(builder_, level_ + 1);
    if (!result_) result_ = attrString_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, ATTR_STRING, result_);
    return result_;
  }

  // STRING_START ((tag_block|tag|i18nFormat) | STRING+)+ STRING_END
  private static boolean attrString_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "attrString_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, STRING_START);
    result_ = result_ && attrString_0_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, STRING_END);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ((tag_block|tag|i18nFormat) | STRING+)+
  private static boolean attrString_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "attrString_0_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = attrString_0_1_0(builder_, level_ + 1);
    int pos_ = current_position_(builder_);
    while (result_) {
      if (!attrString_0_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "attrString_0_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (tag_block|tag|i18nFormat) | STRING+
  private static boolean attrString_0_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "attrString_0_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = attrString_0_1_0_0(builder_, level_ + 1);
    if (!result_) result_ = attrString_0_1_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // tag_block|tag|i18nFormat
  private static boolean attrString_0_1_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "attrString_0_1_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = tag_block(builder_, level_ + 1);
    if (!result_) result_ = tag(builder_, level_ + 1);
    if (!result_) result_ = i18nFormat(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // STRING+
  private static boolean attrString_0_1_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "attrString_0_1_0_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, STRING);
    int pos_ = current_position_(builder_);
    while (result_) {
      if (!consumeToken(builder_, STRING)) break;
      if (!empty_element_parsed_guard_(builder_, "attrString_0_1_0_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // STRING_START STRING_END
  private static boolean attrString_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "attrString_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, STRING_START, STRING_END);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // CRLF? IDENTIFIER EQUAL (path|attrString|NUMBER|IDENTIFIER) CRLF?
  public static boolean attribute(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "attribute")) return false;
    if (!nextTokenIs(builder_, "<attribute>", CRLF, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<attribute>");
    result_ = attribute_0(builder_, level_ + 1);
    result_ = result_ && consumeTokens(builder_, 0, IDENTIFIER, EQUAL);
    result_ = result_ && attribute_3(builder_, level_ + 1);
    result_ = result_ && attribute_4(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, ATTRIBUTE, result_, false, null);
    return result_;
  }

  // CRLF?
  private static boolean attribute_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "attribute_0")) return false;
    consumeToken(builder_, CRLF);
    return true;
  }

  // path|attrString|NUMBER|IDENTIFIER
  private static boolean attribute_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "attribute_3")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = path(builder_, level_ + 1);
    if (!result_) result_ = attrString(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, NUMBER);
    if (!result_) result_ = consumeToken(builder_, IDENTIFIER);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // CRLF?
  private static boolean attribute_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "attribute_4")) return false;
    consumeToken(builder_, CRLF);
    return true;
  }

  /* ********************************************************** */
  // CLOSE tag_name index_deref? tag_content RD
  public static boolean close_tag(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "close_tag")) return false;
    if (!nextTokenIs(builder_, CLOSE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, CLOSE);
    result_ = result_ && tag_name(builder_, level_ + 1);
    result_ = result_ && close_tag_2(builder_, level_ + 1);
    result_ = result_ && tag_content(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RD);
    exit_section_(builder_, marker_, CLOSE_TAG, result_);
    return result_;
  }

  // index_deref?
  private static boolean close_tag_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "close_tag_2")) return false;
    index_deref(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // COLON (path|STRING|STRING_SINGLE|IDENTIFIER|PERIOD)
  public static boolean context(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "context")) return false;
    if (!nextTokenIs(builder_, COLON)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COLON);
    result_ = result_ && context_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, CONTEXT, result_);
    return result_;
  }

  // path|STRING|STRING_SINGLE|IDENTIFIER|PERIOD
  private static boolean context_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "context_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = path(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, STRING);
    if (!result_) result_ = consumeToken(builder_, STRING_SINGLE);
    if (!result_) result_ = consumeToken(builder_, IDENTIFIER);
    if (!result_) result_ = consumeToken(builder_, PERIOD);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // statements
  static boolean dustFile(PsiBuilder builder_, int level_) {
    return statements(builder_, level_ + 1);
  }

  /* ********************************************************** */
  // ELSE tag_name tag_content RD
  public static boolean else_tag(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "else_tag")) return false;
    if (!nextTokenIs(builder_, ELSE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ELSE);
    result_ = result_ && tag_name(builder_, level_ + 1);
    result_ = result_ && tag_content(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RD);
    exit_section_(builder_, marker_, ELSE_TAG, result_);
    return result_;
  }

  /* ********************************************************** */
  // PIPE IDENTIFIER
  public static boolean filter(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "filter")) return false;
    if (!nextTokenIs(builder_, PIPE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, PIPE, IDENTIFIER);
    exit_section_(builder_, marker_, FILTER, result_);
    return result_;
  }

  /* ********************************************************** */
  // LD (tag|NUMBER|IDENTIFIER|HTML|PIPE)* RD
  public static boolean i18nFormat(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "i18nFormat")) return false;
    if (!nextTokenIs(builder_, LD)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LD);
    result_ = result_ && i18nFormat_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RD);
    exit_section_(builder_, marker_, I1_8N_FORMAT, result_);
    return result_;
  }

  // (tag|NUMBER|IDENTIFIER|HTML|PIPE)*
  private static boolean i18nFormat_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "i18nFormat_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!i18nFormat_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "i18nFormat_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // tag|NUMBER|IDENTIFIER|HTML|PIPE
  private static boolean i18nFormat_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "i18nFormat_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = tag(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, NUMBER);
    if (!result_) result_ = consumeToken(builder_, IDENTIFIER);
    if (!result_) result_ = consumeToken(builder_, HTML);
    if (!result_) result_ = consumeToken(builder_, PIPE);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // LB (NUMBER|IDENTIFIER+|path) RB
  public static boolean index_deref(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "index_deref")) return false;
    if (!nextTokenIs(builder_, LB)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LB);
    result_ = result_ && index_deref_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RB);
    exit_section_(builder_, marker_, INDEX_DEREF, result_);
    return result_;
  }

  // NUMBER|IDENTIFIER+|path
  private static boolean index_deref_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "index_deref_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, NUMBER);
    if (!result_) result_ = index_deref_1_1(builder_, level_ + 1);
    if (!result_) result_ = path(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // IDENTIFIER+
  private static boolean index_deref_1_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "index_deref_1_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IDENTIFIER);
    int pos_ = current_position_(builder_);
    while (result_) {
      if (!consumeToken(builder_, IDENTIFIER)) break;
      if (!empty_element_parsed_guard_(builder_, "index_deref_1_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // LD (json|tag|HTML|CRLF|STRING|IDENTIFIER)* RD
  public static boolean json(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "json")) return false;
    if (!nextTokenIs(builder_, LD)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LD);
    result_ = result_ && json_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RD);
    exit_section_(builder_, marker_, JSON, result_);
    return result_;
  }

  // (json|tag|HTML|CRLF|STRING|IDENTIFIER)*
  private static boolean json_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "json_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!json_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "json_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // json|tag|HTML|CRLF|STRING|IDENTIFIER
  private static boolean json_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "json_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = json(builder_, level_ + 1);
    if (!result_) result_ = tag(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, HTML);
    if (!result_) result_ = consumeToken(builder_, CRLF);
    if (!result_) result_ = consumeToken(builder_, STRING);
    if (!result_) result_ = consumeToken(builder_, IDENTIFIER);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // LD tag_name index_deref? context* tag_content RD
  public static boolean key_tag(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "key_tag")) return false;
    if (!nextTokenIs(builder_, LD)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LD);
    result_ = result_ && tag_name(builder_, level_ + 1);
    result_ = result_ && key_tag_2(builder_, level_ + 1);
    result_ = result_ && key_tag_3(builder_, level_ + 1);
    result_ = result_ && tag_content(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RD);
    exit_section_(builder_, marker_, KEY_TAG, result_);
    return result_;
  }

  // index_deref?
  private static boolean key_tag_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "key_tag_2")) return false;
    index_deref(builder_, level_ + 1);
    return true;
  }

  // context*
  private static boolean key_tag_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "key_tag_3")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!context(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "key_tag_3", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  /* ********************************************************** */
  // (SECTION|EXISTANCE|NOT_EXISTANCE|HELPER|PARTIAL|INLINE_PARTIAL|BLOCK) CRLF? tag_name index_deref? context* tag_content RD
  public static boolean open_tag(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "open_tag")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<open tag>");
    result_ = open_tag_0(builder_, level_ + 1);
    result_ = result_ && open_tag_1(builder_, level_ + 1);
    result_ = result_ && tag_name(builder_, level_ + 1);
    result_ = result_ && open_tag_3(builder_, level_ + 1);
    result_ = result_ && open_tag_4(builder_, level_ + 1);
    result_ = result_ && tag_content(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RD);
    exit_section_(builder_, level_, marker_, OPEN_TAG, result_, false, null);
    return result_;
  }

  // SECTION|EXISTANCE|NOT_EXISTANCE|HELPER|PARTIAL|INLINE_PARTIAL|BLOCK
  private static boolean open_tag_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "open_tag_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, SECTION);
    if (!result_) result_ = consumeToken(builder_, EXISTANCE);
    if (!result_) result_ = consumeToken(builder_, NOT_EXISTANCE);
    if (!result_) result_ = consumeToken(builder_, HELPER);
    if (!result_) result_ = consumeToken(builder_, PARTIAL);
    if (!result_) result_ = consumeToken(builder_, INLINE_PARTIAL);
    if (!result_) result_ = consumeToken(builder_, BLOCK);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // CRLF?
  private static boolean open_tag_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "open_tag_1")) return false;
    consumeToken(builder_, CRLF);
    return true;
  }

  // index_deref?
  private static boolean open_tag_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "open_tag_3")) return false;
    index_deref(builder_, level_ + 1);
    return true;
  }

  // context*
  private static boolean open_tag_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "open_tag_4")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!context(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "open_tag_4", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  /* ********************************************************** */
  // (PERIOD? IDENTIFIER (PERIOD IDENTIFIER)*) | PERIOD
  public static boolean path(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "path")) return false;
    if (!nextTokenIs(builder_, "<path>", IDENTIFIER, PERIOD)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<path>");
    result_ = path_0(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, PERIOD);
    exit_section_(builder_, level_, marker_, PATH, result_, false, null);
    return result_;
  }

  // PERIOD? IDENTIFIER (PERIOD IDENTIFIER)*
  private static boolean path_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "path_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = path_0_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, IDENTIFIER);
    result_ = result_ && path_0_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // PERIOD?
  private static boolean path_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "path_0_0")) return false;
    consumeToken(builder_, PERIOD);
    return true;
  }

  // (PERIOD IDENTIFIER)*
  private static boolean path_0_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "path_0_2")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!path_0_2_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "path_0_2", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // PERIOD IDENTIFIER
  private static boolean path_0_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "path_0_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, PERIOD, IDENTIFIER);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // (SECTION|HELPER|PARTIAL|INLINE_PARTIAL|BLOCK|CLOSE|ELSE|LD) tag_name context* tag_content SLASH_RD
  public static boolean self_close_tag(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "self_close_tag")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<self close tag>");
    result_ = self_close_tag_0(builder_, level_ + 1);
    result_ = result_ && tag_name(builder_, level_ + 1);
    result_ = result_ && self_close_tag_2(builder_, level_ + 1);
    result_ = result_ && tag_content(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, SLASH_RD);
    exit_section_(builder_, level_, marker_, SELF_CLOSE_TAG, result_, false, null);
    return result_;
  }

  // SECTION|HELPER|PARTIAL|INLINE_PARTIAL|BLOCK|CLOSE|ELSE|LD
  private static boolean self_close_tag_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "self_close_tag_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, SECTION);
    if (!result_) result_ = consumeToken(builder_, HELPER);
    if (!result_) result_ = consumeToken(builder_, PARTIAL);
    if (!result_) result_ = consumeToken(builder_, INLINE_PARTIAL);
    if (!result_) result_ = consumeToken(builder_, BLOCK);
    if (!result_) result_ = consumeToken(builder_, CLOSE);
    if (!result_) result_ = consumeToken(builder_, ELSE);
    if (!result_) result_ = consumeToken(builder_, LD);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // context*
  private static boolean self_close_tag_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "self_close_tag_2")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!context(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "self_close_tag_2", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  /* ********************************************************** */
  // (COMMENT|tag_block|tag|json|HTML|CRLF)*
  public static boolean statements(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statements")) return false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<statements>");
    int pos_ = current_position_(builder_);
    while (true) {
      if (!statements_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "statements", pos_)) break;
      pos_ = current_position_(builder_);
    }
    exit_section_(builder_, level_, marker_, STATEMENTS, true, false, null);
    return true;
  }

  // COMMENT|tag_block|tag|json|HTML|CRLF
  private static boolean statements_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statements_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMENT);
    if (!result_) result_ = tag_block(builder_, level_ + 1);
    if (!result_) result_ = tag(builder_, level_ + 1);
    if (!result_) result_ = json(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, HTML);
    if (!result_) result_ = consumeToken(builder_, CRLF);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // (statements? else_tag statements?) | statements
  static boolean statements_block(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statements_block")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = statements_block_0(builder_, level_ + 1);
    if (!result_) result_ = statements(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // statements? else_tag statements?
  private static boolean statements_block_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statements_block_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = statements_block_0_0(builder_, level_ + 1);
    result_ = result_ && else_tag(builder_, level_ + 1);
    result_ = result_ && statements_block_0_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // statements?
  private static boolean statements_block_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statements_block_0_0")) return false;
    statements(builder_, level_ + 1);
    return true;
  }

  // statements?
  private static boolean statements_block_0_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statements_block_0_2")) return false;
    statements(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // self_close_tag|key_tag
  public static boolean tag(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "tag")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<tag>");
    result_ = self_close_tag(builder_, level_ + 1);
    if (!result_) result_ = key_tag(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, TAG, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // open_tag statements_block close_tag
  public static boolean tag_block(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "tag_block")) return false;
    boolean result_;
    boolean pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<tag block>");
    result_ = open_tag(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, statements_block(builder_, level_ + 1));
    result_ = pinned_ && close_tag(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, TAG_BLOCK, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // attribute* filter*
  public static boolean tag_content(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "tag_content")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<tag content>");
    result_ = tag_content_0(builder_, level_ + 1);
    result_ = result_ && tag_content_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, TAG_CONTENT, result_, false, null);
    return result_;
  }

  // attribute*
  private static boolean tag_content_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "tag_content_0")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!attribute(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "tag_content_0", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // filter*
  private static boolean tag_content_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "tag_content_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!filter(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "tag_content_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  /* ********************************************************** */
  // path|STRING|STRING_SINGLE|IDENTIFIER|PERIOD|NUMBER
  public static boolean tag_name(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "tag_name")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<tag name>");
    result_ = path(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, STRING);
    if (!result_) result_ = consumeToken(builder_, STRING_SINGLE);
    if (!result_) result_ = consumeToken(builder_, IDENTIFIER);
    if (!result_) result_ = consumeToken(builder_, PERIOD);
    if (!result_) result_ = consumeToken(builder_, NUMBER);
    exit_section_(builder_, level_, marker_, TAG_NAME, result_, false, null);
    return result_;
  }

}
