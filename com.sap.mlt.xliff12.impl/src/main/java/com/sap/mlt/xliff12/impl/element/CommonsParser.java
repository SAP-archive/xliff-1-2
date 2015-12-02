package com.sap.mlt.xliff12.impl.element;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.sap.mlt.xliff12.api.base.CodeFragment;
import com.sap.mlt.xliff12.api.base.TextFragment;
import com.sap.mlt.xliff12.api.element.delimiter.Mrk;
import com.sap.mlt.xliff12.api.element.inline.Bpt;
import com.sap.mlt.xliff12.api.element.inline.Bx;
import com.sap.mlt.xliff12.api.element.inline.Ept;
import com.sap.mlt.xliff12.api.element.inline.Ex;
import com.sap.mlt.xliff12.api.element.inline.G;
import com.sap.mlt.xliff12.api.element.inline.It;
import com.sap.mlt.xliff12.api.element.inline.Ph;
import com.sap.mlt.xliff12.api.element.inline.Sub;
import com.sap.mlt.xliff12.api.element.inline.X;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.element.delimiter.MrkImpl;
import com.sap.mlt.xliff12.impl.element.inline.BptImpl;
import com.sap.mlt.xliff12.impl.element.inline.BxImpl;
import com.sap.mlt.xliff12.impl.element.inline.EptImpl;
import com.sap.mlt.xliff12.impl.element.inline.ExImpl;
import com.sap.mlt.xliff12.impl.element.inline.GImpl;
import com.sap.mlt.xliff12.impl.element.inline.ItImpl;
import com.sap.mlt.xliff12.impl.element.inline.PhImpl;
import com.sap.mlt.xliff12.impl.element.inline.SubImpl;
import com.sap.mlt.xliff12.impl.element.inline.XImpl;
import com.sap.mlt.xliff12.impl.text.TextImpl;
import com.sap.mlt.xliff12.impl.util.NodeIterator;

public final class CommonsParser {

	private CommonsParser() {
	}

	public static ArrayList<TextFragment> parseTextFragments(
			List<? extends Node> elementsAndText)
			throws ConstraintViolationException {
		ArrayList<TextFragment> ret = new ArrayList<TextFragment>();
		NodeIterator iter = new NodeIterator(elementsAndText, false);
		while (iter.hasNext()) {
			if (iter.nextIsElement()) {
				Element element = iter
						.getXliffElement(G.NAME, X.NAME, Bx.NAME, Ex.NAME,
								Bpt.NAME, Ept.NAME, Ph.NAME, It.NAME, Mrk.NAME);
				String name = element.getLocalName();
				if (G.NAME.equals(name)) {
					ret.add(new GImpl(element));
				} else if (X.NAME.equals(name)) {
					ret.add(new XImpl(element));
				} else if (Bx.NAME.equals(name)) {
					ret.add(new BxImpl(element));
				} else if (Ex.NAME.equals(name)) {
					ret.add(new ExImpl(element));
				} else if (Bpt.NAME.equals(name)) {
					ret.add(new BptImpl(element));
				} else if (Ept.NAME.equals(name)) {
					ret.add(new EptImpl(element));
				} else if (Ph.NAME.equals(name)) {
					ret.add(new PhImpl(element));
				} else if (It.NAME.equals(name)) {
					ret.add(new ItImpl(element));
				} else if (Mrk.NAME.equals(name)) {
					ret.add(new MrkImpl(element));
				}
			} else {
				ret.add(new TextImpl(iter.getText()));
			}
		}
		return ret;
	}

	public static ArrayList<CodeFragment> parseCodeFragments(
			List<? extends Node> elementsAndText)
			throws ConstraintViolationException {
		ArrayList<CodeFragment> ret = new ArrayList<CodeFragment>();
		NodeIterator iter = new NodeIterator(elementsAndText, false);
		while (iter.hasNext()) {
			if (iter.nextIsElement()) {
				Element element = iter
						.getXliffElement(Sub.NAME);
				ret.add(new SubImpl(element));
			} else {
				ret.add(new TextImpl(iter.getText()));
			}
		}
		return ret;
	}
}
