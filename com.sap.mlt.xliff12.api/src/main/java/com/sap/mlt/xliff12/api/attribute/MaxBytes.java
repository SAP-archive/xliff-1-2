package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XliffAttribute;
import com.sap.mlt.xliff12.api.element.structural.Target;
import com.sap.mlt.xliff12.api.element.structural.TransUnit;

/**
 * Maximum bytes - The maximum number of bytes for the {@link Target} of a
 * {@link TransUnit}. The verification of whether the relevant text respects
 * this requirement must be done using the encoding and line-break type of the
 * final target environment.
 * 
 * @author D049314
 */
public interface MaxBytes extends XliffAttribute {

	/**
	 * The attribute's name.
	 */
	final static String NAME = "maxbytes";

}
