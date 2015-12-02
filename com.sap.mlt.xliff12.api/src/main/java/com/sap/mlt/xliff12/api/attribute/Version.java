package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.EnumeratedAttribute;
import com.sap.mlt.xliff12.api.base.XliffAttribute;

/**
 * XLIFF version - The version attribute is used to specify the format version
 * of the XLIFF document. This corresponds to the version number of the XLIFF
 * specification that is being adhered to.
 * 
 * @author D049314
 */
public interface Version extends XliffAttribute, EnumeratedAttribute {

	/**
	 * The attribute's name.
	 */
	static final String NAME = "version";

	/**
	 * Pre-defined version values.
	 * 
	 * @author D049314
	 */
	enum Value {
		/**
		 * XLIFF version 1.0
		 */
		V1_0("1.0"),
		/**
		 * XLIFF version 1.1
		 */
		V1_1("1.1"),
		/**
		 * XLIFF version 1.2
		 */
		V1_2("1.2");

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
