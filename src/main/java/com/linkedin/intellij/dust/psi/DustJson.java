// This is a generated file. Not intended for manual editing.
package com.linkedin.intellij.dust.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DustJson extends PsiElement {

  @NotNull
  List<DustJson> getJsonList();

  @NotNull
  List<DustTag> getTagList();

}
