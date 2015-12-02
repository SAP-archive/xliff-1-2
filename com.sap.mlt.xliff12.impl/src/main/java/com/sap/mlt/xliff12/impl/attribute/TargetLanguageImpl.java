package com.sap.mlt.xliff12.impl.attribute;

import java.text.MessageFormat;
import java.util.Locale;

import com.sap.mlt.xliff12.api.attribute.TargetLanguage;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;
import com.sap.mlt.xliff12.impl.rfc4646.Lang;

public class TargetLanguageImpl extends XliffAttributeImpl implements
		TargetLanguage {
	
	public TargetLanguageImpl(String targetLanguage) {
		super(NAME, targetLanguage);
		language = new Lang(targetLanguage);
		if (!language.isValid()) {
			String msg = MessageFormat.format(
					"''{0}'' is not a valid language", targetLanguage);
			throw new IllegalArgumentException(msg);
		}
	}
	
	public TargetLanguageImpl(Locale targetLanguage) {
		super(NAME, Lang.fromLocale(targetLanguage));
		language = new Lang(targetLanguage);
		if (!language.isValid()) {
			String msg = MessageFormat.format(
					"''{0}'' is not a valid language", Lang
							.fromLocale(targetLanguage));
			throw new IllegalArgumentException(msg);
		}
	}
	
	private Lang language;

	public Locale getLocale() {
		return language.getLocale();
	}

}
