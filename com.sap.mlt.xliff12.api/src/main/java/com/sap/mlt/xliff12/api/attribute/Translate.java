package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.EnumeratedAttribute;
import com.sap.mlt.xliff12.api.base.XliffAttribute;

/**
 * Translate - The translate attribute indicates whether or not the text
 * referred to should be translated.
 * 
 * @author D049314
 */
public interface Translate extends XliffAttribute, EnumeratedAttribute {

	/**
	 * The attribute's name.
	 */
	final static String NAME = "translate";

	/**
	 * Pre-defined translate values
	 * 
	 * @author D049314
	 */
	enum Value {
		/**
		 * The text should be translated
		 */
		YES("yes"),
		/**
		 * The text should not be translated
		 */
		NO("no");

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
