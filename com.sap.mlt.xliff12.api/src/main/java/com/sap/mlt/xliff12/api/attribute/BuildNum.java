package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XliffAttribute;

/**
 * Build number - The build number of the version of the product or application
 * the localizable material is for. For example: "12" for the 12th build of the
 * new version of a product.
 * 
 * @author D049314
 */
public interface BuildNum extends XliffAttribute {

	/**
	 * The attribute's name.
	 */
	final static String NAME = "build-num";

}
