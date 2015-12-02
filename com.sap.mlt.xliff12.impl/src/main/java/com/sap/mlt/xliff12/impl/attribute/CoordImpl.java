package com.sap.mlt.xliff12.impl.attribute;

import com.sap.mlt.xliff12.api.attribute.Coord;
import com.sap.mlt.xliff12.impl.base.XliffAttributeImpl;

public class CoordImpl extends XliffAttributeImpl implements Coord {

	public CoordImpl(Integer x, Integer y, Integer cx, Integer cy) {
		super(NAME, buildValue(x, y, cx, cy));
		this.x = x;
		this.y = y;
		this.cx = cx;
		this.cy = cy;
	}

	private Integer x;

	private Integer y;

	private Integer cx;

	private Integer cy;

	public Integer getCx() {
		return cx;
	}

	public Integer getCy() {
		return cy;
	}

	public Integer getX() {
		return x;
	}

	public Integer getY() {
		return y;
	}

	private static String buildValue(Integer x, Integer y, Integer cx,
			Integer cy) {
		StringBuilder sb = new StringBuilder();
		sb.append((x == null)? "#": x.intValue());
		sb.append(';');
		sb.append((y == null)? "#": y.intValue());
		sb.append(';');
		sb.append((cx == null)? "#": cx.intValue());
		sb.append(';');
		sb.append((cy == null)? "#": cy.intValue());
		return sb.toString();
	}
	
}
