package com.sap.mlt.xliff12.api.element.structural;

import java.util.Collection;
import java.util.List;

import com.sap.mlt.xliff12.api.attribute.Coord;
import com.sap.mlt.xliff12.api.attribute.CssStyle;
import com.sap.mlt.xliff12.api.attribute.EquivTrans;
import com.sap.mlt.xliff12.api.attribute.ExStyle;
import com.sap.mlt.xliff12.api.attribute.Font;
import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.api.attribute.PhaseName;
import com.sap.mlt.xliff12.api.attribute.ResName;
import com.sap.mlt.xliff12.api.attribute.ResType;
import com.sap.mlt.xliff12.api.attribute.State;
import com.sap.mlt.xliff12.api.attribute.StateQualifier;
import com.sap.mlt.xliff12.api.attribute.Style;
import com.sap.mlt.xliff12.api.attribute.TargetLanguage;
import com.sap.mlt.xliff12.api.attribute.XmlLang;
import com.sap.mlt.xliff12.api.base.TextFragment;
import com.sap.mlt.xliff12.api.base.XliffElement;
import com.sap.mlt.xliff12.api.element.delimiter.Mrk;
import com.sap.mlt.xliff12.api.element.header.Phase;
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
 * Target - The Target element contains the translation of the content of the
 * sibling {@link Source} element. The optional {@link State} and
 * {@link StateQualifier} attributes indicate in which state the {@link Target}
 * is. The optional {@link PhaseName} attribute references the {@link Phase} in
 * which the {@link Target} was last modified. The optional {@link XmlLang}
 * attribute is used to specify the content language of the {@link Target}; this
 * should always match {@link TargetLanguage} as a child of {@link TransUnit}
 * but can vary as a child of {@link AltTrans}. The optional {@link Coord},
 * {@link Font} , {@link CssStyle}, {@link Style}, and {@link ExStyle}
 * attributes describe the resource contained within the {@link Target}; these
 * are the modifiable attributes for the {@link TransUnit} depending upon the
 * reformat attribute of the parent {@link TransUnit}. The optional
 * {@link EquivTrans} describes if the target language translation is a direct
 * equivalent of the source text. The optional
 * {@link com.sap.mlt.xliff12.api.attribute.Ts} attribute was DEPRECATED in
 * XLIFF 1.1. The {@link ResType} attribute is DEPRECATED in XLIFF 1.2, since
 * Target will always be of the same {@link ResType} as its parent
 * {@link TransUnit} or {@link AltTrans}. A list of preferred values for the
 * {@link ResType}, {@link State}, and {@link StateQualifier} attributes are
 * provided by this specification.
 * 
 * @author D049314
 */
public interface Target extends XliffElement {

	/**
	 * The element's name.
	 */
	static final String NAME = "target";

	/**
	 * Returns the <code>State</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>State</code> attribute. Might be
	 *         <code>null</code>.
	 */
	State getState();

	/**
	 * Sets the <code>State</code> attribute.
	 * 
	 * @param state
	 *            The <code>State</code> attribute. May be <code>null</code>.
	 */
	void setState(State state);

	/**
	 * Returns the <code>StateQualifier</code> attribute. Might be
	 * <code>null</code>.
	 * 
	 * @return Returns the <code>StateQualifier</code> attribute. Might be
	 *         <code>null</code>.
	 */
	StateQualifier getStateQualifier();

	/**
	 * Sets the <code>StateQualifier</code> attribute.
	 * 
	 * @param stateQualifier
	 *            The <code>StateQualifier</code> attribute. May be
	 *            <code>null</code> .
	 */
	void setStateQualifier(StateQualifier stateQualifier);

	/**
	 * Returns the <code>PhaseName</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>PhaseName</code> attribute. Might be
	 *         <code>null</code>.
	 */
	PhaseName getPhaseName();

	/**
	 * Sets the <code>PhaseName</code> attribute.
	 * 
	 * @param phaseName
	 *            The <code>PhaseName</code> attribute. May be <code>null</code>
	 *            .
	 */
	void setPhaseName(PhaseName phaseName);

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
	 * Returns the <code>ResType</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>ResType</code> attribute. Might be
	 *         <code>null</code> .
	 */
	ResType getResType();

	/**
	 * Sets the <code>ResType</code> attribute.
	 * 
	 * @param resType
	 *            The <code>ResType</code> attribute. May be <code>null</code>.
	 */
	void setResType(ResType resType);

	/**
	 * Returns the <code>ResName</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>ResName</code> attribute. Might be
	 *         <code>null</code> .
	 */
	ResName getResName();

	/**
	 * Sets the <code>ResName</code> attribute.
	 * 
	 * @param resName
	 *            The <code>ResName</code> attribute. May be <code>null</code>.
	 */
	void setResName(ResName resName);

	/**
	 * Returns the <code>Coord</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Coord</code> attribute. Might be
	 *         <code>null</code>.
	 */
	Coord getCoord();

	/**
	 * Sets the <code>Coord</code> attribute.
	 * 
	 * @param coord
	 *            The <code>Coord</code> attribute. May be <code>null</code>.
	 */
	void setCoord(Coord coord);

	/**
	 * Returns the <code>Font</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Font</code> attribute. Might be
	 *         <code>null</code>.
	 */
	Font getFont();

	/**
	 * Sets the <code>Font</code> attribute.
	 * 
	 * @param font
	 *            The <code>Font</code> attribute. May be <code>null</code>.
	 */
	void setFont(Font font);

	/**
	 * Returns the <code>CssStyle</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>CssStyle</code> attribute. Might be
	 *         <code>null</code>.
	 */
	CssStyle getCssStyle();

	/**
	 * Sets the <code>CssStyle</code> attribute.
	 * 
	 * @param cssStyle
	 *            The <code>CssStyle</code> attribute. May be <code>null</code>.
	 */
	void setCssStyle(CssStyle cssStyle);

	/**
	 * Returns the <code>Style</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Style</code> attribute. Might be
	 *         <code>null</code>.
	 */
	Style getStyle();

	/**
	 * Sets the <code>Style</code> attribute.
	 * 
	 * @param style
	 *            The <code>Style</code> attribute. May be <code>null</code>.
	 */
	void setStyle(Style style);

	/**
	 * Returns the <code>ExStyle</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>ExStyle</code> attribute. Might be
	 *         <code>null</code> .
	 */
	ExStyle getExStyle();

	/**
	 * Sets the <code>ExStyle</code> attribute.
	 * 
	 * @param exStyle
	 *            The <code>ExStyle</code> attribute. May be <code>null</code>.
	 */
	void setExStyle(ExStyle exStyle);

	/**
	 * Returns the <code>EquivTrans</code> attribute.
	 * 
	 * @return Returns the <code>EquivTrans</code> attribute.
	 */
	EquivTrans getEquivTrans();

	/**
	 * Sets the <code>EquivTrans</code> attribute.
	 * 
	 * @param equivTrans
	 *            The <code>EquivTrans</code> attribute. If the passed value is
	 *            <code>null</code> the attribute is set to the default
	 *            <code>yes</code>.
	 */
	void setEquivTrans(EquivTrans equivTrans);

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
