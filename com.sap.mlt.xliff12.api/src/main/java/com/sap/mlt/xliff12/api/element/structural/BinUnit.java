package com.sap.mlt.xliff12.api.element.structural;

import java.util.Collection;
import java.util.List;

import com.sap.mlt.xliff12.api.attribute.Approved;
import com.sap.mlt.xliff12.api.attribute.Id;
import com.sap.mlt.xliff12.api.attribute.MimeType;
import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.api.attribute.PhaseName;
import com.sap.mlt.xliff12.api.attribute.Reformat;
import com.sap.mlt.xliff12.api.attribute.ResName;
import com.sap.mlt.xliff12.api.attribute.ResType;
import com.sap.mlt.xliff12.api.attribute.Translate;
import com.sap.mlt.xliff12.api.base.XliffElement;
import com.sap.mlt.xliff12.api.element.header.Note;
import com.sap.mlt.xliff12.api.element.namedgroup.ContextGroup;
import com.sap.mlt.xliff12.api.element.namedgroup.CountGroup;
import com.sap.mlt.xliff12.api.element.nonxliff.NonXliffElement;
import com.sap.mlt.xliff12.api.element.toplevel.File;

/**
 * Binary unit - The BinUnit element contains a binary object that may or may
 * not be translatable. The required {@link Id} attribute is used to uniquely
 * identify the {@link BinUnit} within all {@link TransUnit} and {@link BinUnit}
 * elements within the same {@link File}. The required {@link MimeType}
 * attribute specifies the data type of the binary object based on RFC 1341. The
 * optional {@link Approved} attribute indicates whether the translation has
 * been approved by a reviewer. The optional {@link Translate} attribute
 * indicates whether the BinUnit is to be translated. The optional
 * {@link Reformat} attribute specifies whether and which attributes can be
 * modified for the {@link BinTarget} element of the {@link BinUnit}. The
 * optional {@link com.sap.mlt.xliff12.api.attribute.Ts} attribute was
 * DEPRECATED in XLIFF 1.1. The optional {@link PhaseName} attribute references
 * the phase that the BinUnit is in. The optional {@link ResType} and
 * {@link ResName} attributes describe the resource contained within the
 * BinUnit. A list of values for The <code>ResType</code> attribute is provided.
 * 
 * @author D049314
 */
public interface BinUnit extends XliffElement, StructuralUnit {

	/**
	 * The element's name.
	 */
	static final String NAME = "bin-unit";

	/**
	 * A {@link ContextGroup}, {@link CountGroup}, {@link Note},
	 * {@link com.sap.mlt.xliff12.api.element.namedgroup.PropGroup} or
	 * {@link TransUnit} element.
	 * 
	 * @author D049314
	 */
	interface Context extends XliffElement {
	}

	/**
	 * Returns the <code>Id</code> attribute.
	 * 
	 * @return Returns the <code>Id</code> attribute.
	 */
	Id getId();

	/**
	 * Sets the <code>Id</code> attribute.
	 * 
	 * @param id
	 *            The <code>Id</code> attribute. Must not be <code>null</code>.
	 */
	void setId(Id id);

	/**
	 * Returns the <code>MimeType</code> attribute.
	 * 
	 * @return Returns the <code>MimeType</code> attribute.
	 */
	MimeType getMimeType();

	/**
	 * Sets the <code>MimeType</code> attribute.
	 * 
	 * @param mimeType
	 *            The <code>MimeType</code> attribute. Must not be
	 *            <code>null</code>.
	 */
	void setMimeType(MimeType mimeType);

	/**
	 * Returns the <code>Approved</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Approved</code> attribute. Might be
	 *         <code>null</code>.
	 */
	Approved getApproved();

	void setApproved(Approved approved);

	/**
	 * Returns the <code>Translate</code> attribute.
	 * 
	 * @return Returns the <code>Translate</code> attribute.
	 */
	Translate getTranslate();

	/**
	 * Sets the <code>Translate</code> attribute.
	 * 
	 * @param translate
	 *            The <code>Translate</code> attribute. If this parameter is
	 *            <code>null</code>, the attribute is set to the default value
	 *            <code>yes</code>.
	 */
	void setTranslate(Translate translate);

	/**
	 * Returns the <code>Reformat</code> attribute.
	 * 
	 * @return Returns the <code>Reformat</code> attribute.
	 */
	Reformat getReformat();

	/**
	 * Sets the <code>Reformat</code> attribute.
	 * 
	 * @param reformat
	 *            The <code>Reformat</code> attribute. If this parameter is
	 *            <code>null</code>, the attribute is set to the default value
	 *            <code>yes</code>.
	 */
	void setReformat(Reformat reformat);

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
	 * Returns non-XLIFF attributes.
	 * 
	 * @return Returns non-XLIFF attributes.
	 */
	Collection<NonXliffAttribute> getNonXliffAttributes();

	/**
	 * Sets the element's non-XLIFF attributes.
	 * 
	 * @param nonXliffAttributes
	 *            The non-XLIFF attributes. Must not be <code>null</code>.
	 */
	void setNonXliffAttributes(Collection<NonXliffAttribute> nonXliffAttributes);

	/**
	 * Returns the <code>BinSource</code> element.
	 * 
	 * @return Returns the <code>BinSource</code> element.
	 */
	BinSource getBinSource();

	/**
	 * Sets the <code>BinSource</code> element.
	 * 
	 * @param binSource
	 *            The <code>BinSource</code> element. Must not be
	 *            <code>null</code>.
	 */
	void setBinSource(BinSource binSource);

	/**
	 * Returns the <code>BinTarget</code> element. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>BinTarget</code> element. Might be
	 *         <code>null</code> .
	 */
	BinTarget getBinTarget();

	/**
	 * Sets the <code>BinTarget</code> element.
	 * 
	 * @param binTarget
	 *            The <code>BinTarget</code> element. May be <code>null</code>.
	 */
	void setBinTarget(BinTarget binTarget);

	/**
	 * Returns a list of <code>Context</code> elements. This is any combination
	 * of {@link ContextGroup}, {@link CountGroup},
	 * {@link com.sap.mlt.xliff12.api.element.namedgroup.PropGroup},
	 * {@link Note} and {@link TransUnit} elements.
	 * 
	 * @return Returns a list of <code>Context</code> elements. This is any
	 *         combination of {@link ContextGroup}, {@link CountGroup},
	 *         {@link com.sap.mlt.xliff12.api.element.namedgroup.PropGroup},
	 *         {@link Note} and {@link TransUnit} elements.
	 */
	List<? extends Context> getContext();

	/**
	 * The <code>Context</code> elements.
	 * 
	 * @param context
	 *            The <code>Context</code> elements. This can be any combination
	 *            of {@link ContextGroup}, {@link CountGroup},
	 *            {@link com.sap.mlt.xliff12.api.element.namedgroup.PropGroup},
	 *            {@link Note} and {@link TransUnit} elements.
	 */
	void setContext(List<? extends Context> context);

	/**
	 * Returns a list of non-XLIFF elements.
	 * 
	 * @return Returns a list of non-XLIFF elements.
	 */
	List<NonXliffElement> getNonXliffElements();

	/**
	 * Sets the list of non-XLIFF elements.
	 * 
	 * @param nonXliffElements
	 *            The list of non-XLIFF elements. Must not be <code>null</code>.
	 */
	void setNonXliffElements(List<NonXliffElement> nonXliffElements);

}
