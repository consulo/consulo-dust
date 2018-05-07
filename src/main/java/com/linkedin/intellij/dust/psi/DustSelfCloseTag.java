// This is a generated file. Not intended for manual editing.
package com.linkedin.intellij.dust.psi;

import java.util.List;

import javax.annotation.Nonnull;

import com.intellij.psi.PsiElement;

public interface DustSelfCloseTag extends PsiElement {

  @Nonnull
  List<DustContext> getContextList();

  @Nonnull
  DustTagContent getTagContent();

  @Nonnull
  DustTagName getTagName();

}
