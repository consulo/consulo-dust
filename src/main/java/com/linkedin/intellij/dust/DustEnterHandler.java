package com.linkedin.intellij.dust;

import javax.annotation.Nonnull;

import com.intellij.codeInsight.editorActions.enter.EnterHandlerDelegateAdapter;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.actionSystem.EditorActionHandler;
import com.intellij.openapi.editor.ex.EditorEx;
import com.intellij.openapi.editor.highlighter.EditorHighlighter;
import com.intellij.openapi.editor.highlighter.HighlighterIterator;
import com.intellij.openapi.util.Ref;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.linkedin.intellij.dust.psi.DustFile;
import com.linkedin.intellij.dust.psi.DustPsiUtil;

/**
 * Created with IntelliJ IDEA.
 * User: yzhang
 * Date: 6/5/13
 * Time: 9:55 AM
 *
 * Same logic as in the intellij mustache/handlebars plugin
 */
public class DustEnterHandler extends EnterHandlerDelegateAdapter{

  public Result preprocessEnter(@Nonnull final PsiFile file, @Nonnull final Editor editor, @Nonnull final Ref<Integer> caretOffset, @Nonnull final Ref<Integer> caretAdvance,
                                @Nonnull final DataContext dataContext, final EditorActionHandler originalHandler) {
    /**
     * if we are between open and close tags, we ensure the caret ends up in the "logical" place on Enter.
     * i.e. "{#foo}<caret>{/foo}" becomes the following on Enter:
     *
     * {#foo}
     * <caret>
     * {/foo}
     *
     * (Note: <caret> may be indented depending on formatter settings.)
     */
    if (file instanceof DustFile
        && isBetweenHbTags(editor, file, caretOffset.get())) {
      originalHandler.executeInCommand(editor, dataContext);
      return Result.Default;
    }
    return Result.Continue;
  }

  /**
   * Checks to see if {@code Enter} has been typed while the caret is between an open and close tag pair.
   * @return true if between open and close tags, false otherwise
   */
  private static boolean isBetweenHbTags(Editor editor, PsiFile file, int offset) {
    if (offset == 0) return false;
    CharSequence chars = editor.getDocument().getCharsSequence();
    if (chars.charAt(offset - 1) != '}') return false;

    EditorHighlighter highlighter = ((EditorEx)editor).getHighlighter();
    HighlighterIterator iterator = highlighter.createIterator(offset - 1);

    final PsiElement openerElement = file.findElementAt(iterator.getStart());

    PsiElement openTag = DustPsiUtil.findParentOpenTagElement(openerElement);

    if (openTag == null) {
      return false;
    }

    iterator.advance();

    if (iterator.atEnd()) {
      // no more tokens, so certainly no close tag
      return false;
    }

    final PsiElement closerElement = file.findElementAt(iterator.getStart());

    PsiElement closeTag = DustPsiUtil.findParentCloseTagElement(closerElement);

    // if we got this far, we're between open and close tags iff this is a close tag
    return closeTag != null;
  }

}
