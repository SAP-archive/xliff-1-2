package com.sap.mlt.xliff12.api.attribute;

import java.util.List;

import com.sap.mlt.xliff12.api.base.MultiXTendableAttribute;
import com.sap.mlt.xliff12.api.element.namedgroup.ContextGroup;

/**
 * Purpose - The purpose attribute specifies the purpose of a
 * {@link ContextGroup} element. For example: "information" indicates the
 * content is informational only and not used for specific processing.
 * 
 * @author D049314
 */
public interface Purpose extends MultiXTendableAttribute {

	/**
	 * The attribute's name.
	 */
	final static String NAME = "purpose";

	/**
	 * Pre-defined purpose values.
	 * 
	 * @author D049314
	 */
	enum Value {
		/**
		 * Indicates that the context is informational in nature, specifying for
		 * example, how a term should be translated. Thus, should be displayed
		 * to anyone editing the XLIFF document.
		 */
		INFORMATION("information"),
		/**
		 * Indicates that the context-group is used to specify where the term
		 * was found in the translatable source. Thus, it is not displayed.
		 */
		LOCATION("location"),
		/**
		 * Indicates that the context information should be used during
		 * translation memory lookups. Thus, it is not displayed.
		 */
		MATCH("match");

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
	 * @see com.sap.mlt.xliff12.api.base.MultiXTendableAttribute#getEnumValues()
	 */
	List<Value> getEnumValues();

}
