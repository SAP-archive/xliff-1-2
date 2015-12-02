package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XliffAttribute;

/**
 * Reference identifier - The rid attribute is used to link paired inline
 * elements. The rid attribute of a begin-paired-code element should have the
 * same value as the close-paired-code element.
 * 
 * @author D049314
 */
public interface Rid extends XliffAttribute {

	/**
	 * The attribute's name.
	 */
	static final String NAME = "rid";

}
