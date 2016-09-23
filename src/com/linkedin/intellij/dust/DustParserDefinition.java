package com.linkedin.intellij.dust;

import java.io.Reader;

import org.jetbrains.annotations.NotNull;
import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import com.linkedin.intellij.dust.parser.DustParser;
import com.linkedin.intellij.dust.psi.DustFile;
import com.linkedin.intellij.dust.psi.DustTypes;
import consulo.lang.LanguageVersion;

/**
 * Created with IntelliJ IDEA.
 * User: yzhang
 * Date: 1/16/13
 * Time: 1:54 PM
 */
public class DustParserDefinition  implements ParserDefinition{
  public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);

  public static final IFileElementType FILE = new IFileElementType(Language.<DustLanguage>findInstance(DustLanguage.class));

  @NotNull
  @Override
  public Lexer createLexer( @NotNull LanguageVersion languageVersion) {
    return new FlexAdapter(new DustLexer((Reader) null));
  }

  @Override
  @NotNull
  public TokenSet getWhitespaceTokens(@NotNull LanguageVersion languageVersion) {
    return WHITE_SPACES;
  }

  @Override
  @NotNull
  public TokenSet getCommentTokens(@NotNull LanguageVersion languageVersion) {
    return TokenSet.create(DustTypes.COMMENT);
  }

  @Override
  @NotNull
  public TokenSet getStringLiteralElements(@NotNull LanguageVersion languageVersion) {
    return TokenSet.EMPTY;
  }

  @Override
  @NotNull
  public PsiParser createParser(@NotNull LanguageVersion languageVersion) {
    return new DustParser();
  }

  @NotNull
  @Override
  public IFileElementType getFileNodeType() {
    return FILE;
  }

  @Override
  public PsiFile createFile(FileViewProvider viewProvider) {
    return new DustFile(viewProvider);
  }

  @NotNull
  @Override
  public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
    return SpaceRequirements.MAY;
  }

  @Override
  @NotNull
  public PsiElement createElement(ASTNode node) {
    return DustTypes.Factory.createElement(node);
  }
}

