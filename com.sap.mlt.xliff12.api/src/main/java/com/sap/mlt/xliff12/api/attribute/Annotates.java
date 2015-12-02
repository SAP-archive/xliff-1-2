package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.EnumeratedAttribute;
import com.sap.mlt.xliff12.api.base.XliffAttribute;
import com.sap.mlt.xliff12.api.element.header.Note;
import com.sap.mlt.xliff12.api.element.structural.Source;
import com.sap.mlt.xliff12.api.element.structural.Target;

/**
 * Annotates - Indicates if a {@link Note} element pertains to the
 * {@link Source} or the {@link Target}, or neither in particular.
 * 
 * @author D049314
 */
public interface Annotates extends XliffAttribute, EnumeratedAttribute {

	/**
	 * The attribute's name.
	 */
	static final String NAME = "annotates";

	/**
	 * Predefined annotates values
	 * 
	 * @author D049314
	 */
	enum Value {
		/**
		 * Pertains neither to source not to target
		 */
		GENERAL("general"),
		/**
		 * Pertains to source
		 */
		SOURCE("source"),
		/**
		 * Pertains to target
		 */
		TARGET("target");

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
