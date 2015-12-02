package com.sap.mlt.xliff12.impl.element.structural;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.ContextType;
import com.sap.mlt.xliff12.api.attribute.CountType;
import com.sap.mlt.xliff12.api.attribute.MergedTrans;
import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.api.attribute.SizeUnit;
import com.sap.mlt.xliff12.api.attribute.Translate;
import com.sap.mlt.xliff12.api.attribute.XmlSpace;
import com.sap.mlt.xliff12.api.base.Attribute;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.base.TextFragment;
import com.sap.mlt.xliff12.api.element.header.Note;
import com.sap.mlt.xliff12.api.element.namedgroup.Context;
import com.sap.mlt.xliff12.api.element.namedgroup.ContextGroup;
import com.sap.mlt.xliff12.api.element.namedgroup.Count;
import com.sap.mlt.xliff12.api.element.namedgroup.CountGroup;
import com.sap.mlt.xliff12.api.element.namedgroup.Prop;
import com.sap.mlt.xliff12.api.element.namedgroup.PropGroup;
import com.sap.mlt.xliff12.api.element.nonxliff.NonXliffElement;
import com.sap.mlt.xliff12.api.element.structural.StructuralUnit;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
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
import com.sap.mlt.xliff12.impl.attribute.HrefImpl;
import com.sap.mlt.xliff12.impl.attribute.IdImpl;
import com.sap.mlt.xliff12.impl.attribute.MaxBytesImpl;
import com.sap.mlt.xliff12.impl.attribute.MaxHeightImpl;
import com.sap.mlt.xliff12.impl.attribute.MaxWidthImpl;
import com.sap.mlt.xliff12.impl.attribute.MenuImpl;
import com.sap.mlt.xliff12.impl.attribute.MenuNameImpl;
import com.sap.mlt.xliff12.impl.attribute.MenuOptionImpl;
import com.sap.mlt.xliff12.impl.attribute.MergedTransImpl;
import com.sap.mlt.xliff12.impl.attribute.MimeTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.MinBytesImpl;
import com.sap.mlt.xliff12.impl.attribute.MinHeightImpl;
import com.sap.mlt.xliff12.impl.attribute.MinWidthImpl;
import com.sap.mlt.xliff12.impl.attribute.NameImpl;
import com.sap.mlt.xliff12.impl.attribute.NonXliffAttributeImpl;
import com.sap.mlt.xliff12.impl.attribute.PropTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.ReformatYesNoImpl;
import com.sap.mlt.xliff12.impl.attribute.ResNameImpl;
import com.sap.mlt.xliff12.impl.attribute.ResTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.SizeUnitImpl;
import com.sap.mlt.xliff12.impl.attribute.StyleImpl;
import com.sap.mlt.xliff12.impl.attribute.TranslateImpl;
import com.sap.mlt.xliff12.impl.attribute.TsImpl;
import com.sap.mlt.xliff12.impl.attribute.XmlSpaceImpl;
import com.sap.mlt.xliff12.impl.element.header.ExternalFileImpl;
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
public class GroupImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testGroupImplListOfQextendsStructuralUnit() {
		GroupImpl group = createDefaultGroup();
		assertEquals(createDefaultStructuralUnits(), group.getStructuralUnits());
		assertEquals(new XmlSpaceImpl(XmlSpace.Value.DEFAULT), group
				.getXmlSpace());
		assertEquals(new TranslateImpl(Translate.Value.YES), group
				.getTranslate());
		assertEquals(new ReformatYesNoImpl(true), group.getReformat());
		assertEquals(new SizeUnitImpl(SizeUnit.Value.PIXEL), group
				.getSizeUnit());
		assertEquals(new MergedTransImpl(MergedTrans.Value.NO), group
				.getMergedTrans());
	}

	@Test
	public void testGroupImplElement() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "group");

		try {
			GroupImpl group = new GroupImpl(elem);
			assertEquals(new XmlSpaceImpl(XmlSpace.Value.DEFAULT), group
					.getXmlSpace());
			assertEquals(new TranslateImpl(Translate.Value.YES), group
					.getTranslate());
			assertEquals(new ReformatYesNoImpl(true), group.getReformat());
			assertEquals(new SizeUnitImpl(SizeUnit.Value.PIXEL), group
					.getSizeUnit());
			assertEquals(new MergedTransImpl(MergedTrans.Value.NO), group
					.getMergedTrans());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		elem.appendChild(createDefaultContextGroup().asXmlNode(doc));
		try {
			GroupImpl group = new GroupImpl(elem);
			assertEquals(new Integer(1), new Integer(group.getContextGroups().size()));
			assertEquals(createDefaultContextGroup(), group.getContextGroups()
					.get(0));
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		elem.appendChild(createDefaultCountGroup().asXmlNode(doc));
		try {
			GroupImpl group = new GroupImpl(elem);
			assertEquals(new Integer(1), new Integer(group.getCountGroups().size()));
			assertEquals(createDefaultCountGroup(), group.getCountGroups().get(
					0));
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		elem.appendChild(createDefaultPropGroup().asXmlNode(doc));
		try {
			GroupImpl group = new GroupImpl(elem);
			assertEquals(new Integer(1), new Integer(group.getPropGroups().size()));
			assertEquals(createDefaultPropGroup(), group.getPropGroups().get(0));
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		elem.appendChild(createDefaultNote().asXmlNode(doc));
		try {
			GroupImpl group = new GroupImpl(elem);
			assertEquals(new Integer(1), new Integer(group.getNotes().size()));
			assertEquals(createDefaultNote(), group.getNotes().get(0));
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		elem.appendChild(createDefaultNonXliffElement().asXmlNode(doc));
		try {
			GroupImpl group = new GroupImpl(elem);
			assertEquals(new Integer(1), new Integer(group.getNonXliffElements().size()));
			assertEquals(createDefaultNonXliffElement(), group
					.getNonXliffElements().get(0));
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		elem.appendChild(createDefaultTransUnit().asXmlNode(doc));
		elem.appendChild(createEmptyGroup().asXmlNode(doc));
		elem.appendChild(createDefaultBinUnit().asXmlNode(doc));
		try {
			GroupImpl group = new GroupImpl(elem);
			assertEquals(new Integer(3), new Integer(group.getStructuralUnits().size()));
			assertEquals(createDefaultTransUnit(), group.getStructuralUnits()
					.get(0));
			assertEquals(createEmptyGroup(), group.getStructuralUnits().get(1));
			assertEquals(createDefaultBinUnit(), group.getStructuralUnits()
					.get(2));
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		elem.appendChild(createDefaultNote().asXmlNode(doc));
		try {
			new GroupImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
	}

	@Test
	public void testGetChildren() {
		GroupImpl group = createDefaultGroup();
		assertEquals(createDefaultStructuralUnits(), group.getChildren());
	}

	@Test
	public void testCharClass() {
		GroupImpl group = createDefaultGroup();
		group.setCharClass(new CharClassImpl("abc"));
		assertEquals(new CharClassImpl("abc"), group.getCharClass());
		group.setCharClass(null);
		assertNull(group.getCharClass());
	}

	@Test
	public void testContextGroups() {
		GroupImpl group = createDefaultGroup();
		List<ContextGroup> cgs = new ArrayList<ContextGroup>();
		cgs.add(createDefaultContextGroup());
		group.setContextGroups(cgs);
		assertEquals(cgs, group.getContextGroups());
		group.setContextGroups(new ArrayList<ContextGroup>());
		assertEquals(new ArrayList<ContextGroup>(), group.getContextGroups());
	}

	@Test
	public void testCoord() {
		GroupImpl group = createDefaultGroup();
		group.setCoord(new CoordImpl(1, 2, 3, 4));
		assertEquals(new CoordImpl(1, 2, 3, 4), group.getCoord());
		group.setCoord(null);
		assertNull(group.getCoord());
	}

	@Test
	public void testCountGroups() {
		GroupImpl group = createDefaultGroup();
		List<CountGroup> cgs = new ArrayList<CountGroup>();
		cgs.add(createDefaultCountGroup());
		group.setCountGroups(cgs);
		assertEquals(cgs, group.getCountGroups());
		group.setCountGroups(new ArrayList<CountGroup>());
		assertEquals(new ArrayList<CountGroup>(), group.getCountGroups());
	}

	@Test
	public void testCssStyle() {
		GroupImpl group = createDefaultGroup();
		group.setCssStyle(new CssStyleImpl("abc"));
		assertEquals(new CssStyleImpl("abc"), group.getCssStyle());
		group.setCssStyle(null);
		assertNull(group.getCssStyle());
	}

	@Test
	public void testDataType() {
		GroupImpl group = createDefaultGroup();
		group.setDataType(new DataTypeImpl("abc"));
		assertEquals(new DataTypeImpl("abc"), group.getDataType());
		group.setDataType(null);
		assertNull(group.getDataType());
	}

	@Test
	public void testExStyle() {
		GroupImpl group = createDefaultGroup();
		group.setExStyle(new ExStyleImpl("abc"));
		assertEquals(new ExStyleImpl("abc"), group.getExStyle());
		group.setExStyle(null);
		assertNull(group.getExStyle());
	}

	@Test
	public void testExType() {
		GroupImpl group = createDefaultGroup();
		group.setExType(new ExTypeImpl("abc"));
		assertEquals(new ExTypeImpl("abc"), group.getExType());
		group.setExType(null);
		assertNull(group.getExType());
	}

	@Test
	public void testExtraData() {
		GroupImpl group = createDefaultGroup();
		group.setExtraData(new ExtraDataImpl("abc"));
		assertEquals(new ExtraDataImpl("abc"), group.getExtraData());
		group.setExtraData(null);
		assertNull(group.getExtraData());
	}

	@Test
	public void testFont() {
		GroupImpl group = createDefaultGroup();
		group.setFont(new FontImpl("abc"));
		assertEquals(new FontImpl("abc"), group.getFont());
		group.setFont(null);
		assertNull(group.getFont());
	}

	@Test
	public void testHelpId() {
		GroupImpl group = createDefaultGroup();
		group.setHelpId(new HelpIdImpl("abc"));
		assertEquals(new HelpIdImpl("abc"), group.getHelpId());
		group.setHelpId(null);
		assertNull(group.getHelpId());
	}

	@Test
	public void testId() {
		GroupImpl group = createDefaultGroup();
		group.setId(new IdImpl("abc"));
		assertEquals(new IdImpl("abc"), group.getId());
		group.setId(null);
		assertNull(group.getId());
	}

	@Test
	public void testMaxBytes() {
		GroupImpl group = createDefaultGroup();
		group.setMaxBytes(new MaxBytesImpl("123"));
		assertEquals(new MaxBytesImpl("123"), group.getMaxBytes());
		group.setMaxBytes(null);
		assertNull(group.getMaxBytes());
	}

	@Test
	public void testMaxHeight() {
		GroupImpl group = createDefaultGroup();
		group.setMaxHeight(new MaxHeightImpl("123"));
		assertEquals(new MaxHeightImpl("123"), group.getMaxHeight());
		group.setMaxHeight(null);
		assertNull(group.getMaxHeight());
	}

	@Test
	public void testMaxWidth() {
		GroupImpl group = createDefaultGroup();
		group.setMaxWidth(new MaxWidthImpl("123"));
		assertEquals(new MaxWidthImpl("123"), group.getMaxWidth());
		group.setMaxWidth(null);
		assertNull(group.getMaxWidth());
	}

	@Test
	public void testMenu() {
		GroupImpl group = createDefaultGroup();
		group.setMenu(new MenuImpl("abc"));
		assertEquals(new MenuImpl("abc"), group.getMenu());
		group.setMenu(null);
		assertNull(group.getMenu());
	}

	@Test
	public void testMenuName() {
		GroupImpl group = createDefaultGroup();
		group.setMenuName(new MenuNameImpl("abc"));
		assertEquals(new MenuNameImpl("abc"), group.getMenuName());
		group.setMenuName(null);
		assertNull(group.getMenuName());
	}

	@Test
	public void testMenuOption() {
		GroupImpl group = createDefaultGroup();
		group.setMenuOption(new MenuOptionImpl("abc"));
		assertEquals(new MenuOptionImpl("abc"), group.getMenuOption());
		group.setMenuOption(null);
		assertNull(group.getMenuOption());
	}

	@Test
	public void testMergedTrans() {
		GroupImpl group = createDefaultGroup();
		group.setMergedTrans(new MergedTransImpl(MergedTrans.Value.YES));
		assertEquals(new MergedTransImpl(MergedTrans.Value.YES), group
				.getMergedTrans());
		group.setMergedTrans(null);
		assertEquals(new MergedTransImpl(MergedTrans.Value.NO), group
				.getMergedTrans());
	}

	@Test
	public void testMinBytes() {
		GroupImpl group = createDefaultGroup();
		group.setMinBytes(new MinBytesImpl("123"));
		assertEquals(new MinBytesImpl("123"), group.getMinBytes());
		group.setMinBytes(null);
		assertNull(group.getMinBytes());
	}

	@Test
	public void testMinHeight() {
		GroupImpl group = createDefaultGroup();
		group.setMinHeight(new MinHeightImpl("123"));
		assertEquals(new MinHeightImpl("123"), group.getMinHeight());
		group.setMinHeight(null);
		assertNull(group.getMinHeight());
	}

	@Test
	public void testMinWidth() {
		GroupImpl group = createDefaultGroup();
		group.setMinWidth(new MinWidthImpl("123"));
		assertEquals(new MinWidthImpl("123"), group.getMinWidth());
		group.setMinWidth(null);
		assertNull(group.getMinWidth());
	}

	@Test
	public void testNonXliffAttributes() {
		GroupImpl group = createDefaultGroup();
		Collection<NonXliffAttribute> nonXliffAttributes = group
				.getNonXliffAttributes();
		assertTrue(nonXliffAttributes.isEmpty());

		ArrayList<NonXliffAttribute> nxas = new ArrayList<NonXliffAttribute>();
		nxas.add(new NonXliffAttributeImpl("ns", "pre", "name", "value"));
		nxas.add(new NonXliffAttributeImpl("ns", "pre", "name2", "value2"));
		group.setNonXliffAttributes(nxas);

		nonXliffAttributes = group.getNonXliffAttributes();
		assertEquals(new Integer(2), new Integer(nonXliffAttributes.size()));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns",
				"pre", "name", "value")));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns",
				"pre", "name2", "value2")));

		nxas.clear();
		nxas.add(new NonXliffAttributeImpl("ns", "pre", "name2", "value2"));
		nxas.add(new NonXliffAttributeImpl("ns2", "pre", "name2", "value2"));
		group.setNonXliffAttributes(nxas);

		nonXliffAttributes = group.getNonXliffAttributes();
		assertEquals(new Integer(2), new Integer(nonXliffAttributes.size()));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns",
				"pre", "name2", "value2")));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns2",
				"pre", "name2", "value2")));

		nxas.clear();
		group.setNonXliffAttributes(nxas);
		nonXliffAttributes = group.getNonXliffAttributes();
		assertTrue(nonXliffAttributes.isEmpty());
	}

	@Test
	public void testNonXliffElements() {
		GroupImpl group = createDefaultGroup();

		ArrayList<Attribute> attributes = new ArrayList<Attribute>();
		ArrayList<Node> children = new ArrayList<Node>();

		ArrayList<NonXliffElement> nxes = new ArrayList<NonXliffElement>();
		nxes.add(new NonXliffElementImpl("ns", "pre", "name", attributes,
				children));
		nxes.add(new NonXliffElementImpl("ns2", null, "name", attributes,
				children));
		group.setNonXliffElements(nxes);
		assertEquals(nxes, group.getNonXliffElements());

		nxes = new ArrayList<NonXliffElement>();
		nxes.add(new NonXliffElementImpl("ns", "pre", "name", attributes,
				children));
		nxes.add(new NonXliffElementImpl("ns2", null, "name", attributes,
				children));
		nxes.add(new NonXliffElementImpl("ns2", null, "name", attributes,
				children));
		group.setNonXliffElements(nxes);
		assertEquals(nxes, group.getNonXliffElements());
	}

	@Test
	public void testNotes() {
		GroupImpl group = createDefaultGroup();
		List<Note> notes = new ArrayList<Note>();
		notes.add(createDefaultNote());
		group.setNotes(notes);
		assertEquals(notes, group.getNotes());
		group.setNotes(new ArrayList<Note>());
		assertEquals(new ArrayList<Note>(), group.getNotes());
	}

	@Test
	public void testPropGroups() {
		GroupImpl group = createDefaultGroup();
		List<PropGroup> pgs = new ArrayList<PropGroup>();
		pgs.add(createDefaultPropGroup());
		group.setPropGroups(pgs);
		assertEquals(pgs, group.getPropGroups());
		group.setPropGroups(new ArrayList<PropGroup>());
		assertEquals(new ArrayList<PropGroup>(), group.getPropGroups());
	}

	@Test
	public void testReformat() {
		GroupImpl group = createDefaultGroup();
		group.setReformat(new ReformatYesNoImpl(false));
		assertEquals(new ReformatYesNoImpl(false), group.getReformat());
		group.setReformat(null);
		assertEquals(new ReformatYesNoImpl(true), group.getReformat());
	}

	@Test
	public void testResName() {
		GroupImpl group = createDefaultGroup();
		group.setResName(new ResNameImpl("abc"));
		assertEquals(new ResNameImpl("abc"), group.getResName());
		group.setResName(null);
		assertNull(group.getResName());
	}

	@Test
	public void testResType() {
		GroupImpl group = createDefaultGroup();
		group.setResType(new ResTypeImpl("abc"));
		assertEquals(new ResTypeImpl("abc"), group.getResType());
		group.setResType(null);
		assertNull(group.getResType());
	}

	@Test
	public void testSizeUnit() {
		GroupImpl group = createDefaultGroup();
		group.setSizeUnit(new SizeUnitImpl("abc"));
		assertEquals(new SizeUnitImpl("abc"), group.getSizeUnit());
		group.setSizeUnit(null);
		assertEquals(new SizeUnitImpl(SizeUnit.Value.PIXEL), group
				.getSizeUnit());
	}

	@Test
	public void testStructuralUnits() {
		GroupImpl group = createDefaultGroup();
		group.setStructuralUnits(new ArrayList<StructuralUnit>());
		assertEquals(new ArrayList<StructuralUnit>(), group
				.getStructuralUnits());
		group.setStructuralUnits(createDefaultStructuralUnits());
		assertEquals(createDefaultStructuralUnits(), group.getStructuralUnits());
	}

	@Test
	public void testStyle() {
		GroupImpl group = createDefaultGroup();
		group.setStyle(new StyleImpl("abc"));
		assertEquals(new StyleImpl("abc"), group.getStyle());
		group.setStyle(null);
		assertNull(group.getStyle());
	}

	@Test
	public void testTranslate() {
		GroupImpl group = createDefaultGroup();
		group.setTranslate(new TranslateImpl(Translate.Value.NO));
		assertEquals(new TranslateImpl(Translate.Value.NO), group
				.getTranslate());
		group.setTranslate(null);
		assertEquals(new TranslateImpl(Translate.Value.YES), group
				.getTranslate());
	}

	@Test
	public void testTs() {
		GroupImpl group = createDefaultGroup();
		group.setTs(new TsImpl("abc"));
		assertEquals(new TsImpl("abc"), group.getTs());
		group.setTs(null);
		assertNull(group.getTs());
	}

	@Test
	public void testXmlSpace() {
		GroupImpl group = createDefaultGroup();
		group.setXmlSpace(new XmlSpaceImpl(XmlSpace.Value.PRESERVE));
		assertEquals(new XmlSpaceImpl(XmlSpace.Value.PRESERVE), group
				.getXmlSpace());
		group.setXmlSpace(null);
		assertEquals(new XmlSpaceImpl(XmlSpace.Value.DEFAULT), group
				.getXmlSpace());
	}

	@Test
	public void testClone() {
		GroupImpl group = createDefaultGroup();

		ArrayList<ContextGroup> contextgroups = new ArrayList<ContextGroup>();
		contextgroups.add(createDefaultContextGroup());
		group.setContextGroups(contextgroups);

		ArrayList<CountGroup> countgroups = new ArrayList<CountGroup>();
		countgroups.add(createDefaultCountGroup());
		group.setCountGroups(countgroups);

		ArrayList<PropGroup> propgroups = new ArrayList<PropGroup>();
		propgroups.add(createDefaultPropGroup());
		group.setPropGroups(propgroups);

		ArrayList<Note> notes = new ArrayList<Note>();
		notes.add(createDefaultNote());
		group.setNotes(notes);

		ArrayList<NonXliffElement> nxes = new ArrayList<NonXliffElement>();
		nxes.add(createDefaultNonXliffElement());
		group.setNonXliffElements(nxes);

		group.setStructuralUnits(createDefaultStructuralUnits());

		GroupImpl clone = (GroupImpl) group.clone();
		assertEquals(group, clone);
		assertNotSame(group, clone);
	}

	private GroupImpl createDefaultGroup() {
		GroupImpl group = new GroupImpl(createDefaultStructuralUnits());
		return group;
	}

	private List<StructuralUnit> createDefaultStructuralUnits() {
		ArrayList<StructuralUnit> ret = new ArrayList<StructuralUnit>();
		ret.add(createDefaultTransUnit());
		ret.add(createEmptyGroup());
		return ret;
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

	private GroupImpl createEmptyGroup() {
		return new GroupImpl(new ArrayList<StructuralUnit>());
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

	private BinUnitImpl createDefaultBinUnit() {
		BinUnitImpl binUnit = new BinUnitImpl(new IdImpl("b1"),
				new MimeTypeImpl("text/plain"), createDefaultBinSource());
		return binUnit;
	}

	private BinSourceImpl createDefaultBinSource() {
		BinSourceImpl binSource = new BinSourceImpl(new ExternalFileImpl(
				new HrefImpl("http://some.where")));
		return binSource;
	}
}
