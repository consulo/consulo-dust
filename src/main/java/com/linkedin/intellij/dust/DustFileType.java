package com.linkedin.intellij.dust;

import javax.annotation.Nonnull;

import org.jetbrains.annotations.NonNls;
import com.intellij.openapi.fileTypes.LanguageFileType;
import consulo.ui.image.Image;

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
  public String getDescription() {
    return "Dust files";
  }

  @Override
  @Nonnull
  public String getDefaultExtension() {
    return DEFAULT_EXTENSION;
  }

  @Override
  public Image getIcon() {
    return DustIcons.FILE;
  }
}
