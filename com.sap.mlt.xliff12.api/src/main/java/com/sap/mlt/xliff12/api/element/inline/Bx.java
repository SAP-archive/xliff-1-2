package com.sap.mlt.xliff12.api.element.inline;

import com.sap.mlt.xliff12.api.attribute.Clone;
import com.sap.mlt.xliff12.api.attribute.CtypeDelim;
import com.sap.mlt.xliff12.api.attribute.EquivText;
import com.sap.mlt.xliff12.api.attribute.Id;
import com.sap.mlt.xliff12.api.attribute.Rid;
import com.sap.mlt.xliff12.api.attribute.Xid;
import com.sap.mlt.xliff12.api.base.InlineBase;
import com.sap.mlt.xliff12.api.base.TextFragment;
import com.sap.mlt.xliff12.api.element.structural.BinUnit;
import com.sap.mlt.xliff12.api.element.structural.TransUnit;

/**
 * Begin paired placeholder - The Bx element is used to replace a beginning
 * paired code of the original document. It should be used for paired codes that
 * do not follow XML well-formedness rules (i.e. no overlapping elements). If
 * the paired codes follow that rule, it is strongly recommended that the
 * {@link G} element is used because it simplifies processing. The Bx element
 * should be followed by a matching Ex element. These paired elements are
 * related via their {@link Rid} attributes. If the {@link Rid} attribute is not
 * present (in a 1.0 document for example), the attribute {@link Id} is used to
 * match both tags. The required {@link Id} attribute is used to reference the
 * replaced code in the skeleton file. The optional {@link CtypeDelim} attribute
 * allows you to specify what kind of attribute the placeholder represents. The
 * optional {@link com.sap.mlt.xliff12.api.attribute.Ts} attribute was
 * DEPRECATED in XLIFF 1.1. The optional {@link Clone} attribute indicates
 * whether this Bx element may be duplicated. The optional {@link Xid} attribute
 * references a {@link TransUnit} or {@link BinUnit}, through its {@link Id}
 * attribute value, which can contain any translatable text from the replaced
 * code. A list of values for the {@link CtypeDelim} attribute is provided. The
 * optional {@link EquivText} attribute specifies text to substitute in place of
 * the inline tag.
 * 
 * @author D049314
 */
public interface Bx extends InlineBase, TextFragment {

	/**
	 * The element's name.
	 */
	static final String NAME = "bx";

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

}
