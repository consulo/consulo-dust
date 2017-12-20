package com.linkedin.intellij.dust;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

import java.io.Reader;

import org.jetbrains.annotations.NotNull;
import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.CodeInsightColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.linkedin.intellij.dust.psi.DustTypes;

/**
 * Created with IntelliJ IDEA.
 * User: yzhang
 * Date: 1/16/13
 * Time: 3:13 PM
 */
public class DustSyntaxHighlighter extends SyntaxHighlighterBase
{
	public static final TextAttributesKey COMMENT = createTextAttributesKey(DustLanguage.INSTANCE, DefaultLanguageHighlighterColors.LINE_COMMENT);
	public static final TextAttributesKey TODO = createTextAttributesKey(DustLanguage.INSTANCE, CodeInsightColors.TODO_DEFAULT_ATTRIBUTES);
	public static final TextAttributesKey TAG = createTextAttributesKey(DustLanguage.INSTANCE, DefaultLanguageHighlighterColors.KEYWORD);
	public static final TextAttributesKey IDENTIFIER = createTextAttributesKey(DustLanguage.INSTANCE, DefaultLanguageHighlighterColors.KEYWORD);
	public static final TextAttributesKey NUMBER = createTextAttributesKey(DustLanguage.INSTANCE, DefaultLanguageHighlighterColors.NUMBER);
	public static final TextAttributesKey STRING = createTextAttributesKey(DustLanguage.INSTANCE, DefaultLanguageHighlighterColors.STRING);

	static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey(DustLanguage.INSTANCE, HighlighterColors.BAD_CHARACTER);

	private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
	private static final TextAttributesKey[] TAG_KEYS = new TextAttributesKey[]{TAG};
	private static final TextAttributesKey[] IDENTIFIER_KEYS = new TextAttributesKey[]{IDENTIFIER};
	private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
	private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};
	private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];
	private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};

	@NotNull
	@Override
	public Lexer getHighlightingLexer()
	{
		return new FlexAdapter(new DustLexer((Reader) null));
	}

	@NotNull
	@Override
	public TextAttributesKey[] getTokenHighlights(IElementType tokenType)
	{
		if(isPartOfComment(tokenType))
		{
			return COMMENT_KEYS;
		}
		else if(tokenType.equals(DustTypes.NUMBER))
		{
			return NUMBER_KEYS;
		}
		else if(tokenType.equals(DustTypes.IDENTIFIER))
		{
			return IDENTIFIER_KEYS;
		}
		else if(isPartOfTag(tokenType))
		{
			return TAG_KEYS;
		}
		else if(tokenType.equals(DustTypes.STRING) || tokenType.equals(DustTypes.STRING_START) || tokenType.equals(DustTypes.STRING_END))
		{
			return STRING_KEYS;
		}
		else if(tokenType.equals(TokenType.BAD_CHARACTER))
		{
			return BAD_CHAR_KEYS;
		}
		else
		{
			return EMPTY_KEYS;
		}
	}

	private static boolean isPartOfTag(IElementType tokenType)
	{
		return tokenType.equals(DustTypes.LD) || tokenType.equals(DustTypes.RD) || tokenType.equals(DustTypes.LB) || tokenType.equals(DustTypes.RB)
				|| tokenType.equals(DustTypes.SLASH_RD) || tokenType.equals(DustTypes.SECTION) || tokenType.equals(DustTypes.EXISTANCE) || tokenType
				.equals(DustTypes.NOT_EXISTANCE) || tokenType.equals(DustTypes.HELPER) || tokenType.equals(DustTypes.PARTIAL) || tokenType.equals
				(DustTypes.INLINE_PARTIAL) || tokenType.equals(DustTypes.BLOCK) || tokenType.equals(DustTypes.CLOSE) || tokenType.equals(DustTypes
				.ELSE) || tokenType.equals(DustTypes.PERIOD) || tokenType.equals(DustTypes.PIPE) || tokenType.equals(DustTypes.EQUAL);
	}

	private static boolean isPartOfComment(IElementType tokenType)
	{
		return tokenType.equals(DustTypes.COMMENT);
	}
}
