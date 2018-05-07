// This is a generated file. Not intended for manual editing.
package com.linkedin.intellij.dust.psi.impl;

import java.util.List;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;

import javax.annotation.*;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.linkedin.intellij.dust.psi.*;

public class DustKeyTagImpl extends ASTWrapperPsiElement implements DustKeyTag {

  public DustKeyTagImpl(ASTNode node) {
    super(node);
  }

  public void accept(@Nonnull PsiElementVisitor visitor) {
    if (visitor instanceof DustVisitor) ((DustVisitor)visitor).visitKeyTag(this);
    else super.accept(visitor);
  }

  @Override
  @Nonnull
  public List<DustContext> getContextList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, DustContext.class);
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
