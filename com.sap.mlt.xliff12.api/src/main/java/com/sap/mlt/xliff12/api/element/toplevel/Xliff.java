package com.sap.mlt.xliff12.api.element.toplevel;

import java.util.Collection;
import java.util.List;

import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.api.attribute.Version;
import com.sap.mlt.xliff12.api.attribute.XmlLang;
import com.sap.mlt.xliff12.api.base.XliffElement;
import com.sap.mlt.xliff12.api.element.nonxliff.NonXliffElement;

/**
 * XLIFF document - The Xliff element encloses all the other elements of the
 * document.
 * 
 * The required {@link Version} attribute specifies the version of XLIFF. The
 * optional {@link XmlLang} attribute is used to specify the language of the
 * content of the document.
 * 
 * @author D049314
 */
public interface Xliff extends XliffElement {

	/**
	 * Name of this element
	 */
	final static String NAME = "xliff";

	/**
	 * Returns the version of the XLIFF document.
	 * 
	 * @return Returns the version of the XLIFF document.
	 */
	Version getVersion();

	/**
	 * Sets the version of the XLIFF document. Set the version to
	 * {@link com.sap.mlt.xliff12.api.attribute.Version.Value#V1_2} only, except
	 * you know exactly what you are doing.
	 * 
	 * @param version
	 *            The version of the XLIFF document. Must not be
	 *            <code>null</code>.
	 */
	void setVersion(Version version);

	/**
	 * Returns the language of the document. Might return <code>null</code>.
	 * 
	 * @return Returns the language of the document. Might return
	 *         <code>null</code>.
	 */
	XmlLang getXmlLang();

	/**
	 * Sets the language of the XLIFF document.
	 * 
	 * @param xmlLang
	 *            The language of the document. Might be <code>null</code>.
	 */
	void setXmlLang(XmlLang xmlLang);

	/**
	 * Returns the non-XLIFF attributes of this element.
	 * 
	 * @return Returns the non-XLIFF attributes of this element.
	 */
	Collection<NonXliffAttribute> getNonXliffAttributes();

	/**
	 * Sets the non-XLIFF attributes of this element.
	 * 
	 * @param nonXliffAttributes
	 *            Non-XLIFF attributes
	 */
	void setNonXliffAttributes(Collection<NonXliffAttribute> nonXliffAttributes);

	/**
	 * Returns the list of <code>File</code>s contained in this element.
	 * 
	 * @return Returns the list of <code>File</code>s contained in this element.
	 */
	List<File> getFiles();

	/**
	 * Sets the list of <code>File</code>s contained in this element.
	 * 
	 * @param files
	 *            The list of <code>File</code>s. Must not be empty.
	 */
	void setFiles(List<File> files);

	/**
	 * Returns the list of non-XLIFF elements contained in this element.
	 * 
	 * Note that the specification and the XML schema are inconsistent with
	 * regards to non-XLIFF element. Therefore the API allows reading files with
	 * non-XLIFF element contained in this element, but does not allow setting
	 * non-XLIFF elements and won't write them to files.
	 * 
	 * @return Returns the list of non-XLIFF elements contained in this element.
	 */
	List<NonXliffElement> getNonXliffElements();

}
