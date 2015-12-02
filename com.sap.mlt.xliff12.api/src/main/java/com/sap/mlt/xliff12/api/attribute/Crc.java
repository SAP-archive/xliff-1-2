package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XliffAttribute;

/**
 * Cyclic redundancy checking - A private value used to verify data as it is
 * returned to the producer. The generation and verification of this number is
 * tool-specific.
 * 
 * @author D049314
 */
public interface Crc extends XliffAttribute {

	/**
	 * The attribute's name.
	 */
	static final String NAME = "crc";

}
