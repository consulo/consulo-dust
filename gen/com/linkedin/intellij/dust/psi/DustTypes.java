// This is a generated file. Not intended for manual editing.
package com.linkedin.intellij.dust.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.linkedin.intellij.dust.psi.impl.*;

public interface DustTypes {

  IElementType ATTRIBUTE = new DustElementType("ATTRIBUTE");
  IElementType ATTR_STRING = new DustElementType("ATTR_STRING");
  IElementType CLOSE_TAG = new DustElementType("CLOSE_TAG");
  IElementType CONTEXT = new DustElementType("CONTEXT");
  IElementType ELSE_TAG = new DustElementType("ELSE_TAG");
  IElementType FILTER = new DustElementType("FILTER");
  IElementType I1_8N_FORMAT = new DustElementType("I1_8N_FORMAT");
  IElementType INDEX_DEREF = new DustElementType("INDEX_DEREF");
  IElementType JSON = new DustElementType("JSON");
  IElementType KEY_TAG = new DustElementType("KEY_TAG");
  IElementType OPEN_TAG = new DustElementType("OPEN_TAG");
  IElementType PATH = new DustElementType("PATH");
  IElementType SELF_CLOSE_TAG = new DustElementType("SELF_CLOSE_TAG");
  IElementType STATEMENTS = new DustElementType("STATEMENTS");
  IElementType TAG = new DustElementType("TAG");
  IElementType TAG_BLOCK = new DustElementType("TAG_BLOCK");
  IElementType TAG_CONTENT = new DustElementType("TAG_CONTENT");
  IElementType TAG_NAME = new DustElementType("TAG_NAME");

  IElementType BLOCK = new DustTokenType("BLOCK");
  IElementType CLOSE = new DustTokenType("CLOSE");
  IElementType COLON = new DustTokenType("COLON");
  IElementType COMMENT = new DustTokenType("COMMENT");
  IElementType CRLF = new DustTokenType("CRLF");
  IElementType ELSE = new DustTokenType("ELSE");
  IElementType EQUAL = new DustTokenType("EQUAL");
  IElementType EXISTANCE = new DustTokenType("EXISTANCE");
  IElementType HELPER = new DustTokenType("HELPER");
  IElementType HTML = new DustTokenType("HTML");
  IElementType IDENTIFIER = new DustTokenType("IDENTIFIER");
  IElementType INLINE_PARTIAL = new DustTokenType("INLINE_PARTIAL");
  IElementType LB = new DustTokenType("LB");
  IElementType LD = new DustTokenType("LD");
  IElementType NOT_EXISTANCE = new DustTokenType("NOT_EXISTANCE");
  IElementType NUMBER = new DustTokenType("NUMBER");
  IElementType PARTIAL = new DustTokenType("PARTIAL");
  IElementType PERIOD = new DustTokenType("PERIOD");
  IElementType PIPE = new DustTokenType("PIPE");
  IElementType RB = new DustTokenType("RB");
  IElementType RD = new DustTokenType("RD");
  IElementType SECTION = new DustTokenType("SECTION");
  IElementType SLASH_RD = new DustTokenType("SLASH_RD");
  IElementType STRING = new DustTokenType("STRING");
  IElementType STRING_END = new DustTokenType("STRING_END");
  IElementType STRING_SINGLE = new DustTokenType("STRING_SINGLE");
  IElementType STRING_START = new DustTokenType("STRING_START");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ATTRIBUTE) {
        return new DustAttributeImpl(node);
      }
      else if (type == ATTR_STRING) {
        return new DustAttrStringImpl(node);
      }
      else if (type == CLOSE_TAG) {
        return new DustCloseTagImpl(node);
      }
      else if (type == CONTEXT) {
        return new DustContextImpl(node);
      }
      else if (type == ELSE_TAG) {
        return new DustElseTagImpl(node);
      }
      else if (type == FILTER) {
        return new DustFilterImpl(node);
      }
      else if (type == I1_8N_FORMAT) {
        return new DustI18nFormatImpl(node);
      }
      else if (type == INDEX_DEREF) {
        return new DustIndexDerefImpl(node);
      }
      else if (type == JSON) {
        return new DustJsonImpl(node);
      }
      else if (type == KEY_TAG) {
        return new DustKeyTagImpl(node);
      }
      else if (type == OPEN_TAG) {
        return new DustOpenTagImpl(node);
      }
      else if (type == PATH) {
        return new DustPathImpl(node);
      }
      else if (type == SELF_CLOSE_TAG) {
        return new DustSelfCloseTagImpl(node);
      }
      else if (type == STATEMENTS) {
        return new DustStatementsImpl(node);
      }
      else if (type == TAG) {
        return new DustTagImpl(node);
      }
      else if (type == TAG_BLOCK) {
        return new DustTagBlockImpl(node);
      }
      else if (type == TAG_CONTENT) {
        return new DustTagContentImpl(node);
      }
      else if (type == TAG_NAME) {
        return new DustTagNameImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
