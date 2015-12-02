package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XliffAttribute;
import com.sap.mlt.xliff12.api.element.toplevel.File;

/**
 * Original file - The original attribute specifies the name of the original
 * file from which the contents of a {@link File} element has been extracted.
 * 
 * @author D049314
 */
public interface Original extends XliffAttribute {

	/**
	 * The attribute's name.
	 */
	final static String NAME = "original";

}
