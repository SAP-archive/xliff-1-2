package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.EnumeratedAttribute;
import com.sap.mlt.xliff12.api.base.XliffAttribute;

/**
 * equiv-trans - Indicates if the target language translation is a direct
 * equivalent of the source text.
 * 
 * @author D049314
 */
public interface EquivTrans extends XliffAttribute, EnumeratedAttribute {

	/**
	 * The attribute's name.
	 */
	final static String NAME = "equiv-trans";

	/**
	 * Pre-defined equiv-trans values.
	 * 
	 * @author D049314
	 */
	enum Value {
		/**
		 * Target language translation is a direct equivalent of the source
		 * text.
		 */
		YES("yes"),
		/**
		 * Target language translation is not a direct equivalent of the source
		 * text.
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
