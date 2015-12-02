package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XTendableAttribute;

/**
 * Data type - The datatype attribute specifies the kind of text contained in
 * the element. Depending on that type, you may apply different processes to the
 * data. For example: "winres" specifies that the content is Windows resources
 * which would allow using the Win32 API in rendering the content.
 * 
 * @author D049314
 */
public interface DataType extends XTendableAttribute {

	/**
	 * The attribute's name.
	 */
	final static String NAME = "datatype";

	/**
	 * Pre-defined data-type values.
	 * 
	 * @author D049314
	 */
	enum Value {
		/**
		 * Indicates Active Server Page data.
		 */
		ASP("asp"),
		/**
		 * Indicates C source file data.
		 */
		C("c"),
		/**
		 * Indicates Channel Definition Format (CDF) data.
		 */
		CDF("cdf"),
		/**
		 * Indicates ColdFusion data.
		 */
		CFM("cfm"),
		/**
		 * Indicates C++ source file data.
		 */
		CPP("cpp"),
		/**
		 * Indicates C-Sharp data.
		 */
		CSHARP("csharp"),
		/**
		 * Indicates strings from C, ASM, and driver files data.
		 */
		CSTRING("cstring"),
		/**
		 * Indicates comma-separated values data.
		 */
		CSV("csv"),
		/**
		 * Indicates database data.
		 */
		DATABASE("database"),
		/**
		 * Indicates portions of document that follows data and contains
		 * metadata.
		 */
		DOCUMENTFOOTER("documentfooter"),
		/**
		 * Indicates portions of document that precedes data and contains
		 * metadata.
		 */
		DOCUMENTHEADER("documentheader"),
		/**
		 * Indicates data from standard UI file operations dialogs (e.g., Open,
		 * Save, Save As, Export, Import).
		 */
		FILEDIALOG("filedialog"),
		/**
		 * Indicates standard user input screen data.
		 */
		FORM("form"),
		/**
		 * Indicates HyperText Markup Language (HTML) data - document instance.
		 */
		HTML("html"),
		/**
		 * Indicates content within an HTML document's &lt;body&gt; element.
		 */
		HTMLBODY("htmlbody"),
		/**
		 * Indicates Windows INI file data.
		 */
		INI("ini"),
		/**
		 * Indicates Interleaf data.
		 */
		INTERLEAF("interleaf"),
		/**
		 * Indicates Java source file data (extension '.java').
		 */
		JAVACLASS("javaclass"),
		/**
		 * Indicates Java property resource bundle data.
		 */
		JAVAPROPERTYRESOURCEBUNDLE("javapropertyresourcebundle"),
		/**
		 * Indicates Java list resource bundle data.
		 */
		JAVALISTRESOURCEBUNDLE("javalistresourcebundle"),
		/**
		 * Indicates JavaScript source file data.
		 */
		JAVASCRIPT("javascript"),
		/**
		 * Indicates JScript source file data.
		 */
		JSCRIPT("jscript"),
		/**
		 * Indicates information relating to formatting.
		 */
		LAYOUT("layout"),
		/**
		 * Indicates LISP source file data.
		 */
		LISP("lisp"),
		/**
		 * Indicates information relating to margin formats.
		 */
		MARGIN("margin"),
		/**
		 * Indicates a file containing menu.
		 */
		MENUFILE("menufile"),
		/**
		 * Indicates numerically identified string table.
		 */
		MESSAGEFILE("messagefile"),
		/**
		 * Indicates Maker Interchange Format (MIF) data.
		 */
		MIF("mif"),
		/**
		 * Indicates that the datatype attribute value is a MIME Type value and
		 * is defined in the mime-type attribute.
		 */
		MIMETYPE("mimetype"),
		/**
		 * Indicates GNU Machine Object data.
		 */
		MO("mo"),
		/**
		 * Indicates Message Librarian strings created by Novell's Message
		 * Librarian Tool.
		 */
		MSGLIB("msglib"),
		/**
		 * Indicates information to be displayed at the bottom of each page of a
		 * document.
		 */
		PAGEFOOTER("pagefooter"),
		/**
		 * Indicates information to be displayed at the top of each page of a
		 * document.
		 */
		PAGEHEADER("pageheader"),
		/**
		 * Indicates a list of property values (e.g., settings within INI files
		 * or preferences dialog).
		 */
		PARAMETERS("parameters"),
		/**
		 * Indicates Pascal source file data.
		 */
		PASCAL("pascal"),
		/**
		 * Indicates Hypertext Preprocessor data.
		 */
		PHP("php"),
		/**
		 * Indicates plain text file (no formatting other than, possibly,
		 * wrapping).
		 */
		PLAINTEXT("plaintext"),
		/**
		 * Indicates GNU Portable Object file.
		 */
		PO("po"),
		/**
		 * Indicates dynamically generated user defined document. e.g. Oracle
		 * Report, Crystal Report, etc.
		 */
		REPORT("report"),
		/**
		 * Indicates Windows .NET binary resources.
		 */
		RESOURCES("resources"),
		/**
		 * Indicates Windows .NET Resources.
		 */
		RESX("resx"),
		/**
		 * Indicates Rich Text Format (RTF) data.
		 */
		RTF("rtf"),
		/**
		 * Indicates Standard Generalized Markup Language (SGML) data - document
		 * instance.
		 */
		SGML("sgml"),
		/**
		 * Indicates Standard Generalized Markup Language (SGML) data - Document
		 * Type Definition (DTD).
		 */
		SGMLDTD("sgmldtd"),
		/**
		 * Indicates Scalable Vector Graphic (SVG) data.
		 */
		SVG("svg"),
		/**
		 * Indicates VisualBasic Script source file.
		 */
		VBSCRIPT("vbscript"),
		/**
		 * Indicates warning message.
		 */
		WARNING("warning"),
		/**
		 * Indicates Windows (Win32) resources (i.e. resources extracted from an
		 * RC script, a message file, or a compiled file).
		 */
		WINRES("winres"),
		/**
		 * Indicates Extensible HyperText Markup Language (XHTML) data -
		 * document instance.
		 */
		XHTML("xhtml"),
		/**
		 * Indicates Extensible Markup Language (XML) data - document instance.
		 */
		XML("xml"),
		/**
		 * Indicates Extensible Markup Language (XML) data - Document Type
		 * Definition (DTD).
		 */
		XMLDTD("xmldtd"),
		/**
		 * Indicates Extensible Stylesheet Language (XSL) data.
		 */
		XSL("xsl"),
		/**
		 * Indicates XUL elements.
		 */
		XUL("xul");

		private Value(String xmlName) {
			this.xmlName = xmlName;
		}

		private String xmlName;

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Enum#toString()
		 */
		public String toString() {
			return xmlName;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mlt.xliff12.api.base.EnumeratedAttribute#getEnumValue()
	 */
	Value getEnumValue();
}
