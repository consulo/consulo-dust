// This is a generated file. Not intended for manual editing.
package com.linkedin.intellij.dust.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DustAttrString extends PsiElement {

  @NotNull
  List<DustI18nFormat> getI18nFormatList();

  @NotNull
  List<DustTag> getTagList();

  @NotNull
  List<DustTagBlock> getTagBlockList();

}
