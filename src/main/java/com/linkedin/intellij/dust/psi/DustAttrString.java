// This is a generated file. Not intended for manual editing.
package com.linkedin.intellij.dust.psi;

import java.util.List;

import javax.annotation.Nonnull;

import com.intellij.psi.PsiElement;

public interface DustAttrString extends PsiElement {

  @Nonnull
  List<DustI18nFormat> getI18nFormatList();

  @Nonnull
  List<DustTag> getTagList();

  @Nonnull
  List<DustTagBlock> getTagBlockList();

}
