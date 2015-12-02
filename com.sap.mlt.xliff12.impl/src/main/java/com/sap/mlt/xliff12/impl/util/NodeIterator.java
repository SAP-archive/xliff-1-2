package com.sap.mlt.xliff12.impl.util;

import java.text.MessageFormat;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.schema.Schemas;

public class NodeIterator {

	public NodeIterator(List<? extends Node> nodes, boolean ignoreWhitespaceText) {
		this.nodes = nodes;
		this.ignoreWhitespaceText = ignoreWhitespaceText;
		this.pos = 0;
		this.next = null;
		advance();
	}

	private List<? extends Node> nodes;

	private boolean ignoreWhitespaceText;

	private int pos;

	private Node next;

	public boolean hasNext() {
		return next != null;
	}

	public boolean nextIsText() {
		if (next == null) {
			return false;
		}
		return next instanceof Text;
	}

	public boolean nextIsElement() {
		if (next == null) {
			return false;
		}
		return next instanceof Element;
	}

	public boolean nextIsXliffElement() {
		if (next == null) {
			return false;
		}
		return (next instanceof Element)
				&& (Schemas.XLIFF_12_NAMESPACE.equals(next.getNamespaceURI()));
	}

	public boolean nextIsXliffElement(String localName) {
		if (next == null) {
			return false;
		}
		return (next instanceof Element)
				&& (Schemas.XLIFF_12_NAMESPACE.equals(next.getNamespaceURI()))
				&& (localName.equals(next.getLocalName()));
	}

	public boolean nextIsNonXliffElement() {
		if (next == null) {
			return false;
		}
		return (next instanceof Element)
				&& (!Schemas.XLIFF_12_NAMESPACE.equals(next.getNamespaceURI()));
	}

	public String getText() throws ConstraintViolationException {
		if (next == null) {
			throw new ConstraintViolationException(
					"Expected text node, but found no further node");
		}
		if (!(next instanceof Text)) {
			String msg = MessageFormat
					.format(
							"Expected text content, but found a node of type ''{0}'' by name ''{1}''",
							next.getClass().getName(), next.getLocalName());
			throw new ConstraintViolationException(msg);
		}
		String ret = ((Text) next).getTextContent();
		advance();
		return ret;
	}

	public Element getElement() throws ConstraintViolationException {
		if (next == null) {
			throw new ConstraintViolationException(
					"Expected element node, but found no further node");
		}
		if (!(next instanceof Element)) {
			String msg = MessageFormat.format(
					"Expected element node, but found a node of type ''{0}''",
					next.getClass().getName());
			throw new ConstraintViolationException(msg);
		}
		Element ret = (Element) next;
		advance();
		return ret;
	}

	public Element getXliffElement() throws ConstraintViolationException {
		if (next == null) {
			String msg = "Expected XLIFF element, but found no further element";
			throw new ConstraintViolationException(msg);
		}
		if (!(next instanceof Element)) {
			String msg = MessageFormat.format(
					"Expected XLIFF element, but found a node of type ''{0}''",
					next.getClass().getName());
			throw new ConstraintViolationException(msg);
		}
		if (!Schemas.XLIFF_12_NAMESPACE.equals(next.getNamespaceURI())) {
			String msg = MessageFormat
					.format(
							"Expected XLIFF element, but found an element <{1}> of namespace {2}",
							next.getLocalName(), next.getNamespaceURI());
			throw new ConstraintViolationException(msg);
		}
		Element ret = (Element) next;
		advance();
		return ret;
	}

	public Element getNonXliffElement() throws ConstraintViolationException {
		if (next == null) {
			String msg = "Expected non-XLIFF element, but found no further element";
			throw new ConstraintViolationException(msg);
		}
		if (!(next instanceof Element)) {
			String msg = MessageFormat.format(
					"Expected non-XLIFF element, but found a node of type ''{0}''",
					next.getClass().getName());
			throw new ConstraintViolationException(msg);
		}
		if (Schemas.XLIFF_12_NAMESPACE.equals(next.getNamespaceURI())) {
			String msg = MessageFormat
					.format(
							"Expected non-XLIFF element, but found XLIFF element <{1}>",
							next.getLocalName());
			throw new ConstraintViolationException(msg);
		}
		Element ret = (Element) next;
		advance();
		return ret;
	}

