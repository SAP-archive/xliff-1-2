package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XTendableAttribute;

/**
 * Content type - The ctype attribute specifies the type of code that is
 * represented by the inline element; e.g. "bold" means that the code represents
 * a bolding code.
 * 
 * @author D049314
 */
public interface CtypePh extends XTendableAttribute {

	/**
	 * The attribute's name.
	 */
	final static String NAME = "ctype";

	/**
	 * Pre-defined ctype values.
	 * 
	 * @author D049314
	 */
	enum Value {
		/**
		 * Indicates a inline image.
		 */
		IMAGE("image"),
		/**
		 * Indicates a page break.
		 */
		PB("pb"),
		/**
		 * Indicates a line break.
		 */
		LB("lb");

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
