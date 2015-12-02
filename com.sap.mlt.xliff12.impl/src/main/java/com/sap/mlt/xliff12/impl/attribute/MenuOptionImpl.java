package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.MenuOption;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

public class MenuOptionImpl extends XliffAttributeImpl implements MenuOption {

	public MenuOptionImpl(String menuOption) {
		super(NAME, menuOption);
	}
	
}
