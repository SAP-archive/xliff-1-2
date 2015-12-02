package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XliffAttribute;
import com.sap.mlt.xliff12.api.element.header.Note;

/**
 * From - Indicates the author of a {@link Note} element. For example:
 * "reviewer" indicates a note from a reviewer.
 * 
 * @author D049314
 */
public interface From extends XliffAttribute {

	/**
	 * The attribute's name.
	 */
	static final String NAME = "from";

}
