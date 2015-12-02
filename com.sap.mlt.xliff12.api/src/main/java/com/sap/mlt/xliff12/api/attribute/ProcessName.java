package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XliffAttribute;
import com.sap.mlt.xliff12.api.element.header.Phase;

/**
 * Process name - The name specifying the type of process a given {@link Phase}
 * corresponds to (e.g. Translation, Proofreading, Sizing, etc.).
 * 
 * @author D049314
 */
public interface ProcessName extends XliffAttribute {

	/**
	 * The attribute's name.
	 */
	final static String NAME = "process-name";

}
