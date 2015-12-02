package com.sap.mlt.xliff12.api.element.structural;

import java.util.Collection;

import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.api.base.XliffElement;
import com.sap.mlt.xliff12.api.element.header.ExternalFile;
import com.sap.mlt.xliff12.api.element.header.InternalFile;

/**
 * Binary source - The BinSource element is the container for the binary source
 * data. The optional {@link com.sap.mlt.xliff12.api.attribute.Ts} attribute was
 * DEPRECATED in XLIFF 1.1.
 * 
 * @author D049314
 */
public interface BinSource extends XliffElement {

	/**
	 * The element's name.
	 */
	static final String NAME = "bin-source";

	/**
	 * An {@link InternalFile} or {@link ExternalFile} element.
	 * 
	 * @author D049314
	 */
	interface Child extends XliffElement {
	}

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
