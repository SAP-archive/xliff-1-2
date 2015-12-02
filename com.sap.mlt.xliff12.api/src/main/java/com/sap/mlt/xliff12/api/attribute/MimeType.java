package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XliffAttribute;

/**
 * Mime type -Indicates the type of a binary object. These roughly correspond to
 * the content-type of RFC 1341 , the MIME specification; e.g. "image/jpeg"
 * indicates the binary object is an image file of JPEG format. This is
 * important in determining how to edit the binary object.
 * 
 * @author D049314
 */
public interface MimeType extends XliffAttribute {

	/**
	 * The attribute's name.
	 */
	final static String NAME = "mime-type";

}
