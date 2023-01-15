package com.linkedin.intellij.dust.psi;

import com.linkedin.intellij.dust.DustFileType;
import com.linkedin.intellij.dust.DustLanguage;
import consulo.language.file.FileViewProvider;
import consulo.language.impl.psi.PsiFileBase;
import consulo.virtualFileSystem.fileType.FileType;

import javax.annotation.Nonnull;

/**
 * Created with IntelliJ IDEA.
 * User: yzhang
 * Date: 1/16/13
 * Time: 2:12 PM
 */
public class DustFile  extends PsiFileBase {
  public DustFile(@Nonnull FileViewProvider viewProvider) {
    super(viewProvider, DustLanguage.INSTANCE);
  }

  @Nonnull
  @Override
  public FileType getFileType() {
    return DustFileType.INSTANCE;
  }

  @Override
  public String toString() {
    return "Dust File";
  }
}