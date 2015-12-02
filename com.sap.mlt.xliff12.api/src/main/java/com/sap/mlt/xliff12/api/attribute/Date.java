package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XliffAttribute;

/**
 * Date - The date attribute indicates when a given element was created or
 * modified.
 * 
 * @author D049314
 */
public interface Date extends XliffAttribute {

	/**
	 * The attribute's name.
	 */
	static final String NAME = "date";

	/**
	 * Returns this date as {@link java.util.Date}.
	 * 
	 * @return Returns this date as {@link java.util.Date}.
	 */
	java.util.Date getDate();

}
