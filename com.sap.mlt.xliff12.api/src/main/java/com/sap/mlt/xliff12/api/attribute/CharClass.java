package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XliffAttribute;

/**
 * Character class - This indicates that a translation is restricted to a subset
 * of characters (i.e. ASCII only, Katakana only, uppercase only, etc.). A blank
 * value indicates there is no limitation.
 * 
 * @author D049314
 */
public interface CharClass extends XliffAttribute {

	/**
	 * The attribute's name.
	 */
	public static final String NAME = "charclass";

}
