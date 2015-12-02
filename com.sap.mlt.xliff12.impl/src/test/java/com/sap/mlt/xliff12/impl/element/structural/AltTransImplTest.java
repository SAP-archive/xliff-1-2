package com.sap.mlt.xliff12.impl.element.structural;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.AltTransType;
import com.sap.mlt.xliff12.api.attribute.ContextType;
import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.api.attribute.XmlSpace;
import com.sap.mlt.xliff12.api.base.Attribute;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.base.TextFragment;
import com.sap.mlt.xliff12.api.element.namedgroup.Context;
import com.sap.mlt.xliff12.api.element.namedgroup.Prop;
import com.sap.mlt.xliff12.api.element.nonxliff.NonXliffElement;
import com.sap.mlt.xliff12.api.element.structural.AltTrans;
import com.sap.mlt.xliff12.api.element.structural.Target;
import com.sap.mlt.xliff12.api.element.structural.TransUnit;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.AltTransTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.ContextTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.CoordImpl;
import com.sap.mlt.xliff12.impl.attribute.CrcImpl;
import com.sap.mlt.xliff12.impl.attribute.CssStyleImpl;
import com.sap.mlt.xliff12.impl.attribute.DataTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.ExStyleImpl;
import com.sap.mlt.xliff12.impl.attribute.ExTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.ExtraDataImpl;
import com.sap.mlt.xliff12.impl.attribute.FontImpl;
import com.sap.mlt.xliff12.impl.attribute.HelpIdImpl;
import com.sap.mlt.xliff12.impl.attribute.MatchQualityImpl;
import com.sap.mlt.xliff12.impl.attribute.MenuImpl;
import com.sap.mlt.xliff12.impl.attribute.MenuNameImpl;
import com.sap.mlt.xliff12.impl.attribute.MenuOptionImpl;
import com.sap.mlt.xliff12.impl.attribute.MidImpl;
import com.sap.mlt.xliff12.impl.attribute.NonXliffAttributeImpl;
import com.sap.mlt.xliff12.impl.attribute.OriginImpl;
import com.sap.mlt.xliff12.impl.attribute.PhaseNameImpl;
import com.sap.mlt.xliff12.impl.attribute.PropTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.ResNameImpl;
import com.sap.mlt.xliff12.impl.attribute.ResTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.StyleImpl;
import com.sap.mlt.xliff12.impl.attribute.ToolIdImpl;
import com.sap.mlt.xliff12.impl.attribute.ToolImpl;
import com.sap.mlt.xliff12.impl.attribute.TsImpl;
import com.sap.mlt.xliff12.impl.attribute.XmlLangImpl;
import com.sap.mlt.xliff12.impl.attribute.XmlSpaceImpl;
import com.sap.mlt.xliff12.impl.element.header.NoteImpl;
import com.sap.mlt.xliff12.impl.element.namedgroup.ContextGroupImpl;
import com.sap.mlt.xliff12.impl.element.namedgroup.ContextImpl;
import com.sap.mlt.xliff12.impl.element.namedgroup.PropGroupImpl;
import com.sap.mlt.xliff12.impl.element.namedgroup.PropImpl;
import com.sap.mlt.xliff12.impl.element.nonxliff.NonXliffElementImpl;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.test.util.Utils;

