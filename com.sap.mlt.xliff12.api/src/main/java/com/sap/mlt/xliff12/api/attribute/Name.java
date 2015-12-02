package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XliffAttribute;

/**
 * Name - The name attribute specifies the user-defined name of a named group
 * element. This is used for identification purposes only and is not referenced
 * with the file, unless by a processing instruction.
 * 
 * @author D049314
 */
public interface Name extends XliffAttribute {

	/**
	 * The attribute's name.
	 */
	final static String NAME = "name";

}
