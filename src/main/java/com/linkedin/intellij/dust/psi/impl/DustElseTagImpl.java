// This is a generated file. Not intended for manual editing.
package com.linkedin.intellij.dust.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;

import javax.annotation.Nonnull;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.linkedin.intellij.dust.psi.*;

public class DustElseTagImpl extends ASTWrapperPsiElement implements DustElseTag {

  public DustElseTagImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof DustVisitor) ((DustVisitor)visitor).visitElseTag(this);
    else super.accept(visitor);
  }

  @Override
  @Nonnull
  public DustTagContent getTagContent() {
    return findNotNullChildByClass(DustTagContent.class);
  }

  @Override
  @Nonnull
  public DustTagName getTagName() {
    return findNotNullChildByClass(DustTagName.class);
  }

}
