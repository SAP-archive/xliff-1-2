package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.Crc;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;
import com.sap.mlt.xliff12.impl.util.Assert;

public class CrcImpl extends XliffAttributeImpl implements Crc {

	public CrcImpl(String crc) {
		super(NAME, crc);
		Assert.isNmtoken(crc, "crc");
	}
	
}
