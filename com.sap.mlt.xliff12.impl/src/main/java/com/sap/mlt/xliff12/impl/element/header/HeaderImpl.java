package com.sap.mlt.xliff12.impl.element.header;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sap.mlt.xliff12.api.base.Element;
import com.sap.mlt.xliff12.api.element.header.Glossary;
import com.sap.mlt.xliff12.api.element.header.Header;
import com.sap.mlt.xliff12.api.element.header.Note;
import com.sap.mlt.xliff12.api.element.header.PhaseGroup;
import com.sap.mlt.xliff12.api.element.header.Reference;
import com.sap.mlt.xliff12.api.element.header.Skl;
import com.sap.mlt.xliff12.api.element.header.Tool;
import com.sap.mlt.xliff12.api.element.namedgroup.CountGroup;
import com.sap.mlt.xliff12.api.element.namedgroup.PropGroup;
import com.sap.mlt.xliff12.api.element.nonxliff.NonXliffElement;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.base.ElementImpl;
import com.sap.mlt.xliff12.impl.base.XliffElementImpl;
import com.sap.mlt.xliff12.impl.element.namedgroup.CountGroupImpl;
import com.sap.mlt.xliff12.impl.element.namedgroup.PropGroupImpl;
import com.sap.mlt.xliff12.impl.element.nonxliff.NonXliffElementImpl;
import com.sap.mlt.xliff12.impl.util.Assert;
import com.sap.mlt.xliff12.impl.util.NodeIterator;

@SuppressWarnings("deprecation")
public class HeaderImpl extends XliffElementImpl implements Header {

	public HeaderImpl() {
		super(NAME);
		context = new ArrayList<Context>();
		nonXliffElements = new ArrayList<NonXliffElement>();
	}

	private Skl skl;

	private PhaseGroup phaseGroup;

	private ArrayList<Context> context;

	private ArrayList<NonXliffElement> nonXliffElements;

	public HeaderImpl(org.w3c.dom.Element element)
			throws ConstraintViolationException {
		super(NAME, element);
	}

	@Override
	protected void assertAttributesValid(org.w3c.dom.Element element)
			throws ConstraintViolationException {
		Assert.xliffAttrRestricted(element, false, false, false);
	}

	@Override
	protected void cloneChildrenFrom(ElementImpl elem) {
		HeaderImpl source = (HeaderImpl) elem;
		if (source.skl != null) {
			skl = (Skl) source.skl.clone();
			attach(skl);
		}
		if (source.phaseGroup != null) {
			phaseGroup = (PhaseGroup) source.phaseGroup.clone();
			attach(phaseGroup);
		}
		context = new ArrayList<Context>();
		for (Context ctx : source.context) {
			context.add((Context) ctx.clone());
		}
		attach(context);
		nonXliffElements = new ArrayList<NonXliffElement>();
		for (NonXliffElement nxe : source.nonXliffElements) {
			nonXliffElements.add((NonXliffElement) nxe.clone());
		}
		attach(nonXliffElements);
	}

	@Override
	public List<? extends Element> getChildren() {
		ArrayList<Element> ret = new ArrayList<Element>();
		if (skl != null) {
			ret.add(skl);
		}
		if (phaseGroup != null) {
			ret.add(phaseGroup);
		}
		ret.addAll(context);
		ret.addAll(nonXliffElements);
		return ret;
	}

	@Override
	protected void processChildren(
			List<? extends org.w3c.dom.Node> elementsAndText)
			throws ConstraintViolationException {

		context = new ArrayList<Context>();
		nonXliffElements = new ArrayList<NonXliffElement>();

		NodeIterator iter = new NodeIterator(elementsAndText, true);
		while (iter.nextIsXliffElement()) {
			org.w3c.dom.Element element = iter.getXliffElement(Skl.NAME,
					PhaseGroup.NAME, Glossary.NAME, Reference.NAME,
					CountGroup.NAME, PropGroup.NAME, Note.NAME, Tool.NAME);
			String name = element.getLocalName();
			if (Skl.NAME.equals(name)) {
				if (skl != null) {
					String msg = MessageFormat
							.format(
									"Only one <{0}> element is allowed in the <{1}> element",
									Skl.NAME, NAME);
					throw new ConstraintViolationException(msg);
				}
				skl = new SklImpl(element);
			} else if (PhaseGroup.NAME.equals(name)) {
				if (phaseGroup != null) {
					String msg = MessageFormat
							.format(
									"Only one <{0}> element is allowed in the <{1}> element",
									PhaseGroup.NAME, NAME);
					throw new ConstraintViolationException(msg);
				}
				phaseGroup = new PhaseGroupImpl(element);
			} else if (Glossary.NAME.equals(name)) {
				context.add(new GlossaryImpl(element));
			} else if (Reference.NAME.equals(name)) {
				context.add(new ReferenceImpl(element));
			} else if (CountGroup.NAME.equals(name)) {
				context.add(new CountGroupImpl(element));
			} else if (PropGroup.NAME.equals(name)) {
				context.add(new PropGroupImpl(element));
			} else if (Note.NAME.equals(name)) {
				context.add(new NoteImpl(element));
			} else if (Tool.NAME.equals(name)) {
				context.add(new ToolImpl(element));
			}
		}
		while (iter.nextIsNonXliffElement()) {
			org.w3c.dom.Element element = iter.getElement();
			nonXliffElements.add(new NonXliffElementImpl(element));
		}
		iter.assertNoMoreNodes();

		attach(skl);
		attach(phaseGroup);
		attach(context);
		attach(nonXliffElements);
	}

	public List<? extends Context> getContext() {
		return Collections.unmodifiableList(context);
	}

	public List<NonXliffElement> getNonXliffElements() {
		return Collections.unmodifiableList(nonXliffElements);
	}

	public PhaseGroup getPhaseGroup() {
		return phaseGroup;
	}

	public Skl getSkl() {
		return skl;
	}

	public void setContext(List<? extends Context> context) {
		Assert.notNull(context, "context");
		Assert.areInstances(context, "context", GlossaryImpl.class,
				ReferenceImpl.class, CountGroupImpl.class, PropGroupImpl.class,
				NoteImpl.class, ToolImpl.class);
		assertNotAttached(context);
		detach(this.context);
		this.context = new ArrayList<Context>(context);
		attach(this.context);
	}

	public void setNonXliffElements(List<NonXliffElement> nonXliffElements) {
		Assert.notNull(nonXliffElements, "nonXliffElements");
		Assert.areInstances(nonXliffElements, "nonXliffelements",
				NonXliffElementImpl.class);
		assertNotAttached(nonXliffElements);
		detach(this.nonXliffElements);
		this.nonXliffElements = new ArrayList<NonXliffElement>(nonXliffElements);
		attach(this.nonXliffElements);
	}

	public void setPhaseGroup(PhaseGroup phaseGroup) {
		Assert.isInstance(phaseGroup, "phaseGroup", PhaseGroupImpl.class);
		assertNotAttached(phaseGroup);
		detach(this.phaseGroup);
		this.phaseGroup = phaseGroup;
		attach(this.phaseGroup);
	}

	public void setSkl(Skl skl) {
		Assert.isInstance(skl, "skl", SklImpl.class);
		assertNotAttached(skl);
		detach(this.skl);
		this.skl = skl;
		attach(this.skl);
	}

}
