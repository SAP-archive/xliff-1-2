package com.sap.mlt.xliff12.api.text;

import org.w3c.dom.Document;

import com.sap.mlt.xliff12.api.base.CodeFragment;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.base.TextFragment;

/**
 * A plain text that can be inserted as child node into elements.
 * 
 * @author D049314
 */
public interface Text extends Node, TextFragment, CodeFragment {

	/**
	 * Returns the text.
	 * 
	 * @return Returns the text.
	 */
	String getText();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mlt.xliff12.api.base.Node#asXmlNode(org.w3c.dom.Document)
	 */
	org.w3c.dom.Text asXmlNode(Document document);

}
