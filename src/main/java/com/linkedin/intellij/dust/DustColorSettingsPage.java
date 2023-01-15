package com.linkedin.intellij.dust;

import consulo.annotation.component.ExtensionImpl;
import consulo.colorScheme.TextAttributesKey;
import consulo.colorScheme.setting.AttributesDescriptor;
import consulo.colorScheme.setting.ColorDescriptor;
import consulo.language.editor.colorScheme.setting.ColorSettingsPage;
import consulo.language.editor.highlight.SyntaxHighlighter;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: yzhang
 * Date: 1/16/13
 * Time: 3:17 PM
 */
@ExtensionImpl
public class DustColorSettingsPage implements ColorSettingsPage {
  private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
      new AttributesDescriptor("Dust Tag", DustSyntaxHighlighter.TAG),
      new AttributesDescriptor("Number", DustSyntaxHighlighter.NUMBER),
      new AttributesDescriptor("Identifier", DustSyntaxHighlighter.IDENTIFIER),
      new AttributesDescriptor("String", DustSyntaxHighlighter.STRING),
      new AttributesDescriptor("Comments", DustSyntaxHighlighter.COMMENT),
      new AttributesDescriptor("Todo", DustSyntaxHighlighter.TODO)
  };

  private static final Map<String, TextAttributesKey>additionalHighlightingMap = new HashMap<String, TextAttributesKey>();
  static {
    additionalHighlightingMap.put("todocomment", DustSyntaxHighlighter.TODO);
  }


  private String demo = "";

  public DustColorSettingsPage() {
    try {
      final InputStream is = DustColorSettingsPage.class.getResourceAsStream("demo_text.tl");
      BufferedReader br = new BufferedReader(new InputStreamReader(is));
      StringBuilder sb = new StringBuilder();
      int c;
      while ((c = br.read()) != -1) {
        sb.append((char) c);
      }
      demo = sb.toString();
    } catch (Throwable e) {
      // Fallback demo
      demo = "{! You are reading the DUST template example !}\n" +
          "{?person test=something keya=valuea keyb=\"linked{expression}in\"}\n" +
          "  something abc=abc\n" +
          "  <div class=\"abc\">hello</div>\n" +
          "{/person}";
    }
  }

  @Nonnull
  @Override
  public SyntaxHighlighter getHighlighter() {
    return new DustSyntaxHighlighter();
  }

  @Nonnull
  @Override
  public String getDemoText() {
    return demo;
  }

  @Nullable
  @Override
  public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
    return additionalHighlightingMap;
  }

  @Nonnull
  @Override
  public AttributesDescriptor[] getAttributeDescriptors() {
    return DESCRIPTORS;
  }

  @Nonnull
  @Override
  public ColorDescriptor[] getColorDescriptors() {
    return ColorDescriptor.EMPTY_ARRAY;
  }

  @Nonnull
  @Override
  public String getDisplayName() {
    return "Dust";
  }
}