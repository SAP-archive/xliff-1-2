package com.sap.mlt.xliff12.api.base;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Basic interface extended by all elements.
 * 
 * @author D049314
 */
public interface Element extends Node {

	/**
	 * Returns the element's namespace URI.
	 * 
	 * @return Returns the element's namespace URI.
	 */
	String getNamespaceUri();

	/**
	 * Returns the element's prefix or <code>null</code> if no prefix was used.
	 * 
	 * @return Returns the element's prefix or <code>null</code> if no prefix
	 *         was used.
	 * @since 1.1
	 */
	String getPrefix();

	/**
	 * Returns the (local) name of this element.
	 * 
	 * @return Returns the (local) name of this element.
	 */
	String getName();

	/**
	 * Returns the mapping of namespaces to prefixes that are set on this
	 * element via the <code>xmlns</code> attribute. Key is the namespace URI,
	 * value the prefix. If a namespace is the default namespace, the according
	 * prefix is an empty string.
	 * 
	 * @return Returns the mapping of namespaces to prefixes that are set on
	 *         this element via the <code>xmlns</code> attribute. Key is the
	 *         namespace URI, value the prefix. If a namespace is the default
	 *         namespace, the according prefix is an empty string.
	 * @since 1.1
	 */
	Map<String, String> getNamespacePrefixMapping();

	/**
	 * Sets the mapping of namespaces to prefix of this element. On
	 * serialization the serializer will set the appropriate <code>xmlns</code>
	 * attributes.
	 * 
	 * @param namespace2Prefix
	 *            Map containing the namespace to prefix mappings. Key is the
	 *            namespace URI, value is the prefix. If you would like to set
	 *            the default namespace, use the empty string as prefix.
	 * @since 1.1
	 */
	void setNamespacePrefixMapping(Map<String, String> namespace2Prefix);

	/**
	 * Returns all attributes of this element.
	 * 
	 * @return Returns all attributes of this element.
	 */
	Collection<? extends Attribute> getAttributes();

	/**
	 * Returns all child nodes of this element.
	 * 
	 * @return Returns all child nodes of this element.
	 */
	List<? extends Node> getChildren();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mlt.xliff12.api.base.Node#asXmlNode(org.w3c.dom.Document)
	 */
	org.w3c.dom.Element asXmlNode(org.w3c.dom.Document document);
}
