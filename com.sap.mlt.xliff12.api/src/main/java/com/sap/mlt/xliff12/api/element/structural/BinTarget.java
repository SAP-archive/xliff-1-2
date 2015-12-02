package com.sap.mlt.xliff12.api.element.structural;

import java.util.Collection;

import com.sap.mlt.xliff12.api.attribute.MimeType;
import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.api.attribute.PhaseName;
import com.sap.mlt.xliff12.api.attribute.ResName;
import com.sap.mlt.xliff12.api.attribute.ResType;
import com.sap.mlt.xliff12.api.attribute.State;
import com.sap.mlt.xliff12.api.attribute.StateQualifier;
import com.sap.mlt.xliff12.api.base.XliffElement;
import com.sap.mlt.xliff12.api.element.header.ExternalFile;
import com.sap.mlt.xliff12.api.element.header.InternalFile;
import com.sap.mlt.xliff12.api.element.header.Phase;

/**
 * Binary target - The BinTarget element is the container for the translated
 * version of the binary data. The optional {@link MimeType} attribute specifies
 * the data type of the binary object based on RFC 1341. The optional
 * {@link com.sap.mlt.xliff12.api.attribute.Ts} attribute was DEPRECATED in
 * XLIFF 1.1. The optional {@link State} and {@link StateQualifier} attributes
 * indicate in which state the BinTarget is. The optional {@link PhaseName}
 * attribute references the {@link Phase} that the BinTarget is in. The optional
 * {@link ResType} and {@link ResName} attributes describe the resource
 * contained within the BinTarget. A list of values for the {@link ResType},
 * {@link State}, and {@link StateQualifier} attributes are provided.
 * 
 * @author D049314
 */
public interface BinTarget extends XliffElement {

	/**
	 * The element's name.
	 */
	static final String NAME = "bin-target";

	/**
	 * An {@link InternalFile} or {@link ExternalFile} element.
	 * 
	 * @author D049314
	 */
	interface Child extends XliffElement {
	}

	/**
	 * Returns the <code>MimeType</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>MimeType</code> attribute. Might be
	 *         <code>null</code>.
	 */
	MimeType getMimeType();

	/**
	 * Sets the <code>MimeType</code> attribute.
	 * 
	 * @param mimeType
	 *            The <code>MimeType</code> attribute. May be <code>null</code>.
	 */
	void setMimeType(MimeType mimeType);

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
	 *            The <code>ResType</code> attribute. May be <code>null</code>:
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
	 * Returns the content of this element. Either an {@link InternalFile} or
	 * {@link ExternalFile} element.
	 * 
	 * @return Returns the content of this element. Either an
	 *         {@link InternalFile} or {@link ExternalFile} element.
	 */
	Child getChild();

	/**
	 * Sets the content of this element.
	 * 
	 * @param child
	 *            The content. Either an {@link InternalFile} or
	 *            {@link ExternalFile} element.
	 */
	void setChild(Child child);


}
