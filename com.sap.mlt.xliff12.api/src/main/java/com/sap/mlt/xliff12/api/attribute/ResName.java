package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XliffAttribute;

/**
 * Resource name - Resource name or identifier of a item. For example: the key
 * in the key/value pair in a Java properties file, the ID of a string in a
 * Windows string table, the index value of an entry in a database table, etc.
 * 
 * @author D049314
 */
public interface ResName extends XliffAttribute {

	/**
	 * The attribute's name.
	 */
	static final String NAME = "resname";

}
