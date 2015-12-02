package com.sap.mlt.xliff12.impl.factory;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.mlt.xliff12.api.text.Text;
import com.sap.mlt.xliff12.impl.text.TextImpl;

public class TextFactoryImplTest {

	@Test
	public void testCreateText() {
		TextFactoryImpl textFactory = TextFactoryImpl.getInstance();
		Text text = textFactory.createText("abc");
		assertEquals(new TextImpl("abc"), text);
	}

}
