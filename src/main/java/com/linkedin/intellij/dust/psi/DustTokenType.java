package com.linkedin.intellij.dust.psi;

import com.linkedin.intellij.dust.DustLanguage;
import consulo.language.ast.IElementType;
import org.jetbrains.annotations.NonNls;

import jakarta.annotation.Nonnull;

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
