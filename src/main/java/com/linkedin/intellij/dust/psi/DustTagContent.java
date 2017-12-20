// This is a generated file. Not intended for manual editing.
package com.linkedin.intellij.dust.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DustTagContent extends PsiElement {

  @NotNull
  List<DustAttribute> getAttributeList();

  @NotNull
  List<DustFilter> getFilterList();

}
