// This is a generated file. Not intended for manual editing.
package com.linkedin.intellij.dust.psi.impl;

import java.util.List;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;

import javax.annotation.Nonnull;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.linkedin.intellij.dust.psi.*;

public class DustI18nFormatImpl extends ASTWrapperPsiElement implements DustI18nFormat {

  public DustI18nFormatImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof DustVisitor) ((DustVisitor)visitor).visitI18nFormat(this);
    else super.accept(visitor);
  }

  @Override
  @Nonnull
  public List<DustTag> getTagList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, DustTag.class);
  }

}
