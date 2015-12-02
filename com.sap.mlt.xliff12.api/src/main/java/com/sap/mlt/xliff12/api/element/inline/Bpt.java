package com.sap.mlt.xliff12.api.element.inline;

import java.util.List;

import com.sap.mlt.xliff12.api.attribute.Crc;
import com.sap.mlt.xliff12.api.attribute.CtypeDelim;
import com.sap.mlt.xliff12.api.attribute.EquivText;
import com.sap.mlt.xliff12.api.attribute.Id;
import com.sap.mlt.xliff12.api.attribute.Rid;
import com.sap.mlt.xliff12.api.attribute.Xid;
import com.sap.mlt.xliff12.api.base.CodeFragment;
import com.sap.mlt.xliff12.api.base.InlineBase;
import com.sap.mlt.xliff12.api.base.TextFragment;
import com.sap.mlt.xliff12.api.element.structural.BinUnit;
import com.sap.mlt.xliff12.api.element.structural.TransUnit;
import com.sap.mlt.xliff12.api.text.Text;

/**
 * Begin paired tag - The Bpt element is used to delimit the beginning of a
 * paired sequence of native codes. Each Bpt has a corresponding {@link Ept}
 * element within the translation unit. These paired elements are related via
 * their {@link Rid} attributes. If the {@link Rid} attribute is not present (in
 * a 1.0 document for example), the attribute {@link Id} is used to match both
 * tags. The required {@link Id} attribute is used to identify the {@link Bpt}
 * inline code. The optional {@link CtypeDelim} attribute allows you to specify
 * what kind of attribute the code represents. The optional
 * {@link com.sap.mlt.xliff12.api.attribute.Ts} attribute was DEPRECATED in
 * XLIFF 1.1. The optional {@link Crc} attribute allows a verification of the
 * data. The optional {@link Xid} attribute references a {@link TransUnit} or
 * {@link BinUnit}, through its {@link Id} attribute value, which can contain
 * any translatable text from the inline code. A list of values for the
 * {@link CtypeDelim} attribute is provided. The optional {@link EquivText}
 * attribute specifies text to substitute in place of the inline tag.
 * 
 * @author D049314
 */
public interface Bpt extends InlineBase, TextFragment {

	/**
	 * The element's name.
	 */
	static final String NAME = "bpt";

	/**
	 * Returns the <code>Rid</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Rid</code> attribute. Might be
	 *         <code>null</code>.
	 */
	Rid getRid();

	/**
	 * Sets the <code>Rid</code> attribute.
	 * 
	 * @param rid
	 *            The <code>Rid</code> attribute. May be <code>null</code>.
	 */
	void setRid(Rid rid);

	/**
	 * Returns the <code>CtypeDelim</code> attribute. Might be <code>null</code>
	 * .
	 * 
	 * @return Returns the <code>CtypeDelim</code> attribute. Might be
	 *         <code>null</code>.
	 */
	CtypeDelim getCtype();

	/**
	 * Sets the <code>CtypeDelim</code> attribute.
	 * 
	 * @param ctype
	 *            The <code>CtypeDelim</code> attribute. May be
	 *            <code>null</code>.
	 */
	void setCtype(CtypeDelim ctype);

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
	 * Returns the list of <code>CodeFragment</code>s. This can be any
	 * combination of {@link Sub} elements and {@link Text}s.
	 * 
	 * @return Returns the list of <code>CodeFragment</code>s. This can be any
	 *         combination of {@link Sub} elements and {@link Text}s.
	 */
	List<? extends CodeFragment> getContent();

	/**
	 * Sets the list of <code>CodeFragment</code>s.
	 * 
	 * @param content
	 *            The list of <code>CodeFragment</code>s. Must not be
	 *            <code>null</null>. This can be any combination of
	 *            {@link Sub} elements and {@link Text}s.
	 */
	void setContent(List<? extends CodeFragment> content);

}
