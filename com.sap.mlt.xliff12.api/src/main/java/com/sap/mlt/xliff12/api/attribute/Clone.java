package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.EnumeratedAttribute;
import com.sap.mlt.xliff12.api.base.XliffAttribute;
import com.sap.mlt.xliff12.api.element.structural.Target;

/**
 * Clone - This indicates that a copy of the given inline element can be made
 * and placed multiple times in the {@link Target}. This is useful for codes
 * such as bold which may require duplication after localization of a segment.
 * 
 * @author D049314
 */
public interface Clone extends XliffAttribute, EnumeratedAttribute {

	/**
	 * The attribute's name.
	 */
	final static String NAME = "clone";

	/**
	 * Pre-defined clone values
	 * 
	 * @author D049314
	 */
	enum Value {
		/**
		 * An inline tag can be cloned in a {@link Target} element
		 */
		YES("yes"),
		/**
		 * An inline tag must not be cloned in a {@link Target} element
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
