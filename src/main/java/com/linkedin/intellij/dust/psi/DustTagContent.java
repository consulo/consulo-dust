// This is a generated file. Not intended for manual editing.
package com.linkedin.intellij.dust.psi;

import java.util.List;

import javax.annotation.Nonnull;

import com.intellij.psi.PsiElement;

public interface DustTagContent extends PsiElement {

  @Nonnull
  List<DustAttribute> getAttributeList();

  @Nonnull
  List<DustFilter> getFilterList();

}
