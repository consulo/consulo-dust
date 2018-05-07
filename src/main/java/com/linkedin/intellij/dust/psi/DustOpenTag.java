// This is a generated file. Not intended for manual editing.
package com.linkedin.intellij.dust.psi;

import java.util.List;

import javax.annotation.*;

import com.intellij.psi.PsiElement;

public interface DustOpenTag extends PsiElement {

  @Nonnull
  List<DustContext> getContextList();

  @Nullable
  DustIndexDeref getIndexDeref();

  @Nonnull
  DustTagContent getTagContent();

  @Nonnull
  DustTagName getTagName();

}
