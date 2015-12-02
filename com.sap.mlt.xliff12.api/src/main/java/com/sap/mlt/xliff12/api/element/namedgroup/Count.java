package com.sap.mlt.xliff12.api.element.namedgroup;

import com.sap.mlt.xliff12.api.attribute.CountType;
import com.sap.mlt.xliff12.api.attribute.PhaseName;
import com.sap.mlt.xliff12.api.attribute.Unit;
import com.sap.mlt.xliff12.api.base.XliffElement;
import com.sap.mlt.xliff12.api.element.header.Phase;
import com.sap.mlt.xliff12.api.text.Text;

/**
 * Count - The Count element contains information about counts. For each Count
 * element the required {@link CountType} attribute indicates what kind of count
 * the element represents, and the optional {@link Unit} attribute indicates the
 * unit of the count (by default: word). A list of values for {@link CountType}
 * and {@link Unit} is provided. The optional {@link PhaseName} attribute
 * references the {@link Phase} in which the count was produced.
 * 
 * @author D049314
 */
public interface Count extends XliffElement {

	/**
	 * The element's name.
	 */
	static final String NAME = "count";

	/**
	 * Returns the <code>CountType</code> attribute.
	 * 
	 * @return Returns the <code>CountType</code> attribute.
	 */
	CountType getCountType();

	/**
	 * Sets the <code>CountType</code> attribute.
	 * 
	 * @param countType
	 *            The <code>CountType</code> attribute. Must not be
	 *            <code>null</code> .
	 */
	void setCountType(CountType countType);

	/**
	 * Returns the <code>PhaseName</code> attribute. Might be <code>null</code>.
	 * 
	 * @return Returns the <code>PhaseName</code> attribute. Might be
	 *         <code>null</code>.
	 */
	PhaseName getPhaseName();

	/**
	 * Sets the <code>PhaseName</code> attribute.
	 * 
	 * @param phaseName
	 *            The <code>PhaseName</code> attribute. May be <code>null</code>
	 *            .
	 */
	void setPhaseName(PhaseName phaseName);

	/**
	 * Returns the <code>Unit</code> attribute.
	 * 
	 * @return Returns the <code>Unit</code> attribute.
	 */
	Unit getUnit();

	/**
	 * Sets the <code>Unit</code> attribute.
	 * 
	 * @param unit
	 *            The <code>Unit</code> attribute. If this parameter is
	 *            <code>null</code>, the attribute is set to the default value
	 *            <code>word</code>.
	 */
	void setUnit(Unit unit);

	/**
	 * Returns the number contained in this element.
	 * 
	 * @return Returns the number contained in this element.
	 */
	Text getNumber();

	/**
	 * Sets the number contained in this element.
	 * 
	 * @param number
	 *            The number. Must not be <code>null</code>.
	 */
	void setNumber(Text number);
}
