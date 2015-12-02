package com.sap.mlt.xliff12.impl.element.toplevel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.sap.mlt.xliff12.api.attribute.BuildNum;
import com.sap.mlt.xliff12.api.attribute.Category;
import com.sap.mlt.xliff12.api.attribute.DataType;
import com.sap.mlt.xliff12.api.attribute.Date;
import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.api.attribute.Original;
import com.sap.mlt.xliff12.api.attribute.ProductName;
import com.sap.mlt.xliff12.api.attribute.ProductVersion;
import com.sap.mlt.xliff12.api.attribute.SourceLanguage;
import com.sap.mlt.xliff12.api.attribute.TargetLanguage;
import com.sap.mlt.xliff12.api.attribute.Tool;
import com.sap.mlt.xliff12.api.attribute.ToolId;
import com.sap.mlt.xliff12.api.attribute.Ts;
import com.sap.mlt.xliff12.api.attribute.XmlSpace;
import com.sap.mlt.xliff12.api.base.Attribute;
import com.sap.mlt.xliff12.api.base.Element;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.element.header.Header;
import com.sap.mlt.xliff12.api.element.structural.Body;
import com.sap.mlt.xliff12.api.element.toplevel.File;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.base.ElementImpl;
import com.sap.mlt.xliff12.impl.base.XliffElementImpl;
import com.sap.mlt.xliff12.impl.element.header.HeaderImpl;
import com.sap.mlt.xliff12.impl.element.structural.BodyImpl;
import com.sap.mlt.xliff12.impl.schema.Schemas;
import com.sap.mlt.xliff12.impl.util.Assert;
import com.sap.mlt.xliff12.impl.util.NodeIterator;

@SuppressWarnings("deprecation")
public class FileImpl extends XliffElementImpl implements File {

	public FileImpl(Original original, SourceLanguage sourceLanguage,
			DataType dataType, Body body) {
		super(NAME);
		setOriginal(original);
		setSourceLanguage(sourceLanguage);
		setDataType(dataType);
		setBody(body);
	}

	public FileImpl(org.w3c.dom.Element element)
			throws ConstraintViolationException {
		super(NAME, element);
	}

	private Header header;

	private Body body;

	@Override
	protected void assertAttributesValid(org.w3c.dom.Element element)
			throws ConstraintViolationException {
		Assert.xliffAttrAvailable(element, Original.NAME, SourceLanguage.NAME,
				DataType.NAME);
		Assert.xliffAttrRestricted(element, true, true, false, Original.NAME,
				SourceLanguage.NAME, DataType.NAME, Tool.NAME, ToolId.NAME,
				Date.NAME, Ts.NAME, Category.NAME, TargetLanguage.NAME,
				ProductName.NAME, ProductVersion.NAME, BuildNum.NAME);
	}

	@Override
	protected void cloneChildrenFrom(ElementImpl elem) {
		FileImpl source = (FileImpl) elem;
		if (source.header != null) {
			header = (Header) source.header.clone();
			attach(header);
		}
		body = (Body) source.body.clone();
		attach(body);
	}

	@Override
	public List<? extends Node> getChildren() {
		ArrayList<Element> children = new ArrayList<Element>();
		if (header != null) {
			children.add(header);
		}
		children.add(body);
		return children;
	}

	@Override
	protected void processChildren(
			List<? extends org.w3c.dom.Node> elementsAndText)
			throws ConstraintViolationException {
		NodeIterator iter = new NodeIterator(elementsAndText, true);
		if (iter.nextIsXliffElement(Header.NAME)) {
			header = new HeaderImpl(iter.getElement());
		}
		body = new BodyImpl(iter.getXliffElement(Body.NAME));
		attach(header);
		attach(body);
	}

	public Body getBody() {
		return body;
	}

	public BuildNum getBuildNum() {
		return (BuildNum) getXliffAttribute(BuildNum.NAME);
	}

	public Category getCategory() {
		return (Category) getXliffAttribute(Category.NAME);
	}

	public DataType getDataType() {
		return (DataType) getXliffAttribute(DataType.NAME);
	}

	public Date getDate() {
		return (Date) getXliffAttribute(Date.NAME);
	}

	public Header getHeader() {
		return header;
	}

	public Collection<NonXliffAttribute> getNonXliffAttributes() {
		return super.getNonXliffAttributes();
	}

	public Original getOriginal() {
		return (Original) getXliffAttribute(Original.NAME);
	}

