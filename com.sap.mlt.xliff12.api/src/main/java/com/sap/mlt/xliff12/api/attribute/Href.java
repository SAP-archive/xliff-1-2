package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XliffAttribute;
import com.sap.mlt.xliff12.api.element.header.ExternalFile;

/**
 * Hypertext reference - The location of the file or the URL for an
 * {@link ExternalFile} element. For example:
 * "file:///C:/MyFolder/MyProject/MyFile.htm" indicates a file on a local drive.
 * 
 * @author D049314
 */
public interface Href extends XliffAttribute {

	/**
	 * The attribute's name.
	 */
	final static String NAME = "href";

}
