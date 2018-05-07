package com.linkedin.intellij.dust.psi;

import javax.annotation.Nonnull;

import com.intellij.psi.tree.IElementType;
import com.linkedin.intellij.dust.DustLanguage;
import org.jetbrains.annotations.NonNls;

/**
 * Created with IntelliJ IDEA.
 * User: yzhang
 * Date: 1/16/13
 * Time: 1:22 PM
 */
public class DustTokenType extends IElementType {
  public DustTokenType(@Nonnull @NonNls String debugName) {
    super(debugName, DustLanguage.INSTANCE);
  }

  @Override
  public String toString() {
    return "DustTokenType." + super.toString();
  }
}
