package com.sap.mlt.xliff12.impl.base;

import org.junit.Ignore;

@Ignore
public class ConcreteXTendableAttributeImpl extends XTendableAttributeImpl {

	public enum Value {
		ENUM1("enum1"),
		ENUM2("enum2");
		
		private Value(String s) {
			this.value = s;
		}
		
		private String value;
		
		public String toString() {
			return value;
		}
	}
	
	public ConcreteXTendableAttributeImpl(String name, Value enumValue) {
		super(name, enumValue);
	}

	public ConcreteXTendableAttributeImpl(String name, String xtendValue) {
		super(name, xtendValue);
	}

}
