package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.EnumeratedAttribute;
import com.sap.mlt.xliff12.api.base.XliffAttribute;
import com.sap.mlt.xliff12.api.element.namedgroup.Context;
import com.sap.mlt.xliff12.api.element.structural.AltTrans;
import com.sap.mlt.xliff12.api.element.structural.TransUnit;

/**
 * Match mandatory - Indicates that any {@link AltTrans} element of the parent
 * {@link TransUnit} must have the same {@link Context} as the {@link TransUnit}
 * .
 * 
 * @author D049314
 */
public interface MatchMandatory extends XliffAttribute, EnumeratedAttribute {

	/**
	 * The attribute's name.
	 */
	final static String NAME = "match-mandatory";

	/**
	 * Pre-defined match-mandatory values.
	 * 
	 * @author D049314
	 */
	enum Value {
		/**
		 * {@link AltTrans} element of the parent {@link TransUnit} need not
		 * have the same {@link Context} as the {@link TransUnit}
		 */
		NO("no"),
		/**
		 * {@link AltTrans} element of the parent {@link TransUnit} must have
		 * the same {@link Context} as the {@link TransUnit}
		 */
		YES("yes");

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
