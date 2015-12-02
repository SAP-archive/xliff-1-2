package com.sap.mlt.xliff12.api.element.namedgroup;

import com.sap.mlt.xliff12.api.attribute.PropType;
import com.sap.mlt.xliff12.api.attribute.XmlLang;
import com.sap.mlt.xliff12.api.base.XliffElement;
import com.sap.mlt.xliff12.api.text.Text;

/**
 * Property - The Prop element allows the tools to specify non-standard
 * information in the XLIFF document. This information can be used by the tools
 * that have produced the file or that translate the file or that do any other
 * amount of processing specific to the producer.
 * 
 * @author D049314
 * @deprecated The Prop element was DEPRECATED in version 1.1. Instead, use
 *             attributes defined in a namespace different from XLIFF.
 */
public interface Prop extends XliffElement {

	/**
	 * The element's name.
	 */
	static final String NAME = "prop";

	/**
	 * Returns the <code>PropType</code> attribute.
	 * 
	 * @return Returns the <code>PropType</code> attribute.
	 */
	PropType getPropType();

	/**
	 * Sets the <code>PropType</code> attribute.
	 * 
	 * @param propType
	 *            The <code>PropType</code> attribute. Must not be
	 *            <code>null</code>.
	 */
	void setPropType(PropType propType);

	/**
	 * Returns the <code>XmlLang</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>XmlLang</code> attribute. Might be
	 *         <code>null</code> .
	 */
	XmlLang getXmlLang();

	/**
	 * Sets the <code>XmlLang</code> attribute.
	 * 
	 * @param lang
	 *            The <code>XmlLang</code> attribute. May be <code>null</code>.
	 */
	void setXmlLang(XmlLang lang);

	/**
	 * Returns the content of this property.
	 * 
	 * @return Returns the content of this property.
	 */
	Text getContent();

	/**
	 * Sets the content of this property.
	 * 
	 * @param text
	 *            The content. Must not be <code>null</code>.
	 */
	void setContent(Text text);


}
