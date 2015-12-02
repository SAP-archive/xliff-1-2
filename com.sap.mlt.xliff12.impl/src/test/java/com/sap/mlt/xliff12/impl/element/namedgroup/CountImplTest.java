package com.sap.mlt.xliff12.impl.element.namedgroup;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.CountType;
import com.sap.mlt.xliff12.api.attribute.Unit;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.CountTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.PhaseNameImpl;
import com.sap.mlt.xliff12.impl.attribute.UnitImpl;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.test.util.Utils;

public class CountImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testCountImplCountTypeText() {
		CountImpl count = createDefaultCount();
		assertEquals(new CountTypeImpl(CountType.Value.CAPTION), count
				.getCountType());
		assertEquals(new TextImpl("3"), count.getNumber());
		assertEquals(new UnitImpl(Unit.Value.WORD), count.getUnit());
	}

	@Test
	public void testCountImplElement() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "count");
		elem.setAttributeNS(null, "count-type", "caption");

		try {
			new CountImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}

		elem.appendChild(doc.createElementNS("ns", "name"));
		try {
			new CountImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			elem.removeChild(elem.getFirstChild());
		}

		elem.setTextContent("3");
		try {
			CountImpl count = new CountImpl(elem);
			assertEquals(new CountTypeImpl(CountType.Value.CAPTION), count
					.getCountType());
			assertEquals(new TextImpl("3"), count.getNumber());
			assertEquals(new UnitImpl(Unit.Value.WORD), count.getUnit());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}
	}

	@Test
	public void testGetChildren() {
		CountImpl count = createDefaultCount();
		ArrayList<TextImpl> expected = new ArrayList<TextImpl>();
		expected.add(new TextImpl("3"));
		assertEquals(expected, count.getChildren());
	}

	@Test
	public void testCountType() {
		CountImpl count = createDefaultCount();
		try {
			count.setCountType(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
		assertEquals(new CountTypeImpl(CountType.Value.CAPTION), count
				.getCountType());
		count.setCountType(new CountTypeImpl("abc"));
		assertEquals(new CountTypeImpl("abc"), count.getCountType());
	}

	@Test
	public void testNumber() {
		CountImpl count = createDefaultCount();
		try {
			count.setNumber(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
		assertEquals(new TextImpl("3"), count.getNumber());
		
		count.setNumber(new TextImpl("10"));
		assertEquals(new TextImpl("10"), count.getNumber());
	}

	@Test
	public void testPhaseName() {
		CountImpl count = createDefaultCount();
		count.setPhaseName(new PhaseNameImpl("abc"));
		assertEquals(new PhaseNameImpl("abc"), count.getPhaseName());
		count.setPhaseName(null);
		assertNull(count.getPhaseName());
	}

	@Test
	public void testUnit() {
		CountImpl count = createDefaultCount();
		count.setUnit(new UnitImpl("abc"));
		assertEquals(new UnitImpl("abc"), count.getUnit());
		count.setUnit(null);
		assertEquals(new UnitImpl(Unit.Value.WORD), count.getUnit());
	}
	
	@Test
	public void testClone() {
		CountImpl count = createDefaultCount();
		CountImpl clone = (CountImpl) count.clone();
		assertEquals(count, clone);
		assertNotSame(count, clone);
	}

	private CountImpl createDefaultCount() {
		CountImpl count = new CountImpl(new CountTypeImpl(
				CountType.Value.CAPTION), new TextImpl("3"));
		return count;
	}

}
