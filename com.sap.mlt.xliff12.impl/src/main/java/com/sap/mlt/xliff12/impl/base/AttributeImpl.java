package com.sap.mlt.xliff12.impl.base;

import java.text.MessageFormat;

import com.sap.mlt.xliff12.api.base.Attribute;
import com.sap.mlt.xliff12.api.base.Element;
import com.sap.mlt.xliff12.impl.util.Assert;
import com.sap.mlt.xliff12.impl.util.XMLChar;

public abstract class AttributeImpl implements Attribute {

	protected AttributeImpl(String namespaceURI, String prefix, String name,
			String value) {
		Assert.notNull(namespaceURI, "namespaceURI");
		Assert.notNull(name, "name");
		Assert.notNull(value, "value");

		if ((prefix != null) && (prefix.length() == 0)) {
			prefix = null;
		}
		if ((prefix != null) && !XMLChar.isValidNCName(prefix)) {
			String msg = MessageFormat.format(
					"''{0}'' is not a valid XML prefix", prefix);
			throw new IllegalArgumentException(msg);
		}
		if (!XMLChar.isValidName(name)) {
			String msg = MessageFormat.format(
					"''{0}'' is not a valid attribute name", name);
			throw new IllegalArgumentException(msg);
		}
		Assert.validXMLChars(value, "value");

		this.namespaceURI = namespaceURI;
		this.prefix = prefix;
		this.name = name;
		this.value = value;
	}

	private String prefix;

	private String namespaceURI;

	private String name;

	private String value;

	private Element owner;

	public String getNamespaceUri() {
		return namespaceURI;
	}

	public String getPrefix() {
		return prefix;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	public void setOwner(Element owner) {
		Assert.isInstance(owner, "owner", ElementImpl.class);
		if (owner == null) {
			this.owner = null;
			return;
		}
		if ((this.owner != null) && (this.owner != owner )) {
			String msg = MessageFormat
					.format(
							"The attribute ''{0}'' is already owned by element ''<{1}>''",
							this, owner.getName());
			throw new IllegalArgumentException(msg);
		}
		this.owner = owner;
	}

	public Element getOwnerElement() {
		return owner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + name.hashCode();
		result = prime * result + namespaceURI.hashCode();
		result = prime * result + value.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AttributeImpl))
			return false;
		AttributeImpl other = (AttributeImpl) obj;
		if (!name.equals(other.name))
			return false;
		if (!namespaceURI.equals(other.namespaceURI))
			return false;
		if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		sb.append(namespaceURI);
		sb.append("]:");
		sb.append(name);
		sb.append("=\"");
		sb.append(value);
		sb.append('"');
		return sb.toString();
	}
	
	public Object clone() {
		try {
			AttributeImpl clone = (AttributeImpl) super.clone();
			clone.owner = null;
			return clone;
		} catch (CloneNotSupportedException e) {
			//$JL-EXC$
			throw new AssertionError(e);
		}
	}

}
