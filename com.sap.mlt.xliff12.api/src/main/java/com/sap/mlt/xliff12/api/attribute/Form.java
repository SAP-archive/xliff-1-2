package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XliffAttribute;
import com.sap.mlt.xliff12.api.element.header.InternalFile;

/**
 * Format - Describes the type of format used in an {@link InternalFile}
 * element. For example: "text" indicates a plain text format internal file.
 * 
 * @author D049314
 */
public interface Form extends XliffAttribute {

	/**
	 * The attribute's name.
	 */
	final static String NAME = "form";

}
