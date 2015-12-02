package com.sap.mlt.xliff12.impl.element.toplevel;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.api.attribute.Version;
import com.sap.mlt.xliff12.api.attribute.XmlLang;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.element.nonxliff.NonXliffElement;
import com.sap.mlt.xliff12.api.element.toplevel.File;
import com.sap.mlt.xliff12.api.element.toplevel.Xliff;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.base.ElementImpl;
import com.sap.mlt.xliff12.impl.base.XliffElementImpl;
import com.sap.mlt.xliff12.impl.element.nonxliff.NonXliffElementImpl;
import com.sap.mlt.xliff12.impl.schema.Schemas;
import com.sap.mlt.xliff12.impl.util.Assert;
import com.sap.mlt.xliff12.impl.util.NodeIterator;

public class XliffImpl extends XliffElementImpl implements Xliff {

	public XliffImpl(Version version, List<File> files) {
		super(NAME);
		setVersion(version);
		setFiles(files);
		nonXliffElements = new ArrayList<NonXliffElement>();
	}

	public XliffImpl(org.w3c.dom.Element element)
			throws ConstraintViolationException {
		super(NAME, element);
	}

	private ArrayList<File> files;

	private ArrayList<NonXliffElement> nonXliffElements;

	@Override
	protected void assertAttributesValid(Element element)
			throws ConstraintViolationException {
		Assert.xliffAttrAvailable(element, Version.NAME);
		Assert.xliffAttrRestricted(element, true, false, true, Version.NAME);
	}

	@Override
	protected void cloneChildrenFrom(ElementImpl elem) {
		XliffImpl source = (XliffImpl) elem;

		files = new ArrayList<File>();
		for (File file : source.files) {
			File clonedFile = (File) file.clone();
			attach(clonedFile);
			files.add(clonedFile);
		}

		nonXliffElements = new ArrayList<NonXliffElement>();
		for (NonXliffElement nonXliffElement : source.nonXliffElements) {
			NonXliffElement clonedNonXliffElement = (NonXliffElement) nonXliffElement.clone();
			attach(clonedNonXliffElement);
			nonXliffElements.add(clonedNonXliffElement);
		}
	}

	@Override
	public List<? extends Node> getChildren() {
		return Collections.unmodifiableList(files);
	}

	@Override
	protected void processChildren(
			List<? extends org.w3c.dom.Node> elementsAndText)
			throws ConstraintViolationException {
		files = new ArrayList<File>();
		nonXliffElements = new ArrayList<NonXliffElement>();

		NodeIterator iter = new NodeIterator(elementsAndText, true);
		while (iter.hasNext()) {
			if (!iter.nextIsElement()) {
				String msg = MessageFormat
						.format(
								"Element <{0}> must not contain text, but contains text ''{1}''",
								NAME, iter.getText());
				throw new ConstraintViolationException(msg);
			}
			if (iter.nextIsNonXliffElement()) {
				nonXliffElements.add(new NonXliffElementImpl(iter.getElement()));
			} else {
				files.add(new FileImpl(iter.getXliffElement(File.NAME)));				
			}
		}
		if (files.isEmpty()) {
			String msg = MessageFormat.format(
					"Element <{0}> must contain at least one <{1}> element",
					NAME, File.NAME);
			throw new ConstraintViolationException(msg);
		}
		attach(files);
		attach(nonXliffElements);
	}

	public List<File> getFiles() {
		return Collections.unmodifiableList(files);
	}

	public Collection<NonXliffAttribute> getNonXliffAttributes() {
		return super.getNonXliffAttributes();
	}

	public List<NonXliffElement> getNonXliffElements() {
		return Collections.unmodifiableList(nonXliffElements);
	}

	public Version getVersion() {
		return (Version) getXliffAttribute(Version.NAME);
	}

	public XmlLang getXmlLang() {
		return (XmlLang) getAttribute(Schemas.XML_NAMESPACE, "lang");
	}

	public void setFiles(List<File> files) {
		Assert.notNull(files, "files");
		Assert.areInstances(files, "files", FileImpl.class);
		if (files.isEmpty()) {
			throw new IllegalArgumentException(
					"List of files must contain at least one file element");
		}
		assertNotAttached(files);
		detach(this.files);
		this.files = new ArrayList<File>(files);
		attach(this.files);
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

	public void setVersion(Version version) {
		Assert.notNull(version, "version");
		setAttribute(version);
	}

	public void setXmlLang(XmlLang xmlLang) {
		if (xmlLang == null) {
			clearAttribute(Schemas.XML_NAMESPACE, XmlLang.NAME);
		} else {
			setAttribute(xmlLang);
		}
	}
}
