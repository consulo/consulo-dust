package com.linkedin.intellij.dust;

import consulo.annotation.component.ExtensionImpl;
import consulo.codeEditor.EditorHighlighter;
import consulo.colorScheme.EditorColorsScheme;
import consulo.language.editor.highlight.EditorHighlighterProvider;
import consulo.project.Project;
import consulo.virtualFileSystem.VirtualFile;
import consulo.virtualFileSystem.fileType.FileType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author VISTALL
 * @since 2019-02-26
 */
@ExtensionImpl
public class DustEditorHighlighterProvider implements EditorHighlighterProvider {
  @Override
  public EditorHighlighter getEditorHighlighter(@Nullable Project project,
                                                @Nonnull FileType fileType,
                                                @Nullable VirtualFile virtualFile,
                                                @Nonnull EditorColorsScheme colors) {
    return new DustLayeredSyntaxHighlighter(project, virtualFile, colors);
  }

  @Nonnull
  @Override
  public FileType getFileType() {
    return DustFileType.INSTANCE;
  }
}
