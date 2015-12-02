package com.sap.mlt.xliff12.api.element.header;

import com.sap.mlt.xliff12.api.attribute.Crc;
import com.sap.mlt.xliff12.api.attribute.Href;
import com.sap.mlt.xliff12.api.attribute.Uid;
import com.sap.mlt.xliff12.api.base.XliffElement;
import com.sap.mlt.xliff12.api.element.structural.BinSource;
import com.sap.mlt.xliff12.api.element.structural.BinTarget;

/**
 * External file - The ExternalFile element specifies the location of the actual
 * file being referenced. The required {@link Href} attribute provides a URI to
 * the file. The {@link Crc} attribute accepts a value that can be used to
 * precisely identify and assure the authenticity of the file. The {@link Uid}
 * attribute allows a unique ID to be assigned to the file.
 * 
 * @author D049314
 */
public interface ExternalFile extends XliffElement, Skl.Child, Glossary.Child,
		Reference.Child, BinSource.Child, BinTarget.Child {

	/**
	 * This element's name.
	 */
	final static String NAME = "external-file";

	/**
	 * Returns the <code>Href</code> attribute.
	 * 
	 * @return Returns the <code>Href</code> attribute.
	 */
	Href getHref();

	/**
	 * Sets the <code>Href</code> attribute.
	 * 
	 * @param href
	 *            The <code>Href</code> attribute. Must not be <code>null</code>
	 *            .
	 */
	void setHref(Href href);

	/**
	 * Returns the <code>Uid</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Uid</code> attribute. Might be
	 *         <code>null</code>.
	 */
	Uid getUid();

	/**
	 * Sets the <code>Uid</code> attribute.
	 * 
	 * @param uid
	 *            The <code>Uid</code> attribute. May be <code>null</code>.
	 */
	void setUid(Uid uid);

	/**
	 * Returns the <code>Crc</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Crc</code> attribute. Might be
	 *         <code>null</code>.
	 */
	Crc getCrc();

	/**
	 * Sets the <code>Crc</code> attribute.
	 * 
	 * @param crc
	 *            The <code>Crc</code> attribute. May be <code>null</code>.
	 */
	void setCrc(Crc crc);

}
