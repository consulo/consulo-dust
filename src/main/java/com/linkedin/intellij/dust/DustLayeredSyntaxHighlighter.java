package com.linkedin.intellij.dust;

import com.linkedin.intellij.dust.psi.DustTypes;
import consulo.colorScheme.EditorColorsScheme;
import consulo.language.Language;
import consulo.language.editor.highlight.LayerDescriptor;
import consulo.language.editor.highlight.LayeredLexerEditorHighlighter;
import consulo.language.editor.highlight.SyntaxHighlighter;
import consulo.language.editor.highlight.SyntaxHighlighterFactory;
import consulo.language.plain.PlainTextFileType;
import consulo.language.template.TemplateDataLanguageMappings;
import consulo.project.Project;
import consulo.virtualFileSystem.VirtualFile;
import consulo.virtualFileSystem.fileType.FileType;
import consulo.xml.ide.highlighter.HtmlFileType;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

/**
 * Created with IntelliJ IDEA.
 * User: yzhang
 * Date: 2/1/13
 * Time: 2:44 PM
 */
public class DustLayeredSyntaxHighlighter extends LayeredLexerEditorHighlighter {
  public DustLayeredSyntaxHighlighter(@Nullable Project project, @Nullable VirtualFile virtualFile, @Nonnull EditorColorsScheme colors) {
    // create main highlighter
    super(new DustSyntaxHighlighter(), colors);

    // highlighter for outer lang
    FileType type = null;
    if(project == null || virtualFile == null) {
      type = PlainTextFileType.INSTANCE;
    } else {
      Language language = TemplateDataLanguageMappings.getInstance(project).getMapping(virtualFile);
      if(language != null) type = language.getAssociatedFileType();
      if(type == null) type = HtmlFileType.INSTANCE;
    }
    SyntaxHighlighter outerHighlighter = SyntaxHighlighterFactory.getSyntaxHighlighter(type, project, virtualFile);

    registerLayer(DustTypes.HTML, new LayerDescriptor(outerHighlighter, ""));
  }
}
