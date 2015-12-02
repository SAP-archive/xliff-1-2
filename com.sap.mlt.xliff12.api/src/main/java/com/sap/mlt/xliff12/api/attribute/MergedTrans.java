package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.EnumeratedAttribute;
import com.sap.mlt.xliff12.api.base.XliffAttribute;
import com.sap.mlt.xliff12.api.element.structural.TransUnit;

/**
 * merged-trans - Indicates if the group element contains merged
 * {@link TransUnit} elements.
 * 
 * @author D049314
 */
public interface MergedTrans extends XliffAttribute, EnumeratedAttribute {

	/**
	 * The attribute's name.
	 */
	final static String NAME = "merged-trans";

	/**
	 * Pre-defined merged-trans values.
	 * 
	 * @author D049314
	 */
	enum Value {
		/**
		 * Group element does not contain merged {@link TransUnit} elements.
		 */
		NO("no"),
		/**
		 * Group element contains merged {@link TransUnit} elements.
		 */
		YES("yes");

		private Value(String xmlName) {
			this.xmlName = xmlName;
		}

		private String xmlName;

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Enum#toString()
		 */
		public String toString() {
			return xmlName;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mlt.xliff12.api.base.EnumeratedAttribute#getEnumValue()
	 */
	Value getEnumValue();
}