	public ProductName getProductName() {
		return (ProductName) getXliffAttribute(ProductName.NAME);
	}

	public ProductVersion getProductVersion() {
		return (ProductVersion) getXliffAttribute(ProductVersion.NAME);
	}

	public SourceLanguage getSourceLanguage() {
		return (SourceLanguage) getXliffAttribute(SourceLanguage.NAME);
	}

	public TargetLanguage getTargetLanguage() {
		return (TargetLanguage) getXliffAttribute(TargetLanguage.NAME);
	}

	public Tool getTool() {
		return (Tool) getXliffAttribute(Tool.NAME);
	}

	public ToolId getToolId() {
		return (ToolId) getXliffAttribute(ToolId.NAME);
	}

	public Ts getTs() {
		return (Ts) getXliffAttribute(Ts.NAME);
	}

	public XmlSpace getXmlSpace() {
		return (XmlSpace) getAttribute(Schemas.XML_NAMESPACE, XmlSpace.NAME);
	}

	public void setBody(Body body) {
		Assert.notNull(body, "body");
		Assert.isInstance(body, "body", BodyImpl.class);
		assertNotAttached(body);
		detach(this.body);
		this.body = body;
		attach(this.body);
	}

	public void setBuildNum(BuildNum buildNum) {
		if (buildNum == null) {
			clearXliffAttribute(BuildNum.NAME);
		} else {
			setAttribute(buildNum);
		}
	}

	public void setCategory(Category category) {
		if (category == null) {
			clearXliffAttribute(Category.NAME);
		} else {
			setAttribute(category);
		}
	}

	public void setDataType(DataType dataType) {
		Assert.notNull(dataType, "dataType");
		setAttribute(dataType);
	}

	public void setDate(Date date) {
		if (date == null) {
			clearXliffAttribute(Date.NAME);
		} else {
			setAttribute(date);
		}
	}

	public void setHeader(Header header) {
		Assert.isInstance(header, "header", HeaderImpl.class);
		assertNotAttached(header);
		detach(this.header);
		this.header = header;
		attach(this.header);
	}

	public void setNonXliffAttributes(
			Collection<NonXliffAttribute> nonXliffAttributes) {
		Assert.notNull(nonXliffAttributes, "nonXliffAttributes");
		Collection<NonXliffAttribute> toDelete = getNonXliffAttributes();
		for (NonXliffAttribute attr : toDelete) {
			clearAttribute(attr.getNamespaceUri(), attr.getName());
		}
		for (NonXliffAttribute attr : nonXliffAttributes) {
			setAttribute(attr);
		}
	}

	public void setOriginal(Original original) {
		Assert.notNull(original, "original");
		setAttribute(original);
	}

	public void setProductName(ProductName productName) {
		if (productName == null) {
			clearXliffAttribute(ProductName.NAME);
		} else {
			setAttribute(productName);
		}
	}

	public void setProductVersion(ProductVersion productVersion) {
		if (productVersion == null) {
			clearXliffAttribute(ProductVersion.NAME);
		} else {
			setAttribute(productVersion);
		}
	}

	public void setSourceLanguage(SourceLanguage sourceLanguage) {
		Assert.notNull(sourceLanguage, "sourceLanguage");
		setAttribute(sourceLanguage);
	}

	public void setTargetLanguage(TargetLanguage targetLanguage) {
		if (targetLanguage == null) {
			clearXliffAttribute(TargetLanguage.NAME);
		} else {
			setAttribute(targetLanguage);
		}
	}

	public void setTool(Tool tool) {
		if (tool == null) {
			setAttribute(new com.sap.mlt.xliff12.impl.attribute.ToolImpl(
					"manual"));
		} else {
			setAttribute(tool);
		}
	}

	public void setToolId(ToolId toolId) {
		if (toolId == null) {
			clearXliffAttribute(ToolId.NAME);
		} else {
			setAttribute(toolId);
		}
	}

	public void setTs(Ts ts) {
		if (ts == null) {
			clearXliffAttribute(Ts.NAME);
		} else {
			setAttribute(ts);
		}
	}

	public void setXmlSpace(XmlSpace xmlSpace) {
		if (xmlSpace == null) {
			clearAttribute(Schemas.XML_NAMESPACE, "space");
		} else {
			setAttribute(xmlSpace);
		}
	}

	@Override
	protected Collection<? extends Attribute> getDefaultAttributes() {
		return Collections
				.singletonList(new com.sap.mlt.xliff12.impl.attribute.ToolImpl(
						"manual"));
	}
}
