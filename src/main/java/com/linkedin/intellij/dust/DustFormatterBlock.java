package com.linkedin.intellij.dust;

import com.linkedin.intellij.dust.psi.DustPsiUtil;
import com.linkedin.intellij.dust.psi.DustTypes;
import consulo.document.util.TextRange;
import consulo.language.ast.ASTNode;
import consulo.language.ast.IElementType;
import consulo.language.codeStyle.Alignment;
import consulo.language.codeStyle.ChildAttributes;
import consulo.language.codeStyle.CodeStyleSettings;
import consulo.language.codeStyle.Indent;
import consulo.language.codeStyle.template.BlockWithParent;
import consulo.language.codeStyle.template.DataLanguageBlockWrapper;
import consulo.language.codeStyle.template.TemplateLanguageBlock;
import consulo.language.codeStyle.template.TemplateLanguageBlockFactory;
import consulo.language.psi.PsiErrorElement;
import consulo.xml.psi.formatter.xml.SyntheticBlock;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yzhang
 * Date: 3/11/13
 * Time: 10:19 AM
 *
 * Based on the intellij mustache plugin
 */
public class DustFormatterBlock extends TemplateLanguageBlock {
  DustFormatterBlock(@Nonnull TemplateLanguageBlockFactory blockFactory, @Nonnull CodeStyleSettings settings,
                     @Nonnull ASTNode node, @Nullable List<DataLanguageBlockWrapper> foreignChildren) {
    super(blockFactory, settings, node, foreignChildren);
  }

  @Override
  public Indent getIndent() {
    // ignore whitespace
    if (myNode.getText().trim().length() == 0) {
      return Indent.getNoneIndent();
    }

    if (DustPsiUtil.isNonRootStatementsElement(myNode.getPsi())) {
      // we're computing the indent for a non-root STATEMENTS:
      //      if it's not contained in a foreign block, indent!
      if (hasOnlyDustLanguageParents()) {
        return Indent.getNormalIndent();
      }
    }

    if (myNode.getTreeParent() != null
        && DustPsiUtil.isNonRootStatementsElement(myNode.getTreeParent().getPsi())) {
      // we're computing the indent for a direct descendant of a non-root STATEMENTS:
      //      if its Block parent (i.e. not DUST AST Tree parent) is a DustForamtterBlock
      //      which has NOT been indented, then have the element provide the indent itself
      if (getParent() instanceof DustFormatterBlock
          && ((DustFormatterBlock) getParent()).getIndent() == Indent.getNoneIndent()) {
        return Indent.getNormalIndent();
      }
    }

    // any element that is the direct descendant of a foreign block gets an indent
    if (getRealBlockParent() instanceof DataLanguageBlockWrapper) {
      return Indent.getNormalIndent();
    }

    return Indent.getNoneIndent();
  }

  private boolean hasOnlyDustLanguageParents() {
    BlockWithParent parent = getParent();
    boolean hasOnlyDustLanguageParents = true;

    while (parent != null) {
      if (parent instanceof DataLanguageBlockWrapper) {
        hasOnlyDustLanguageParents = false;
        break;
      }
      parent = parent.getParent();
    }

    return hasOnlyDustLanguageParents;
  }

  private BlockWithParent getRealBlockParent() {
    // if we can follow the chain of synthetic parent blocks, and if we end up
    // at a real DataLanguage block (i.e. the synthetic blocks didn't lead to an DustFormatterBlock),
    // we're a child of a templated language node and need an indent
    BlockWithParent parent = getParent();
    while (parent instanceof DataLanguageBlockWrapper
        && ((DataLanguageBlockWrapper) parent).getOriginal() instanceof SyntheticBlock) {
      parent = parent.getParent();
    }


    return parent;
  }

  /**
   * TODO implement alignment for "stacked" content.  i.e.:
   *      {#foo bar="baz"
   *           bat="bam"} <- note the alignment here
   */
  @Override
  public Alignment getAlignment() {
    return null;
  }

  @Override
  protected IElementType getTemplateTextElementType() {
    // we ignore HTML tokens since they get formatted by the templated language
    return DustTypes.HTML;
  }

  @Override
  public boolean isRequiredRange(TextRange range) {
    // seems our approach doesn't require us to insert any custom DataLanguageBlockFragmentWrapper blocks
    return false;
  }

  /**
   * TODO if/when we implement alignment, update this method to do alignment properly
   *
   * This method handles indent and alignment on Enter.
   */
  @Nonnull
  @Override
  public ChildAttributes getChildAttributes(int newChildIndex) {
    /**
     * We indent if we're in a TAG_BLOCK (note that this works nicely since Enter can only be invoked
     * INSIDE a block (i.e. after the open block).
     *
     * Also indent if we are wrapped in a block created by the templated language
     */
    if (myNode.getElementType() == DustTypes.TAG_BLOCK
        || (getParent() instanceof DataLanguageBlockWrapper
        && (myNode.getElementType() != DustTypes.STATEMENTS || myNode.getTreeNext() instanceof PsiErrorElement))) {
      return new ChildAttributes(Indent.getNormalIndent(), null);
    } else {
      return new ChildAttributes(Indent.getNoneIndent(), null);
    }
  }

}
