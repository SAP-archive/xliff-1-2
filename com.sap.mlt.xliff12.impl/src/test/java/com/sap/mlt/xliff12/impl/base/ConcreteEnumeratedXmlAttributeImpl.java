package com.sap.mlt.xliff12.impl.base;

import org.junit.Ignore;


@Ignore
public class ConcreteEnumeratedXmlAttributeImpl extends EnumeratedXmlAttributeImpl {

	public enum Value {
		ENUM1("enum1"),
		ENUM2("enum2");
		
		private Value(String value) {
			this.value = value;
		}
		
		private String value;
		
		public String toString() {
			return value;
		}
	}

	public ConcreteEnumeratedXmlAttributeImpl(String name, Enum<?> value) {
		super(name, value);
	}

}
