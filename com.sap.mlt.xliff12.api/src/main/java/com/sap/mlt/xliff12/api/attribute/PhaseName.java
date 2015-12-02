package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XliffAttribute;
import com.sap.mlt.xliff12.api.element.header.Phase;

/**
 * Phase Name - The phase-name attribute provides a unique name for a
 * {@link Phase} element. It is used in other elements in the file to refer to
 * the given {@link Phase} element.
 * 
 * @author D049314
 */
public interface PhaseName extends XliffAttribute {

	/**
	 * The attribute's name.
	 */
	final static String NAME = "phase-name";
}
