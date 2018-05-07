package com.linkedin.intellij.dust;

import java.io.Reader;

import javax.annotation.Nonnull;

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

  @Nonnull
  @Override
  public Lexer createLexer( @Nonnull LanguageVersion languageVersion) {
    return new FlexAdapter(new DustLexer((Reader) null));
  }

  @Override
  @Nonnull
  public TokenSet getWhitespaceTokens(@Nonnull LanguageVersion languageVersion) {
    return WHITE_SPACES;
  }

  @Override
  @Nonnull
  public TokenSet getCommentTokens(@Nonnull LanguageVersion languageVersion) {
    return TokenSet.create(DustTypes.COMMENT);
  }

  @Override
  @Nonnull
  public TokenSet getStringLiteralElements(@Nonnull LanguageVersion languageVersion) {
    return TokenSet.EMPTY;
  }

  @Override
  @Nonnull
  public PsiParser createParser(@Nonnull LanguageVersion languageVersion) {
    return new DustParser();
  }

  @Nonnull
  @Override
  public IFileElementType getFileNodeType() {
    return FILE;
  }

  @Override
  public PsiFile createFile(FileViewProvider viewProvider) {
    return new DustFile(viewProvider);
  }

  @Nonnull
  @Override
  public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
    return SpaceRequirements.MAY;
  }

  @Override
  @Nonnull
  public PsiElement createElement(ASTNode node) {
    return DustTypes.Factory.createElement(node);
  }
}

