package com.sap.mlt.xliff12.impl.element.structural;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.Element;

import com.sap.mlt.xliff12.api.attribute.Approved;
import com.sap.mlt.xliff12.api.attribute.Id;
import com.sap.mlt.xliff12.api.attribute.MimeType;
import com.sap.mlt.xliff12.api.attribute.NonXliffAttribute;
import com.sap.mlt.xliff12.api.attribute.PhaseName;
import com.sap.mlt.xliff12.api.attribute.Reformat;
import com.sap.mlt.xliff12.api.attribute.ResName;
import com.sap.mlt.xliff12.api.attribute.ResType;
import com.sap.mlt.xliff12.api.attribute.Translate;
import com.sap.mlt.xliff12.api.attribute.Ts;
import com.sap.mlt.xliff12.api.base.Attribute;
import com.sap.mlt.xliff12.api.base.Node;
import com.sap.mlt.xliff12.api.element.header.Note;
import com.sap.mlt.xliff12.api.element.namedgroup.ContextGroup;
import com.sap.mlt.xliff12.api.element.namedgroup.CountGroup;
import com.sap.mlt.xliff12.api.element.namedgroup.PropGroup;
import com.sap.mlt.xliff12.api.element.nonxliff.NonXliffElement;
import com.sap.mlt.xliff12.api.element.structural.BinSource;
import com.sap.mlt.xliff12.api.element.structural.BinTarget;
import com.sap.mlt.xliff12.api.element.structural.BinUnit;
import com.sap.mlt.xliff12.api.element.structural.Source;
import com.sap.mlt.xliff12.api.element.structural.TransUnit;
import com.sap.mlt.xliff12.api.exception.ConstraintViolationException;
import com.sap.mlt.xliff12.impl.attribute.ReformatYesNoImpl;
import com.sap.mlt.xliff12.impl.attribute.TranslateImpl;
import com.sap.mlt.xliff12.impl.base.ElementImpl;
import com.sap.mlt.xliff12.impl.base.XliffElementImpl;
import com.sap.mlt.xliff12.impl.element.header.NoteImpl;
import com.sap.mlt.xliff12.impl.element.namedgroup.ContextGroupImpl;
import com.sap.mlt.xliff12.impl.element.namedgroup.CountGroupImpl;
import com.sap.mlt.xliff12.impl.element.namedgroup.PropGroupImpl;
import com.sap.mlt.xliff12.impl.element.nonxliff.NonXliffElementImpl;
import com.sap.mlt.xliff12.impl.util.Assert;
import com.sap.mlt.xliff12.impl.util.NodeIterator;

@SuppressWarnings("deprecation")
public class BinUnitImpl extends XliffElementImpl implements BinUnit {

	public BinUnitImpl(Id id, MimeType mimeType, BinSource binSource) {
		super(NAME);
		context = new ArrayList<Context>();
		nonXliffElements = new ArrayList<NonXliffElement>();
		setId(id);
		setMimeType(mimeType);
		setBinSource(binSource);
	}

	public BinUnitImpl(org.w3c.dom.Element element)
			throws ConstraintViolationException {
		super(NAME, element);
	}

	private BinSource binSource;

	private BinTarget binTarget;

	private ArrayList<Context> context;

	private ArrayList<NonXliffElement> nonXliffElements;

	@Override
	protected void assertAttributesValid(Element element)
			throws ConstraintViolationException {
		Assert.xliffAttrAvailable(element, Id.NAME, MimeType.NAME);
		Assert.xliffAttrRestricted(element, true, false, false, Id.NAME,
				MimeType.NAME, Approved.NAME, Translate.NAME, Reformat.NAME,
				Ts.NAME, PhaseName.NAME, ResType.NAME, ResName.NAME);
	}

