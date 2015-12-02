package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XliffAttribute;
import com.sap.mlt.xliff12.api.element.delimiter.Mrk;
import com.sap.mlt.xliff12.api.element.structural.AltTrans;
import com.sap.mlt.xliff12.api.element.structural.SegSource;
import com.sap.mlt.xliff12.api.element.structural.Target;
import com.sap.mlt.xliff12.api.element.structural.TransUnit;

/**
 * Marker ID - Identifier for an {@link Mrk} element. When used with in
 * combination with {@link com.sap.mlt.xliff12.api.attribute.Mtype.Value#SEG}
 * the value of this attribute is used to reference segments between the
 * {@link SegSource} and {@link Target} of a {@link TransUnit}. When used in
 * {@link AltTrans} this attribute indicates that the entire {@link AltTrans}
 * element references a particular {@link Mrk} segment in the {@link SegSource}
 * (and {@link Target}) element.
 * 
 * @author D049314
 */
public interface Mid extends XliffAttribute {

	/**
	 * The attribute's name.
	 */
	static final String NAME = "mid";

}
