package com.sap.mlt.xliff12.api.element.header;

import com.sap.mlt.xliff12.api.attribute.Annotates;
import com.sap.mlt.xliff12.api.attribute.From;
import com.sap.mlt.xliff12.api.attribute.Priority;
import com.sap.mlt.xliff12.api.attribute.XmlLang;
import com.sap.mlt.xliff12.api.base.XliffElement;
import com.sap.mlt.xliff12.api.element.structural.AltTrans;
import com.sap.mlt.xliff12.api.element.structural.BinUnit;
import com.sap.mlt.xliff12.api.element.structural.Source;
import com.sap.mlt.xliff12.api.element.structural.Target;
import com.sap.mlt.xliff12.api.element.structural.TransUnit;
import com.sap.mlt.xliff12.api.text.Text;

/**
 * Note - The Note element is used to add localization-related comments to the
 * XLIFF document. The content of Note may be instructions from developers about
 * how to handle the {@link Source}, comments from the translator about the
 * translation, or any comment from anyone involved in processing the XLIFF
 * file. The optional {@link XmlLang} attribute specifies the language of the
 * note content. The optional {@link From} attribute indicates who entered the
 * note. The optional {@link Priority} attribute allows a priority from 1 (high)
 * to 10 (low) to be assigned to the note. The optional {@link Annotates}
 * attribute indicates if the note is a general note or, in the case of a
 * {@link TransUnit}, pertains specifically to the {@link Source} or the
 * {@link Target} element.
 * 
 * @author D049314
 */
public interface Note extends XliffElement, Header.Context, TransUnit.Context,
		AltTrans.Context, BinUnit.Context {

	/**
	 * The element's name.
	 */
	final static String NAME = "note";

	/**
	 * Returns the note.
	 * 
	 * @return Returns the note.
	 */
	Text getNote();

	/**
	 * Sets the note.
	 * 
	 * @param text
	 *            The note. Must not be <code>null</code>.
	 */
	void setNote(Text text);

	/**
	 * Returns the <code>XmlLang</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>XmlLang</code> attribute. Might be
	 *         <code>null</code> .
	 */
	XmlLang getXmlLang();

	/**
	 * Sets the <code>XmlLang</code> attribute.
	 * 
	 * @param xmlLang
	 *            The <code>XmlLang</code> attribute. May be <code>null</code>.
	 */
	void setXmlLang(XmlLang xmlLang);

	/**
	 * Returns the <code>From</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>From</code> attribute. Might be
	 *         <code>null</code>.
	 */
	From getFrom();

	/**
	 * Sets the <code>From</code> attribute.
	 * 
	 * @param from
	 *            The <code>From</code> attribute. May be <code>null</code>.
	 */
	void setFrom(From from);

	/**
	 * Returns the <code>Priority</code> attribute.
	 * 
	 * @return Returns the <code>Priority</code> attribute.
	 */
	Priority getPriority();

	/**
	 * Sets the <code>Priority</code> attribute.
	 * 
	 * @param priority
	 *            The <code>Priority</code> attribute. If this parameter is
	 *            <code>null</code> the attribute is set to the default priority
	 *            (1).
	 */
	void setPriority(Priority priority);

	/**
	 * Returns the <code>Annotates</code> attribute.
	 * 
	 * @return Returns the <code>Annotates</code> attribute.
	 */
	Annotates getAnnotates();

	/**
	 * Sets the <code>Annotates</code> attribute.
	 * 
	 * @param annotates
	 *            The <code>Annotates</code> attribute. If this parameter is
	 *            <code>null</code> the attribute is set to the default value
	 *            (general).
	 */
	void setAnnotates(Annotates annotates);

}
