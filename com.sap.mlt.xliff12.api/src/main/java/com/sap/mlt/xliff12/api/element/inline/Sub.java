package com.sap.mlt.xliff12.api.element.inline;

import java.util.List;

import com.sap.mlt.xliff12.api.attribute.CtypeDelim;
import com.sap.mlt.xliff12.api.attribute.DataType;
import com.sap.mlt.xliff12.api.attribute.Id;
import com.sap.mlt.xliff12.api.attribute.Xid;
import com.sap.mlt.xliff12.api.base.CodeFragment;
import com.sap.mlt.xliff12.api.base.TextFragment;
import com.sap.mlt.xliff12.api.base.XliffElement;
import com.sap.mlt.xliff12.api.element.delimiter.Mrk;
import com.sap.mlt.xliff12.api.element.structural.BinUnit;
import com.sap.mlt.xliff12.api.element.structural.TransUnit;
import com.sap.mlt.xliff12.api.text.Text;

/**
 * Sub-flow - The Sub element is used to delimit sub-flow text inside a sequence
 * of native code, for example: the definition of a footnote or the text of a
 * title attribute in a HTML <code>&lt;a&gt;</code> element. The optional
 * {@link DataType} attribute specifies the data type of the content of the
 * Sub.. The optional {@link CtypeDelim} attribute allows you to specify what
 * kind of attribute the code represents. The optional {@link Xid} attribute
 * references a {@link TransUnit} or {@link BinUnit}, through its {@link Id}
 * attribute value, which can contain any translatable text from the inline
 * code. Lists of values for the {@link CtypeDelim} and {@link DataType}
 * attributes are provided.
 * 
 * @author D049314
 */
public interface Sub extends XliffElement, CodeFragment {

	/**
	 * The element's name.
	 */
	static final String NAME = "sub";

	/**
	 * Returns the <code>DataType</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>DataType</code> attribute. Might be
	 *         <code>null</code>.
	 */
	DataType getDataType();

	/**
	 * Sets the <code>DataType</code> attribute.
	 * 
	 * @param dataType
	 *            The <code>DataType</code> attribute. May be <code>null</code>.
	 */
	void setDataType(DataType dataType);

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
	 * Returns the <code>Xid</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>Xid</code> attribute. Might be
	 *         <code>null</code>.
	 */
	Xid getXid();

	/**
	 * Sets the <code>Xid</code> attribute.
	 * 
	 * @param xid
	 *            The <code>Xid</code> attribute. May be <code>null</code>.
	 */
	void setXid(Xid xid);

	/**
	 * Returns the content of this element. This is a list of any combination of
	 * {@link Text}s, {@link Bpt}s, {@link Ept}s, {@link Bx}s, {@link Ex}s
	 * {@link G}s, {@link It}, {@link Mrk}, {@link Ph}s and {@link X}s.
	 * 
	 * @return Returns the content of this element. This is a list of any
	 *         combination of {@link Text}s, {@link Bpt}s, {@link Ept}s,
	 *         {@link Bx}s, {@link Ex}s {@link G}s, {@link It}, {@link Mrk},
	 *         {@link Ph}s and {@link X}s.
	 */
	List<? extends TextFragment> getContent();

	/**
	 * Sets the content of this element.
	 * 
	 * @param content
	 *            The content. Must not be <code>null</code>. This can be any
	 *            combination of {@link Text}s, {@link Bpt}s, {@link Ept}s,
	 *            {@link Bx}s, {@link Ex}s {@link G}s, {@link It}, {@link Mrk},
	 *            {@link Ph}s and {@link X}s.
	 */
	void setContent(List<? extends TextFragment> content);

}
