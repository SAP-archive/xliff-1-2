package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XliffAttribute;

/**
 * Identifier - The id attribute is used in many elements as a reference to the
 * original corresponding code data or format for the given element. The value
 * of the id element is determined by the tool creating the XLIFF document. It
 * may or may not be a resource identifier. The identifier of a resource should,
 * at least, be stored in the {@link ResName} attribute.
 * 
 * @author D049314
 */
public interface Id extends XliffAttribute {

	/**
	 * The attribute's name.
	 */
	final static String NAME = "id";

}
