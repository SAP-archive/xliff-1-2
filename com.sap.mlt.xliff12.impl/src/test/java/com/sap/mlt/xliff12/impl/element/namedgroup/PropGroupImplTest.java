package com.sap.mlt.xliff12.impl.element.namedgroup;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.element.namedgroup.Prop;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.NameImpl;
import com.sap.mlt.xliff12.impl.attribute.PropTypeImpl;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.test.util.Utils;

@SuppressWarnings("deprecation")
public class PropGroupImplTest {

	static private final String XLIFF_12_NAMESPACE = "urn:oasis:names:tc:xliff:document:1.2";

	@Test
	public void testCountGroupImplListOfProp() {
		PropGroupImpl pg = createDefaultPropGroup();
		assertEquals(createDefaultProps(), pg.getProps());
	}

	@Test
	public void testPropGroupImplElement() {
		Document doc = Utils.createDocument();
		Element elem = doc.createElementNS(XLIFF_12_NAMESPACE, "prop-group");

		try {
			new PropGroupImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}

		elem.appendChild(createDefaultProp().asXmlNode(doc));
		try {
			PropGroupImpl pg = new PropGroupImpl(elem);
			assertEquals(createDefaultProps(), pg.getProps());
		} catch (ConstraintViolationException e) {
			//$JL-EXC$
			fail("Did not expect ConstraintViolationException");
		}

		elem.appendChild(doc.createElementNS("ns", "name"));
		try {
			new PropGroupImpl(elem);
			fail("Expected ConstraintViolationException");
		} catch (ConstraintViolationException e) {
			// $JL-EXC$
		}
	}

	@Test
	public void testGetChildren() {
		PropGroupImpl pg = createDefaultPropGroup();
		assertEquals(createDefaultProps(), pg.getChildren());
	}

	@Test
	public void testPropGroupName() {
		PropGroupImpl pg = createDefaultPropGroup();
		pg.setPropGroupName(new NameImpl("abc"));
		assertEquals(new NameImpl("abc"), pg.getPropGroupName());
		pg.setPropGroupName(null);
		assertNull(pg.getPropGroupName());
	}

	@Test
	public void testProps() {
		PropGroupImpl pg = createDefaultPropGroup();
		try {
			pg.setProps(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
			// $JL-EXC$
		}
		try {
			pg.setProps(new ArrayList<Prop>());
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
		assertEquals(createDefaultProps(), pg.getProps());

		ArrayList<Prop> props = new ArrayList<Prop>();
		props.add(createDefaultProp());
		props.add(createDefaultProp());
		pg.setProps(props);
		assertEquals(props, pg.getProps());
	}
	
	@Test
	public void testClone() {
		PropGroupImpl pg = createDefaultPropGroup();
		PropGroupImpl clone = (PropGroupImpl) pg.clone();
		assertEquals(pg, clone);
		assertNotSame(pg, clone);
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

}