	@Override
	protected void cloneChildrenFrom(ElementImpl elem) {
		BinUnitImpl source = (BinUnitImpl) elem;
		
		binSource = (BinSource) source.binSource.clone();
		attach(binSource);
		
		if (source.binTarget != null) {
			binTarget = (BinTarget) source.binTarget.clone();
			attach(binTarget);
		}
		
		context = new ArrayList<Context>();
		for (Context ctx : source.context) {
			context.add((Context) ctx.clone());
		}
		attach(context);

		nonXliffElements = new ArrayList<NonXliffElement>();
		for (NonXliffElement nonXliffElement : source.nonXliffElements) {
			nonXliffElements.add((NonXliffElement) nonXliffElement.clone());
		}
		attach(nonXliffElements);
	}

	@Override
	public List<? extends Node> getChildren() {
		ArrayList<Node> ret = new ArrayList<Node>();
		ret.add(binSource);
		if (binTarget != null) {
			ret.add(binTarget);
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
			org.w3c.dom.Element element = iter.getXliffElement(BinSource.NAME,
					BinTarget.NAME, ContextGroup.NAME,
					CountGroup.NAME, PropGroup.NAME, Note.NAME, TransUnit.NAME);
			String name = element.getLocalName();
			if (BinSource.NAME.equals(name)) {
				if (binSource != null) {
					String msg = MessageFormat
							.format(
									"Only one <{0}> element is allowed per <{1}> element",
									BinSource.NAME, NAME);
					throw new ConstraintViolationException(msg);
				}
				binSource = new BinSourceImpl(element);
			} else if (BinTarget.NAME.equals(name)) {
				if (binTarget != null) {
					String msg = MessageFormat
							.format(
									"Only one <{0}> element is allowed per <{1}> element",
									BinTarget.NAME, NAME);
					throw new ConstraintViolationException(msg);
				}
				binTarget = new BinTargetImpl(element);
			} else if (ContextGroup.NAME.equals(name)) {
				context.add(new ContextGroupImpl(element));
			} else if (CountGroup.NAME.equals(name)) {
				context.add(new CountGroupImpl(element));
			} else if (PropGroup.NAME.equals(name)) {
				context.add(new PropGroupImpl(element));
			} else if (Note.NAME.equals(name)) {
				context.add(new NoteImpl(element));
			} else if (TransUnit.NAME.equals(name)) {
				context.add(new TransUnitImpl(element));
			}
		}
		while (iter.hasNext()) {
			nonXliffElements.add(new NonXliffElementImpl(iter.getNonXliffElement()));
		}

		if (binSource == null) {
			String msg = MessageFormat.format(
					"A <{0}> element must contain a <{1}> element", NAME,
					Source.NAME);
			throw new ConstraintViolationException(msg);
		}

		attach(binSource);
		attach(binTarget);
		attach(context);
		attach(nonXliffElements);
	}


	public Approved getApproved() {
		return (Approved) getXliffAttribute(Approved.NAME);
	}

	public BinSource getBinSource() {
		return binSource;
	}

	public BinTarget getBinTarget() {
		return binTarget;
	}

	public List<? extends Context> getContext() {
		return Collections.unmodifiableList(context);
	}

	public Id getId() {
		return (Id) getXliffAttribute(Id.NAME);
	}

	public MimeType getMimeType() {
		return (MimeType) getXliffAttribute(MimeType.NAME);
	}

	public Collection<NonXliffAttribute> getNonXliffAttributes() {
		return super.getNonXliffAttributes();
	}

	public List<NonXliffElement> getNonXliffElements() {
		return Collections.unmodifiableList(nonXliffElements);
	}

	public PhaseName getPhaseName() {
		return (PhaseName) getXliffAttribute(PhaseName.NAME);
	}

	public Reformat getReformat() {
		return (Reformat) getXliffAttribute(Reformat.NAME);
	}

	public ResName getResName() {
		return (ResName) getXliffAttribute(ResName.NAME);
	}

	public ResType getResType() {
		return (ResType) getXliffAttribute(ResType.NAME);
	}

	public Translate getTranslate() {
		return (Translate) getXliffAttribute(Translate.NAME);
	}

	/**
	 * @deprecated
	 */
	public com.sap.mlt.xliff12.api.attribute.Ts getTs() {
		return (com.sap.mlt.xliff12.api.attribute.Ts) getXliffAttribute(com.sap.mlt.xliff12.api.attribute.Ts.NAME);
	}

