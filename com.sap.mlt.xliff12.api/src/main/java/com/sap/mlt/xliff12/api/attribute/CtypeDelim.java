package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XTendableAttribute;

/**
 * Content type - The ctype attribute specifies the type of code that is
 * represented by the inline element; e.g. "bold" means that the code represents
 * a bolding code.
 * 
 * @author D049314
 */
public interface CtypeDelim extends XTendableAttribute {

	/**
	 * The attribute's name.
	 */
	static final String NAME = "ctype";

	/**
	 * Pre-defined ctype values.
	 * 
	 * @author D049314
	 */
	enum Value {
		/**
		 * Indicates a run of bolded text.
		 */
		BOLD("bold"),
		/**
		 * Indicates a run of text in italics.
		 */
		ITALIC("italic"),
		/**
		 * Indicates a run of underlined text.
		 */
		UNDERLINED("underlined"),
		/**
		 * Indicates a run of hyper-text.
		 */
		LINK("link");

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