@SuppressWarnings("deprecation")
public class AltTransImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testAltTransImplTarget() {
		AltTransImpl altTrans = createDefaultAltTrans();
		assertEquals(createDefaultTarget(), altTrans.getTarget());
		assertEquals(new XmlSpaceImpl(XmlSpace.Value.DEFAULT), altTrans
				.getXmlSpace());
		assertEquals(new AltTransTypeImpl(AltTransType.Value.PROPOSAL),
				altTrans.getAltTransType());
	}

	@Test
	public void testAltTransImplElement() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "alt-trans");

		try {
			new AltTransImpl(elem);
			fail("Expected ConstaintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}

		elem.appendChild(createDefaultTarget().asXmlNode(doc));

		try {
			AltTransImpl altTrans = new AltTransImpl(elem);
			assertEquals(createDefaultTarget(), altTrans.getTarget());
			assertEquals(new XmlSpaceImpl(XmlSpace.Value.DEFAULT), altTrans
					.getXmlSpace());
			assertEquals(new AltTransTypeImpl(AltTransType.Value.PROPOSAL),
					altTrans.getAltTransType());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		elem.appendChild(doc.createElementNS(XLIFF_12_NAMESPACE, "something"));
		try {
			new AltTransImpl(elem);
			fail("Expected ConstaintViolationException");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			elem.removeChild(elem.getLastChild());
		}

		elem.appendChild(createDefaultSegSource().asXmlNode(doc));
		elem.appendChild(createDefaultSegSource().asXmlNode(doc));
		try {
			new AltTransImpl(elem);
			fail("Expected ConstaintViolationException");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			elem.removeChild(elem.getLastChild());
		}

		elem.appendChild(createDefaultSource().asXmlNode(doc));
		elem.appendChild(createDefaultSource().asXmlNode(doc));
		try {
			new AltTransImpl(elem);
			fail("Expected ConstaintViolationException");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			elem.removeChild(elem.getLastChild());
		}

		elem.appendChild(createDefaultContextGroup().asXmlNode(doc));
		elem.appendChild(createDefaultPropGroup().asXmlNode(doc));
		elem.appendChild(createDefaultNote().asXmlNode(doc));
		elem.appendChild(createDefaultNonXliffElement().asXmlNode(doc));
		try {
			AltTransImpl altTrans = new AltTransImpl(elem);
			assertEquals(createDefaultSource(), altTrans.getSource());
			assertEquals(createDefaultSegSource(), altTrans.getSegSource());
			assertEquals(createDefaultTarget(), altTrans.getTarget());

			ArrayList<TransUnit.Context> context = new ArrayList<TransUnit.Context>();
			context.add(createDefaultContextGroup());
			context.add(createDefaultPropGroup());
			context.add(createDefaultNote());
			assertEquals(context, altTrans.getContext());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		elem.appendChild(createDefaultNote().asXmlNode(doc));
		try {
			new AltTransImpl(elem);
			fail("Expected ConstaintViolationException");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			elem.removeChild(elem.getLastChild());
		}
	}

	@Test
	public void testGetChildren() {
		AltTransImpl altTrans = createDefaultAltTrans();

		altTrans.setSegSource(createDefaultSegSource());
		altTrans.setSource(createDefaultSource());

		ArrayList<AltTrans.Context> context = new ArrayList<AltTrans.Context>();
		context.add(createDefaultContextGroup());
		context.add(createDefaultPropGroup());
		context.add(createDefaultNote());
		altTrans.setContext(context);

		ArrayList<NonXliffElement> nxes = new ArrayList<NonXliffElement>();
		nxes.add(createDefaultNonXliffElement());
		altTrans.setNonXliffElements(nxes);

		List<? extends Node> children = altTrans.getChildren();
		assertEquals(new Integer(7), new Integer(children.size()));
	}

	@Test
	public void testAltTransType() {
		AltTransImpl tu = createDefaultAltTrans();
		tu.setAltTransType(new AltTransTypeImpl("abc"));
		assertEquals(new AltTransTypeImpl("abc"), tu.getAltTransType());
		tu.setAltTransType(null);
		assertEquals(new AltTransTypeImpl(AltTransType.Value.PROPOSAL), tu
				.getAltTransType());
	}

	@Test
	public void testContext() {
		AltTransImpl altTrans = createDefaultAltTrans();
		ArrayList<AltTrans.Context> context = new ArrayList<AltTrans.Context>();
		context.add(createDefaultContextGroup());
		context.add(createDefaultPropGroup());
		context.add(createDefaultNote());
		altTrans.setContext(context);
		assertEquals(context, altTrans.getContext());
		altTrans.setContext(new ArrayList<AltTrans.Context>());
		assertEquals(new ArrayList<AltTrans.Context>(), altTrans.getContext());
	}

	@Test
	public void testCoord() {
		AltTransImpl altTrans = createDefaultAltTrans();
		altTrans.setCoord(new CoordImpl(1, 2, 3, 4));
		assertEquals(new CoordImpl(1, 2, 3, 4), altTrans.getCoord());
		altTrans.setCoord(null);
		assertNull(altTrans.getCoord());
	}

	@Test
	public void testCrc() {
		AltTransImpl altTrans = createDefaultAltTrans();
		altTrans.setCrc(new CrcImpl("125"));
		assertEquals(new CrcImpl("125"), altTrans.getCrc());
		altTrans.setCrc(null);
		assertNull(altTrans.getCrc());
	}

	@Test
	public void testCssStyle() {
		AltTransImpl altTrans = createDefaultAltTrans();
		altTrans.setCssStyle(new CssStyleImpl("abc"));
		assertEquals(new CssStyleImpl("abc"), altTrans.getCssStyle());
		altTrans.setCssStyle(null);
		assertNull(altTrans.getCssStyle());
	}

	@Test
	public void testDataType() {
		AltTransImpl altTrans = createDefaultAltTrans();
		altTrans.setDataType(new DataTypeImpl("abc"));
		assertEquals(new DataTypeImpl("abc"), altTrans.getDataType());
		altTrans.setDataType(null);
		assertNull(altTrans.getDataType());
	}

	@Test
	public void testExStyle() {
		AltTransImpl altTrans = createDefaultAltTrans();
		altTrans.setExStyle(new ExStyleImpl("abc"));
		assertEquals(new ExStyleImpl("abc"), altTrans.getExStyle());
		altTrans.setExStyle(null);
		assertNull(altTrans.getExStyle());
	}

	@Test
	public void testExType() {
		AltTransImpl altTrans = createDefaultAltTrans();
		altTrans.setExType(new ExTypeImpl("abc"));
		assertEquals(new ExTypeImpl("abc"), altTrans.getExType());
		altTrans.setExType(null);
		assertNull(altTrans.getExType());
	}

	@Test
	public void testExtraData() {
		AltTransImpl altTrans = createDefaultAltTrans();
		altTrans.setExtraData(new ExtraDataImpl("abc"));
		assertEquals(new ExtraDataImpl("abc"), altTrans.getExtraData());
		altTrans.setExtraData(null);
		assertNull(altTrans.getExtraData());
	}

	@Test
	public void testFont() {
		AltTransImpl altTrans = createDefaultAltTrans();
		altTrans.setFont(new FontImpl("abc"));
		assertEquals(new FontImpl("abc"), altTrans.getFont());
		altTrans.setFont(null);
		assertNull(altTrans.getFont());
	}

	@Test
	public void testHelpId() {
		AltTransImpl altTrans = createDefaultAltTrans();
		altTrans.setHelpId(new HelpIdImpl("abc"));
		assertEquals(new HelpIdImpl("abc"), altTrans.getHelpId());
		altTrans.setHelpId(null);
		assertNull(altTrans.getHelpId());
	}

	@Test
	public void testMatchQuality() {
		AltTransImpl altTrans = createDefaultAltTrans();
		altTrans.setMatchQuality(new MatchQualityImpl("98%"));
		assertEquals(new MatchQualityImpl("98%"), altTrans.getMatchQuality());
		altTrans.setMatchQuality(null);
		assertNull(altTrans.getMatchQuality());
	}

	@Test
	public void testMenu() {
		AltTransImpl altTrans = createDefaultAltTrans();
		altTrans.setMenu(new MenuImpl("abc"));
		assertEquals(new MenuImpl("abc"), altTrans.getMenu());
		altTrans.setMenu(null);
		assertNull(altTrans.getMenu());
	}

	@Test
	public void testMenuName() {
		AltTransImpl altTrans = createDefaultAltTrans();
		altTrans.setMenuName(new MenuNameImpl("abc"));
		assertEquals(new MenuNameImpl("abc"), altTrans.getMenuName());
		altTrans.setMenuName(null);
		assertNull(altTrans.getMenuName());
	}

	@Test
	public void testMenuOption() {
		AltTransImpl altTrans = createDefaultAltTrans();
		altTrans.setMenuOption(new MenuOptionImpl("abc"));
		assertEquals(new MenuOptionImpl("abc"), altTrans.getMenuOption());
		altTrans.setMenuOption(null);
		assertNull(altTrans.getMenuOption());
	}

	@Test
	public void testMid() {
		AltTransImpl altTrans = createDefaultAltTrans();
		altTrans.setMid(new MidImpl("abc"));
		assertEquals(new MidImpl("abc"), altTrans.getMid());
		altTrans.setMid(null);
		assertNull(altTrans.getMid());
	}


	@Test
	public void testNonXliffAttributes() {
		AltTransImpl altTrans = createDefaultAltTrans();
		Collection<NonXliffAttribute> nonXliffAttributes = altTrans
				.getNonXliffAttributes();
		assertTrue(nonXliffAttributes.isEmpty());

		ArrayList<NonXliffAttribute> nxas = new ArrayList<NonXliffAttribute>();
		nxas.add(new NonXliffAttributeImpl("ns", "pre", "name", "value"));
		nxas.add(new NonXliffAttributeImpl("ns", "pre", "name2", "value2"));
		altTrans.setNonXliffAttributes(nxas);

		nonXliffAttributes = altTrans.getNonXliffAttributes();
		assertEquals(new Integer(2), new Integer(nonXliffAttributes.size()));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns",
				"pre", "name", "value")));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns",
				"pre", "name2", "value2")));

		nxas.clear();
		nxas.add(new NonXliffAttributeImpl("ns", "pre", "name2", "value2"));
		nxas.add(new NonXliffAttributeImpl("ns2", "pre", "name2", "value2"));
		altTrans.setNonXliffAttributes(nxas);

		nonXliffAttributes = altTrans.getNonXliffAttributes();
		assertEquals(new Integer(2), new Integer(nonXliffAttributes.size()));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns",
				"pre", "name2", "value2")));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns2",
				"pre", "name2", "value2")));

		nxas.clear();
		altTrans.setNonXliffAttributes(nxas);
		nonXliffAttributes = altTrans.getNonXliffAttributes();
		assertTrue(nonXliffAttributes.isEmpty());
	}
	
	@Test
	public void testNonXliffElements() {
		AltTransImpl altTrans = createDefaultAltTrans();
		
		ArrayList<Attribute> attributes = new ArrayList<Attribute>();
		ArrayList<Node> children = new ArrayList<Node>();
		
		ArrayList<NonXliffElement> nxes = new ArrayList<NonXliffElement>();
		nxes.add(new NonXliffElementImpl("ns", "pre", "name", attributes, children));
		nxes.add(new NonXliffElementImpl("ns2", null, "name", attributes, children));
		altTrans.setNonXliffElements(nxes);
		assertEquals(nxes, altTrans.getNonXliffElements());
		
		nxes = new ArrayList<NonXliffElement>();
		nxes.add(new NonXliffElementImpl("ns", "pre", "name", attributes, children));
		nxes.add(new NonXliffElementImpl("ns2", null, "name", attributes, children));
		nxes.add(new NonXliffElementImpl("ns2", null, "name", attributes, children));
		altTrans.setNonXliffElements(nxes);
		assertEquals(nxes, altTrans.getNonXliffElements());
	}

	@Test
	public void testOrigin() {
		AltTransImpl altTrans = createDefaultAltTrans();
		altTrans.setOrigin(new OriginImpl("abc"));
		assertEquals(new OriginImpl("abc"), altTrans.getOrigin());
		altTrans.setOrigin(null);
		assertNull(altTrans.getOrigin());
	}

	@Test
	public void testPhaseName() {
		AltTransImpl altTrans = createDefaultAltTrans();
		altTrans.setPhaseName(new PhaseNameImpl("abc"));
		assertEquals(new PhaseNameImpl("abc"), altTrans.getPhaseName());
		altTrans.setPhaseName(null);
		assertNull(altTrans.getPhaseName());
	}

	@Test
	public void testResName() {
		AltTransImpl altTrans = createDefaultAltTrans();
		altTrans.setResName(new ResNameImpl("abc"));
		assertEquals(new ResNameImpl("abc"), altTrans.getResName());
		altTrans.setResName(null);
		assertNull(altTrans.getResName());
	}

	@Test
	public void testResType() {
		AltTransImpl altTrans = createDefaultAltTrans();
		altTrans.setResType(new ResTypeImpl("abc"));
		assertEquals(new ResTypeImpl("abc"), altTrans.getResType());
		altTrans.setResType(null);
		assertNull(altTrans.getResType());
	}

	@Test
	public void testSegSource() {
		AltTransImpl altTrans = createDefaultAltTrans();
		altTrans.setSegSource(createDefaultSegSource());
		assertEquals(createDefaultSegSource(), altTrans.getSegSource());
		altTrans.setSegSource(null);
		assertNull(altTrans.getSegSource());
	}


	@Test
	public void testSource() {
		AltTransImpl tu = createDefaultAltTrans();
		tu.setSource(createDefaultSource());
		assertEquals(createDefaultSource(), tu.getSource());
		tu.setSource(null);
		assertNull(tu.getSource());
	}

	@Test
	public void testStyle() {
		AltTransImpl altTrans = createDefaultAltTrans();
		altTrans.setStyle(new StyleImpl("abc"));
		assertEquals(new StyleImpl("abc"), altTrans.getStyle());
		altTrans.setStyle(null);
		assertNull(altTrans.getStyle());
	}

	@Test
	public void testTarget() {
		AltTransImpl altTrans = createDefaultAltTrans();
		try {
			altTrans.setTarget(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
		assertEquals(createDefaultTarget(), altTrans.getTarget());
		
		TargetImpl target = new TargetImpl(new ArrayList<TextFragment>());
		altTrans.setTarget(target);
		assertEquals(target, altTrans.getTarget());
	}

	@Test
	public void testTargets() {
		AltTransImpl altTrans = createDefaultAltTrans();
		ArrayList<Target> targets = new ArrayList<Target>();
		try {
			altTrans.setTargets(targets);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
		targets.add(createDefaultTarget());
		altTrans.setTargets(targets);
		assertEquals(targets, altTrans.getTargets());
		targets.add(createDefaultTarget());
		altTrans.setTargets(targets);
		assertEquals(targets, altTrans.getTargets());
	}

	@Test
	public void testTool() {
		AltTransImpl altTrans = createDefaultAltTrans();
		altTrans.setTool(new ToolImpl("abc"));
		assertEquals(new ToolImpl("abc"), altTrans.getTool());
		altTrans.setTool(null);
		assertNull(altTrans.getTool());
	}

	@Test
	public void testToolId() {
		AltTransImpl altTrans = createDefaultAltTrans();
		altTrans.setToolId(new ToolIdImpl("abc"));
		assertEquals(new ToolIdImpl("abc"), altTrans.getToolId());
		altTrans.setToolId(null);
		assertNull(altTrans.getToolId());
	}

	@Test
	public void testTs() {
		AltTransImpl altTrans = createDefaultAltTrans();
		altTrans.setTs(new TsImpl("abc"));
		assertEquals(new TsImpl("abc"), altTrans.getTs());
		altTrans.setTs(null);
		assertNull(altTrans.getTs());
	}

	@Test
	public void testXmlLang() {
		AltTransImpl altTrans = createDefaultAltTrans();
		altTrans.setXmlLang(new XmlLangImpl("de-CH"));
		assertEquals(new XmlLangImpl("de-CH"), altTrans.getXmlLang());
		altTrans.setXmlLang(null);
		assertNull(altTrans.getXmlLang());
	}

	@Test
	public void testXmlSpace() {
		AltTransImpl altTrans = createDefaultAltTrans();
		altTrans.setXmlSpace(new XmlSpaceImpl(XmlSpace.Value.PRESERVE));
		assertEquals(new XmlSpaceImpl(XmlSpace.Value.PRESERVE), altTrans.getXmlSpace());
		altTrans.setXmlSpace(null);
		assertEquals(new XmlSpaceImpl(XmlSpace.Value.DEFAULT), altTrans.getXmlSpace());
	}
	
	@Test
	public void testClone() {
		AltTransImpl altTrans = createDefaultAltTrans();
		
		altTrans.setSegSource(createDefaultSegSource());
		altTrans.setSource(createDefaultSource());

		ArrayList<AltTrans.Context> context = new ArrayList<AltTrans.Context>();
		context.add(createDefaultContextGroup());
		context.add(createDefaultPropGroup());
		context.add(createDefaultNote());
		altTrans.setContext(context);

		ArrayList<NonXliffElement> nxes = new ArrayList<NonXliffElement>();
		nxes.add(createDefaultNonXliffElement());
		altTrans.setNonXliffElements(nxes);

		AltTransImpl clone = (AltTransImpl) altTrans.clone();
		assertEquals(altTrans, clone);
		assertNotSame(altTrans, clone);
	}

	private AltTransImpl createDefaultAltTrans() {
		AltTransImpl altTrans = new AltTransImpl(createDefaultTarget());
		return altTrans;
	}

	private SourceImpl createDefaultSource() {
		List<TextFragment> texts = new ArrayList<TextFragment>();
		texts.add(new TextImpl("source"));
		SourceImpl source = new SourceImpl(texts);
		return source;
	}

	private SegSourceImpl createDefaultSegSource() {
		List<TextFragment> texts = new ArrayList<TextFragment>();
		texts.add(new TextImpl("source"));
		SegSourceImpl segSource = new SegSourceImpl(texts);
		return segSource;
	}

	private TargetImpl createDefaultTarget() {
		List<TextFragment> texts = new ArrayList<TextFragment>();
		texts.add(new TextImpl("target"));
		TargetImpl target = new TargetImpl(texts);
		return target;
	}

	private ContextGroupImpl createDefaultContextGroup() {
		ContextGroupImpl contextGroup = new ContextGroupImpl(
				createDefaultContexts());
		return contextGroup;
	}

	private ArrayList<Context> createDefaultContexts() {
		ArrayList<Context> contexts = new ArrayList<Context>();
		contexts.add(createDefaultContext());
		return contexts;
	}

	private ContextImpl createDefaultContext() {
		ContextImpl context = new ContextImpl(new ContextTypeImpl(
				ContextType.Value.ELEMENT), new TextImpl("context"));
		return context;
	}

	private PropGroupImpl createDefaultPropGroup() {
		PropGroupImpl propGroup = new PropGroupImpl(createDefaultProps());
		return propGroup;
	}

	private ArrayList<Prop> createDefaultProps() {
		ArrayList<Prop> props = new ArrayList<Prop>();
		props.add(createDefaultProp());
		return props;
	}

	private PropImpl createDefaultProp() {
		PropImpl prop = new PropImpl(new PropTypeImpl("pt"), new TextImpl(
				"proval"));
		return prop;
	}

	private NoteImpl createDefaultNote() {
		return new NoteImpl(new TextImpl("test"));
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
}
