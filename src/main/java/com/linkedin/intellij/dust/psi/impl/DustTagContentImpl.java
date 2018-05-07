// This is a generated file. Not intended for manual editing.
package com.linkedin.intellij.dust.psi.impl;

import java.util.List;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;

import javax.annotation.Nonnull;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.linkedin.intellij.dust.psi.*;

public class DustTagContentImpl extends ASTWrapperPsiElement implements DustTagContent {

  public DustTagContentImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof DustVisitor) ((DustVisitor)visitor).visitTagContent(this);
    else super.accept(visitor);
  }

  @Override
  @Nonnull
  public List<DustAttribute> getAttributeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, DustAttribute.class);
  }

  @Override
  @Nonnull
  public List<DustFilter> getFilterList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, DustFilter.class);
  }

}
