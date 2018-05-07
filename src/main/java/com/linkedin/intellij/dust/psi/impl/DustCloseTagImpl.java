// This is a generated file. Not intended for manual editing.
package com.linkedin.intellij.dust.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;

import javax.annotation.*;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.linkedin.intellij.dust.psi.*;

public class DustCloseTagImpl extends ASTWrapperPsiElement implements DustCloseTag {

  public DustCloseTagImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof DustVisitor) ((DustVisitor)visitor).visitCloseTag(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public DustIndexDeref getIndexDeref() {
    return findChildByClass(DustIndexDeref.class);
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
