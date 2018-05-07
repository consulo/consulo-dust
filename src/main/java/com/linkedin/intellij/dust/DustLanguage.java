package com.linkedin.intellij.dust;

import com.intellij.lang.Language;

/**
 * Created with IntelliJ IDEA.
 * User: yzhang
 * Date: 1/16/13
 * Time: 12:42 PM
 */
public class DustLanguage extends Language {
  public static final DustLanguage INSTANCE = new DustLanguage();

  private DustLanguage() {
    super("Dust");
  }
}
