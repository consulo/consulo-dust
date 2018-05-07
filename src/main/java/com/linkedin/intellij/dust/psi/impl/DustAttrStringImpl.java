// This is a generated file. Not intended for manual editing.
package com.linkedin.intellij.dust.psi.impl;

import java.util.List;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;

import javax.annotation.Nonnull;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.linkedin.intellij.dust.psi.*;

public class DustAttrStringImpl extends ASTWrapperPsiElement implements DustAttrString {

  public DustAttrStringImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof DustVisitor) ((DustVisitor)visitor).visitAttrString(this);
    else super.accept(visitor);
  }

  @Override
  @Nonnull
  public List<DustI18nFormat> getI18nFormatList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, DustI18nFormat.class);
  }

  @Override
  @Nonnull
  public List<DustTag> getTagList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, DustTag.class);
  }

  @Override
  @Nonnull
  public List<DustTagBlock> getTagBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, DustTagBlock.class);
  }

}
