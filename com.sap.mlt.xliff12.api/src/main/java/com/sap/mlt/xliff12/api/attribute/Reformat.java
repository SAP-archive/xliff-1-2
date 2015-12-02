package com.sap.mlt.xliff12.api.attribute;

import java.util.List;

import com.sap.mlt.xliff12.api.base.MultiXTendableAttribute;

/**
 * Reformat - Indicates whether some properties (size, font, etc.) of the target
 * can be formatted differently from the source.
 * 
 * @author D049314
 */
public interface Reformat extends MultiXTendableAttribute {

	/**
	 * The attribute's name.
	 */
	final static String NAME = "reformat";

	/**
	 * Pre-defined reformat values.
	 * 
	 * @author D049314
	 */
	enum Value {
		/**
		 * This value indicates that all information in the coord attribute can
		 * be modified.
		 */
		COORD("coord"),
		/**
		 * This value indicates that the x information in the coord attribute
		 * can be modified.
		 */
		COORD_X("coord-x"),
		/**
		 * This value indicates that the y information in the coord attribute
		 * can be modified.
		 */
		COORD_Y("coord-y"),
		/**
		 * This value indicates that the cx information in the coord attribute
		 * can be modified.
		 */
		COORD_CX("coord-cx"),
		/**
		 * This value indicates that the cy information in the coord attribute
		 * can be modified.
		 */
		COORD_CY("coord-cy"),
		/**
		 * This value indicates that all the information in the font attribute
		 * can be modified.
		 */
		FONT("font"),
		/**
		 * This value indicates that the name information in the font attribute
		 * can be modified.
		 */
		FONT_NAME("font-name"),
		/**
		 * This value indicates that the size information in the font attribute
		 * can be modified.
		 */
		FONT_SIZE("font-size"),
		/**
		 * This value indicates that the weight information in the font
		 * attribute can be modified.
		 */
		FONT_WEIGHT("font-weight"),
		/**
		 * This value indicates that the information in the css-style attribute
		 * can be modified.
		 */
		CSS_STYLE("css-style"),
		/**
		 * This value indicates that the information in the style attribute can
		 * be modified.
		 */
		STYLE("style"),
		/**
		 * This value indicates that the information in the exstyle attribute
		 * can be modified.
		 */
		EX_STYLE("ex-style");

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

	/**
	 * Returns <code>true</code> if it's allowed to reformat all properties,
	 * <code>false</code> otherwise.
	 * 
	 * @return Returns <code>true</code> if it's allowed to reformat all
	 *         properties, <code>false</code> otherwise.
	 */
	boolean canAllPropertiesBeReformatted();

	/**
	 * Returns <code>true</code> if it's not allowed to reformat any property,
	 * <code>false</code> otherwise.
	 * 
	 * @return Returns <code>true</code> if it's not allowed to reformat any
	 *         property, <code>false</code> otherwise.
	 */
	boolean shouldNoPropertiesBeReformatted();

	/**
	 * Returns a list of properties that are allowed to be reformatted. Returns
	 * an empty list if {@link #canAllPropertiesBeReformatted()} or
	 * {@link #shouldNoPropertiesBeReformatted()} returns <code>true</code>.
	 */
	List<Value> getEnumValues();
}
