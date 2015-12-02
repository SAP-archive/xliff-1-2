package com.sap.mlt.xliff12.impl.base;

import java.util.ArrayList;
import java.util.Collection;

import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.api.base.Attribute;
import com.sap.mlt.xliff12.api.base.XliffAttribute;
import com.sap.mlt.xliff12.api.base.XliffElement;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.schema.Schemas;

public abstract class XliffElementImpl extends ElementImpl implements
		XliffElement {

	protected XliffElementImpl(String name) {
		super(Schemas.XLIFF_12_NAMESPACE, null, name);
	}

	protected XliffElementImpl(String name, org.w3c.dom.Element xmlElement)
			throws ConstraintViolationException {
		super(Schemas.XLIFF_12_NAMESPACE, name, xmlElement);
	}

	protected XliffAttribute getXliffAttribute(String name) {
		return (XliffAttribute) getAttribute(Schemas.XLIFF_12_NAMESPACE, name);
	}

	protected void clearXliffAttribute(String name) {
		clearAttribute(Schemas.XLIFF_12_NAMESPACE, name);
	}

	protected Collection<NonXliffAttribute> getNonXliffAttributes() {
		ArrayList<NonXliffAttribute> ret = new ArrayList<NonXliffAttribute>();
		for (Attribute attr : getAttributes()) {
			if (attr instanceof NonXliffAttribute) {
				ret.add((NonXliffAttribute) attr);
			}
		}
		return ret;
	}

	protected static boolean isXliffElement(org.w3c.dom.Node node) {
		if (!(node instanceof org.w3c.dom.Element)) {
			return false;
		}
		org.w3c.dom.Element element = (Element) node;
		return Schemas.XLIFF_12_NAMESPACE.equals(element.getNamespaceURI());
	}

	protected static boolean isNonXliffElement(org.w3c.dom.Node node) {
		if (!(node instanceof org.w3c.dom.Element)) {
			return false;
		}
		org.w3c.dom.Element element = (Element) node;
		return !Schemas.XLIFF_12_NAMESPACE.equals(element.getNamespaceURI());
	}

	protected static boolean isXliffElement(org.w3c.dom.Node node, String name) {
		if (!(node instanceof org.w3c.dom.Element)) {
			return false;
		}
		org.w3c.dom.Element element = (Element) node;
		return Schemas.XLIFF_12_NAMESPACE.equals(element.getNamespaceURI())
				&& name.equals(element.getLocalName());
	}
	
}
