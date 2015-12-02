package com.sap.mlt.xliff12.api.base;

import java.util.Collection;

import com.sap.mlt.xliff12.api.attribute.EquivText;
import com.sap.mlt.xliff12.api.attribute.Id;
import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.api.attribute.Xid;

/**
 * Basic interface extended by most inline elements.
 * 
 * @author D049314
 */
public interface InlineBase extends XliffElement {

	/**
	 * Returns the <code>Id</code> attribute of the inline element.
	 * 
	 * @return Returns the <code>Id</code> attribute of the inline element.
	 */
	Id getId();

	/**
	 * Sets the <code>Id</code> attribute of the inline element.
	 * 
	 * @param id
	 *            The <code>Id</code> attribute. Must not be <code>null</code>.
	 */
	void setId(Id id);

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
	 * Returns the <code>EquivText</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>EquivText</code> attribute. Might be
	 *         <code>null</code>.
	 */
	EquivText getEquivText();

	/**
	 * Sets the <code>EquivText</code> attribute.
	 * 
	 * @param equivText
	 *            The <code>EquivText</code> attribute. May be <code>null</code>
	 *            .
	 */
	void setEquivText(EquivText equivText);

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
	 *            Non-XLIFF attributes. Must not be <code>null</code>.
	 */
	void setNonXliffAttributes(Collection<NonXliffAttribute> nonXliffAttributes);

}
