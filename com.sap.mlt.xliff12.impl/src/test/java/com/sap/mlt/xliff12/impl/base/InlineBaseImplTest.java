package com.sap.mlt.xliff12.impl.base;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.EquivTextImpl;
import com.sap.mlt.xliff12.impl.attribute.IdImpl;
import com.sap.mlt.xliff12.impl.attribute.NonXliffAttributeImpl;
import com.sap.mlt.xliff12.impl.attribute.TsImpl;
import com.sap.mlt.xliff12.impl.attribute.XidImpl;
import com.sap.mlt.xliff12.test.util.Utils;

@SuppressWarnings("deprecation")
public class InlineBaseImplTest {

	private final static String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testInlineBaseImplStringId() {
		ConcreteInlineBaseImpl elem = new ConcreteInlineBaseImpl("name",
				new IdImpl("id"));
		assertEquals(XLIFF_12_NAMESPACE, elem.getNamespaceUri());
		assertEquals("name", elem.getName());
		assertEquals(new IdImpl("id"), elem.getId());

		try {
			elem = new ConcreteInlineBaseImpl("name", (IdImpl) null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
	}

	@Test
	public void testInlineBaseImplStringElement() {
		Document doc = Utils.createDocument();
		Element xmlElem = doc.createElementNS(XLIFF_12_NAMESPACE, "name");
		xmlElem.setAttributeNS(null, "id", "id");

		ConcreteInlineBaseImpl elem;
		try {
			elem = new ConcreteInlineBaseImpl("name", xmlElem);
			assertEquals(XLIFF_12_NAMESPACE, elem.getNamespaceUri());
			assertEquals("name", elem.getName());
			assertEquals(new IdImpl("id"), elem.getId());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
	}

	@Test
	public void testEquivText() {
		ConcreteInlineBaseImpl elem = new ConcreteInlineBaseImpl("name",
				new IdImpl("id"));
		elem.setEquivText(new EquivTextImpl("equivText"));
		assertEquals(new EquivTextImpl("equivText"), elem.getEquivText());
		elem.setEquivText(null);
		assertNull(elem.getEquivText());
	}

	@Test
	public void testId() {
		ConcreteInlineBaseImpl elem = new ConcreteInlineBaseImpl("name",
				new IdImpl("id"));
		assertEquals(new IdImpl("id"), elem.getId());
		elem.setId(new IdImpl("id2"));
		assertEquals(new IdImpl("id2"), elem.getId());
		try {
			elem.setId(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
	}

	@Test
	public void testGetTs() {
		ConcreteInlineBaseImpl elem = new ConcreteInlineBaseImpl("name",
				new IdImpl("id"));
		elem.setTs(new TsImpl("value"));
		assertEquals(new TsImpl("value"), elem.getTs());
		elem.setTs(null);
		assertNull(elem.getTs());
	}

	@Test
	public void testXid() {
		ConcreteInlineBaseImpl elem = new ConcreteInlineBaseImpl("name",
				new IdImpl("id"));
		elem.setXid(new XidImpl("value"));
		assertEquals(new XidImpl("value"), elem.getXid());
		elem.setXid(null);
		assertNull(elem.getXid());
	}

	@Test
	public void testNonXliffAttributes() {
		ConcreteInlineBaseImpl elem = new ConcreteInlineBaseImpl("name",
				new IdImpl("id"));

		ArrayList<NonXliffAttribute> attrs = new ArrayList<NonXliffAttribute>();
		attrs.add(new NonXliffAttributeImpl("ns", null, "name", "value"));
		elem.setNonXliffAttributes(attrs);

		Collection<NonXliffAttribute> setAttrs = elem.getNonXliffAttributes();
		assertEquals(new Integer(1), new Integer(setAttrs.size()));
		assertTrue(setAttrs.contains(new NonXliffAttributeImpl("ns", null,
				"name", "value")));
		
		attrs = new ArrayList<NonXliffAttribute>();
		attrs.add(new NonXliffAttributeImpl("ns", null, "name2", "value2"));
		elem.setNonXliffAttributes(attrs);
		
		setAttrs = elem.getNonXliffAttributes();
		assertEquals(new Integer(1), new Integer(setAttrs.size()));
		assertTrue(setAttrs.contains(new NonXliffAttributeImpl("ns", null,
				"name2", "value2")));

	}

}
