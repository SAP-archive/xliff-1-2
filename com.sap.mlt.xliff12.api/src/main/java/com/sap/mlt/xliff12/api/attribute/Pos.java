package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.EnumeratedAttribute;
import com.sap.mlt.xliff12.api.base.XliffAttribute;
import com.sap.mlt.xliff12.api.element.inline.It;

/**
 * Position - Indicates whether an isolated tag {@link It} is a beginning or an
 * ending tag.
 * 
 * @author D049314
 */
public interface Pos extends XliffAttribute, EnumeratedAttribute {

	/**
	 * The attribute's name.
	 */
	static final String NAME = "pos";

	/**
	 * Pre-defined pos values.
	 * 
	 * @author D049314
	 */
	enum Value {

		/**
		 * Isolated tag is a beginning tag.
		 */
		OPEN("open"),
		/**
		 * Isolated tag is an ending tag.
		 */
		CLOSE("close");

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
