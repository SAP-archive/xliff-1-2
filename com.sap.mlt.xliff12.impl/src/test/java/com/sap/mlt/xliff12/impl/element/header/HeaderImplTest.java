package com.sap.mlt.xliff12.impl.element.header;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.CountType;
import com.sap.mlt.xliff12.api.base.Attribute;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.element.header.Header;
import com.sap.mlt.xliff12.api.element.header.Phase;
import com.sap.mlt.xliff12.api.element.namedgroup.Count;
import com.sap.mlt.xliff12.api.element.namedgroup.Prop;
import com.sap.mlt.xliff12.api.element.nonxliff.NonXliffElement;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.CountTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.NameImpl;
import com.sap.mlt.xliff12.impl.attribute.PhaseNameImpl;
import com.sap.mlt.xliff12.impl.attribute.ProcessNameImpl;
import com.sap.mlt.xliff12.impl.attribute.PropTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.ToolIdImpl;
import com.sap.mlt.xliff12.impl.attribute.ToolNameImpl;
import com.sap.mlt.xliff12.impl.element.namedgroup.CountGroupImpl;
import com.sap.mlt.xliff12.impl.element.namedgroup.CountImpl;
import com.sap.mlt.xliff12.impl.element.namedgroup.PropGroupImpl;
import com.sap.mlt.xliff12.impl.element.namedgroup.PropImpl;
import com.sap.mlt.xliff12.impl.element.nonxliff.NonXliffElementImpl;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.test.util.Utils;

