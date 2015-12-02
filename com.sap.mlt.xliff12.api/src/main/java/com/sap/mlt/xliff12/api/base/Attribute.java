package com.sap.mlt.xliff12.api.base;

/**
 * Basic interface for all attributes.
 * 
 * @author D049314
 */
public interface Attribute extends Cloneable {

	/**
	 * Returns the attribute's namespace URI.
	 * 
	 * @return Returns the attribute's namespace URI.
	 */
	String getNamespaceUri();

	/**
	 * Returns the prefix that is used for this attribute inside the XML
	 * document. Returns <code>null</code> if the attribute does not have a
	 * prefix.
	 * 
	 * @return Returns the prefix that is used for this attribute inside the XML
	 *         document. Returns <code>null</code> if the attribute does not
	 *         have a prefix.
	 */
	String getPrefix();

	/**
	 * Returns the (local) name of this attribute.
	 * 
	 * @return Returns the (local) name of this attribute.
	 */
	String getName();

	/**
	 * Returns the value of this attribute.
	 * 
	 * @return Returns the value of this attribute.
	 */
	String getValue();

	/**
	 * Returns the element that owns this attribute. Returns <code>null</code>
	 * if this attribute is not owned by an element.
	 * 
	 * @return Returns the element that owns this attribute. Returns
	 *         <code>null</code> if this attribute is not owned by an element.
	 */
	Element getOwnerElement();

	/**
	 * Returns a clone of this attribute. The cloned attributes has the same
	 * properties as this attribute, but is not owned by an element.
	 * 
	 * @return Returns a clone of this attribute. The cloned attributes has the
	 *         same properties as this attribute, but is not owned by an
	 *         element.
	 */
	Object clone();

}
