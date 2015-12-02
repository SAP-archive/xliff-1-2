package com.sap.mlt.xliff12.impl.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.sap.mlt.xliff12.api.base.MultiXTendableAttribute;
import com.sap.mlt.xliff12.impl.util.Assert;

public abstract class MultiXtendableAttributeImpl extends XliffAttributeImpl implements
		MultiXTendableAttribute {

	protected MultiXtendableAttributeImpl(String name, Collection<? extends Enum<?>> values,
			Collection<String> xtendValues) {
		super(name, buildValue(values, xtendValues));
		this.values = new ArrayList<Enum<?>>(values);
		this.xtendValues = new ArrayList<String>(xtendValues);
	}

	private ArrayList<? extends Enum<?>> values;

	private ArrayList<String> xtendValues;

	public List<? extends Enum<?>> getEnumValues() {
		return Collections.unmodifiableList(values);
	}

	public List<String> getXtendValues() {
		return Collections.unmodifiableList(xtendValues);
	}
	
	private static String buildValue(Collection<? extends Enum<?>> values,
			Collection<String> xtendValues) {
		Assert.notNull(values, "values");
		Assert.notNull(xtendValues, "xtendValues");
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for (Enum<?> value : values) {
			if (first) {
				first = false;
			} else {
				sb.append(' ');
			}
			sb.append(value.toString());
		}
		for (String value : xtendValues) {
			if (first) {
				first = false;
			} else {
				sb.append(' ');
			}
			sb.append("x-");
			sb.append(value);
		}
		return sb.toString();
	}
	
}
