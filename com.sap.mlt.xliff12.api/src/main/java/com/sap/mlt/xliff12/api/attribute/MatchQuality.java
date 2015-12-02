package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XliffAttribute;
import com.sap.mlt.xliff12.api.element.structural.AltTrans;

/**
 * Match quality - The match quality of the {@link AltTrans} element is tool
 * specific and can be a score expressed in percentage or an arbitrary value
 * (e.g. "high").
 * 
 * @author D049314
 */
public interface MatchQuality extends XliffAttribute {

	/**
	 * The attribute's name.
	 */
	final static String NAME = "match-quality";

}