@SuppressWarnings("deprecation")
public class HeaderImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testHeaderImpl() {
		HeaderImpl header = new HeaderImpl();
		assertTrue(header.getChildren().isEmpty());
		assertTrue(header.getContext().isEmpty());
		assertTrue(header.getNonXliffElements().isEmpty());
		assertNull(header.getPhaseGroup());
		assertNull(header.getSkl());
	}

	@Test
	public void testHeaderImplElement() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "header");
		elem.appendChild(createDefaultSkl().asXmlNode(doc));
		elem.appendChild(createDefaultPhaseGroup().asXmlNode(doc));
		elem.appendChild(createDefaultGlossary().asXmlNode(doc));
		elem.appendChild(createDefaultReference().asXmlNode(doc));
		elem.appendChild(createDefaultCountGroup().asXmlNode(doc));
		elem.appendChild(createDefaultPropGroup().asXmlNode(doc));
		elem.appendChild(createDefaultNote().asXmlNode(doc));
		elem.appendChild(createDefaultTool().asXmlNode(doc));
		elem.appendChild(createDefaultNonXliffElement().asXmlNode(doc));

		try {
			HeaderImpl header = new HeaderImpl(elem);
			assertEquals(createDefaultSkl(), header.getSkl());
			assertEquals(createDefaultPhaseGroup(), header.getPhaseGroup());

			List<? extends Header.Context> context = header.getContext();
			assertTrue(context.contains(createDefaultGlossary()));
			assertTrue(context.contains(createDefaultReference()));
			assertTrue(context.contains(createDefaultCountGroup()));
			assertTrue(context.contains(createDefaultPropGroup()));
			assertTrue(context.contains(createDefaultNote()));
			assertTrue(context.contains(createDefaultTool()));
			assertEquals(new Integer(6), new Integer(context.size()));

			List<NonXliffElement> nxes = header.getNonXliffElements();
			assertTrue(nxes.contains(createDefaultNonXliffElement()));
			assertEquals(new Integer(1), new Integer(nxes.size()));
		} catch (ConstraintViolationException e) {
			//$JL-EXC$			
			fail("Did not expect ConstraintViolationException");
		}

		// XLIFF-element after non-XLIFF elements
		elem.appendChild(createDefaultNote().asXmlNode(doc));
		try {
			new HeaderImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			elem.removeChild(elem.getLastChild());
		}

		// Two skls
		elem.insertBefore(createDefaultSkl().asXmlNode(doc), elem
				.getFirstChild());
		try {
			new HeaderImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			elem.removeChild(elem.getFirstChild());
		}

		// Two phase-groups
		elem.insertBefore(createDefaultPhaseGroup().asXmlNode(doc), elem
				.getFirstChild());
		try {
			new HeaderImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			elem.removeChild(elem.getFirstChild());
		}

		// Forbidden XLIFF element
		elem.insertBefore(new InternalFileImpl(new TextImpl("abc"))
				.asXmlNode(doc), elem.getFirstChild());
		try {
			new HeaderImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			elem.removeChild(elem.getFirstChild());
		}
	}

	@Test
	public void testGetChildren() {
		HeaderImpl header = new HeaderImpl();
		header.setSkl(createDefaultSkl());
		header.setPhaseGroup(createDefaultPhaseGroup());

		ArrayList<Header.Context> context = new ArrayList<Header.Context>();
		context.add(createDefaultGlossary());
		context.add(createDefaultReference());
		context.add(createDefaultCountGroup());
		context.add(createDefaultPropGroup());
		context.add(createDefaultNote());
		context.add(createDefaultTool());
		header.setContext(context);

		ArrayList<NonXliffElement> nxes = new ArrayList<NonXliffElement>();
		nxes.add(createDefaultNonXliffElement());
		header.setNonXliffElements(nxes);

		List<? extends com.sap.mlt.xliff12.api.base.Element> children = header
				.getChildren();
		assertEquals(new Integer(9), new Integer(children.size()));
	}
	
	@Test
	public void testPhaseGroup() {
		HeaderImpl header = new HeaderImpl();
		header.setPhaseGroup(createDefaultPhaseGroup());
		assertEquals(createDefaultPhaseGroup(), header.getPhaseGroup());
		header.setPhaseGroup(null);
		assertNull(header.getPhaseGroup());
	}
	
	@Test
	public void testSkl() {
		HeaderImpl header = new HeaderImpl();
		header.setSkl(createDefaultSkl());
		assertEquals(createDefaultSkl(), header.getSkl());
		header.setSkl(null);
		assertNull(header.getSkl());
	}
	
	@Test
	public void testContext() {
		HeaderImpl header = new HeaderImpl();
		
		ArrayList<Header.Context> context = new ArrayList<Header.Context>();
		context.add(createDefaultReference());
		context.add(createDefaultGlossary());
		header.setContext(context);
		
		assertEquals(context, header.getContext());
	}

	@Test
	public void testNonXliffElements() {
		HeaderImpl header = new HeaderImpl();
		
		ArrayList<Attribute> attributes = new ArrayList<Attribute>();
		ArrayList<Node> children = new ArrayList<Node>();
		
		ArrayList<NonXliffElement> nxes = new ArrayList<NonXliffElement>();
		nxes.add(new NonXliffElementImpl("ns", "pre", "name", attributes, children));
		nxes.add(new NonXliffElementImpl("ns2", null, "name", attributes, children));
		header.setNonXliffElements(nxes);
		assertEquals(nxes, header.getNonXliffElements());
		
		nxes = new ArrayList<NonXliffElement>();
		nxes.add(new NonXliffElementImpl("ns", "pre", "name", attributes, children));
		nxes.add(new NonXliffElementImpl("ns2", null, "name", attributes, children));
		nxes.add(new NonXliffElementImpl("ns2", null, "name", attributes, children));
		header.setNonXliffElements(nxes);
		assertEquals(nxes, header.getNonXliffElements());
	}
	
	@Test
	public void testClone() {
		HeaderImpl header = new HeaderImpl();
		header.setSkl(createDefaultSkl());
		header.setPhaseGroup(createDefaultPhaseGroup());

		ArrayList<Header.Context> context = new ArrayList<Header.Context>();
		context.add(createDefaultGlossary());
		context.add(createDefaultReference());
		context.add(createDefaultCountGroup());
		context.add(createDefaultPropGroup());
		context.add(createDefaultNote());
		context.add(createDefaultTool());
		header.setContext(context);

		ArrayList<NonXliffElement> nxes = new ArrayList<NonXliffElement>();
		nxes.add(createDefaultNonXliffElement());
		header.setNonXliffElements(nxes);

		HeaderImpl clone = (HeaderImpl) header.clone();
		assertEquals(header, clone);
		assertNotSame(header, clone);
	}
	
	private SklImpl createDefaultSkl() {
		return new SklImpl(new InternalFileImpl(new TextImpl("abc")));
	}

	private PhaseGroupImpl createDefaultPhaseGroup() {
		List<Phase> phases = new ArrayList<Phase>();
		phases.add(new PhaseImpl(new PhaseNameImpl("pn"), new ProcessNameImpl(
				"procn")));
		return new PhaseGroupImpl(phases);
	}

	private GlossaryImpl createDefaultGlossary() {
		return new GlossaryImpl(new InternalFileImpl(new TextImpl("abc")));
	}

	private ReferenceImpl createDefaultReference() {
		return new ReferenceImpl(new InternalFileImpl(new TextImpl("abc")));
	}

	private CountGroupImpl createDefaultCountGroup() {
		ArrayList<Count> counts = new ArrayList<Count>();
		counts.add(new CountImpl(new CountTypeImpl(CountType.Value.C),
				new TextImpl("3")));
		return new CountGroupImpl(new NameImpl("cg"), counts);
	}

	private PropGroupImpl createDefaultPropGroup() {
		ArrayList<Prop> props = new ArrayList<Prop>();
		props.add(new PropImpl(new PropTypeImpl("pt"), new TextImpl("abc")));
		return new PropGroupImpl(props);
	}

	private NoteImpl createDefaultNote() {
		return new NoteImpl(new TextImpl("note"));
	}

	private ToolImpl createDefaultTool() {
		return new ToolImpl(new ToolIdImpl("1"), new ToolNameImpl("tn"));
	}

	private NonXliffElementImpl createDefaultNonXliffElement() {
		ArrayList<Attribute> attributes = new ArrayList<Attribute>();
		ArrayList<Node> children = new ArrayList<Node>();
		return new NonXliffElementImpl("ns", "pre", "name", attributes,
				children);
	}

}
