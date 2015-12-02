package com.sap.mlt.xliff12.impl.text;

import org.w3c.dom.Document;

import com.sap.mlt.xliff12.api.text.Text;
import com.sap.mlt.xliff12.impl.base.NodeImpl;
import com.sap.mlt.xliff12.impl.util.Assert;

public class TextImpl extends NodeImpl implements Text {

	public TextImpl(String text) {
		Assert.validXMLChars(text, "text");
		this.text = text;
	}
	
	private String text;
	
	@Override
	public org.w3c.dom.Text asXmlNode(Document document) {
		return document.createTextNode(text);
	}

	public String getText() {
		return text;
	}

	public String getPlainText() {
		return text;
	}

	@Override
	public int hashCode() {
		return text.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TextImpl other = (TextImpl) obj;
		return text.equals(other.text);
	}
	
	@Override
	public String toString() {
		return text;
	}
}
