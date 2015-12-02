package com.sap.mlt.xliff12.impl.element.header;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.api.base.Attribute;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.NonXliffAttributeImpl;
import com.sap.mlt.xliff12.impl.attribute.ToolCompanyImpl;
import com.sap.mlt.xliff12.impl.attribute.ToolIdImpl;
import com.sap.mlt.xliff12.impl.attribute.ToolNameImpl;
import com.sap.mlt.xliff12.impl.attribute.ToolVersionImpl;
import com.sap.mlt.xliff12.impl.element.nonxliff.NonXliffElementImpl;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.test.util.Utils;

public class ToolImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testToolImplToolIdToolName() {
		ToolImpl tool = createDefaultTool();
		assertEquals(new ToolIdImpl("1"), tool.getToolId());
		assertEquals(new ToolNameImpl("toolname"), tool.getToolName());
	}

	@Test
	public void testToolImplElement() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "tool");
		elem.setAttributeNS(null, "tool-name", "toolname");
		elem.setAttributeNS(null, "tool-id", "1");
		try {
			ToolImpl tool = new ToolImpl(elem);
			assertEquals(new ToolIdImpl("1"), tool.getToolId());
			assertEquals(new ToolNameImpl("toolname"), tool.getToolName());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect a ConstraintViolationException");
		}

		elem.appendChild(doc.createElementNS("ns", "name"));
		elem.appendChild(doc.createTextNode("text"));
		try {
			ToolImpl tool = new ToolImpl(elem);
			assertEquals(new ToolIdImpl("1"), tool.getToolId());
			assertEquals(new ToolNameImpl("toolname"), tool.getToolName());
			List<? extends Node> children = tool.getChildren();
			assertEquals(new Integer(2), new Integer(children.size()));
			ArrayList<Attribute> emptyAttrs = new ArrayList<Attribute>();
			ArrayList<Node> emptyChildren = new ArrayList<Node>();
			assertEquals(new NonXliffElementImpl("ns", null, "name",
					emptyAttrs, emptyChildren), children.get(0));
			assertEquals(new TextImpl("text"), children.get(1));
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect a ConstraintViolationException");
		}

		elem.appendChild(doc.createElementNS(XLIFF_12_NAMESPACE, "something"));
		try {
			new ToolImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
	}

	@Test
	public void testChildren() {
		ToolImpl tool = createDefaultTool();
		assertTrue(tool.getChildren().isEmpty());

		ArrayList<Attribute> emptyAttrs = new ArrayList<Attribute>();
		ArrayList<Node> emptyChildren = new ArrayList<Node>();
		ArrayList<Node> children = new ArrayList<Node>();
		children.add(new NonXliffElementImpl("ns", null, "name", emptyAttrs,
				emptyChildren));
		children.add(new TextImpl("text"));
		tool.setChildren(children);

		List<? extends Node> echildren = tool.getChildren();
		assertEquals(new Integer(2), new Integer(echildren.size()));
		assertEquals(new NonXliffElementImpl("ns", null, "name", emptyAttrs,
				emptyChildren), echildren.get(0));
		assertEquals(new TextImpl("text"), echildren.get(1));

		tool.setChildren(new ArrayList<Node>());
		assertTrue(tool.getChildren().isEmpty());
	}

	@Test
	public void testNonXliffAttributes() {
		ToolImpl tool = createDefaultTool();
		Collection<NonXliffAttribute> nonXliffAttributes = tool
				.getNonXliffAttributes();
		assertTrue(nonXliffAttributes.isEmpty());

		ArrayList<NonXliffAttribute> nxas = new ArrayList<NonXliffAttribute>();
		nxas.add(new NonXliffAttributeImpl("ns", "pre", "name", "value"));
		nxas.add(new NonXliffAttributeImpl("ns", "pre", "name2", "value2"));
		tool.setNonXliffAttributes(nxas);

		nonXliffAttributes = tool.getNonXliffAttributes();
		assertEquals(new Integer(2), new Integer(nonXliffAttributes.size()));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns",
				"pre", "name", "value")));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns",
				"pre", "name2", "value2")));

		nxas.clear();
		nxas.add(new NonXliffAttributeImpl("ns", "pre", "name2", "value2"));
		nxas.add(new NonXliffAttributeImpl("ns2", "pre", "name2", "value2"));
		tool.setNonXliffAttributes(nxas);

		nonXliffAttributes = tool.getNonXliffAttributes();
		assertEquals(new Integer(2), new Integer(nonXliffAttributes.size()));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns",
				"pre", "name2", "value2")));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns2",
				"pre", "name2", "value2")));

		nxas.clear();
		tool.setNonXliffAttributes(nxas);
		nonXliffAttributes = tool.getNonXliffAttributes();
		assertTrue(nonXliffAttributes.isEmpty());
	}

	@Test
	public void testToolCompany() {
		ToolImpl tool = createDefaultTool();
		assertNull(tool.getToolCompany());

		tool.setToolCompany(new ToolCompanyImpl("abc"));
		assertEquals(new ToolCompanyImpl("abc"), tool.getToolCompany());

		tool.setToolCompany(null);
		assertNull(tool.getToolCompany());
	}

	@Test
	public void testToolId() {
		ToolImpl tool = createDefaultTool();

		tool.setToolId(new ToolIdImpl("abc"));
		assertEquals(new ToolIdImpl("abc"), tool.getToolId());

		try {
			tool.setToolId(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
		assertEquals(new ToolIdImpl("abc"), tool.getToolId());
	}

	@Test
	public void testToolName() {
		ToolImpl tool = createDefaultTool();

		tool.setToolName(new ToolNameImpl("abc"));
		assertEquals(new ToolNameImpl("abc"), tool.getToolName());

		try {
			tool.setToolName(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
		assertEquals(new ToolNameImpl("abc"), tool.getToolName());
	}

	@Test
	public void testVersion() {
		ToolImpl tool = createDefaultTool();
		assertNull(tool.getToolVersion());

		tool.setToolVersion(new ToolVersionImpl("abc"));
		assertEquals(new ToolVersionImpl("abc"), tool.getToolVersion());

		tool.setToolVersion(null);
		assertNull(tool.getToolVersion());
	}
	
	@Test
	public void testClone() {
		ToolImpl tool = createDefaultTool();
		ArrayList<Attribute> emptyAttrs = new ArrayList<Attribute>();
		ArrayList<Node> emptyChildren = new ArrayList<Node>();
		ArrayList<Node> children = new ArrayList<Node>();
		children.add(new NonXliffElementImpl("ns", null, "name", emptyAttrs,
				emptyChildren));
		children.add(new TextImpl("text"));
		tool.setChildren(children);
		ToolImpl clone = (ToolImpl) tool.clone();
		assertEquals(tool, clone);
		assertNotSame(tool, clone);
	}

	private ToolImpl createDefaultTool() {
		ToolImpl tool = new ToolImpl(new ToolIdImpl("1"), new ToolNameImpl(
				"toolname"));
		return tool;
	}

}
