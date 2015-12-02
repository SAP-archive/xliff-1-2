package com.sap.mlt.xliff12.api.base;

/**
 * Basic interface extended by all nodes (i.e. elements and text).
 * 
 * @author D049314
 */
public interface Node extends Cloneable {

	/**
	 * Returns this node as XML document node.
	 * 
	 * @param document
	 *            The document that is to become the owner of the returned node.
	 * @return Returns this node as XML document node.
	 */
	org.w3c.dom.Node asXmlNode(org.w3c.dom.Document document);

	/**
	 * Returns the parent element of this node. Returns <code>null</code> if
	 * this node is not the child of any element.
	 * 
	 * @return Returns the parent element of this node. Returns
	 *         <code>null</code> if this node is not the child of any element.
	 */
	Element getParentElement();

	/**
	 * Returns a clone of this node. The cloned node has the same properties as
	 * this node, but its parent element is <code>null</code>.
	 * 
	 * @return Returns a clone of this node. The cloned node has the same
	 *         properties as this node, but its parent element is
	 *         <code>null</code>.
	 */
	Object clone();

}
