package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XTendableAttribute;
import com.sap.mlt.xliff12.api.element.structural.AltTrans;

/**
 * Resource type - Indicates the type of translation within the containing
 * {@link AltTrans} element.
 * 
 * @author D049314
 */
public interface AltTransType extends XTendableAttribute {

	/**
	 * The attribute's name.
	 */
	static final String NAME = "alttranstype";

	/**
	 * Pre-defined alt-trans-type values
	 * 
	 * @author D049314
	 */
	enum Value {
		/**
		 * Represents a translation proposal from a translation memory or other
		 * resource.
		 */
		PROPOSAL("proposal"),
		/**
		 * Represents a previous version of the target element.
		 */
		PREVIOUS_VERSION("previous-version"),
		/**
		 * Represents a rejected version of the target element.
		 */
		REJECTED("rejected"),
		/**
		 * Represents a translation to be used for reference purposes only, for
		 * example from a related product or a different language.
		 */
		REFERENCE("reference"),
		/**
		 * Represents a proposed translation that was used for the translation
		 * of the trans-unit, possibly modified.
		 */
		ACCEPTED("accepted");

		private Value(String xmlName) {
			this.xmlName = xmlName;
		}

		private String xmlName;

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
