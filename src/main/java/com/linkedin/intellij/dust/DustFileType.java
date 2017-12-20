package com.linkedin.intellij.dust;

import javax.swing.Icon;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.openapi.editor.colors.EditorColorsScheme;
import com.intellij.openapi.editor.highlighter.EditorHighlighter;
import com.intellij.openapi.fileTypes.EditorHighlighterProvider;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.FileTypeEditorHighlighterProviders;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;

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
    // register highlighter - lazy singleton factory
    FileTypeEditorHighlighterProviders.INSTANCE.addExplicitExtension(this, new EditorHighlighterProvider() {
      public EditorHighlighter getEditorHighlighter(@Nullable Project project,
                                                    @NotNull FileType fileType,
                                                    @Nullable VirtualFile virtualFile,
                                                    @NotNull EditorColorsScheme editorColorsScheme) {
        return new DustLayeredSyntaxHighlighter(project, virtualFile, editorColorsScheme);
      }
    });
  }

  @Override
  @NotNull
  public String getName() {
    return "Dust";
  }

  @Override
  @NotNull
  public String getDescription() {
    return "Dust files";
  }

  @Override
  @NotNull
  public String getDefaultExtension() {
    return DEFAULT_EXTENSION;
  }

  @Override
  public Icon getIcon() {
    return DustIcons.FILE;
  }
}
