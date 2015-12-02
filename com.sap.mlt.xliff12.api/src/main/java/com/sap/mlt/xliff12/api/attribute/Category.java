package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XliffAttribute;

/**
 * Category - This provides information on the subject of what is being
 * translated. For example: "medical" for files from a medical related product.
 * 
 * @author D049314
 */
public interface Category extends XliffAttribute {

	/**
	 * The attribute's name.
	 */
	final static String NAME = "category";

}
