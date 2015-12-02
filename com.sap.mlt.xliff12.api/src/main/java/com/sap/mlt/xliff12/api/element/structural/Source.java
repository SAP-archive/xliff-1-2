package com.sap.mlt.xliff12.api.element.structural;

import java.util.Collection;
import java.util.List;

import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.api.attribute.SourceLanguage;
import com.sap.mlt.xliff12.api.attribute.XmlLang;
import com.sap.mlt.xliff12.api.base.TextFragment;
import com.sap.mlt.xliff12.api.base.XliffElement;
import com.sap.mlt.xliff12.api.element.delimiter.Mrk;
import com.sap.mlt.xliff12.api.element.inline.Bpt;
import com.sap.mlt.xliff12.api.element.inline.Bx;
import com.sap.mlt.xliff12.api.element.inline.Ept;
import com.sap.mlt.xliff12.api.element.inline.Ex;
import com.sap.mlt.xliff12.api.element.inline.G;
import com.sap.mlt.xliff12.api.element.inline.It;
import com.sap.mlt.xliff12.api.element.inline.Ph;
import com.sap.mlt.xliff12.api.element.inline.X;
import com.sap.mlt.xliff12.api.text.Text;

/**
 * Source text - The Source element is used to delimit a unit of text that could
 * be a paragraph, a title, a menu item, a caption, etc. The content of the
 * Source is generally the translatable text, depending upon the translate
 * attribute of the parent {@link TransUnit}. The optional {@link XmlLang}
 * attribute is used to specify the content language of the Source; this should
 * always match {@link SourceLanguage} as a child of {@link TransUnit} but can
 * vary as a child of {@link AltTrans}. The optional
 * {@link com.sap.mlt.xliff12.api.attribute.Ts} attribute was DEPRECATED in
 * XLIFF 1.1.
 * 
 * @author D049314
 */
public interface Source extends XliffElement {

	/**
	 * The element's name.
	 */
	static final String NAME = "source";

	/**
	 * Returns the <code>XmlLang</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>XmlLang</code> attribute. Might be
	 *         <code>null</code> .
	 */
	XmlLang getXmlLang();

	/**
	 * Sets the <code>XmlLang</code> attribute.
	 * 
	 * @param xmlLang
	 *            The <code>XmlLang</code> attribute. May be <code>null</code>.
	 */
	void setXmlLang(XmlLang xmlLang);

	/**
	 * Returns the <code>Ts</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Ts</code> attribute. Might be <code>null</code>
	 *         .
	 * 
	 * @deprecated The <code>Ts</code> attribute was DEPRECATED in version 1.1.
	 *             Instead, use attributes defined in a namespace different from
	 *             XLIFF.
	 */
	com.sap.mlt.xliff12.api.attribute.Ts getTs();

	/**
	 * Sets the <code>Ts</code> attribute
	 * 
	 * @param ts
	 *            The <code>Ts</code> attribute. May be <code>null</code>.
	 * 
	 * @deprecated The <code>Ts</code> attribute was DEPRECATED in version 1.1.
	 *             Instead, use attributes defined in a namespace different from
	 *             XLIFF.
	 */
	void setTs(com.sap.mlt.xliff12.api.attribute.Ts ts);

	/**
	 * Returns this element's non-XLIFF attributes.
	 * 
	 * @return Returns this element's non-XLIFF attributes.
	 */
	Collection<NonXliffAttribute> getNonXliffAttributes();

	/**
	 * Sets this element's non-XLIFF attributes.
	 * 
	 * @param nonXliffAttributes
	 *            The non-XLIFF attributes. Must not be <code>null</code>.
	 */
	void setNonXliffAttributes(Collection<NonXliffAttribute> nonXliffAttributes);

	/**
	 * Returns the content of this element. This is a list of any combination of
	 * {@link Text}s, {@link Bpt}s, {@link Ept}s, {@link Bx}s, {@link Ex}s
	 * {@link G}s, {@link It}, {@link Mrk}, {@link Ph}s and {@link X}s.
	 * 
	 * @return Returns the content of this element. This is a list of any
	 *         combination of {@link Text}s, {@link Bpt}s, {@link Ept}s,
	 *         {@link Bx}s, {@link Ex}s {@link G}s, {@link It}, {@link Mrk},
	 *         {@link Ph}s and {@link X}s.
	 */
	List<? extends TextFragment> getContent();

	/**
	 * Sets the content of this element.
	 * 
	 * @param content
	 *            The content. Must not be <code>null</code>. This can be any
	 *            combination of {@link Text}s, {@link Bpt}s, {@link Ept}s,
	 *            {@link Bx}s, {@link Ex}s {@link G}s, {@link It}, {@link Mrk},
	 *            {@link Ph}s and {@link X}s.
	 */
	void setContent(List<? extends TextFragment> content);

	/**
	 * Returns the plain text representation of this element's content.
	 * Convenience method that appends the return values of all
	 * {@link TextFragment}{@link #getPlainText()} calls on the contained text
	 * fragments.
	 * 
	 * @return Returns the plain text representation of this element's content.
	 *         Convenience method that appends the return values of all
	 *         {@link TextFragment}{@link #getPlainText()} calls on the
	 *         contained text fragments.
	 */
	String getPlainText();

}
