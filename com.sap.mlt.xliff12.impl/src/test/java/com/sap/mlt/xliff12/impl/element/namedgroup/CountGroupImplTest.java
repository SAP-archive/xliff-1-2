package com.sap.mlt.xliff12.impl.element.namedgroup;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.CountType;
import com.sap.mlt.xliff12.api.element.namedgroup.Count;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.CountTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.NameImpl;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.test.util.Utils;

public class CountGroupImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testCountGroupImplNameListOfContext() {
		CountGroupImpl cg = createDefaultCountGroup();
		assertEquals(new NameImpl("cgname"), cg.getCountGroupName());
		assertEquals(createDefaultCounts(), cg.getCounts());
	}

	@Test
	public void testContextGroupImplElement() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "count-group");
		elem.setAttributeNS(null, "name", "cgname");

		try {
			new CountGroupImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}

		elem.appendChild(createDefaultCount().asXmlNode(doc));
		try {
			CountGroupImpl cg = new CountGroupImpl(elem);
			assertEquals(new NameImpl("cgname"), cg.getCountGroupName());
			assertEquals(createDefaultCounts(), cg.getCounts());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		elem.appendChild(doc.createElementNS("ns", "name"));
		try {
			new CountGroupImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
	}

	@Test
	public void testGetChildren() {
		CountGroupImpl cg = createDefaultCountGroup();
		assertEquals(createDefaultCounts(), cg.getChildren());
	}

	@Test
	public void testCountGroupName() {
		CountGroupImpl cg = createDefaultCountGroup();
		try {
			cg.setCountGroupName(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
		cg.setCountGroupName(new NameImpl("abc"));
		assertEquals(new NameImpl("abc"), cg.getCountGroupName());
	}

	@Test
	public void testCounts() {
		CountGroupImpl cg = createDefaultCountGroup();
		try {
			cg.setCounts(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
		try {
			cg.setCounts(new ArrayList<Count>());
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
		assertEquals(createDefaultCounts(), cg.getCounts());

		ArrayList<Count> counts = new ArrayList<Count>();
		counts.add(createDefaultCount());
		counts.add(createDefaultCount());
		cg.setCounts(counts);
		assertEquals(counts, cg.getCounts());
	}
	
	@Test
	public void testClone() {
		CountGroupImpl cg = createDefaultCountGroup();
		CountGroupImpl clone = (CountGroupImpl) cg.clone();
		assertEquals(cg, clone);
		assertNotSame(cg, clone);
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

}
