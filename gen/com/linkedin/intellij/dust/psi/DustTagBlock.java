// This is a generated file. Not intended for manual editing.
package com.linkedin.intellij.dust.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DustTagBlock extends PsiElement {

  @Nullable
  DustCloseTag getCloseTag();

  @Nullable
  DustElseTag getElseTag();

  @NotNull
  DustOpenTag getOpenTag();

  @NotNull
  List<DustStatements> getStatementsList();

}
