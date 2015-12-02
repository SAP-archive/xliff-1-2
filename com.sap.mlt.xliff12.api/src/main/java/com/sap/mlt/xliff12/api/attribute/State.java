package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XTendableAttribute;
import com.sap.mlt.xliff12.api.element.structural.BinTarget;
import com.sap.mlt.xliff12.api.element.structural.Target;

/**
 * State - The status of a particular translation in a {@link Target} or
 * {@link BinTarget} element.
 * 
 * @author D049314
 */
public interface State extends XTendableAttribute {

	/**
	 * The attribute's name.
	 */
	final static String NAME = "state";

	/**
	 * Pre-defined state values.
	 * 
	 * @author D049314
	 */
	enum Value {
		/**
		 * Indicates the terminating state.
		 */
		FINAL("final"),
		/**
		 * Indicates only non-textual information needs adaptation.
		 */
		NEEDS_ADAPTATION("needs-adaptation"),
		/**
		 * Indicates both text and non-textual information needs adaptation.
		 */
		NEEDS_L10N("needs-l10n"),
		/**
		 * Indicates only non-textual information needs review.
		 */
		NEEDS_REVIEW_ADAPTATION("needs-review-adaptation"),
		/**
		 * Indicates both text and non-textual information needs review.
		 */
		NEEDS_REVIEW_L10N("needs-review-l10n"),
		/**
		 * Indicates that only the text of the item needs to be reviewed.
		 */
		NEEDS_REVIEW_TRANSLATION("needs-review-translation"),
		/**
		 * Indicates that the item needs to be translated.
		 */
		NEEDS_TRANSLATION("needs-translation"),
		/**
		 * Indicates that the item is new. For example, translation units that
		 * were not in a previous version of the document.
		 */
		NEW("new"),
		/**
		 * Indicates that changes are reviewed and approved.
		 */
		SIGNED_OFF("signed-off"),
		/**
		 * Indicates that the item has been translated.
		 */
		TRANSLATED("translated");

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
