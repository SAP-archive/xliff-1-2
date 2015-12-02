package com.sap.mlt.xliff12.impl.element.structural;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.EquivTrans;
import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.api.base.TextFragment;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.CoordImpl;
import com.sap.mlt.xliff12.impl.attribute.CssStyleImpl;
import com.sap.mlt.xliff12.impl.attribute.EquivTransImpl;
import com.sap.mlt.xliff12.impl.attribute.ExStyleImpl;
import com.sap.mlt.xliff12.impl.attribute.FontImpl;
import com.sap.mlt.xliff12.impl.attribute.IdImpl;
import com.sap.mlt.xliff12.impl.attribute.NonXliffAttributeImpl;
import com.sap.mlt.xliff12.impl.attribute.PhaseNameImpl;
import com.sap.mlt.xliff12.impl.attribute.ResNameImpl;
import com.sap.mlt.xliff12.impl.attribute.ResTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.StateImpl;
import com.sap.mlt.xliff12.impl.attribute.StateQualifierImpl;
import com.sap.mlt.xliff12.impl.attribute.StyleImpl;
import com.sap.mlt.xliff12.impl.attribute.TsImpl;
import com.sap.mlt.xliff12.impl.attribute.XmlLangImpl;
import com.sap.mlt.xliff12.impl.element.inline.XImpl;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.test.util.Utils;

