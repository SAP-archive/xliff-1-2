package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.EnumeratedAttribute;
import com.sap.mlt.xliff12.api.base.XliffAttribute;

/**
 * Approved - Indicates whether a translation is final or has passed its final
 * review.
 * 
 * @author D049314
 */
public interface Approved extends XliffAttribute, EnumeratedAttribute {

	/**
	 * The attribute's name.
	 */
	static final String NAME = "approved";

	/**
	 * Pre-defined approved values
	 * 
	 * @author D049314
	 */
	enum Value {
		/**
		 * Not approved
		 */
		NO("no"),
		/**
		 * Approved
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
