package com.sap.mlt.xliff12.impl.element.structural;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.base.TextFragment;
import com.sap.mlt.xliff12.api.element.structural.StructuralUnit;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.HrefImpl;
import com.sap.mlt.xliff12.impl.attribute.IdImpl;
import com.sap.mlt.xliff12.impl.attribute.MimeTypeImpl;
import com.sap.mlt.xliff12.impl.element.header.ExternalFileImpl;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.test.util.Utils;

public class BodyImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testBodyImplListOfQextendsStructuralUnit() {
		BodyImpl body = createDefaultBody();
		assertEquals(createDefaultStructuralUnits(), body.getStructuralUnits());
	}

	@Test
	public void testBodyImplElement() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "body");

		elem.appendChild(createEmptyGroup().asXmlNode(doc));
		elem.appendChild(createDefaultTransUnit().asXmlNode(doc));
		elem.appendChild(createDefaultBinUnit().asXmlNode(doc));
		try {
			BodyImpl body = new BodyImpl(elem);
			List<? extends StructuralUnit> sus = body.getStructuralUnits();
			assertEquals(new Integer(3), new Integer(sus.size()));
			assertEquals(createEmptyGroup(), sus.get(0));
			assertEquals(createDefaultTransUnit(), sus.get(1));
			assertEquals(createDefaultBinUnit(), sus.get(2));
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		elem.appendChild(createDefaultSource().asXmlNode(doc));
		try {
			new BodyImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
	}

	@Test
	public void testGetChildren() {
		BodyImpl body = createDefaultBody();
		assertEquals(createDefaultStructuralUnits(), body.getChildren());
	}

	@Test
	public void testStructualUnits() {
		BodyImpl body = createDefaultBody();
		body.setStructuralUnits(new ArrayList<StructuralUnit>());
		assertEquals(new ArrayList<StructuralUnit>(), body.getStructuralUnits());
		body.setStructuralUnits(createDefaultStructuralUnits());
		assertEquals(createDefaultStructuralUnits(), body.getStructuralUnits());
	}

	@Test
	public void testClone() {
		BodyImpl body = createDefaultBody();
		BodyImpl clone = (BodyImpl) body.clone();
		assertEquals(body, clone);
		assertNotSame(body, clone);
	}

	private BodyImpl createDefaultBody() {
		BodyImpl body = new BodyImpl(createDefaultStructuralUnits());
		return body;
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
