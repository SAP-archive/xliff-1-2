package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XliffAttribute;

/**
 * Translation Match Origin - The origin attribute specifies where a translation
 * match came from; for example, from a previous version of the same product, a
 * different product, a shared translation memory, etc.
 * 
 * @author D049314
 */
public interface Origin extends XliffAttribute {

	/**
	 * The attribute's name.
	 */
	static final String NAME = "origin";

}
