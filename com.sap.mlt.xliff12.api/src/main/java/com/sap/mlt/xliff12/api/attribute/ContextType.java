package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XTendableAttribute;

/**
 * Context type - The context-type attribute specifies the context and the type
 * of resource or style of the data of a given element. For example, to define
 * if it is a label, or a menu item in the case of resource-type data, or the
 * style in the case of document-related data.
 * 
 * @author D049314
 */
public interface ContextType extends XTendableAttribute {

	/**
	 * The attribute's name.
	 */
	static final String NAME = "context-type";

	/**
	 * Pre-defined context-type values.
	 * 
	 * @author D049314
	 */
	enum Value {
		/**
		 * Indicates a database content.
		 */
		DATABASE("database"),
		/**
		 * Indicates the content of an element within an XML document.
		 */
		ELEMENT("element"),
		/**
		 * Indicates the name of an element within an XML document.
		 */
		ELEMENTTITLE("elementtitle"),
		/**
		 * Indicates the line number from the sourcefile (see context-type=
		 * "sourcefile") where the &lt;source&gt; is found.
		 */
		LINENUMBER("linenumber"),
		/**
		 * Indicates a the number of parameters contained within the
		 * &lt;source&gt;.
		 */
		NUMPARAMS("numparams"),
		/**
		 * Indicates notes pertaining to the parameters in the &lt;source&gt;.
		 */
		PARAMNOTES("paramnotes"),
		/**
		 * Indicates the content of a record within a database.
		 */
		RECORD("record"),
		/**
		 * Indicates the name of a record within a database.
		 */
		RECORDTITLE("recordtitle"),
		/**
		 * Indicates the original source file in the case that multiple files
		 * are merged to form the original file from which the XLIFF file is
		 * created. This differs from the original &lt;file&gt; attribute in
		 * that this sourcefile is one of many that make up that file.
		 */
		SOURCEFILE("sourcefile");

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
