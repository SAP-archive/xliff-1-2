package com.sap.mlt.xliff12.api.base;

import java.util.List;

/**
 * Basic interface for attributes that can consist of multiple "xtendable"
 * values.
 * 
 * @author D049314
 */
public interface MultiXTendableAttribute extends XliffAttribute {

	/**
	 * Returns a list of the attribute's enumeration values.
	 * 
	 * @return Returns a list of the attribute's enumeration values.
	 */
	List<? extends Enum<?>> getEnumValues();

	/**
	 * Returns a list of the attribute's "xtend"-values.
	 * 
	 * @return Returns a list of the attribute's "xtend"-values.
	 */
	List<String> getXtendValues();
}