	public Element getXliffElement(String localName)
			throws ConstraintViolationException {
		if (next == null) {
			String msg = MessageFormat
					.format(
							"Expected XLIFF element <{0}>, but found no further element",
							localName);
			throw new ConstraintViolationException(msg);
		}
		if (!(next instanceof Element)) {
			String msg = MessageFormat
					.format(
							"Expected XLIFF element <{0}>, but found a node of type ''{1}''",
							localName, next.getClass().getName());
			throw new ConstraintViolationException(msg);
		}
		if (!Schemas.XLIFF_12_NAMESPACE.equals(next.getNamespaceURI())) {
			String msg = MessageFormat
					.format(
							"Expected XLIFF element <{0}>, but found an element <{1}> of namespace {2}",
							localName, next.getLocalName(), next
									.getNamespaceURI());
			throw new ConstraintViolationException(msg);
		}
		if (!localName.equals(next.getLocalName())) {
			String msg = MessageFormat
					.format(
							"Expected XLIFF element <{0}>, but found XLIFF element <{1}>",
							localName, next.getLocalName());
			throw new ConstraintViolationException(msg);
		}
		Element ret = (Element) next;
		advance();
		return ret;
	}

	public void assertNoMoreNodes() throws ConstraintViolationException {
		if (next == null) {
			return;
		}
		if (next instanceof Text) {
			String msg = MessageFormat.format(
					"Expected no more nodes, but found text ''{0}''",
					((Text) next).getTextContent());
			throw new ConstraintViolationException(msg);
		}
		if (next instanceof Element) {
			String msg = MessageFormat.format(
					"Expected no more nodes, but found element <{0}>",
					next.getLocalName());
			throw new ConstraintViolationException(msg);
		}
		String msg = MessageFormat.format(
				"Expected no more nodes, but found a node of type ''{0}''",
				next.getClass().getName());
		throw new ConstraintViolationException(msg);
	}

	public Element getXliffElement(String... localNames)
			throws ConstraintViolationException {
		if (next == null) {
			String msg = MessageFormat
					.format(
							"Expected one of XLIFF elements {0}, but found no further element",
							createElementList(localNames));
			throw new ConstraintViolationException(msg);
		}
		if (!(next instanceof Element)) {
			String msg = MessageFormat
					.format(
							"Expected one of XLIFF elements {0}, but found a node of type ''{1}''",
							createElementList(localNames), next.getClass()
									.getName());
			throw new ConstraintViolationException(msg);
		}
		if (!Schemas.XLIFF_12_NAMESPACE.equals(next.getNamespaceURI())) {
			String msg = MessageFormat
					.format(
							"Expected one of XLIFF elements {0}, but found an element <{1}> of namespace {2}",
							createElementList(localNames), next.getLocalName(),
							next.getNamespaceURI());
			throw new ConstraintViolationException(msg);
		}
		boolean matchesName = false;
		String name = next.getLocalName();
		for (String localName : localNames) {
			if (localName.equals(name)) {
				matchesName = true;
				break;
			}
		}
		if (!matchesName) {
			String msg = MessageFormat
					.format(
							"Expected one of XLIFF element {0}, but found XLIFF element <{1}>",
							createElementList(localNames), next.getLocalName());
			throw new ConstraintViolationException(msg);
		}
		Element ret = (Element) next;
		advance();
		return ret;
	}

	private String createElementList(String... localNames) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < localNames.length; ++i) {
			if (i > 0) {
				sb.append(", ");
			}
			sb.append('<');
			sb.append(localNames[i]);
			sb.append('>');
		}
		return sb.toString();
	}

	private void advance() {
		while (pos < nodes.size()) {
			next = nodes.get(pos++);
			if (ignoreWhitespaceText && next instanceof Text) {
				Text text = (Text) next;
				if (isWhitespace(text.getTextContent())) {
					continue;
				}
			}
			if (next instanceof Element || next instanceof Text) {
				return;
			}
		}
		next = null;
	}

	private boolean isWhitespace(String s) {
		int l = s.length();
		for (int i = 0; i < l; ++i) {
			if (!isWhitespace(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	private boolean isWhitespace(char ch) {
		switch (ch) {
		case ' ':
		case '\t':
		case '\r':
		case '\n':
			return true;
		}
		return false;
	}
}
