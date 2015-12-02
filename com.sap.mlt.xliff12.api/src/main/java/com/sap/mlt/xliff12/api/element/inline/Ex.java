package com.sap.mlt.xliff12.api.element.inline;

import com.sap.mlt.xliff12.api.attribute.EquivText;
import com.sap.mlt.xliff12.api.attribute.Id;
import com.sap.mlt.xliff12.api.attribute.Rid;
import com.sap.mlt.xliff12.api.attribute.Xid;
import com.sap.mlt.xliff12.api.base.InlineBase;
import com.sap.mlt.xliff12.api.base.TextFragment;
import com.sap.mlt.xliff12.api.element.structural.BinUnit;
import com.sap.mlt.xliff12.api.element.structural.TransUnit;

/**
 * End paired placeholder - The Ex element is used to replace an ending paired
 * code of the original document. It should be used for paired codes that do not
 * follow XML well-formedness rules (i.e. no overlapping elements). If the
 * paired codes follow that rule, it is strongly recommended that the {@link G}
 * element is used because it simplifies processing. The Ex element should be
 * preceded by a matching {@link Bx} element. These paired elements are related
 * via their {@link Rid} attributes. If the {@link Rid} attribute is not present
 * (in a 1.0 document for example), the attribute {@link Id} is used to match
 * both tags. The required {@link Id} attribute is used to reference the
 * replaced code in the skeleton file. The optional
 * {@link com.sap.mlt.xliff12.api.attribute.Ts} attribute was DEPRECATED in
 * XLIFF 1.1. The optional {@link Xid} attribute references a {@link TransUnit}
 * or {@link BinUnit}, through its {@link Id} attribute value, which can contain
 * any translatable text from the replaced code. The optional {@link EquivText}
 * attribute specifies text to substitute in place of the inline tag.
 * 
 * @author D049314
 */
public interface Ex extends InlineBase, TextFragment {

	/**
	 * The element's name.
	 */
	static final String NAME = "ex";

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

}
