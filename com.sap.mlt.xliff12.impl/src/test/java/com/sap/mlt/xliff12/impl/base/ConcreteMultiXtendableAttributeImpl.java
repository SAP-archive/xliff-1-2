package com.sap.mlt.xliff12.impl.base;

import java.util.Collection;

import org.junit.Ignore;

@Ignore
public class ConcreteMultiXtendableAttributeImpl extends
		MultiXtendableAttributeImpl {

	public enum Value {
		ENUM1("enum1"),
		ENUM2("enum2"),
		ENUM3("enum3");
		
		private Value(String value) {
			this.value = value;
		}
		
		private String value;
		
		public String toString() {
			return value;
		}
	}
	
	public ConcreteMultiXtendableAttributeImpl(String name,
			Collection<? extends Enum<?>> values, Collection<String> xtendValues) {
		super(name, values, xtendValues);
	}

}
