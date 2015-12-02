package com.sap.mlt.xliff12.impl.element.structural;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.Approved;
import com.sap.mlt.xliff12.api.attribute.ContextType;
import com.sap.mlt.xliff12.api.attribute.CountType;
import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.api.attribute.SizeUnit;
import com.sap.mlt.xliff12.api.attribute.Translate;
import com.sap.mlt.xliff12.api.attribute.XmlSpace;
import com.sap.mlt.xliff12.api.base.Attribute;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.base.TextFragment;
import com.sap.mlt.xliff12.api.element.namedgroup.Context;
import com.sap.mlt.xliff12.api.element.namedgroup.Count;
import com.sap.mlt.xliff12.api.element.namedgroup.Prop;
import com.sap.mlt.xliff12.api.element.nonxliff.NonXliffElement;
import com.sap.mlt.xliff12.api.element.structural.TransUnit;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.ApprovedImpl;
import com.sap.mlt.xliff12.impl.attribute.CharClassImpl;
import com.sap.mlt.xliff12.impl.attribute.ContextTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.CoordImpl;
import com.sap.mlt.xliff12.impl.attribute.CountTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.CssStyleImpl;
import com.sap.mlt.xliff12.impl.attribute.DataTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.ExStyleImpl;
import com.sap.mlt.xliff12.impl.attribute.ExTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.ExtraDataImpl;
import com.sap.mlt.xliff12.impl.attribute.FontImpl;
import com.sap.mlt.xliff12.impl.attribute.HelpIdImpl;
import com.sap.mlt.xliff12.impl.attribute.IdImpl;
import com.sap.mlt.xliff12.impl.attribute.MaxBytesImpl;
import com.sap.mlt.xliff12.impl.attribute.MaxHeightImpl;
import com.sap.mlt.xliff12.impl.attribute.MaxWidthImpl;
import com.sap.mlt.xliff12.impl.attribute.MenuImpl;
import com.sap.mlt.xliff12.impl.attribute.MenuNameImpl;
import com.sap.mlt.xliff12.impl.attribute.MenuOptionImpl;
import com.sap.mlt.xliff12.impl.attribute.MinBytesImpl;
import com.sap.mlt.xliff12.impl.attribute.MinHeightImpl;
import com.sap.mlt.xliff12.impl.attribute.MinWidthImpl;
import com.sap.mlt.xliff12.impl.attribute.NameImpl;
import com.sap.mlt.xliff12.impl.attribute.NonXliffAttributeImpl;
import com.sap.mlt.xliff12.impl.attribute.PhaseNameImpl;
import com.sap.mlt.xliff12.impl.attribute.PropTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.ReformatYesNoImpl;
import com.sap.mlt.xliff12.impl.attribute.ResNameImpl;
import com.sap.mlt.xliff12.impl.attribute.ResTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.SizeUnitImpl;
import com.sap.mlt.xliff12.impl.attribute.StyleImpl;
import com.sap.mlt.xliff12.impl.attribute.TranslateImpl;
import com.sap.mlt.xliff12.impl.attribute.TsImpl;
import com.sap.mlt.xliff12.impl.attribute.XmlSpaceImpl;
import com.sap.mlt.xliff12.impl.element.header.NoteImpl;
import com.sap.mlt.xliff12.impl.element.namedgroup.ContextGroupImpl;
import com.sap.mlt.xliff12.impl.element.namedgroup.ContextImpl;
import com.sap.mlt.xliff12.impl.element.namedgroup.CountGroupImpl;
import com.sap.mlt.xliff12.impl.element.namedgroup.CountImpl;
import com.sap.mlt.xliff12.impl.element.namedgroup.PropGroupImpl;
import com.sap.mlt.xliff12.impl.element.namedgroup.PropImpl;
import com.sap.mlt.xliff12.impl.element.nonxliff.NonXliffElementImpl;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.test.util.Utils;

