package com.sap.mlt.xliff12.api.element.toplevel;

import java.util.Collection;

import com.sap.mlt.xliff12.api.attribute.BuildNum;
import com.sap.mlt.xliff12.api.attribute.Category;
import com.sap.mlt.xliff12.api.attribute.DataType;
import com.sap.mlt.xliff12.api.attribute.Date;
import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.api.attribute.Original;
import com.sap.mlt.xliff12.api.attribute.ProductName;
import com.sap.mlt.xliff12.api.attribute.ProductVersion;
import com.sap.mlt.xliff12.api.attribute.SourceLanguage;
import com.sap.mlt.xliff12.api.attribute.TargetLanguage;
import com.sap.mlt.xliff12.api.attribute.ToolId;
import com.sap.mlt.xliff12.api.attribute.XmlSpace;
import com.sap.mlt.xliff12.api.base.XliffElement;
import com.sap.mlt.xliff12.api.element.header.Header;
import com.sap.mlt.xliff12.api.element.header.Tool;
import com.sap.mlt.xliff12.api.element.structural.Body;
import com.sap.mlt.xliff12.api.element.structural.Source;
import com.sap.mlt.xliff12.api.element.structural.Target;

/**
 * File - The File element corresponds to a single extracted original document.
 * The required {@link Original} attribute specifies the name of the file from
 * which this file content is derived. The required {@link DataType} attribute
 * specifies the format of the original file; e.g. "html". The required
 * {@link SourceLanguage} attribute specifies the language of the {@link Source}
 * content. The optional {@link TargetLanguage} attribute is used to specify the
 * language of the {@link Target} content. The optional {@link ToolId} attribute
 * accepts the id of the {@link Tool} used to generate this XLIFF document. The
 * optional {@link Date} attribute is used to specify the creation date of this
 * XLIFF file. The optional {@link XmlSpace} attribute is used to specify how
 * white-spaces are to be treated. The optional {@link Category} attribute is
 * used to specify a general category of the content of the file; e.g.
 * "medical". The optional {@link ProductName} attribute is used to specify the
 * name of the product which uses this file. The optional {@link ProductVersion}
 * and {@link BuildNum} attributes are used to specify the revision of the
 * product from which this file comes. The
 * {@link com.sap.mlt.xliff12.api.attribute.Tool} and
 * {@link com.sap.mlt.xliff12.api.attribute.Ts} attributes have been deprecated
 * in XLIFF 1.1.
 * 
 * @author D049314
 */
public interface File extends XliffElement {

	/**
	 * Name of this element
	 */
	static final String NAME = "file";

	/**
	 * Returns the <code>Original</code> attribute.
	 * 
	 * @return Returns the <code>Original</code> attribute.
	 */
	Original getOriginal();

	/**
	 * Sets the {@link Original} attribute.
	 * 
	 * @param original
	 *            The {@link Original} attribute. Must not be <code>null</code>.
	 */
	void setOriginal(Original original);

	/**
	 * Returns the <code>SourceLanguage</code> attribute.
	 * 
	 * @return Returns the <code>SourceLanguage</code> attribute.
	 */
	SourceLanguage getSourceLanguage();

	/**
	 * Sets the {@link SourceLanguage} attribute.
	 * 
	 * @param sourceLanguage
	 *            The {@link SourceLanguage} attribute. Must not be
	 *            <code>null</code>.
	 */
	void setSourceLanguage(SourceLanguage sourceLanguage);

	/**
	 * Returns the <code>DataType</code> attribute.
	 * 
	 * @return Returns the <code>DataType</code> attribute.
	 */
	DataType getDataType();

	/**
	 * Sets the {@link DataType} attribute.
	 * 
	 * @param dataType
	 *            The {@link DataType} attribute. Must not be <code>null</code>.
	 */
	void setDataType(DataType dataType);

	/**
	 * Returns the <code>Body</code> element.
	 * 
	 * @return Returns the <code>Body</code> element.
	 */
	Body getBody();

	/**
	 * Sets the <code>Body</code> element.
	 * 
	 * @param body
	 *            The <code>Body</code> element. Must not be <code>null</code>.
	 */
	void setBody(Body body);

	/**
	 * Returns the <code>Tool</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Tool</code> attribute. Might be
	 *         <code>null</code>.
	 * 
	 * @deprecated The <code>Tool</code> attribute was DEPRECATED in version
	 *             1.1. Instead, use the {@link Tool} element and a
	 *             {@link ToolId} attribute.
	 */
	com.sap.mlt.xliff12.api.attribute.Tool getTool();

	/**
	 * Sets the <code>Tool</code> attribute.
	 * 
	 * @param tool
	 *            The <code>Tool</code> attribute. May be <code>null</code>.
	 * 
	 * @deprecated The <code>Tool</code> attribute was DEPRECATED in version
	 *             1.1. Instead, use the {@link Tool} element and a
	 *             {@link ToolId} attribute.
	 */
	void setTool(com.sap.mlt.xliff12.api.attribute.Tool tool);

	/**
	 * Returns the <code>ToolId</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>ToolId</code> attribute. Might be
	 *         <code>null</code>.
	 */
	ToolId getToolId();

