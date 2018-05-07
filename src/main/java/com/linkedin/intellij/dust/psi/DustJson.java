// This is a generated file. Not intended for manual editing.
package com.linkedin.intellij.dust.psi;

import java.util.List;

import javax.annotation.Nonnull;

import com.intellij.psi.PsiElement;

public interface DustJson extends PsiElement {

  @Nonnull
  List<DustJson> getJsonList();

  @Nonnull
  List<DustTag> getTagList();

}
