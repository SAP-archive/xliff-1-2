package com.sap.mlt.xliff12.impl.base;

import static org.junit.Assert.*;

import org.junit.Test;

public class NodeImplTest {

	@Test
	public void testParentElement() {
		ConcreteElementImpl parent1 = new ConcreteElementImpl("ns", "pre",
				"name");
		ConcreteElementImpl parent2 = new ConcreteElementImpl("ns", "pre",
				"name");
		ConcreteNodeImpl node = new ConcreteNodeImpl();
		node.setParentElement(parent1);
		node.setParentElement(parent1);
		try {
			node.setParentElement(parent2);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// $JL-EXC$
		}
		assertSame(parent1, node.getParentElement());
		node.setParentElement(null);
		assertNull(node.getParentElement());
		node.setParentElement(parent2);
		assertSame(parent2, node.getParentElement());
	}

}
