package com.sap.mlt.xliff12.impl.attribute;

import java.text.MessageFormat;
import java.util.Locale;

import com.sap.mlt.xliff12.api.attribute.XmlLang;
import com.sap.mlt.xliff12.impl.base.XmlAttributeImpl;
import com.sap.mlt.xliff12.impl.rfc4646.Lang;

public class XmlLangImpl extends XmlAttributeImpl implements
		XmlLang {
	
	public XmlLangImpl(String lang) {
		super(NAME, lang);
		language = new Lang(lang);
		if (!language.isValid()) {
			String msg = MessageFormat.format(
					"''{0}'' is not a valid language", lang);
			throw new IllegalArgumentException(msg);
		}
	}
	
	public XmlLangImpl(Locale lang) {
		super(NAME, Lang.fromLocale(lang));
		language = new Lang(lang);
		if (!language.isValid()) {
			String msg = MessageFormat.format(
					"''{0}'' is not a valid language", Lang
							.fromLocale(lang));
			throw new IllegalArgumentException(msg);
		}
	}
	
	private Lang language;

	public Locale getLocale() {
		return language.getLocale();
	}

}
