package com.sap.mlt.xliff12.impl.base;

import org.junit.Ignore;

@Ignore
public class ConcreteEnumeratedXliffAttributeImpl extends
		EnumeratedXliffAttributeImpl {
	
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

	public ConcreteEnumeratedXliffAttributeImpl(String name, Enum<?> enumValue) {
		super(name, enumValue);
	}

}
