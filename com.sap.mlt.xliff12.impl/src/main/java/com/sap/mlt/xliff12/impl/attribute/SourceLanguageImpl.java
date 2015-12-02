package com.sap.mlt.xliff12.impl.attribute;

import java.text.MessageFormat;
import java.util.Locale;

import com.sap.mlt.xliff12.api.attribute.SourceLanguage;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;
import com.sap.mlt.xliff12.impl.rfc4646.Lang;

public class SourceLanguageImpl extends XliffAttributeImpl implements
		SourceLanguage {
	
	public SourceLanguageImpl(String sourceLanguage) {
		super(NAME, sourceLanguage);
		language = new Lang(sourceLanguage);
		if (!language.isValid()) {
			String msg = MessageFormat.format(
					"''{0}'' is not a valid language", sourceLanguage);
			throw new IllegalArgumentException(msg);
		}
	}
	
	public SourceLanguageImpl(Locale sourceLanguage) {
		super(NAME, Lang.fromLocale(sourceLanguage));
		language = new Lang(sourceLanguage);
		if (!language.isValid()) {
			String msg = MessageFormat.format(
					"''{0}'' is not a valid language", Lang
							.fromLocale(sourceLanguage));
			throw new IllegalArgumentException(msg);
		}
	}
	
	private Lang language;

	public Locale getLocale() {
		return language.getLocale();
	}

}
