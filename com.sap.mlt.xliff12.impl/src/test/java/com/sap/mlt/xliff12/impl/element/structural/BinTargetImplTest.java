package com.sap.mlt.xliff12.impl.element.structural;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.HrefImpl;
import com.sap.mlt.xliff12.impl.attribute.MimeTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.NonXliffAttributeImpl;
import com.sap.mlt.xliff12.impl.attribute.PhaseNameImpl;
import com.sap.mlt.xliff12.impl.attribute.ResNameImpl;
import com.sap.mlt.xliff12.impl.attribute.ResTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.StateImpl;
import com.sap.mlt.xliff12.impl.attribute.StateQualifierImpl;
import com.sap.mlt.xliff12.impl.attribute.TsImpl;
import com.sap.mlt.xliff12.impl.element.header.ExternalFileImpl;
import com.sap.mlt.xliff12.impl.element.header.InternalFileImpl;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.test.util.Utils;

@SuppressWarnings("deprecation")
public class BinTargetImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testBinTargetImplChild() {
		BinTargetImpl bt = createDefaultBinTarget();
		assertEquals(createDefaultInternalFile(), bt.getChild());
	}

	@Test
	public void testBinTargetImplElement() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "bin-target");
		try {
			new BinTargetImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}

		elem.appendChild(createDefaultExternalFile().asXmlNode(doc));
		try {
			BinTargetImpl ref = new BinTargetImpl(elem);
			assertEquals(createDefaultExternalFile(), ref.getChild());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		elem.removeChild(elem.getFirstChild());
		elem.appendChild(createDefaultInternalFile().asXmlNode(doc));
		try {
			BinTargetImpl ref = new BinTargetImpl(elem);
			assertEquals(createDefaultInternalFile(), ref.getChild());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		elem.removeChild(elem.getFirstChild());
		elem.appendChild(doc.createElementNS(XLIFF_12_NAMESPACE, "something"));
		try {
			new BinTargetImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
	}

	@Test
	public void testGetChildren() {
		BinTargetImpl bt = createDefaultBinTarget();
		assertEquals(createDefaultInternalFile(), bt.getChildren().get(0));
	}

	@Test
	public void testChild() {
		BinTargetImpl bt = createDefaultBinTarget();

		try {
			bt.setChild(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}

		bt.setChild(new InternalFileImpl(new TextImpl("abc")));
		assertEquals(new InternalFileImpl(new TextImpl("abc")), bt.getChild());

		bt.setChild(new ExternalFileImpl(new HrefImpl("http://www.sap.com")));
		assertEquals(new ExternalFileImpl(new HrefImpl("http://www.sap.com")),
				bt.getChild());
	}

	@Test
	public void testMimeType() {
		BinTargetImpl bt = createDefaultBinTarget();
		bt.setMimeType(new MimeTypeImpl("text/xml"));
		assertEquals(new MimeTypeImpl("text/xml"), bt.getMimeType());
		bt.setMimeType(null);
		assertNull(bt.getMimeType());
	}

	@Test
	public void testNonXliffAttributes() {
		BinTargetImpl bt = createDefaultBinTarget();
		Collection<NonXliffAttribute> nonXliffAttributes = bt
				.getNonXliffAttributes();
		assertTrue(nonXliffAttributes.isEmpty());

		ArrayList<NonXliffAttribute> nxas = new ArrayList<NonXliffAttribute>();
		nxas.add(new NonXliffAttributeImpl("ns", "pre", "name", "value"));
		nxas.add(new NonXliffAttributeImpl("ns", "pre", "name2", "value2"));
		bt.setNonXliffAttributes(nxas);

		nonXliffAttributes = bt.getNonXliffAttributes();
		assertEquals(new Integer(2), new Integer(nonXliffAttributes.size()));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns",
				"pre", "name", "value")));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns",
				"pre", "name2", "value2")));

		nxas.clear();
		nxas.add(new NonXliffAttributeImpl("ns", "pre", "name2", "value2"));
		nxas.add(new NonXliffAttributeImpl("ns2", "pre", "name2", "value2"));
		bt.setNonXliffAttributes(nxas);

		nonXliffAttributes = bt.getNonXliffAttributes();
		assertEquals(new Integer(2), new Integer(nonXliffAttributes.size()));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns",
				"pre", "name2", "value2")));
		assertTrue(nonXliffAttributes.contains(new NonXliffAttributeImpl("ns2",
				"pre", "name2", "value2")));

		nxas.clear();
		bt.setNonXliffAttributes(nxas);
		nonXliffAttributes = bt.getNonXliffAttributes();
		assertTrue(nonXliffAttributes.isEmpty());
	}

	@Test
	public void testPhaseName() {
		BinTargetImpl bt = createDefaultBinTarget();
		bt.setPhaseName(new PhaseNameImpl("abc"));
		assertEquals(new PhaseNameImpl("abc"), bt.getPhaseName());
		bt.setPhaseName(null);
		assertNull(bt.getPhaseName());
	}

	@Test
	public void testResName() {
		BinTargetImpl bt = createDefaultBinTarget();
		bt.setResName(new ResNameImpl("abc"));
		assertEquals(new ResNameImpl("abc"), bt.getResName());
		bt.setResName(null);
		assertNull(bt.getResName());
	}

	@Test
	public void testResType() {
		BinTargetImpl bt = createDefaultBinTarget();
		bt.setResType(new ResTypeImpl("abc"));
		assertEquals(new ResTypeImpl("abc"), bt.getResType());
		bt.setResType(null);
		assertNull(bt.getResType());
	}

	@Test
	public void testState() {
		BinTargetImpl bt = createDefaultBinTarget();
		bt.setState(new StateImpl("abc"));
		assertEquals(new StateImpl("abc"), bt.getState());
		bt.setState(null);
		assertNull(bt.getState());
	}

	@Test
	public void testStateQualifier() {
		BinTargetImpl bt = createDefaultBinTarget();
		bt.setStateQualifier(new StateQualifierImpl("abc"));
		assertEquals(new StateQualifierImpl("abc"), bt.getStateQualifier());
		bt.setStateQualifier(null);
		assertNull(bt.getStateQualifier());
	}

	@Test
	public void testTs() {
		BinTargetImpl bt = createDefaultBinTarget();
		bt.setTs(new TsImpl("abc"));
		assertEquals(new TsImpl("abc"), bt.getTs());
		bt.setTs(null);
		assertNull(bt.getTs());
	}
	
	@Test
	public void testClone() {
		BinTargetImpl binTargetTrans = createDefaultBinTarget();
		BinTargetImpl clone = (BinTargetImpl) binTargetTrans.clone();
		assertEquals(binTargetTrans, clone);
		assertNotSame(binTargetTrans, clone);
	}	

	private BinTargetImpl createDefaultBinTarget() {
		return new BinTargetImpl(createDefaultInternalFile());
	}

	private InternalFileImpl createDefaultInternalFile() {
		return new InternalFileImpl(new TextImpl("intf"));
	}

	private ExternalFileImpl createDefaultExternalFile() {
		return new ExternalFileImpl(new HrefImpl("http://sap.com"));
	}

}
