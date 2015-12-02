package com.sap.mlt.xliff12.api.element.header;

import com.sap.mlt.xliff12.api.base.XliffElement;
import com.sap.mlt.xliff12.api.element.structural.Source;
import com.sap.mlt.xliff12.api.element.structural.Target;

/**
 * Skeleton file - The Skl element contains the skeleton file or the location of
 * the skeleton file. The skeleton file is a template that can be used in
 * recreating the original file, from the {@link Source} content, or the
 * translated file, from the {@link Target} content.
 * 
 * @author D049314
 */
public interface Skl extends XliffElement {

	/**
	 * The element's name.
	 */
	static final String NAME = "skl";

	/**
	 * Either an {@link InternalFile} or an {@link ExternalFile} element.
	 * 
	 * @author D049314
	 */
	interface Child extends XliffElement {
	}

	/**
	 * Returns this skeleton's child (either an {@link InternalFile} or an
	 * {@link ExternalFile} element).
	 * 
	 * @return Returns this reference's child (either an {@link InternalFile} or
	 *         an {@link ExternalFile} element).
	 */
	Child getChild();

	/**
	 * Sets this skeleton's child.
	 * 
	 * @param child
	 *            The skeleton's child ((either an {@link InternalFile} or an
	 *            {@link ExternalFile} element)
	 */
	void setChild(Child child);

}