	/**
	 * Sets the <code>ToolId</code> attribute.
	 * 
	 * @param toolId
	 *            The <code>ToolId</code> attribute. May be <code>null</code>.
	 */
	void setToolId(ToolId toolId);

	/**
	 * Returns the <code>Date</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Date</code> attribute. Might be
	 *         <code>null</code>.
	 */
	Date getDate();

	/**
	 * Sets the <code>Date</code> attribute.
	 * 
	 * @param date
	 *            The <code>Date</code> attribute. May be <code>null</code>.
	 */
	void setDate(Date date);

	/**
	 * Returns the <code>XmlSpace</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>XmlSpace</code> attribute. Might be
	 *         <code>null</code>.
	 */
	XmlSpace getXmlSpace();

	/**
	 * Sets the <code>XmlSpace</code> attribute.
	 * 
	 * @param xmlSpace
	 *            The <code>XmlSpace</code> attribute. May be <code>null</code>.
	 */
	void setXmlSpace(XmlSpace xmlSpace);

	/**
	 * Returns the <code>Ts</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Ts</code> attribute. Might be <code>null</code>
	 *         .
	 * 
	 * @deprecated The <code>Ts</code> attribute was DEPRECATED in version 1.1.
	 *             Instead, use attributes defined in a namespace different from
	 *             XLIFF.
	 */
	com.sap.mlt.xliff12.api.attribute.Ts getTs();

	/**
	 * Sets the <code>Ts</code> attribute.
	 * 
	 * @param ts
	 *            The <code>Ts</code> attribute. May be <code>null</code>.
	 * 
	 * @deprecated The <code>Ts</code> attribute was DEPRECATED in version 1.1.
	 *             Instead, use attributes defined in a namespace different from
	 *             XLIFF.
	 */
	void setTs(com.sap.mlt.xliff12.api.attribute.Ts ts);

	/**
	 * Returns the <code>Category</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Category</code> attribute. Might be
	 *         <code>null</code>.
	 */
	Category getCategory();

	/**
	 * Sets the <code>Category</code> attribute.
	 * 
	 * @param category
	 *            The <code>Category</code> attribute. May be <code>null</code>.
	 */
	void setCategory(Category category);

	/**
	 * Returns the <code>TargetLanguage</code> attribute. Might be
	 * <code>null</code>.
	 * 
	 * @return Returns the <code>TargetLanguage</code> attribute. Might be
	 *         <code>null</code>.
	 */
	TargetLanguage getTargetLanguage();

	/**
	 * Sets the <code>TargetLanguage</code>. Should always be set if the
	 * {@link File} contains any {@link Target} elements.
	 * 
	 * @param targetLanguage
	 *            The target language. May be <code>null</code>.
	 */
	void setTargetLanguage(TargetLanguage targetLanguage);

	/**
	 * Returns the <code>ProductName</code> attribute. Might be
	 * <code>null</code>.
	 * 
	 * @return Returns the <code>ProductName</code> attribute. Might be
	 *         <code>null</code>.
	 */
	ProductName getProductName();

	/**
	 * Sets the <code>ProductName</code> attribute.
	 * 
	 * @param productName
	 *            The <code>ProductName</code> attribute. May be
	 *            <code>null</code>.
	 */
	void setProductName(ProductName productName);

	/**
	 * Returns the <code>ProductVersion</code> attribute. Might be
	 * <code>null</code>.
	 * 
	 * @return Returns the <code>ProductVersion</code> attribute. Might be
	 *         <code>null</code>.
	 */
	ProductVersion getProductVersion();

	/**
	 * Sets the <code>ProductVersion</code> attribute.
	 * 
	 * @param productVersion
	 *            The <code>ProductVersion</code> attribute. May be
	 *            <code>null</code> .
	 */
	void setProductVersion(ProductVersion productVersion);

	/**
	 * Returns the <code>BuildNum</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>BuildNum</code> attribute. Might be
	 *         <code>null</code>.
	 */
	BuildNum getBuildNum();

	/**
	 * Sets the <code>BuildNum</code> attribute.
	 * 
	 * @param buildNum
	 *            The <code>BuildNum</code> attribute. May be <code>null</code>.
	 */
	void setBuildNum(BuildNum buildNum);

	/**
	 * Returns the non-XLIFF attributes.
	 * 
	 * @return Returns the non-XLIFF attributes.
	 */
	Collection<NonXliffAttribute> getNonXliffAttributes();

	/**
	 * Sets the non-XLIFF attributes.
	 * 
	 * @param nonXliffAttributes
	 *            The non-XLIFF attributes. Must not be <code>null</code>.
	 */
	void setNonXliffAttributes(Collection<NonXliffAttribute> nonXliffAttributes);

	/**
	 * Returns the <code>Header</code> element. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Header</code> element. Might be
	 *         <code>null</code>.
	 */
	Header getHeader();

	/**
	 * Sets the <code>Header</code> element.
	 * 
	 * @param header
	 *            The <code>Header</code> element. May be <code>null</code>.
	 */
	void setHeader(Header header);

}
