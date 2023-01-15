package com.linkedin.intellij.dust;

import consulo.annotation.component.ExtensionImpl;
import consulo.language.Language;
import consulo.language.ast.ASTNode;
import consulo.language.codeStyle.*;
import consulo.language.codeStyle.template.DataLanguageBlockWrapper;
import consulo.language.codeStyle.template.SimpleTemplateLanguageFormattingModelBuilder;
import consulo.language.codeStyle.template.TemplateLanguageBlock;
import consulo.language.codeStyle.template.TemplateLanguageFormattingModelBuilder;
import consulo.language.psi.PsiElement;
import consulo.language.psi.PsiFile;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yzhang
 * Date: 3/11/13
 * Time: 10:30 AM
 * <p>
 * Based on the intellij mustache plugin
 */
@ExtensionImpl
public class DustFormattingModelBuilder extends TemplateLanguageFormattingModelBuilder {
  private static final SimpleTemplateLanguageFormattingModelBuilder ourSimpleModel = new SimpleTemplateLanguageFormattingModelBuilder() {
    @Nonnull
    @Override
    public Language getLanguage() {
      return DustLanguage.INSTANCE;
    }
  };

  @Override
  public TemplateLanguageBlock createTemplateLanguageBlock(@Nonnull ASTNode node,
                                                           @Nullable Wrap wrap,
                                                           @Nullable Alignment alignment,
                                                           @Nullable List<DataLanguageBlockWrapper> foreignChildren,
                                                           @Nonnull CodeStyleSettings codeStyleSettings) {
    return new DustFormatterBlock(this, codeStyleSettings, node, foreignChildren);
  }

  /**
   * We have to override {@link TemplateLanguageFormattingModelBuilder#createModel}
   * since after we delegate to some templated languages, those languages (xml/html for sure, potentially others)
   * delegate right back to us to format the DustTypes.OUTER_TYPE token we tell them to ignore,
   * causing an stack-overflowing loop.
   */
  @Nonnull
  public FormattingModel createModel(FormattingContext context) {
    PsiElement element = context.getPsiElement();
    CodeStyleSettings settings = context.getCodeStyleSettings();

    final PsiFile file = element.getContainingFile();
    Block rootBlock;

    ASTNode node = element.getNode();

    if (node.getElementType() == DustFileViewProvider.OUTER_TYPE) {
      // If we're looking at a DustTypes.HTML element, then we've been invoked by our templated
      // language.  Make a dummy block to allow that formatter to continue
      return ourSimpleModel.createModel(context);
    }
    else {
      rootBlock = getRootBlock(file, file.getViewProvider(), settings);
    }

    return new DocumentBasedFormattingModel(rootBlock, element.getProject(), settings, file.getFileType(), file);
  }

  @Override
  public boolean dontFormatMyModel() {
    return false;
  }

  @Nonnull
  @Override
  public Language getLanguage() {
    return DustLanguage.INSTANCE;
  }
}
