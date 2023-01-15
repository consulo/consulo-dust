package com.linkedin.intellij.dust.psi;

import com.linkedin.intellij.dust.DustLanguage;
import consulo.language.ast.IElementType;
import org.jetbrains.annotations.NonNls;

import javax.annotation.Nonnull;

/**
 * Created with IntelliJ IDEA.
 * User: yzhang
 * Date: 1/16/13
 * Time: 1:23 PM
 */
public class DustElementType extends IElementType {
  public DustElementType(@Nonnull @NonNls String debugName) {
    super(debugName, DustLanguage.INSTANCE);
  }
}
