package com.linkedin.intellij.dust;

import consulo.dust.icon.DustIconGroup;
import consulo.language.file.LanguageFileType;
import consulo.localize.LocalizeValue;
import consulo.ui.image.Image;
import org.jetbrains.annotations.NonNls;

import jakarta.annotation.Nonnull;

/**
 * Created with IntelliJ IDEA.
 * User: yzhang
 * Date: 1/16/13
 * Time: 10:48 AM
 */
public class DustFileType extends LanguageFileType {
  public static final DustFileType INSTANCE = new DustFileType();
  @NonNls public static final String DEFAULT_EXTENSION = "tl";

  private DustFileType() {
    super(DustLanguage.INSTANCE);
  }

  @Override
  @Nonnull
  public String getId() {
    return "Dust";
  }

  @Override
  @Nonnull
  public LocalizeValue getDescription() {
    return LocalizeValue.localizeTODO("Dust files");
  }

  @Override
  @Nonnull
  public String getDefaultExtension() {
    return DEFAULT_EXTENSION;
  }

  @Nonnull
  @Override
  public Image getIcon() {
    return DustIconGroup.dust_icon();
  }
}
