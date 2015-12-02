package com.sap.mlt.xliff12.api.element.inline;

import com.sap.mlt.xliff12.api.attribute.Clone;
import com.sap.mlt.xliff12.api.attribute.CtypePh;
import com.sap.mlt.xliff12.api.attribute.EquivText;
import com.sap.mlt.xliff12.api.attribute.Id;
import com.sap.mlt.xliff12.api.attribute.Xid;
import com.sap.mlt.xliff12.api.base.InlineBase;
import com.sap.mlt.xliff12.api.base.TextFragment;
import com.sap.mlt.xliff12.api.element.structural.BinUnit;
import com.sap.mlt.xliff12.api.element.structural.TransUnit;

/**
 * Generic placeholder - The X element is used to replace any code of the
 * original document. The required {@link Id} attribute is used to reference the
 * replaced code in the skeleton file. The optional {@link CtypePh} attribute
 * allows you to specify what kind of attribute the placeholder represents. The
 * optional {@link com.sap.mlt.xliff12.api.attribute.Ts} attribute was
 * DEPRECATED in XLIFF 1.1. The optional {@link Clone} attribute indicates
 * whether this X element may be duplicated. The optional {@link Xid} attribute
 * references a {@link TransUnit} or {@link BinUnit}, through its {@link Id}
 * attribute value, which can contain any translatable text from the replaced
 * code. A list of values for the {@link CtypePh} attribute is provided by. The
 * optional {@link EquivText} attribute specifies text to substitute in place of
 * the inline tag.
 * 
 * @author D049314
 */
public interface X extends InlineBase, TextFragment {

	static final String NAME = "x";

	/**
	 * Returns the <code>CtypePh</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>CtypePh</code> attribute. Might be
	 *         <code>null</code>.
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
