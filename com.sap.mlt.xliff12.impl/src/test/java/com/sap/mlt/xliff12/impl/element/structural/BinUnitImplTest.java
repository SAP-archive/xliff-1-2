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
import com.sap.mlt.xliff12.api.attribute.Translate;
import com.sap.mlt.xliff12.api.base.Attribute;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.base.TextFragment;
import com.sap.mlt.xliff12.api.element.namedgroup.Context;
import com.sap.mlt.xliff12.api.element.namedgroup.Count;
import com.sap.mlt.xliff12.api.element.namedgroup.Prop;
import com.sap.mlt.xliff12.api.element.nonxliff.NonXliffElement;
import com.sap.mlt.xliff12.api.element.structural.BinUnit;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.ApprovedImpl;
import com.sap.mlt.xliff12.impl.attribute.ContextTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.CountTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.HrefImpl;
import com.sap.mlt.xliff12.impl.attribute.IdImpl;
import com.sap.mlt.xliff12.impl.attribute.MimeTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.NameImpl;
import com.sap.mlt.xliff12.impl.attribute.NonXliffAttributeImpl;
import com.sap.mlt.xliff12.impl.attribute.PhaseNameImpl;
import com.sap.mlt.xliff12.impl.attribute.PropTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.ReformatYesNoImpl;
import com.sap.mlt.xliff12.impl.attribute.ResNameImpl;
import com.sap.mlt.xliff12.impl.attribute.ResTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.TranslateImpl;
import com.sap.mlt.xliff12.impl.attribute.TsImpl;
import com.sap.mlt.xliff12.impl.element.header.ExternalFileImpl;
import com.sap.mlt.xliff12.impl.element.header.InternalFileImpl;
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
public class BinUnitImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testBinUnitImplIdMimeTypeBinSource() {
		BinUnitImpl bu = createDefaultBinUnit();
		assertEquals(new TranslateImpl(Translate.Value.YES), bu.getTranslate());
		assertEquals(new ReformatYesNoImpl(true), bu.getReformat());
		assertEquals(createDefaultBinSource(), bu.getBinSource());
		assertEquals(new IdImpl("1"), bu.getId());
		assertEquals(new MimeTypeImpl("text/plain"), bu.getMimeType());
	}

	@Test
	public void testBinUnitImplElement() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "bin-unit");

		elem.setAttributeNS(null, "id", "1");
		elem.setAttributeNS(null, "mime-type", "text/plain");
		try {
			new BinUnitImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}

		elem.appendChild(createDefaultSource().asXmlNode(doc));
		try {
			new BinUnitImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			elem.removeChild(elem.getLastChild());
		}

		elem.appendChild(createDefaultBinSource().asXmlNode(doc));

		try {
			BinUnitImpl bu = new BinUnitImpl(elem);
			assertEquals(new TranslateImpl(Translate.Value.YES), bu
					.getTranslate());
			assertEquals(new ReformatYesNoImpl(true), bu.getReformat());
			assertEquals(createDefaultBinSource(), bu.getBinSource());
			assertEquals(new IdImpl("1"), bu.getId());
			assertEquals(new MimeTypeImpl("text/plain"), bu.getMimeType());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		elem.appendChild(createDefaultBinSource().asXmlNode(doc));
		try {
			new BinUnitImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			elem.removeChild(elem.getLastChild());
		}

		elem.appendChild(createDefaultBinTarget().asXmlNode(doc));
		try {
			BinUnitImpl bu = new BinUnitImpl(elem);
			assertEquals(createDefaultBinTarget(), bu.getBinTarget());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		elem.appendChild(createDefaultBinTarget().asXmlNode(doc));
		try {
			new BinUnitImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			elem.removeChild(elem.getLastChild());
		}

		elem.appendChild(createDefaultContextGroup().asXmlNode(doc));
		elem.appendChild(createDefaultCountGroup().asXmlNode(doc));
		elem.appendChild(createDefaultPropGroup().asXmlNode(doc));
		elem.appendChild(createDefaultNote().asXmlNode(doc));
		elem.appendChild(createDefaultTransUnit().asXmlNode(doc));
		elem.appendChild(createDefaultNonXliffElement().asXmlNode(doc));
		try {
			BinUnitImpl bu = new BinUnitImpl(elem);
			assertEquals(createDefaultContextGroup(), bu.getContext().get(0));
			assertEquals(createDefaultCountGroup(), bu.getContext().get(1));
			assertEquals(createDefaultPropGroup(), bu.getContext().get(2));
			assertEquals(createDefaultNote(), bu.getContext().get(3));
			assertEquals(createDefaultTransUnit(), bu.getContext().get(4));
			assertEquals(createDefaultNonXliffElement(), bu
					.getNonXliffElements().get(0));
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		elem.appendChild(createDefaultContextGroup().asXmlNode(doc));
		try {
			new BinUnitImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			elem.removeChild(elem.getLastChild());
		}
	}

	@Test
	public void testGetChildren() {
		BinUnitImpl bu = createDefaultBinUnit();
		bu.setBinTarget(createDefaultBinTarget());
		ArrayList<BinUnit.Context> context = new ArrayList<BinUnit.Context>();
		context.add(createDefaultCountGroup());
		bu.setContext(context);
		ArrayList<NonXliffElement> nxes = new ArrayList<NonXliffElement>();
		nxes.add(createDefaultNonXliffElement());
		bu.setNonXliffElements(nxes);

		List<? extends Node> children = bu.getChildren();
		assertEquals(new Integer(4), new Integer(children.size()));
	}

	@Test
	public void testApproved() {
		BinUnitImpl bu = createDefaultBinUnit();
		bu.setApproved(new ApprovedImpl(Approved.Value.YES));
		assertEquals(new ApprovedImpl(Approved.Value.YES), bu.getApproved());
		bu.setApproved(null);
		assertNull(bu.getApproved());
	}

	@Test
	public void testBinSource() {
		BinUnitImpl bu = createDefaultBinUnit();
		try {
			bu.setBinSource(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
		assertEquals(createDefaultBinSource(), bu.getBinSource());

		BinSourceImpl source = new BinSourceImpl(new InternalFileImpl(
				new TextImpl("if")));
		bu.setBinSource(source);
		assertEquals(source, bu.getBinSource());
	}

	@Test
	public void testBinTarget() {
		BinUnitImpl bu = createDefaultBinUnit();
		bu.setBinTarget(createDefaultBinTarget());
		assertEquals(createDefaultBinTarget(), bu.getBinTarget());
		bu.setBinTarget(null);
		assertNull(bu.getBinTarget());
	}

	@Test
	public void testContext() {
		BinUnitImpl bu = createDefaultBinUnit();
		ArrayList<BinUnit.Context> context = new ArrayList<BinUnit.Context>();
		context.add(createDefaultContextGroup());
		context.add(createDefaultCountGroup());
		context.add(createDefaultPropGroup());
		context.add(createDefaultNote());
		bu.setContext(context);
		assertEquals(context, bu.getContext());
		bu.setContext(new ArrayList<BinUnit.Context>());
		assertEquals(new ArrayList<BinUnit.Context>(), bu.getContext());
	}

	@Test
	public void testId() {
		BinUnitImpl bu = createDefaultBinUnit();
		try {
			bu.setId(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
		assertEquals(new IdImpl("1"), bu.getId());
		bu.setId(new IdImpl("abc"));
		assertEquals(new IdImpl("abc"), bu.getId());
	}

	@Test
	public void testMimeType() {
		BinUnitImpl bu = createDefaultBinUnit();
		try {
			bu.setMimeType(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
		assertEquals(new MimeTypeImpl("text/plain"), bu.getMimeType());
		bu.setMimeType(new MimeTypeImpl("text/xml"));
		assertEquals(new MimeTypeImpl("text/xml"), bu.getMimeType());
	}

	@Test
	public void testNonXliffAttributes() {
		BinUnitImpl bu = createDefaultBinUnit();
		Collection<NonXliffAttribute> nonXliffAttributes = bu
				.getNonXliffAttributes();
		assertTrue(nonXliffAttributes.isEmpty());

		ArrayList<NonXliffAttribute> nxas = new ArrayList<NonXliffAttribute>();
		nxas.add(new NonXliffAttributeImpl("ns", "pre", "name", "value"));
		nxas.add(new NonXliffAttributeImpl("ns", "pre", "name2", "value2"));
		bu.setNonXliffAttributes(nxas);

		nonXliffAttributes = bu.getNonXliffAttributes();
		assertEquals(new Integer(2), new Integer(nonXliffAttributes.size()));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns",
				"pre", "name", "value")));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns",
				"pre", "name2", "value2")));

		nxas.clear();
		nxas.add(new NonXliffAttributeImpl("ns", "pre", "name2", "value2"));
		nxas.add(new NonXliffAttributeImpl("ns2", "pre", "name2", "value2"));
		bu.setNonXliffAttributes(nxas);

		nonXliffAttributes = bu.getNonXliffAttributes();
		assertEquals(new Integer(2), new Integer(nonXliffAttributes.size()));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns",
				"pre", "name2", "value2")));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns2",
				"pre", "name2", "value2")));

		nxas.clear();
		bu.setNonXliffAttributes(nxas);
		nonXliffAttributes = bu.getNonXliffAttributes();
		assertTrue(nonXliffAttributes.isEmpty());
	}

	@Test
	public void testNonXliffElements() {
		BinUnitImpl bu = createDefaultBinUnit();

		ArrayList<Attribute> attributes = new ArrayList<Attribute>();
		ArrayList<Node> children = new ArrayList<Node>();

		ArrayList<NonXliffElement> nxes = new ArrayList<NonXliffElement>();
		nxes.add(new NonXliffElementImpl("ns", "pre", "name", attributes,
				children));
		nxes.add(new NonXliffElementImpl("ns2", null, "name", attributes,
				children));
		bu.setNonXliffElements(nxes);
		assertEquals(nxes, bu.getNonXliffElements());

		nxes = new ArrayList<NonXliffElement>();
		nxes.add(new NonXliffElementImpl("ns", "pre", "name", attributes,
				children));
		nxes.add(new NonXliffElementImpl("ns2", null, "name", attributes,
				children));
		nxes.add(new NonXliffElementImpl("ns2", null, "name", attributes,
				children));
		bu.setNonXliffElements(nxes);
		assertEquals(nxes, bu.getNonXliffElements());
	}

	@Test
	public void testPhaseName() {
		BinUnitImpl bu = createDefaultBinUnit();
		bu.setPhaseName(new PhaseNameImpl("abc"));
		assertEquals(new PhaseNameImpl("abc"), bu.getPhaseName());
		bu.setPhaseName(null);
		assertNull(bu.getPhaseName());
	}

	@Test
	public void testReformat() {
		BinUnitImpl bu = createDefaultBinUnit();
		bu.setReformat(new ReformatYesNoImpl(false));
		assertEquals(new ReformatYesNoImpl(false), bu.getReformat());
		bu.setReformat(null);
		assertEquals(new ReformatYesNoImpl(true), bu.getReformat());
	}

	@Test
	public void testResName() {
		BinUnitImpl bu = createDefaultBinUnit();
		bu.setResName(new ResNameImpl("abc"));
		assertEquals(new ResNameImpl("abc"), bu.getResName());
		bu.setResName(null);
		assertNull(bu.getResName());
	}

	@Test
	public void testResType() {
		BinUnitImpl bu = createDefaultBinUnit();
		bu.setResType(new ResTypeImpl("abc"));
		assertEquals(new ResTypeImpl("abc"), bu.getResType());
		bu.setResType(null);
		assertNull(bu.getResType());
	}

	@Test
	public void testTranslate() {
		BinUnitImpl bu = createDefaultBinUnit();
		bu.setTranslate(new TranslateImpl(Translate.Value.NO));
		assertEquals(new TranslateImpl(Translate.Value.NO), bu.getTranslate());
		bu.setTranslate(null);
		assertEquals(new TranslateImpl(Translate.Value.YES), bu.getTranslate());
	}

	@Test
	public void testTs() {
		BinUnitImpl bu = createDefaultBinUnit();
		bu.setTs(new TsImpl("abc"));
		assertEquals(new TsImpl("abc"), bu.getTs());
		bu.setTs(null);
		assertNull(bu.getTs());
	}
	
	@Test
	public void testClone() {
		BinUnitImpl bu = createDefaultBinUnit();
		
		bu.setBinTarget(createDefaultBinTarget());
		ArrayList<BinUnit.Context> context = new ArrayList<BinUnit.Context>();
		context.add(createDefaultCountGroup());
		bu.setContext(context);
		ArrayList<NonXliffElement> nxes = new ArrayList<NonXliffElement>();
		nxes.add(createDefaultNonXliffElement());
		bu.setNonXliffElements(nxes);

		BinUnitImpl clone = (BinUnitImpl) bu.clone();
		assertEquals(bu, clone);
		assertNotSame(bu, clone);
	}	

	private BinUnitImpl createDefaultBinUnit() {
		BinUnitImpl binUnit = new BinUnitImpl(new IdImpl("1"),
				new MimeTypeImpl("text/plain"), createDefaultBinSource());
		return binUnit;
	}

	private BinSourceImpl createDefaultBinSource() {
		BinSourceImpl binSource = new BinSourceImpl(createDefaultExternalFile());
		return binSource;
	}

	private ExternalFileImpl createDefaultExternalFile() {
		return new ExternalFileImpl(new HrefImpl("http://abc.def"));
	}

	private BinTargetImpl createDefaultBinTarget() {
		BinTargetImpl binTarget = new BinTargetImpl(createDefaultExternalFile());
		return binTarget;
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

	private NonXliffElementImpl createDefaultNonXliffElement() {
		ArrayList<Attribute> attributes = new ArrayList<Attribute>();
		ArrayList<Node> children = new ArrayList<Node>();
		return new NonXliffElementImpl("ns", "pre", "name", attributes,
				children);
	}
}
