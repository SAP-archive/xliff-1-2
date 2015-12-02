package com.sap.mlt.xliff12.impl.element.nonxliff;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.base.Attribute;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.NonXliffAttributeImpl;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.test.util.Utils;

public class NonXliffElementImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testNonXliffElementImplStringStringStringCollectionOfQextendsAttributeListOfQextendsNode() {
		NonXliffElementImpl nxe = createDefaultNonXliffElement();
		Collection<? extends Attribute> attrs = nxe.getAttributes();
		Collection<Attribute> expected = createDefaultAttributes();
		assertEquals(new Integer(attrs.size()), new Integer(expected.size()));
		assertEquals(expected.iterator().next(), attrs.iterator().next());

		try {
			new NonXliffElementImpl(XLIFF_12_NAMESPACE, null, "name",
					createDefaultAttributes(), createDefaultChildren());
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
	}

	@Test
	public void testNonXliffElementImplElement() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "name");
		try {
			new NonXliffElementImpl(elem);
			fail("Expected ConstaintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}

		elem = doc.createElementNS("ns", "name");
		elem.appendChild(doc.createElementNS("ns", "something"));
		elem.appendChild(doc.createTextNode("text"));
		try {
			NonXliffElementImpl nxe = new NonXliffElementImpl(elem);
			List<? extends Node> children = nxe.getChildren();
			assertEquals(new Integer(2), new Integer(children.size()));
			NonXliffElementImpl c1 = new NonXliffElementImpl("ns", null,
					"something", createEmptyAttributes(), createEmptyChildren());
			assertEquals(c1, children.get(0));
			assertEquals(new TextImpl("text"), children.get(1));
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstaintViolationException");
		}
	}

	@Test
	public void testGetChildren() {
		NonXliffElementImpl nxe = createDefaultNonXliffElement();
		assertEquals(createDefaultChildren(), nxe.getChildren());
	}

	@Test
	public void testClone() {
		NonXliffElementImpl nxe = createDefaultNonXliffElement();
		NonXliffElementImpl clone = (NonXliffElementImpl) nxe.clone();
		assertEquals(nxe, clone);
		assertNotSame(nxe, clone);
	}

	private NonXliffElementImpl createDefaultNonXliffElement() {
		Collection<Attribute> attributes = createDefaultAttributes();
		List<Node> children = createDefaultChildren();
		NonXliffElementImpl nxe = new NonXliffElementImpl("ns", null, "name",
				attributes, children);
		return nxe;
	}

	private Collection<Attribute> createDefaultAttributes() {
		ArrayList<Attribute> attributes = new ArrayList<Attribute>();
		attributes.add(new NonXliffAttributeImpl("ns", null, "name", "value"));
		return attributes;
	}

	private List<Node> createDefaultChildren() {
		ArrayList<Node> children = new ArrayList<Node>();
		children.add(new TextImpl("abc"));
		return children;
	}

	private List<Attribute> createEmptyAttributes() {
		return new ArrayList<Attribute>();
	}

	private List<Node> createEmptyChildren() {
		return new ArrayList<Node>();
	}

}