	public void setApproved(Approved approved) {
		if (approved == null) {
			clearXliffAttribute(Approved.NAME);
		} else {
			setAttribute(approved);
		}
	}

	public void setBinSource(BinSource binSource) {
		Assert.notNull(binSource, "binSource");
		Assert.isInstance(binSource, "binSource", BinSourceImpl.class);
		assertNotAttached(binSource);
		detach(this.binSource);
		this.binSource = binSource;
		attach(this.binSource);
	}

	public void setBinTarget(BinTarget binTarget) {
		Assert.isInstance(binTarget, "binTarget", BinTargetImpl.class);
		assertNotAttached(binTarget);
		detach(this.binTarget);
		this.binTarget = binTarget;
		attach(this.binTarget);
	}

	public void setContext(List<? extends Context> context) {
		Assert.notNull(context, "context");
		Assert.areInstances(context, "context", TransUnitImpl.class,
				ContextGroupImpl.class, CountGroupImpl.class, NoteImpl.class,
				PropGroupImpl.class);
		assertNotAttached(context);
		detach(this.context);
		this.context = new ArrayList<Context>(context);
		attach(this.context);
	}

	public void setId(Id id) {
		Assert.notNull(id, "id");
		setAttribute(id);
	}

	public void setMimeType(MimeType mimeType) {
		Assert.notNull(mimeType, "mimeType");
		setAttribute(mimeType);
	}

	public void setNonXliffAttributes(
			Collection<NonXliffAttribute> nonXliffAttributes) {
		Assert.notNull(nonXliffAttributes, "nonXliffAttributes");
		Collection<NonXliffAttribute> toDelete = getNonXliffAttributes();
		for (NonXliffAttribute attr : toDelete) {
			clearAttribute(attr.getNamespaceUri(), attr.getName());
		}
		for (NonXliffAttribute attr : nonXliffAttributes) {
			setAttribute(attr);
		}
	}

	public void setNonXliffElements(List<NonXliffElement> nonXliffElements) {
		Assert.notNull(nonXliffElements, "nonXliffElements");
		Assert.areInstances(nonXliffElements, "nonXliffElements",
				NonXliffElementImpl.class);
		assertNotAttached(nonXliffElements);
		detach(this.nonXliffElements);
		this.nonXliffElements = new ArrayList<NonXliffElement>(nonXliffElements);
		attach(this.nonXliffElements);
	}

	public void setPhaseName(PhaseName phaseName) {
		if (phaseName == null) {
			clearXliffAttribute(PhaseName.NAME);
		} else {
			setAttribute(phaseName);
		}
	}

	public void setReformat(Reformat reformat) {
		if (reformat == null) {
			setAttribute(new ReformatYesNoImpl(true));
		} else {
			setAttribute(reformat);
		}
	}

	public void setResName(ResName resName) {
		if (resName == null) {
			clearXliffAttribute(ResName.NAME);
		} else {
			setAttribute(resName);
		}
	}

	public void setResType(ResType resType) {
		if (resType == null) {
			clearXliffAttribute(ResType.NAME);
		} else {
			setAttribute(resType);
		}
	}

	public void setTranslate(Translate translate) {
		if (translate == null) {
			setAttribute(new TranslateImpl(Translate.Value.YES));
		} else {
			setAttribute(translate);
		}
	}

	/**
	 * @deprecated
	 */
	public void setTs(com.sap.mlt.xliff12.api.attribute.Ts ts) {
		if (ts == null) {
			clearXliffAttribute(com.sap.mlt.xliff12.api.attribute.Ts.NAME);
		} else {
			setAttribute(ts);
		}
	}

	@Override
	protected Collection<? extends Attribute> getDefaultAttributes() {
		ArrayList<Attribute> defaults = new ArrayList<Attribute>();
		defaults.add(new TranslateImpl(Translate.Value.YES));
		defaults.add(new ReformatYesNoImpl(true));
		return defaults;
	}
	
	

}
