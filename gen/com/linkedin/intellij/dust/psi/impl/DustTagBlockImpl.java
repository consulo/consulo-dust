// This is a generated file. Not intended for manual editing.
package com.linkedin.intellij.dust.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.linkedin.intellij.dust.psi.DustTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.linkedin.intellij.dust.psi.*;

public class DustTagBlockImpl extends ASTWrapperPsiElement implements DustTagBlock {

  public DustTagBlockImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DustVisitor) ((DustVisitor)visitor).visitTagBlock(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public DustCloseTag getCloseTag() {
    return findChildByClass(DustCloseTag.class);
  }

  @Override
  @Nullable
  public DustElseTag getElseTag() {
    return findChildByClass(DustElseTag.class);
  }

  @Override
  @NotNull
  public DustOpenTag getOpenTag() {
    return findNotNullChildByClass(DustOpenTag.class);
  }

  @Override
  @NotNull
  public List<DustStatements> getStatementsList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, DustStatements.class);
  }

}