// This is a generated file. Not intended for manual editing.
package com.linkedin.intellij.dust.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;

import javax.annotation.*;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.linkedin.intellij.dust.psi.*;

public class DustTagImpl extends ASTWrapperPsiElement implements DustTag {

  public DustTagImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof DustVisitor) ((DustVisitor)visitor).visitTag(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public DustKeyTag getKeyTag() {
    return findChildByClass(DustKeyTag.class);
  }

  @Override
  @Nullable
  public DustSelfCloseTag getSelfCloseTag() {
    return findChildByClass(DustSelfCloseTag.class);
  }

}
