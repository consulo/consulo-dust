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

public class DustOpenTagImpl extends ASTWrapperPsiElement implements DustOpenTag {

  public DustOpenTagImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DustVisitor) ((DustVisitor)visitor).visitOpenTag(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<DustContext> getContextList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, DustContext.class);
  }

  @Override
  @Nullable
  public DustIndexDeref getIndexDeref() {
    return findChildByClass(DustIndexDeref.class);
  }

  @Override
  @NotNull
  public DustTagContent getTagContent() {
    return findNotNullChildByClass(DustTagContent.class);
  }

  @Override
  @NotNull
  public DustTagName getTagName() {
    return findNotNullChildByClass(DustTagName.class);
  }

}
