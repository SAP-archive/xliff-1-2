package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XliffAttribute;

/**
 * Tool-specific data - The ts attribute allows you to include short data
 * understood by a specific toolset. You can also use the
 * {@link com.sap.mlt.xliff12.api.element.namedgroup.Prop} element to define
 * large properties at the element level.
 * 
 * @author D049314
 * @deprecated The ts attribute was DEPRECATED in version 1.1. Instead, use
 *             attributes defined in a namespace different from XLIFF.
 */
public interface Ts extends XliffAttribute {

	/**
	 * The attribute's name.
	 */
	static final String NAME = "ts";

}
