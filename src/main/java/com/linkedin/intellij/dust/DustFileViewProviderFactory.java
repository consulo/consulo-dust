package com.linkedin.intellij.dust;

import consulo.annotation.component.ExtensionImpl;
import consulo.language.Language;
import consulo.language.file.FileViewProvider;
import consulo.language.file.LanguageFileViewProviderFactory;
import consulo.language.psi.PsiManager;
import consulo.virtualFileSystem.VirtualFile;

import jakarta.annotation.Nonnull;

/**
 * Created with IntelliJ IDEA.
 * User: yzhang
 * Date: 2/1/13
 * Time: 2:40 PM
 */
@ExtensionImpl
public class DustFileViewProviderFactory  implements LanguageFileViewProviderFactory {
  @Override
  public FileViewProvider createFileViewProvider(VirtualFile virtualFile, Language language, PsiManager psiManager, boolean physical) {
    return new DustFileViewProvider(psiManager, virtualFile, physical);
  }

  @Nonnull
  @Override
  public Language getLanguage() {
    return DustLanguage.INSTANCE;
  }
}
