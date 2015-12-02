package com.sap.mlt.xliff12.api.element.namedgroup;

import com.sap.mlt.xliff12.api.attribute.ContextType;
import com.sap.mlt.xliff12.api.attribute.Crc;
import com.sap.mlt.xliff12.api.attribute.MatchMandatory;
import com.sap.mlt.xliff12.api.base.XliffElement;
import com.sap.mlt.xliff12.api.element.structural.AltTrans;
import com.sap.mlt.xliff12.api.element.structural.Source;
import com.sap.mlt.xliff12.api.element.structural.TransUnit;
import com.sap.mlt.xliff12.api.text.Text;

/**
 * Context - The Context element describes the context of a {@link Source}
 * within a {@link TransUnit} or a {@link AltTrans}. The purpose of this context
 * information is to allow certain pieces of text to have different translations
 * depending on where they came from. The translation of a piece of text may
 * differ if it is a web form or a dialog or an Oracle form or a Lotus form for
 * example. This information is thus required by a translator when working on
 * the file. Likewise, the information may be used by any tool proposing to
 * automatically leverage the text successfully.
 * 
 * The required {@link ContextType} attribute indicates what the context
 * information is; e.g.
 * {@link com.sap.mlt.xliff12.api.attribute.ContextType.Value#RECORDTITLE}
 * indicates the name of a record in a database. The optional
 * {@link MatchMandatory} attribute indicates that translations of the
 * {@link Source} elements within the scope of this context must have the same
 * context. The optional {@link Crc} attribute allows a verification of the
 * data.
 * 
 * @author D049314
 */
public interface Context extends XliffElement {

	/**
	 * The element's name.
	 */
	static final String NAME = "context";

	/**
	 * Returns the <code>ContextType</code> attribute.
	 * 
	 * @return Returns the <code>ContextType</code> attribute.
	 */
	ContextType getContextType();

	/**
	 * Sets the <code>ContextType</code> attribute.
	 * 
	 * @param contextType
	 *            The <code>ContextType</code> attribute. Must not be
	 *            <code>null</code>.
	 */
	void setContextType(ContextType contextType);

	/**
	 * Returns the <code>MatchMandatory</code> attribute.
	 * 
	 * @return Returns the <code>MatchMandatory</code> attribute.
	 */
	MatchMandatory getMatchMandatory();

	/**
	 * Sets the <code>MatchMandatory</code> attribute.
	 * 
	 * @param matchMandatory
	 *            The <code>MatchMandatory</code> attribute. If this parameter
	 *            is <code>null</code>, the parameter is set to the default
	 *            value <code>no</code>.
	 */
	void setMatchMandatory(MatchMandatory matchMandatory);

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
	 * Returns this element's content.
	 * 
	 * @return Returns this element's content.
	 */
	Text getContent();

	/**
	 * Sets this element's content.
	 * 
	 * @param content
	 *            The element's content. Must not be <code>null</code>.
	 */
	void setContent(Text content);

}
