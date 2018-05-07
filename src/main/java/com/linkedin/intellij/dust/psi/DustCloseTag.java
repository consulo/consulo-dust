// This is a generated file. Not intended for manual editing.
package com.linkedin.intellij.dust.psi;

import javax.annotation.*;

import com.intellij.psi.PsiElement;

public interface DustCloseTag extends PsiElement {

  @Nullable
  DustIndexDeref getIndexDeref();

  @Nonnull
  DustTagContent getTagContent();

  @Nonnull
  DustTagName getTagName();

}
