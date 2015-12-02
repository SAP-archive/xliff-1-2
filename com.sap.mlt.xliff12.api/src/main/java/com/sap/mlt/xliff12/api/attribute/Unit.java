package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XTendableAttribute;
import com.sap.mlt.xliff12.api.element.namedgroup.Count;

/**
 * Unit - The unit attribute specifies the units counted in a {@link Count}
 * element.
 * 
 * @author D049314
 */
public interface Unit extends XTendableAttribute {

	/**
	 * The attribute's name.
	 */
	static final String NAME = "unit";

	/**
	 * Pre-defined unit values.
	 * 
	 * @author D049314
	 */
	enum Value {
		/**
		 * Refers to words.
		 */
		WORD("word"),
		/**
		 * Refers to pages.
		 */
		PAGE("page"),
		/**
		 * Refers to &lt;trans-unit&gt; elements.
		 */
		TRANS_UNIT("trans-unit"),
		/**
		 * Refers to &lt;bin-unit&gt; elements.
		 */
		BIN_UNIT("bin-unit"),
		/**
		 * Refers to glyphs.
		 */
		GLYPH("glyph"),
		/**
		 * Refers to &lt;trans-unit&gt; and/or &lt;bin-unit&gt; elements.
		 */
		ITEM("item"),
		/**
		 * Refers to the occurrences of instances defined by the count-type
		 * value.
		 */
		INSTANCE("instance"),
		/**
		 * Refers to characters.
		 */
		CHARACTER("character"),
		/**
		 * Refers to lines.
		 */
		LINE("line"),
		/**
		 * Refers to sentences.
		 */
		SENTENCE("sentence"),
		/**
		 * Refers to paragraphs.
		 */
		PARAGRAPH("paragraph"),
		/**
		 * Refers to segments.
		 */
		SEGMENT("segment"),
		/**
		 * Refers to placeables (inline elements).
		 */
		PLACEABLE("placeable");

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
