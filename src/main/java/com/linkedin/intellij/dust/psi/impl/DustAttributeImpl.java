// This is a generated file. Not intended for manual editing.
package com.linkedin.intellij.dust.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;

import javax.annotation.*;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.linkedin.intellij.dust.psi.*;

public class DustAttributeImpl extends ASTWrapperPsiElement implements DustAttribute {

  public DustAttributeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof DustVisitor) ((DustVisitor)visitor).visitAttribute(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public DustAttrString getAttrString() {
    return findChildByClass(DustAttrString.class);
  }

  @Override
  @Nullable
  public DustPath getPath() {
    return findChildByClass(DustPath.class);
  }

}
