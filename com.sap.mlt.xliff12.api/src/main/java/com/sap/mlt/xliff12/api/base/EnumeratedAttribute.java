package com.sap.mlt.xliff12.api.base;

/**
 * Interface that is extended by attributes that are based on a value list
 * (enumeration).
 * 
 * @author D049314
 */
public interface EnumeratedAttribute extends Attribute {

	/**
	 * Returns the enumeration value of the attribute. This might be
	 * <code>null</code> in case of {@link XTendableAttribute}s!
	 * 
	 * @return Returns the enumeration value of the attribute. This might be
	 *         <code>null</code> in case of {@link XTendableAttribute}s!
	 */
	Enum<?> getEnumValue();

}
