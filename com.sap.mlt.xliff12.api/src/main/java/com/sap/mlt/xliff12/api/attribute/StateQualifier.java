package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XTendableAttribute;
import com.sap.mlt.xliff12.api.element.structural.BinTarget;
import com.sap.mlt.xliff12.api.element.structural.Target;

/**
 * State-qualifier - Describes the state of a particular translation in a
 * {@link Target} or {@link BinTarget} element.
 * 
 * @author D049314
 */
public interface StateQualifier extends XTendableAttribute {

	/**
	 * The attribute's name.
	 */
	final static String NAME = "state-qualifier";

	/**
	 * Predefined state-qualifier values.
	 * 
	 * @author D049314
	 */
	enum Value {
		/**
		 * Indicates an exact match. An exact match occurs when a source text of
		 * a segment is exactly the same as the source text of a segment that
		 * was translated previously.
		 */
		EXACT_MATCH("exact-match"),
		/**
		 * Indicates a fuzzy match. A fuzzy match occurs when a source text of a
		 * segment is very similar to the source text of a segment that was
		 * translated previously (e.g. when the difference is casing, a few
		 * changed words, white-space discripancy, etc.).
		 */
		FUZZY_MATCH("fuzzy-match"),
		/**
		 * Indicates a match based on matching IDs (in addition to matching
		 * text).
		 */
		ID_MATCH("id-match"),
		/**
		 * Indicates a translation derived from a glossary.
		 */
		LEVERAGED_GLOSSARY("leveraged-glossary"),
		/**
		 * Indicates a translation derived from existing translation.
		 */
		LEVERAGED_INHERITED("leveraged-inherited"),
		/**
		 * Indicates a translation derived from machine translation.
		 */
		LEVERAGED_MT("leveraged-mt"),
		/**
		 * Indicates a translation derived from a translation repository.
		 */
		LEVERAGED_REPOSITORY("leveraged-repository"),
		/**
		 * Indicates a translation derived from a translation memory.
		 */
		LEVERAGED_TM("leveraged-tm"),
		/**
		 * Indicates the translation is suggested by machine translation.
		 */
		MT_SUGGESTION("mt-suggestion"),
		/**
		 * Indicates that the item has been rejected because of incorrect
		 * grammar.
		 */
		REJECTED_GRAMMAR("rejected-grammar"),
		/**
		 * Indicates that the item has been rejected because it is incorrect.
		 */
		REJECTED_INACCURATE("rejected-inaccurate"),
		/**
		 * Indicates that the item has been rejected because it is too long or
		 * too short.
		 */
		REJECTED_LENGTH("rejected-length"),
		/**
		 * Indicates that the item has been rejected because of incorrect
		 * spelling.
		 */
		REJECTED_SPELLING("rejected-spelling"),
		/**
		 * Indicates the translation is suggested by translation memory.
		 */
		TM_SUGGESTION("tm-suggestion");

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
