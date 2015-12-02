package com.sap.mlt.xliff12.api.element.header;

import com.sap.mlt.xliff12.api.base.XliffElement;

/**
 * Glossary - The Glossary element points to or contains a glossary, which can
 * be used in the localization of the file.
 * 
 * @author D049314
 */
public interface Glossary extends XliffElement, Header.Context {

	/**
	 * This element's name.
	 */
	static final String NAME = "glossary";

	/**
	 * Either an {@link InternalFile} or an {@link ExternalFile} element.
	 * 
	 * @author D049314
	 */
	interface Child extends XliffElement {
	}

	/**
	 * Returns the child element (either an {@link InternalFile} or
	 * {@link ExternalFile} element).
	 * 
	 * @return Returns the child element (either an {@link InternalFile} or
	 *         {@link ExternalFile} element).
	 */
	Child getChild();

	/**
	 * Sets the child element.
	 * 
	 * @param child
	 *            Either an {@link InternalFile} or {@link ExternalFile}. Must
	 *            not be <code>null</code>.
	 */
	void setChild(Child child);

}
