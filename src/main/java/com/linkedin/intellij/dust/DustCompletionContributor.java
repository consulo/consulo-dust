package com.linkedin.intellij.dust;

import com.linkedin.intellij.dust.psi.DustTypes;
import consulo.annotation.component.ExtensionImpl;
import consulo.language.Language;
import consulo.language.editor.completion.*;
import consulo.language.editor.completion.lookup.LookupElementBuilder;
import consulo.language.pattern.PlatformPatterns;
import consulo.language.util.ProcessingContext;

import javax.annotation.Nonnull;

/**
 * Created with IntelliJ IDEA.
 * User: yzhang
 * Date: 2/15/13
 * Time: 1:04 PM
 */
@ExtensionImpl
public class DustCompletionContributor extends CompletionContributor {
  public DustCompletionContributor() {
    extend(CompletionType.BASIC,
           PlatformPatterns.psiElement(DustTypes.IDENTIFIER).withLanguage(DustLanguage.INSTANCE),
           new CompletionProvider() {
          public void addCompletions(@Nonnull CompletionParameters parameters,
                                     ProcessingContext context,
                                     @Nonnull CompletionResultSet resultSet) {
            resultSet.addElement(LookupElementBuilder.create("if"));
            resultSet.addElement(LookupElementBuilder.create("select"));
            resultSet.addElement(LookupElementBuilder.create("log"));
            resultSet.addElement(LookupElementBuilder.create("idx"));
            resultSet.addElement(LookupElementBuilder.create("jsControl"));
            resultSet.addElement(LookupElementBuilder.create("math"));
            resultSet.addElement(LookupElementBuilder.create("lt"));
            resultSet.addElement(LookupElementBuilder.create("gt"));
            resultSet.addElement(LookupElementBuilder.create("ne"));
            resultSet.addElement(LookupElementBuilder.create("eq"));
            resultSet.addElement(LookupElementBuilder.create("pre.scss"));
            resultSet.addElement(LookupElementBuilder.create("pre.layout"));
            resultSet.addElement(LookupElementBuilder.create("pre.js"));
            resultSet.addElement(LookupElementBuilder.create("pre.i18n"));
            // TODO add more keywords, think about writing a reference based autocompleter
          }
        }
    );
  }

  @Nonnull
  @Override
  public Language getLanguage() {
    return DustLanguage.INSTANCE;
  }
}
