package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XliffAttribute;
import com.sap.mlt.xliff12.api.element.namedgroup.Prop;

/**
 * The prop-type attribute specifies the type of a {@link Prop} element.
 * 
 * @author D049314
 * @deprecated Because the {@link Prop} element was DEPRECATED in version 1.1
 *             and this attribute is only a member of that element, this
 *             attribute is also deprecated. Instead, use attributes defined in
 *             a namespace different from XLIFF. See the Extensibility section
 *             for more information.
 */
public interface PropType extends XliffAttribute {

	/**
	 * The attribute's name.
	 */
	static final String NAME = "prop-type";

}
