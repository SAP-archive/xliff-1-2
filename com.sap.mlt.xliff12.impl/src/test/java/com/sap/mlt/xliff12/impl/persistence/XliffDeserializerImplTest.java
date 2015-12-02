package com.sap.mlt.xliff12.impl.persistence;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.sap.mlt.xliff12.api.attribute.Version;
import com.sap.mlt.xliff12.api.base.TextFragment;
import com.sap.mlt.xliff12.api.element.structural.Body;
import com.sap.mlt.xliff12.api.element.structural.Source;
import com.sap.mlt.xliff12.api.element.structural.StructuralUnit;
import com.sap.mlt.xliff12.api.element.structural.TransUnit;
import com.sap.mlt.xliff12.api.element.toplevel.File;
import com.sap.mlt.xliff12.api.element.toplevel.Xliff;
import com.sap.mlt.xliff12.api.exception.DeserializationException;
import com.sap.mlt.xliff12.api.exception.SerializationException;
import com.sap.mlt.xliff12.impl.attribute.DataTypeImpl;
import com.sap.mlt.xliff12.impl.attribute.IdImpl;
import com.sap.mlt.xliff12.impl.attribute.OriginalImpl;
import com.sap.mlt.xliff12.impl.attribute.SourceLanguageImpl;
import com.sap.mlt.xliff12.impl.attribute.VersionImpl;
import com.sap.mlt.xliff12.impl.element.structural.BodyImpl;
import com.sap.mlt.xliff12.impl.element.structural.SourceImpl;
import com.sap.mlt.xliff12.impl.element.structural.TransUnitImpl;
import com.sap.mlt.xliff12.impl.element.toplevel.FileImpl;
import com.sap.mlt.xliff12.impl.element.toplevel.XliffImpl;
import com.sap.mlt.xliff12.impl.text.TextImpl;

public class XliffDeserializerImplTest {

	@Test
	public void testDeserializeFile() throws IOException, SerializationException, DeserializationException {
		XliffSerializerImpl serializer = XliffSerializerImpl.getInstance();
		XliffDeserializerImpl deserializer = XliffDeserializerImpl.getInstance();

		java.io.File tempFile = java.io.File.createTempFile("xlflib", ".xlf");
		try {
			Xliff xliff = createDefaultXliff();
			serializer.serialize(xliff, tempFile);
			
			Xliff xliff2 = deserializer.deserialize(tempFile);
			assertEquals(xliff, xliff2);
		} finally {
			tempFile.delete();
		}
	}
	
	private Xliff createDefaultXliff() {
		Version version = new VersionImpl(Version.Value.V1_2);
		return new XliffImpl(version, createDefaultFiles());
	}

	private List<File> createDefaultFiles() {
		ArrayList<File> files = new ArrayList<File>();
		files.add(createDefaultFile());
		return files;
	}

	private File createDefaultFile() {
		return new FileImpl(new OriginalImpl("abc"), new SourceLanguageImpl(
				"en-US"), new DataTypeImpl("xyz"), createDefaultBody());
	}

	private Body createDefaultBody() {
		return new BodyImpl(createDefaultStructuralUnits());
	}

	private List<StructuralUnit> createDefaultStructuralUnits() {
		ArrayList<StructuralUnit> sus = new ArrayList<StructuralUnit>();
		sus.add(createDefaultTransUnit());
		return sus;
	}

	private TransUnit createDefaultTransUnit() {
		return new TransUnitImpl(new IdImpl("1"), createDefaultSource());
	}

	private Source createDefaultSource() {
		return new SourceImpl(createDefaultTextFragments());
	}

	private List<TextFragment> createDefaultTextFragments() {
		ArrayList<TextFragment> fragments = new ArrayList<TextFragment>();
		fragments.add(new TextImpl("text"));
		return fragments;
	}
}