@SuppressWarnings("deprecation")
public class TransUnitImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testTransUnitImplIdSource() {
		TransUnitImpl tu = createDefaultTransUnit();
		assertEquals(new IdImpl("1"), tu.getId());
		assertEquals(createDefaultSource(), tu.getSource());
		assertEquals(new TranslateImpl(Translate.Value.YES), tu.getTranslate());
		assertEquals(new XmlSpaceImpl(XmlSpace.Value.DEFAULT), tu.getXmlSpace());
		assertEquals(new SizeUnitImpl(SizeUnit.Value.PIXEL), tu.getSizeUnit());
		assertEquals(new ReformatYesNoImpl(true), tu.getReformat());
	}

	@Test
	public void testTransUnitImplElement() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "trans-unit");
		elem.setAttributeNS(null, "id", "1");

		try {
			new TransUnitImpl(elem);
			fail("Expected ConstaintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
		
		elem.appendChild(createDefaultSource().asXmlNode(doc));
		
		try {
			TransUnitImpl tu = new TransUnitImpl(elem);
			assertEquals(new IdImpl("1"), tu.getId());
			assertEquals(createDefaultSource(), tu.getSource());
			assertEquals(new TranslateImpl(Translate.Value.YES), tu.getTranslate());
			assertEquals(new XmlSpaceImpl(XmlSpace.Value.DEFAULT), tu.getXmlSpace());
			assertEquals(new SizeUnitImpl(SizeUnit.Value.PIXEL), tu.getSizeUnit());
			assertEquals(new ReformatYesNoImpl(true), tu.getReformat());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		
		elem.appendChild(createDefaultSource().asXmlNode(doc));
		try {
			new TransUnitImpl(elem);
			fail("Expected ConstaintViolationException");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			elem.removeChild(elem.getLastChild());
		}
		
		elem.appendChild(doc.createElementNS(XLIFF_12_NAMESPACE, "something"));
		try {
			new TransUnitImpl(elem);
			fail("Expected ConstaintViolationException");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			elem.removeChild(elem.getLastChild());
		}

		elem.appendChild(createDefaultSegSource().asXmlNode(doc));
		elem.appendChild(createDefaultSegSource().asXmlNode(doc));
		try {
			new TransUnitImpl(elem);
			fail("Expected ConstaintViolationException");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			elem.removeChild(elem.getLastChild());
		}
		
		elem.appendChild(createDefaultTarget().asXmlNode(doc));
		elem.appendChild(createDefaultTarget().asXmlNode(doc));
		try {
			new TransUnitImpl(elem);
			fail("Expected ConstaintViolationException");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			elem.removeChild(elem.getLastChild());
		}
		
		elem.appendChild(createDefaultContextGroup().asXmlNode(doc));
		elem.appendChild(createDefaultCountGroup().asXmlNode(doc));
		elem.appendChild(createDefaultPropGroup().asXmlNode(doc));
		elem.appendChild(createDefaultNote().asXmlNode(doc));
		elem.appendChild(createDefaultAltTrans().asXmlNode(doc));
		elem.appendChild(createDefaultNonXliffElement().asXmlNode(doc));
		try {
			TransUnitImpl tu = new TransUnitImpl(elem);
			assertEquals(new IdImpl("1"), tu.getId());
			assertEquals(createDefaultSource(), tu.getSource());
			assertEquals(createDefaultSegSource(), tu.getSegSource());
			assertEquals(createDefaultTarget(), tu.getTarget());
			
			ArrayList<TransUnit.Context> context = new ArrayList<TransUnit.Context>();
			context.add(createDefaultContextGroup());
			context.add(createDefaultCountGroup());
			context.add(createDefaultPropGroup());
			context.add(createDefaultNote());
			context.add(createDefaultAltTrans());
			assertEquals(context, tu.getContext());
			
			assertEquals(new TranslateImpl(Translate.Value.YES), tu.getTranslate());
			assertEquals(new XmlSpaceImpl(XmlSpace.Value.DEFAULT), tu.getXmlSpace());
			assertEquals(new SizeUnitImpl(SizeUnit.Value.PIXEL), tu.getSizeUnit());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
		
		elem.appendChild(createDefaultNote().asXmlNode(doc));
		try {
			new TransUnitImpl(elem);
			fail("Expected ConstaintViolationException");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			elem.removeChild(elem.getLastChild());
		}
		
	}

	@Test
	public void testGetChildren() {
		TransUnitImpl tu = createDefaultTransUnit();
		
		tu.setSegSource(createDefaultSegSource());
		tu.setTarget(createDefaultTarget());

		ArrayList<TransUnit.Context> context = new ArrayList<TransUnit.Context>();
		context.add(createDefaultContextGroup());
		context.add(createDefaultCountGroup());
		context.add(createDefaultPropGroup());
		context.add(createDefaultNote());
		context.add(createDefaultAltTrans());
		tu.setContext(context);
		
		ArrayList<NonXliffElement> nxes = new ArrayList<NonXliffElement>();
		nxes.add(createDefaultNonXliffElement());
		tu.setNonXliffElements(nxes);
		
		List<? extends Node> children = tu.getChildren();
		assertEquals(new Integer(9), new Integer(children.size()));
	}

	@Test
	public void testApproved() {
		TransUnitImpl tu = createDefaultTransUnit();
		tu.setApproved(new ApprovedImpl(Approved.Value.YES));
		assertEquals(new ApprovedImpl(Approved.Value.YES), tu.getApproved());
		tu.setApproved(null);
		assertNull(tu.getApproved());
	}

	@Test
	public void testCharClass() {
		TransUnitImpl tu = createDefaultTransUnit();
		tu.setCharClass(new CharClassImpl("abc"));
		assertEquals(new CharClassImpl("abc"), tu.getCharClass());
		tu.setCharClass(null);
		assertNull(tu.getCharClass());
	}

	@Test
	public void testContext() {
		TransUnitImpl tu = createDefaultTransUnit();
		ArrayList<TransUnit.Context> context = new ArrayList<TransUnit.Context>();
		context.add(createDefaultContextGroup());
		context.add(createDefaultCountGroup());
		context.add(createDefaultPropGroup());
		context.add(createDefaultNote());
		context.add(createDefaultAltTrans());
		tu.setContext(context);
		assertEquals(context, tu.getContext());
		tu.setContext(new ArrayList<TransUnit.Context>());
		assertEquals(new ArrayList<TransUnit.Context>(), tu.getContext());
	}

	@Test
	public void testCoord() {
		TransUnitImpl tu = createDefaultTransUnit();
		tu.setCoord(new CoordImpl(1, 2, 3, 4));
		assertEquals(new CoordImpl(1, 2, 3, 4), tu.getCoord());
		tu.setCoord(null);
		assertNull(tu.getCoord());
	}

	@Test
	public void testCssStyle() {
		TransUnitImpl tu = createDefaultTransUnit();
		tu.setCssStyle(new CssStyleImpl("abc"));
		assertEquals(new CssStyleImpl("abc"), tu.getCssStyle());
		tu.setCssStyle(null);
		assertNull(tu.getCssStyle());
	}

	@Test
	public void testDataType() {
		TransUnitImpl tu = createDefaultTransUnit();
		tu.setDataType(new DataTypeImpl("abc"));
		assertEquals(new DataTypeImpl("abc"), tu.getDataType());
		tu.setDataType(null);
		assertNull(tu.getDataType());
	}

	@Test
	public void testExStyle() {
		TransUnitImpl tu = createDefaultTransUnit();
		tu.setExStyle(new ExStyleImpl("abc"));
		assertEquals(new ExStyleImpl("abc"), tu.getExStyle());
		tu.setExStyle(null);
		assertNull(tu.getExStyle());
	}

	@Test
	public void testExType() {
		TransUnitImpl tu = createDefaultTransUnit();
		tu.setExType(new ExTypeImpl("abc"));
		assertEquals(new ExTypeImpl("abc"), tu.getExType());
		tu.setExType(null);
		assertNull(tu.getExType());
	}

	@Test
	public void testExtraData() {
		TransUnitImpl tu = createDefaultTransUnit();
		tu.setExtraData(new ExtraDataImpl("abc"));
		assertEquals(new ExtraDataImpl("abc"), tu.getExtraData());
		tu.setExtraData(null);
		assertNull(tu.getExtraData());
	}

	@Test
	public void testFont() {
		TransUnitImpl tu = createDefaultTransUnit();
		tu.setFont(new FontImpl("abc"));
		assertEquals(new FontImpl("abc"), tu.getFont());
		tu.setFont(null);
		assertNull(tu.getFont());
	}

	@Test
	public void testHelpId() {
		TransUnitImpl tu = createDefaultTransUnit();
		tu.setHelpId(new HelpIdImpl("abc"));
		assertEquals(new HelpIdImpl("abc"), tu.getHelpId());
		tu.setHelpId(null);
		assertNull(tu.getHelpId());
	}

	@Test
	public void testId() {
		TransUnitImpl tu = createDefaultTransUnit();
		try {
			tu.setId(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
		assertEquals(new IdImpl("1"), tu.getId());
		tu.setId(new IdImpl("abc"));
		assertEquals(new IdImpl("abc"), tu.getId());
	}

	@Test
	public void testMaxBytes() {
		TransUnitImpl tu = createDefaultTransUnit();
		tu.setMaxBytes(new MaxBytesImpl("123"));
		assertEquals(new MaxBytesImpl("123"), tu.getMaxBytes());
		tu.setMaxBytes(null);
		assertNull(tu.getMaxBytes());
	}

	@Test
	public void testMaxHeight() {
		TransUnitImpl tu = createDefaultTransUnit();
		tu.setMaxHeight(new MaxHeightImpl("123"));
		assertEquals(new MaxHeightImpl("123"), tu.getMaxHeight());
		tu.setMaxHeight(null);
		assertNull(tu.getMaxHeight());
	}

	@Test
	public void testMaxWidth() {
		TransUnitImpl tu = createDefaultTransUnit();
		tu.setMaxWidth(new MaxWidthImpl("123"));
		assertEquals(new MaxWidthImpl("123"), tu.getMaxWidth());
		tu.setMaxWidth(null);
		assertNull(tu.getMaxWidth());
	}

	@Test
	public void testMenu() {
		TransUnitImpl tu = createDefaultTransUnit();
		tu.setMenu(new MenuImpl("abc"));
		assertEquals(new MenuImpl("abc"), tu.getMenu());
		tu.setMenu(null);
		assertNull(tu.getMenu());
	}

	@Test
	public void testMenuName() {
		TransUnitImpl tu = createDefaultTransUnit();
		tu.setMenuName(new MenuNameImpl("abc"));
		assertEquals(new MenuNameImpl("abc"), tu.getMenuName());
		tu.setMenuName(null);
		assertNull(tu.getMenuName());
	}

	@Test
	public void testMenuOption() {
		TransUnitImpl tu = createDefaultTransUnit();
		tu.setMenuOption(new MenuOptionImpl("abc"));
		assertEquals(new MenuOptionImpl("abc"), tu.getMenuOption());
		tu.setMenuOption(null);
		assertNull(tu.getMenuOption());
	}

	@Test
	public void testMinBytes() {
		TransUnitImpl tu = createDefaultTransUnit();
		tu.setMinBytes(new MinBytesImpl("123"));
		assertEquals(new MinBytesImpl("123"), tu.getMinBytes());
		tu.setMinBytes(null);
		assertNull(tu.getMinBytes());
	}

	@Test
	public void testMinHeight() {
		TransUnitImpl tu = createDefaultTransUnit();
		tu.setMinHeight(new MinHeightImpl("123"));
		assertEquals(new MinHeightImpl("123"), tu.getMinHeight());
		tu.setMinHeight(null);
		assertNull(tu.getMinHeight());
	}

	@Test
	public void testMinWidth() {
		TransUnitImpl tu = createDefaultTransUnit();
		tu.setMinWidth(new MinWidthImpl("123"));
		assertEquals(new MinWidthImpl("123"), tu.getMinWidth());
		tu.setMinWidth(null);
		assertNull(tu.getMinWidth());
	}

	@Test
	public void testNonXliffAttributes() {
		TransUnitImpl tu = createDefaultTransUnit();
		Collection<NonXliffAttribute> nonXliffAttributes = tu
				.getNonXliffAttributes();
		assertTrue(nonXliffAttributes.isEmpty());

		ArrayList<NonXliffAttribute> nxas = new ArrayList<NonXliffAttribute>();
		nxas.add(new NonXliffAttributeImpl("ns", "pre", "name", "value"));
		nxas.add(new NonXliffAttributeImpl("ns", "pre", "name2", "value2"));
		tu.setNonXliffAttributes(nxas);

		nonXliffAttributes = tu.getNonXliffAttributes();
		assertEquals(new Integer(2), new Integer(nonXliffAttributes.size()));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns",
				"pre", "name", "value")));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns",
				"pre", "name2", "value2")));

		nxas.clear();
		nxas.add(new NonXliffAttributeImpl("ns", "pre", "name2", "value2"));
		nxas.add(new NonXliffAttributeImpl("ns2", "pre", "name2", "value2"));
		tu.setNonXliffAttributes(nxas);

		nonXliffAttributes = tu.getNonXliffAttributes();
		assertEquals(new Integer(2), new Integer(nonXliffAttributes.size()));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns",
				"pre", "name2", "value2")));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns2",
				"pre", "name2", "value2")));

		nxas.clear();
		tu.setNonXliffAttributes(nxas);
		nonXliffAttributes = tu.getNonXliffAttributes();
		assertTrue(nonXliffAttributes.isEmpty());
	}
	
	@Test
	public void testNonXliffElements() {
		TransUnitImpl tu = createDefaultTransUnit();
		
		ArrayList<Attribute> attributes = new ArrayList<Attribute>();
		ArrayList<Node> children = new ArrayList<Node>();
		
		ArrayList<NonXliffElement> nxes = new ArrayList<NonXliffElement>();
		nxes.add(new NonXliffElementImpl("ns", "pre", "name", attributes, children));
		nxes.add(new NonXliffElementImpl("ns2", null, "name", attributes, children));
		tu.setNonXliffElements(nxes);
		assertEquals(nxes, tu.getNonXliffElements());
		
		nxes = new ArrayList<NonXliffElement>();
		nxes.add(new NonXliffElementImpl("ns", "pre", "name", attributes, children));
		nxes.add(new NonXliffElementImpl("ns2", null, "name", attributes, children));
		nxes.add(new NonXliffElementImpl("ns2", null, "name", attributes, children));
		tu.setNonXliffElements(nxes);
		assertEquals(nxes, tu.getNonXliffElements());
	}

	@Test
	public void testPhaseName() {
		TransUnitImpl tu = createDefaultTransUnit();
		tu.setPhaseName(new PhaseNameImpl("abc"));
		assertEquals(new PhaseNameImpl("abc"), tu.getPhaseName());
		tu.setPhaseName(null);
		assertNull(tu.getPhaseName());
	}

	@Test
	public void testReformat() {
		TransUnitImpl tu = createDefaultTransUnit();
		tu.setReformat(new ReformatYesNoImpl(false));
		assertEquals(new ReformatYesNoImpl(false), tu.getReformat());
		tu.setReformat(null);
		assertEquals(new ReformatYesNoImpl(true), tu.getReformat());
	}

	@Test
	public void testResName() {
		TransUnitImpl tu = createDefaultTransUnit();
		tu.setResName(new ResNameImpl("abc"));
		assertEquals(new ResNameImpl("abc"), tu.getResName());
		tu.setResName(null);
		assertNull(tu.getResName());
	}

	@Test
	public void testResType() {
		TransUnitImpl tu = createDefaultTransUnit();
		tu.setResType(new ResTypeImpl("abc"));
		assertEquals(new ResTypeImpl("abc"), tu.getResType());
		tu.setResType(null);
		assertNull(tu.getResType());
	}

	@Test
	public void testSegSource() {
		TransUnitImpl tu = createDefaultTransUnit();
		tu.setSegSource(createDefaultSegSource());
		assertEquals(createDefaultSegSource(), tu.getSegSource());
		tu.setSegSource(null);
		assertNull(tu.getSegSource());
	}

	@Test
	public void testSizeUnit() {
		TransUnitImpl tu = createDefaultTransUnit();
		tu.setSizeUnit(new SizeUnitImpl("abc"));
		assertEquals(new SizeUnitImpl("abc"), tu.getSizeUnit());
		tu.setSizeUnit(null);
		assertEquals(new SizeUnitImpl(SizeUnit.Value.PIXEL), tu.getSizeUnit());
	}

	@Test
	public void testSource() {
		TransUnitImpl tu = createDefaultTransUnit();
		try {
			tu.setSource(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
		assertEquals(createDefaultSource(), tu.getSource());
		
		SourceImpl source = new SourceImpl(new ArrayList<TextFragment>());
		tu.setSource(source);
		assertEquals(source, tu.getSource());
	}

	@Test
	public void testStyle() {
		TransUnitImpl tu = createDefaultTransUnit();
		tu.setStyle(new StyleImpl("abc"));
		assertEquals(new StyleImpl("abc"), tu.getStyle());
		tu.setStyle(null);
		assertNull(tu.getStyle());
	}

	@Test
	public void testTarget() {
		TransUnitImpl tu = createDefaultTransUnit();
		tu.setTarget(createDefaultTarget());
		assertEquals(createDefaultTarget(), tu.getTarget());
		tu.setTarget(null);
		assertNull(tu.getTarget());
	}

	@Test
	public void testTranslate() {
		TransUnitImpl tu = createDefaultTransUnit();
		tu.setTranslate(new TranslateImpl(Translate.Value.NO));
		assertEquals(new TranslateImpl(Translate.Value.NO), tu.getTranslate());
		tu.setTranslate(null);
		assertEquals(new TranslateImpl(Translate.Value.YES), tu.getTranslate());
	}

	@Test
	public void testTs() {
		TransUnitImpl tu = createDefaultTransUnit();
		tu.setTs(new TsImpl("abc"));
		assertEquals(new TsImpl("abc"), tu.getTs());
		tu.setTs(null);
		assertNull(tu.getTs());
	}

	@Test
	public void testXmlSpace() {
		TransUnitImpl tu = createDefaultTransUnit();
		tu.setXmlSpace(new XmlSpaceImpl(XmlSpace.Value.PRESERVE));
		assertEquals(new XmlSpaceImpl(XmlSpace.Value.PRESERVE), tu.getXmlSpace());
		tu.setXmlSpace(null);
		assertEquals(new XmlSpaceImpl(XmlSpace.Value.DEFAULT), tu.getXmlSpace());
	}

	@Test
	public void testClone() {
		TransUnitImpl tu = createDefaultTransUnit();
		tu.setSegSource(createDefaultSegSource());
		tu.setTarget(createDefaultTarget());

		ArrayList<TransUnit.Context> context = new ArrayList<TransUnit.Context>();
		context.add(createDefaultContextGroup());
		context.add(createDefaultCountGroup());
		context.add(createDefaultPropGroup());
		context.add(createDefaultNote());
		context.add(createDefaultAltTrans());
		tu.setContext(context);
		
		ArrayList<NonXliffElement> nxes = new ArrayList<NonXliffElement>();
		nxes.add(createDefaultNonXliffElement());
		tu.setNonXliffElements(nxes);

		TransUnitImpl clone = (TransUnitImpl) tu.clone();
		assertEquals(tu, clone);
		assertNotSame(tu, clone);
	}

	private TransUnitImpl createDefaultTransUnit() {
		TransUnitImpl tu = new TransUnitImpl(new IdImpl("1"),
				createDefaultSource());
		return tu;
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

	private CountGroupImpl createDefaultCountGroup() {
		CountGroupImpl countGroup = new CountGroupImpl(new NameImpl("cgname"),
				createDefaultCounts());
		return countGroup;
	}

	private ArrayList<Count> createDefaultCounts() {
		ArrayList<Count> counts = new ArrayList<Count>();
		counts.add(createDefaultCount());
		return counts;
	}

	private CountImpl createDefaultCount() {
		CountImpl count = new CountImpl(new CountTypeImpl(
				CountType.Value.BITMAP), new TextImpl("2"));
		return count;
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
		PropImpl prop = new PropImpl(new PropTypeImpl("pt"), new TextImpl("proval"));
		return prop;
	}
	
	private NoteImpl createDefaultNote() {
		return new NoteImpl(new TextImpl("test"));
	}
	
	private AltTransImpl createDefaultAltTrans() {
		return new AltTransImpl(createDefaultTarget());
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
