package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XTendableAttribute;

/**
 * Unit of size attributes - The size-unit attribute specifies the units of
 * measure used in the {@link MaxHeight}, {@link MinHeight}, {@link MaxWidth},
 * and {@link MinWidth} attributes. The size-unit attribute is not related to
 * the {@link Coord} attribute.
 * 
 * @author D049314
 */
public interface SizeUnit extends XTendableAttribute {

	/**
	 * The attribute's name.
	 */
	static final String NAME = "size-unit";

	/**
	 * Pre-defined size-unit values.
	 * 
	 * @author D049314
	 */
	enum Value {
		/**
		 * Indicates a size in 8-bit bytes.
		 */
		BYTE("byte"),
		/**
		 * Indicates a size in Unicode characters.
		 */
		CHAR("char"),
		/**
		 * Indicates a size in columns. Used for HTML text area.
		 */
		COL("col"),
		/**
		 * Indicates a size in centimeters.
		 */
		CM("cm"),
		/**
		 * Indicates a size in dialog units, as defined in Windows resources.
		 */
		DLGUNIT("dlgunit"),
		/**
		 * Indicates a size in 'font-size' units (as defined in CSS).
		 */
		EM("em"),
		/**
		 * Indicates a size in 'x-height' units (as defined in CSS).
		 */
		EX("ex"),
		/**
		 * Indicates a size in glyphs. A glyph is considered to be one or more
		 * combined Unicode characters that represent a single displayable text
		 * character. Sometimes referred to as a 'grapheme cluster'
		 */
		GLYPH("glyph"),
		/**
		 * Indicates a size in inches.
		 */
		IN("in"),
		/**
		 * Indicates a size in millimeters.
		 */
		MM("mm"),
		/**
		 * Indicates a size in percentage.
		 */
		PERCENT("percent"),
		/**
		 * Indicates a size in pixels.
		 */
		PIXEL("pixel"),
		/**
		 * Indicates a size in point.
		 */
		POINT("point"),
		/**
		 * Indicates a size in rows. Used for HTML text area.
		 */
		ROW("row");

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
