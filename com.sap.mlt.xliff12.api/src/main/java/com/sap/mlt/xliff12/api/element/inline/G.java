package com.sap.mlt.xliff12.api.element.inline;

import java.util.List;

import com.sap.mlt.xliff12.api.attribute.Clone;
import com.sap.mlt.xliff12.api.attribute.CtypeDelim;
import com.sap.mlt.xliff12.api.attribute.EquivText;
import com.sap.mlt.xliff12.api.attribute.Id;
import com.sap.mlt.xliff12.api.attribute.Xid;
import com.sap.mlt.xliff12.api.base.InlineBase;
import com.sap.mlt.xliff12.api.base.TextFragment;
import com.sap.mlt.xliff12.api.element.delimiter.Mrk;
import com.sap.mlt.xliff12.api.element.structural.BinUnit;
import com.sap.mlt.xliff12.api.element.structural.TransUnit;
import com.sap.mlt.xliff12.api.text.Text;

/**
 * Generic group placeholder - The G element is used to replace any inline code
 * of the original document that has a beginning and an end, does not overlap
 * other paired inline codes, and can be moved within its parent structural
 * element. The required {@link Id} attribute is used to reference the replaced
 * code in the skeleton file. The optional {@link CtypeDelim} attribute allows
 * you to specify what kind of attribute the placeholder represents; e.g.
 * {@link com.sap.mlt.xliff12.api.attribute.CtypeDelim.Value#BOLD}. The optional
 * {@link com.sap.mlt.xliff12.api.attribute.Ts} attribute was DEPRECATED in
 * XLIFF 1.1. The optional {@link Clone} attribute indicates whether this G
 * element may be duplicated. The optional {@link Xid} attribute references a
 * {@link TransUnit} or {@link BinUnit}, through its {@link Id} attribute value,
 * which can contain any translatable text from the replaced code. A list of
 * values for the {@link CtypeDelim} attribute is available. The optional
 * {@link EquivText} attribute specifies text to substitute in place of the
 * inline tag. A G element can contain another G element.
 * 
 * @author D049314
 */
public interface G extends InlineBase, TextFragment {

	/**
	 * The element's name.
	 */
	static final String NAME = "g";

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
	 * Returns the <code>Clone</code> attribute.
	 * 
	 * @return Returns the <code>Clone</code> attribute.
	 */
	Clone getClone();

	/**
	 * Sets the <code>Clone</code> attribute.
	 * 
	 * @param clone
	 *            The <code>Clone</code> attribute. If this parameter is
	 *            <code>null</code>, the attribute is set to the default value
	 *            <code>yes</code>.
	 */
	void setClone(Clone clone);

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
