package com.sap.mlt.xliff12.impl.attribute;

import java.text.MessageFormat;

import com.sap.mlt.xliff12.api.attribute.Priority;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

public class PriorityImpl extends XliffAttributeImpl implements Priority {

	public PriorityImpl(int priority) {
		super(NAME, Integer.toString(priority));
		if ((priority < 1) || (priority > 10)) {
			String msg = MessageFormat
					.format(
							"Priority must have a value from 1 to 10, but has a value of {0}",
							priority);
			throw new IllegalArgumentException(msg);
		}
		this.priority = priority;
	}

	private int priority;

	public int getPriority() {
		return priority;
	}
}
