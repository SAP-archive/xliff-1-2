package com.sap.mlt.xliff12.impl.element.namedgroup;

import java.util.Collections;
import java.util.List;

import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.PropType;
import com.sap.mlt.xliff12.api.attribute.XmlLang;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.element.namedgroup.Prop;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.api.text.Text;
import com.sap.mlt.xliff12.impl.base.ElementImpl;
import com.sap.mlt.xliff12.impl.base.XliffElementImpl;
import com.sap.mlt.xliff12.impl.schema.Schemas;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.impl.util.Assert;
import com.sap.mlt.xliff12.impl.util.NodeIterator;

/**
 * @deprecated
 */
public class PropImpl extends XliffElementImpl implements Prop {

	public PropImpl(com.sap.mlt.xliff12.api.attribute.PropType propType,
			Text text) {
		super(NAME);
		setPropType(propType);
		setContent(text);
	}

	public PropImpl(Element element) throws ConstraintViolationException {
		super(NAME, element);
	}

	private Text content;

	@Override
	protected void assertAttributesValid(Element element)
			throws ConstraintViolationException {
		Assert.xliffAttrAvailable(element, PropType.NAME);
		Assert.xliffAttrRestricted(element, false, false, true, PropType.NAME);
	}

	@Override
	protected void cloneChildrenFrom(ElementImpl elem) {
		PropImpl source = (PropImpl) elem;
		content = (Text) source.content.clone();
		attach(content);
	}

	@Override
	public List<? extends Node> getChildren() {
		return Collections.singletonList(content);
	}

	@Override
	protected void processChildren(
			List<? extends org.w3c.dom.Node> elementsAndText)
			throws ConstraintViolationException {
		NodeIterator iter = new NodeIterator(elementsAndText, false);
		if (!iter.hasNext()) {
			content = new TextImpl("");
		} else {
			content = new TextImpl(iter.getText());
			iter.assertNoMoreNodes();
		}
		
		attach(content);
	}

	public Text getContent() {
		return content;
	}

	public PropType getPropType() {
		return (com.sap.mlt.xliff12.api.attribute.PropType) getXliffAttribute(com.sap.mlt.xliff12.api.attribute.PropType.NAME);
	}

	public XmlLang getXmlLang() {
		return (XmlLang) getAttribute(Schemas.XML_NAMESPACE, XmlLang.NAME);
	}

	public void setContent(Text text) {
		Assert.notNull(text, "text");
		this.content = text;
	}

	public void setPropType(PropType propType) {
		Assert.notNull(propType, "propType");
		setAttribute(propType);

	}

	public void setXmlLang(XmlLang lang) {
		if (lang == null) {
			clearAttribute(Schemas.XML_NAMESPACE, XmlLang.NAME);
		} else {
			setAttribute(lang);
		}
	}

}
