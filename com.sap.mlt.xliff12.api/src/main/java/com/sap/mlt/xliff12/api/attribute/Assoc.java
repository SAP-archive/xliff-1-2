package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.EnumeratedAttribute;
import com.sap.mlt.xliff12.api.base.XliffAttribute;
import com.sap.mlt.xliff12.api.element.inline.Ph;

/**
 * Association - Indicates the association of a {@link Ph} with the text prior
 * or after the inline element.
 * 
 * @author D049314
 */
public interface Assoc extends XliffAttribute, EnumeratedAttribute {

	/**
	 * The attribute's name.
	 */
	static final String NAME = "assoc";

	/**
	 * Pre-defined assoc values.
	 * 
	 * @author D049314
	 */
	enum Value {
		/**
		 * The element is associated with the text preceding the element
		 */
		PRECEDING("preceding"),
		/**
		 * The element is associated with the text following the element
		 */
		FOLLOWING("following"),
		/**
		 * The element is associated with the text on both sides
		 */
		BOTH("both");

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
