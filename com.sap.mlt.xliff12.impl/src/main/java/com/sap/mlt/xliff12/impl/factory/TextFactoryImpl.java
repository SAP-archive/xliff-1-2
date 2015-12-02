package com.sap.mlt.xliff12.impl.factory;

import com.sap.mlt.xliff12.api.factory.TextFactory;
import com.sap.mlt.xliff12.api.text.Text;
import com.sap.mlt.xliff12.impl.text.TextImpl;

public final class TextFactoryImpl implements TextFactory {
	
	private static final TextFactoryImpl INSTANCE = new TextFactoryImpl();
	
	public static TextFactoryImpl getInstance() {
		return INSTANCE;
	}
	
	private TextFactoryImpl() {
	}

	public Text createText(String text) {
		return new TextImpl(text);
	}

}
