package com.sap.mlt.xliff12.api.base;

/**
 * Basic interface extended by all "xtendable" attributes.
 * 
 * "Xtendable" attributes can specify a value from a pre-defined list or specify
 * a user-defined value by preceding "x-" before the user defined value. If you
 * create attributes with user-defined values using this API don't prepend the
 * "x-", but specify the user-defined value only. The API will take care of
 * prepending the "x-".
 * 
 * @author D049314
 */
public interface XTendableAttribute extends XliffAttribute, EnumeratedAttribute {

	/**
	 * Return <code>true</code> if this attribute has a user-defined value
	 * <code>false</code> otherwise.
	 * 
	 * If the attribute has a user-defined value, {@link #getEnumValue()} will
	 * return <code>null</code>. Otherwise {@link #getXtendValue()} will return
	 * <code>null</code>.
	 * 
	 * @return Return <code>true</code> if this attribute has a user-defined
	 *         value <code>false</code> otherwise. If the attribute has a
	 *         user-defined value, {@link #getEnumValue()} will return
	 *         <code>null</code>. Otherwise {@link #getXtendValue()} will return
	 *         <code>null</code>.
	 */
	boolean isXTended();

	/**
	 * Returns the user-defined attribute value (without the preceding "x-") if
	 * and only if {@link #isXTended()} returns <code>true</code>.
	 * 
	 * @return Returns the user-defined attribute value (without the preceding
	 *         "x-") if and only if {@link #isXTended()} returns
	 *         <code>true</code>.
	 */
	String getXtendValue();
}
