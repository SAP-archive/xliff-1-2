package com.sap.mlt.xliff12.api.element.inline;

import java.util.List;

import com.sap.mlt.xliff12.api.attribute.Assoc;
import com.sap.mlt.xliff12.api.attribute.Crc;
import com.sap.mlt.xliff12.api.attribute.CtypePh;
import com.sap.mlt.xliff12.api.attribute.EquivText;
import com.sap.mlt.xliff12.api.attribute.Id;
import com.sap.mlt.xliff12.api.attribute.Xid;
import com.sap.mlt.xliff12.api.base.CodeFragment;
import com.sap.mlt.xliff12.api.base.InlineBase;
import com.sap.mlt.xliff12.api.base.TextFragment;
import com.sap.mlt.xliff12.api.element.structural.BinUnit;
import com.sap.mlt.xliff12.api.element.structural.TransUnit;
import com.sap.mlt.xliff12.api.text.Text;

/**
 * Placeholder - The Ph element is used to delimit a sequence of native
 * stand-alone codes in the translation unit. The required {@link Id} attribute
 * is used to identify the Ph inline code. The optional {@link CtypePh}
 * attribute allows you to specify what kind of attribute the placeholder
 * represents. The optional {@link com.sap.mlt.xliff12.api.attribute.Ts}
 * attribute was DEPRECATED in XLIFF 1.1. The optional {@link Crc} attribute
 * allows a verification of the data. The optional {@link Assoc} attribute
 * specifies whether this placeholder code is associated with the text prior or
 * after. The optional {@link Xid} attribute references a {@link TransUnit} or
 * {@link BinUnit}, through its {@link Id} attribute value, which can contain
 * any translatable text from the replaced code. A list of values for the
 * {@link CtypePh} attribute is provided. The optional {@link EquivText}
 * attribute specifies text to substitute in place of the inline tag.
 * 
 * @author D049314
 */
public interface Ph extends InlineBase, TextFragment {

	/**
	 * The element's name.
	 */
	static final String NAME = "ph";

	/**
	 * Returns the <code>CtypePh</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>CtypePh</code> attribute. Might be
	 *         <code>null</code> .
	 */
	CtypePh getCtype();

	/**
	 * Sets the <code>CtypePh</code> attribute.
	 * 
	 * @param ctype
	 *            The <code>CtypePh</code> attribute. May be <code>null</code>.
	 */
	void setCtype(CtypePh ctype);

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
	 * Returns the <code>Assoc</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Assoc</code> attribute. Might be
	 *         <code>null</code>.
	 */
	Assoc getAssoc();

	/**
	 * Sets the <code>Assoc</code> attribute.
	 * 
	 * @param assoc
	 *            The <code>Assoc</code> attribute. May be <code>null</code>.
	 */
	void setAssoc(Assoc assoc);

	/**
	 * Returns the list of <code>CodeFragment</code>s. This can be any
	 * combination of {@link Sub} elements and {@link Text}s.
	 * 
	 * @return Returns the list of {@link CodeFragment}s. This can be any
	 *         combination of {@link Sub} elements and {@link Text}s.
	 */
	List<? extends CodeFragment> getContent();

	/**
	 * Sets the list of <code>CodeFragment</code>s.
	 * 
	 * @param content
	 *            The list of {@link CodeFragment}s. Must not be
	 *            <code>null</null>. This can be any combination of
	 *            {@link Sub} elements and {@link Text}s.
	 */
	void setContent(List<? extends CodeFragment> content);

}