@SuppressWarnings("deprecation")
public class TargetImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testTargetImplListOfQextendsTextFragment() {
		TargetImpl target = createDefaultTarget();
		assertEquals(createDefaultContent(), target.getContent());
		assertEquals(new EquivTransImpl(EquivTrans.Value.YES), target
				.getEquivTrans());
	}

	@Test
	public void testTargetImplElement() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "target");
		List<TextFragment> content = createDefaultContent();
		for (TextFragment tf : content) {
			elem.appendChild(tf.asXmlNode(doc));
		}
		try {
			TargetImpl target = new TargetImpl(elem);
			assertEquals(createDefaultContent(), target.getContent());
			assertEquals(new EquivTransImpl(EquivTrans.Value.YES), target
					.getEquivTrans());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
	}

	@Test
	public void testGetChildren() {
		TargetImpl target = createDefaultTarget();
		assertEquals(createDefaultContent(), target.getChildren());
	}

	@Test
	public void testContent() {
		TargetImpl target = createDefaultTarget();
		assertEquals(createDefaultContent(), target.getContent());
		ArrayList<TextFragment> content = new ArrayList<TextFragment>();
		content.add(new TextImpl("text1"));
		content.add(new XImpl(new IdImpl("x1")));
		target.setContent(content);
		assertEquals(content, target.getContent());
	}

	@Test
	public void testCoord() {
		TargetImpl target = createDefaultTarget();
		target.setCoord(new CoordImpl(1, 2, 3, 4));
		assertEquals(new CoordImpl(1, 2, 3, 4), target.getCoord());
		target.setCoord(null);
		assertNull(target.getCoord());
	}

	@Test
	public void testCssStyle() {
		TargetImpl target = createDefaultTarget();
		target.setCssStyle(new CssStyleImpl("abc"));
		assertEquals(new CssStyleImpl("abc"), target.getCssStyle());
		target.setCssStyle(null);
		assertNull(target.getCssStyle());
	}

	@Test
	public void testEquivTrans() {
		TargetImpl target = createDefaultTarget();
		target.setEquivTrans(new EquivTransImpl(EquivTrans.Value.NO));
		assertEquals(new EquivTransImpl(EquivTrans.Value.NO), target
				.getEquivTrans());
		target.setEquivTrans(null);
		assertEquals(new EquivTransImpl(EquivTrans.Value.YES), target
				.getEquivTrans());
	}

	@Test
	public void testExStyle() {
		TargetImpl target = createDefaultTarget();
		target.setExStyle(new ExStyleImpl("abc"));
		assertEquals(new ExStyleImpl("abc"), target.getExStyle());
		target.setExStyle(null);
		assertNull(target.getExStyle());
	}

	@Test
	public void testFont() {
		TargetImpl target = createDefaultTarget();
		target.setFont(new FontImpl("abc"));
		assertEquals(new FontImpl("abc"), target.getFont());
		target.setFont(null);
		assertNull(target.getFont());
	}

	@Test
	public void testNonXliffAttributes() {
		TargetImpl target = createDefaultTarget();
		Collection<NonXliffAttribute> nonXliffAttributes = target
				.getNonXliffAttributes();
		assertTrue(nonXliffAttributes.isEmpty());

		ArrayList<NonXliffAttribute> nxas = new ArrayList<NonXliffAttribute>();
		nxas.add(new NonXliffAttributeImpl("ns", "pre", "name", "value"));
		nxas.add(new NonXliffAttributeImpl("ns", "pre", "name2", "value2"));
		target.setNonXliffAttributes(nxas);

		nonXliffAttributes = target.getNonXliffAttributes();
		assertEquals(new Integer(2), new Integer(nonXliffAttributes.size()));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns",
				"pre", "name", "value")));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns",
				"pre", "name2", "value2")));

		nxas.clear();
		nxas.add(new NonXliffAttributeImpl("ns", "pre", "name2", "value2"));
		nxas.add(new NonXliffAttributeImpl("ns2", "pre", "name2", "value2"));
		target.setNonXliffAttributes(nxas);

		nonXliffAttributes = target.getNonXliffAttributes();
		assertEquals(new Integer(2), new Integer(nonXliffAttributes.size()));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns",
				"pre", "name2", "value2")));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns2",
				"pre", "name2", "value2")));

		nxas.clear();
		target.setNonXliffAttributes(nxas);
		nonXliffAttributes = target.getNonXliffAttributes();
		assertTrue(nonXliffAttributes.isEmpty());
	}

	@Test
	public void testPhaseName() {
		TargetImpl target = createDefaultTarget();
		target.setPhaseName(new PhaseNameImpl("abc"));
		assertEquals(new PhaseNameImpl("abc"), target.getPhaseName());
		target.setPhaseName(null);
		assertNull(target.getPhaseName());
	}

	@Test
	public void testResName() {
		TargetImpl target = createDefaultTarget();
		target.setResName(new ResNameImpl("abc"));
		assertEquals(new ResNameImpl("abc"), target.getResName());
		target.setResName(null);
		assertNull(target.getResName());
	}

	@Test
	public void testResType() {
		TargetImpl target = createDefaultTarget();
		target.setResType(new ResTypeImpl("abc"));
		assertEquals(new ResTypeImpl("abc"), target.getResType());
		target.setResType(null);
		assertNull(target.getResType());
	}

	@Test
	public void testState() {
		TargetImpl target = createDefaultTarget();
		target.setState(new StateImpl("abc"));
		assertEquals(new StateImpl("abc"), target.getState());
		target.setState(null);
		assertNull(target.getState());
	}

	@Test
	public void testStateQualifier() {
		TargetImpl target = createDefaultTarget();
		target.setStateQualifier(new StateQualifierImpl("abc"));
		assertEquals(new StateQualifierImpl("abc"), target.getStateQualifier());
		target.setStateQualifier(null);
		assertNull(target.getStateQualifier());
	}

	@Test
	public void testStyle() {
		TargetImpl target = createDefaultTarget();
		target.setStyle(new StyleImpl("abc"));
		assertEquals(new StyleImpl("abc"), target.getStyle());
		target.setStyle(null);
		assertNull(target.getStyle());
	}

	@Test
	public void testTs() {
		TargetImpl target = createDefaultTarget();
		target.setTs(new TsImpl("abc"));
		assertEquals(new TsImpl("abc"), target.getTs());
		target.setTs(null);
		assertNull(target.getTs());
	}

	@Test
	public void testXmlLang() {
		TargetImpl target = createDefaultTarget();
		target.setXmlLang(new XmlLangImpl("fr-CA"));
		assertEquals(new XmlLangImpl("fr-CA"), target.getXmlLang());
		target.setXmlLang(null);
		assertNull(target.getXmlLang());
	}

	@Test
	public void testGetPlainText() {
		TargetImpl target = createDefaultTarget();
		assertEquals("sometext", target.getPlainText());
	}

	@Test
	public void testClone() {
		TargetImpl target = createDefaultTarget();
		TargetImpl clone = (TargetImpl) target.clone();
		assertEquals(target, clone);
		assertNotSame(target, clone);
	}

	private TargetImpl createDefaultTarget() {
		TargetImpl target = new TargetImpl(createDefaultContent());
		return target;
	}

	private List<TextFragment> createDefaultContent() {
		ArrayList<TextFragment> content = new ArrayList<TextFragment>();
		content.add(new TextImpl("sometext"));
		return content;
	}

}
