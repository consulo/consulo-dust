// This is a generated file. Not intended for manual editing.
package com.linkedin.intellij.dust.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DustCloseTag extends PsiElement {

  @Nullable
  DustIndexDeref getIndexDeref();

  @NotNull
  DustTagContent getTagContent();

  @NotNull
  DustTagName getTagName();

}
