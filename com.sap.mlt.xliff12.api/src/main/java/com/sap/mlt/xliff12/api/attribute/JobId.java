package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XliffAttribute;

/**
 * Job ID - The identifier given to the localization job. This is determined by
 * the entity creating the phase element at the time of processing the file.
 * 
 * @author D049314
 */
public interface JobId extends XliffAttribute {

	/**
	 * The attribute's name.
	 */
	final static String NAME = "job-id";

}
