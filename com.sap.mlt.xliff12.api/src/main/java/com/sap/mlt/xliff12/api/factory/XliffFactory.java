package com.sap.mlt.xliff12.api.factory;

import com.sap.mlt.xliff12.api.persistence.XliffDeserializer;
import com.sap.mlt.xliff12.api.persistence.XliffSerializer;

/**
 * The meta-factory of this API.
 * 
 * @author D049314
 */
public abstract class XliffFactory {

	private static final String INTERFACE_VERSION = "2.1.0";

	private static final String FACTORY_ID = "com.sap.mlt.xliff12.api.factory.XliffFactory";

	private static final String DEFAULT_IMPLEMENTATION = "com.sap.mlt.xliff12.impl.factory.XliffFactoryImpl";

	/**
	 * Creates a new instance of this meta-factory API. The implementation that
	 * is instantiated can be defined by the system parameter
	 * <code>com.sap.mlt.xliff12.api.factory.XliffFactory</code>. If unspecified
	 * this methods attempts to instantiate the class
	 * <code>com.sap.mlt.xliff12.impl.factory.XliffFactoryImpl</code>.
	 * 
	 * @return Returns an instance of this factory.
	 */
	public static XliffFactory newInstance() {
		String className = System.getProperty(FACTORY_ID,
				DEFAULT_IMPLEMENTATION);
		Class<?> clazz;
		try {
			clazz = Class.forName(className);
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"Did not find XLIFF 1.2 implementation on classpath", e);
		}
		Class<? extends XliffFactory> factoryClass = clazz
				.asSubclass(XliffFactory.class);
		try {
			return factoryClass.newInstance();
		} catch (InstantiationException e) {
			throw new IllegalStateException(
					"Could not instantiate XLIFF 1.2 implementation", e);
		} catch (IllegalAccessException e) {
			throw new IllegalStateException(
					"Could not access XLIFF 1.2 implementation", e);
		}
	}

	/**
	 * Returns the version of the interface. The version is a string of the form
	 * <i>major</i>.<i>minor</i>.<i>patch</i>.
	 * 
	 * @return Returns the version of the interface. The version is a string of
	 *         the form <i>major</i>.<i>minor</i>.<i>patch</i>.
	 */
	public final String getInterfaceVersion() {
		return INTERFACE_VERSION;
	}

	/**
	 * Returns the version of the implementation. The version is a string of the
	 * form <i>major</i>.<i>minor</i>.<i>patch</i>.
	 * 
	 * @return Returns the version of the implementation. The version is a
	 *         string of the form <i>major</i>.<i>minor</i>.<i>patch</i>.
	 */
	public abstract String getImplementationVersion();

	/**
	 * Returns an attribute factory that can be used to create XLIFF attributes.
	 * 
	 * @return Returns an attribute factory that can be used to create XLIFF
	 *         attributes.
	 */
	public abstract AttributeFactory getAttributeFactory();

	/**
	 * Returns an element factory that can be used to create XLIFF elements.
	 * 
	 * @return Returns an element factory that can be used to create XLIFF
	 *         elements.
	 */
	public abstract ElementFactory getElementFactory();

	/**
	 * Returns a text factory that can be used to create plain texts for XLIFF
	 * documents.
	 * 
	 * @return Returns a text factory that can be used to create plain texts for
	 *         XLIFF documents.
	 */
	public abstract TextFactory getTextFactory();

	/**
	 * Returns a serializer that can be used to serialize XLIFF documents to
	 * output streams.
	 * 
	 * @return Returns a serializer that can be used to serialize XLIFF
	 *         documents to output streams.
	 */
	public abstract XliffSerializer getSerializer();

	/**
	 * Returns a deserializer that can be used to deserialize XLIFF documents
	 * from input streams.
	 * 
	 * @return Returns a deserializer that can be used to deserialize XLIFF
	 *         documents from input streams.
	 */
	public abstract XliffDeserializer getDeserializer();

}
