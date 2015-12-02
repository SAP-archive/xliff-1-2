package com.sap.mlt.xliff12.api.element.header;

import com.sap.mlt.xliff12.api.attribute.Crc;
import com.sap.mlt.xliff12.api.attribute.Form;
import com.sap.mlt.xliff12.api.base.XliffElement;
import com.sap.mlt.xliff12.api.element.structural.BinSource;
import com.sap.mlt.xliff12.api.element.structural.BinTarget;
import com.sap.mlt.xliff12.api.text.Text;

/**
 * Internal file - The InternalFile element contains the actual file being
 * referenced. It is a child of the {@link Skl}, {@link Glossary}, and
 * {@link Reference} elements. The format of the file is specified by the
 * optional {@link Form} attribute, which accepts mime-type values. The
 * {@link Crc} attribute accepts a value that can be used to precisely identify
 * and assure the authenticity of the file.
 * 
 * @author D049314
 */
public interface InternalFile extends XliffElement, Skl.Child, Glossary.Child,
		Reference.Child, BinSource.Child, BinTarget.Child {

	/**
	 * The element's name.
	 */
	static final String NAME = "internal-file";

	/**
	 * Returns the <code>Form</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Form</code> attribute. Might be
	 *         <code>null</code>.
	 */
	Form getForm();

	/**
	 * Sets the <code>Form</code> attribute.
	 * 
	 * @param form
	 *            The <code>Form</code> attribute. May be <code>null</code>.
	 */
	void setForm(Form form);

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

	/**
	 * Returns the embedded file.
	 * 
	 * @return Returns the embedded file.
	 */
	Text getEmbeddedFile();

	/**
	 * Sets the embedded file.
	 * 
	 * @param embeddedFile
	 *            The embedded file. Must not be <code>null</code>.
	 */
	void setEmbeddedFile(Text embeddedFile);

}
