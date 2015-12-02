package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.EnumeratedAttribute;
import com.sap.mlt.xliff12.api.base.XmlAttribute;

/**
 * White spaces - The XmlSpace attribute specifies how white spaces (ASCII
 * spaces, tabs and line-breaks) should be treated.
 * 
 * @author D049314
 */
public interface XmlSpace extends XmlAttribute, EnumeratedAttribute {

	/**
	 * The attribute's name.
	 */
	static final String NAME = "space";

	/**
	 * Pre-defined XML space values.
	 * 
	 * @author D049314
	 */
	enum Value {
		/**
		 * White-space handling is up to the XML parser.
		 */
		DEFAULT("default"),
		/**
		 * White-space must be preserved by the XML parser.
		 */
		PRESERVE("preserve");

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
