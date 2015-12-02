package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XliffAttribute;
import com.sap.mlt.xliff12.api.element.header.Note;

/**
 * Priority - The priority of a {@link Note} element.
 * 
 * @author D049314
 */
public interface Priority extends XliffAttribute {

	/**
	 * The attribute's name.
	 */
	final static String NAME = "priority";

	/**
	 * Returns the priority as integer.
	 * 
	 * @return Returns the priority as integer.
	 */
	int getPriority();

}
