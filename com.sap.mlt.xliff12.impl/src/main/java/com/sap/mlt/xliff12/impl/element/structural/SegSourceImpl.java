package com.sap.mlt.xliff12.impl.element.structural;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.api.attribute.Ts;
import com.sap.mlt.xliff12.api.attribute.XmlLang;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.base.TextFragment;
import com.sap.mlt.xliff12.api.element.structural.SegSource;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.base.ElementImpl;
import com.sap.mlt.xliff12.impl.base.XliffElementImpl;
import com.sap.mlt.xliff12.impl.element.CommonsParser;
import com.sap.mlt.xliff12.impl.element.delimiter.MrkImpl;
import com.sap.mlt.xliff12.impl.element.inline.BptImpl;
import com.sap.mlt.xliff12.impl.element.inline.BxImpl;
import com.sap.mlt.xliff12.impl.element.inline.EptImpl;
import com.sap.mlt.xliff12.impl.element.inline.ExImpl;
import com.sap.mlt.xliff12.impl.element.inline.GImpl;
import com.sap.mlt.xliff12.impl.element.inline.ItImpl;
import com.sap.mlt.xliff12.impl.element.inline.PhImpl;
import com.sap.mlt.xliff12.impl.element.inline.XImpl;
import com.sap.mlt.xliff12.impl.schema.Schemas;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.impl.util.Assert;

@SuppressWarnings("deprecation")
public class SegSourceImpl extends XliffElementImpl implements SegSource {

	public SegSourceImpl(List<? extends TextFragment> content) {
		super(NAME);
		setContent(content);
	}

	public SegSourceImpl(Element element) throws ConstraintViolationException {
		super(NAME, element);
	}

	private ArrayList<TextFragment> content;

	@Override
	protected void assertAttributesValid(Element element)
			throws ConstraintViolationException {
		Assert.xliffAttrRestricted(element, true, false, true, Ts.NAME);
	}

	@Override
	protected void cloneChildrenFrom(ElementImpl elem) {
		SegSourceImpl source = (SegSourceImpl) elem;
		content = new ArrayList<TextFragment>();
		for (TextFragment tf : source.content) {
			content.add((TextFragment) tf.clone());
		}
		attach(content);
	}

	@Override
	public List<? extends Node> getChildren() {
		return Collections.unmodifiableList(content);
	}

	@Override
	protected void processChildren(
			List<? extends org.w3c.dom.Node> elementsAndText)
			throws ConstraintViolationException {
		content = CommonsParser.parseTextFragments(elementsAndText);
		attach(content);
	}

	public List<? extends TextFragment> getContent() {
		return Collections.unmodifiableList(content);
	}

	public Collection<NonXliffAttribute> getNonXliffAttributes() {
		return super.getNonXliffAttributes();
	}

	public String getPlainText() {
		StringBuilder sb = new StringBuilder();
		for (TextFragment fragment : content) {
			sb.append(fragment.getPlainText());
		}
		return sb.toString();
	}

	public Ts getTs() {
		return (com.sap.mlt.xliff12.api.attribute.Ts) getXliffAttribute(com.sap.mlt.xliff12.api.attribute.Ts.NAME);
	}

	public XmlLang getXmlLang() {
		return (XmlLang) getAttribute(Schemas.XML_NAMESPACE, XmlLang.NAME);
	}

	public void setContent(List<? extends TextFragment> content) {
		Assert.notNull(content, "content");
		Assert.areInstances(content, "content", TextImpl.class, BptImpl.class,
				BxImpl.class, EptImpl.class, ExImpl.class, GImpl.class,
				ItImpl.class, MrkImpl.class, PhImpl.class, XImpl.class);
		assertNotAttached(content);
		detach(this.content);
		this.content = new ArrayList<TextFragment>(content);
		attach(this.content);
	}

	public void setNonXliffAttributes(
			Collection<NonXliffAttribute> nonXliffAttributes) {
		Collection<NonXliffAttribute> toDelete = getNonXliffAttributes();
		for (NonXliffAttribute attr : toDelete) {
			clearAttribute(attr.getNamespaceUri(), attr.getName());
		}
		for (NonXliffAttribute attr : nonXliffAttributes) {
			setAttribute(attr);
		}
	}

	public void setTs(Ts ts) {
		if (ts == null) {
			clearXliffAttribute(com.sap.mlt.xliff12.api.attribute.Ts.NAME);
		} else {
			setAttribute(ts);
		}
	}

	public void setXmlLang(XmlLang xmlLang) {
		if (xmlLang == null) {
			clearAttribute(Schemas.XML_NAMESPACE, XmlLang.NAME);
		} else {
			setAttribute(xmlLang);
		}
	}

}
