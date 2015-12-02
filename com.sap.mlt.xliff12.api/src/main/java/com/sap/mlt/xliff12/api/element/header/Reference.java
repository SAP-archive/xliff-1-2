package com.sap.mlt.xliff12.api.element.header;

import com.sap.mlt.xliff12.api.base.XliffElement;

/**
 * Reference - The Reference element points to or contains reference material,
 * which can aid in the localization of the file.
 * 
 * @author D049314
 */
public interface Reference extends XliffElement, Header.Context {

	/**
	 * The element's name.
	 */
	static final String NAME = "reference";

	/**
	 * Either an {@link InternalFile} or an {@link ExternalFile} element.
	 * 
	 * @author D049314
	 */
	interface Child extends XliffElement {
	}

	/**
	 * Returns this reference's child (either an {@link InternalFile} or an
	 * {@link ExternalFile} element).
	 * 
	 * @return Returns this reference's child (either an {@link InternalFile} or
	 *         an {@link ExternalFile} element).
	 */
	Child getChild();

	/**
	 * Sets this reference's child.
	 * 
	 * @param child
	 *            The reference's child ((either an {@link InternalFile} or an
	 *            {@link ExternalFile} element)
	 */
	void setChild(Child child);

}
