package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.MenuName;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

public class MenuNameImpl extends XliffAttributeImpl implements MenuName {

	public MenuNameImpl(String menuName) {
		super(NAME, menuName);
	}
	
}
