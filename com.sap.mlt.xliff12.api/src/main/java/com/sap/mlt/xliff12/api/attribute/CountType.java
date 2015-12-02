package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XTendableAttribute;
import com.sap.mlt.xliff12.api.element.namedgroup.Count;

/**
 * Count type - The count-type attribute specifies the purpose of the
 * {@link Count} element. For example: "total" for the total count of words in
 * the current scope.
 * 
 * @author D049314
 */
public interface CountType extends XTendableAttribute {

	/**
	 * The attribute's name.
	 */
	final static String NAME = "count-type";

	/**
	 * Pre-defined count-type values.
	 * 
	 * @author D049314
	 */
	enum Value {
		/**
		 * Indicates the count units are items that are used X times in a
		 * certain context; example: this is a reusable text unit which is used
		 * 42 times in other texts.
		 */
		NUM_USAGES("num-usages"),
		/**
		 * Indicates the count units are translation units existing already in
		 * the same document.
		 */
		REPETITION("repetition"),
		/**
		 * Indicates a total count.
		 */
		TOTAL("total"),
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
		XUL("xul"),
		/**
		 * Indicates a Windows RC AUTO3STATE control.
		 */
		AUTO3STATE("auto3state"),
		/**
		 * Indicates a Windows RC AUTOCHECKBOX control.
		 */
		AUTOCHECKBOX("autocheckbox"),
		/**
		 * Indicates a Windows RC AUTORADIOBUTTON control.
		 */
		AUTORADIOBUTTON("autoradiobutton"),
		/**
		 * Indicates a Windows RC BEDIT control.
		 */
		BEDIT("bedit"),
		/**
		 * Indicates a bitmap, for example a BITMAP resource in Windows.
		 */
		BITMAP("bitmap"),
		/**
		 * Indicates a button object, for example a BUTTON control Windows.
		 */
		BUTTON("button"),
		/**
		 * Indicates a caption, such as the caption of a dialog box.
		 */
		CAPTION("caption"),
		/**
		 * Indicates the cell in a table, for example the content of the &lt;td>
		 * element in HTML.
		 */
		CELL("cell"),
		/**
		 * Indicates check box object, for example a CHECKBOX control in
		 * Windows.
		 */
		CHECKBOX("checkbox"),
		/**
		 * Indicates a menu item with an associated checkbox.
		 */
		CHECKBOXMENUITEM("checkboxmenuitem"),
		/**
		 * Indicates a list box, but with a check-box for each item.
		 */
		CHECKEDLISTBOX("checkedlistbox"),
		/**
		 * Indicates a color selection dialog.
		 */
		COLORCHOOSER("colorchooser"),
		/**
		 * Indicates a combination of edit box and listbox object, for example a
		 * COMBOBOX control in Windows.
		 */
		COMBOBOX("combobox"),
		/**
		 * Indicates an initialization entry of an extended combobox DLGINIT
		 * resource block. (code 0x1234).
		 */
		COMBOBOXEXITEM("comboboxexitem"),
		/**
		 * Indicates an initialization entry of a combobox DLGINIT resource
		 * block (code 0x0403).
		 */
		COMBOBOXITEM("comboboxitem"),
		/**
		 * Indicates a UI base class element that cannot be represented by any
		 * other element.
		 */
		COMPONENT("component"),
		/**
		 * Indicates a context menu.
		 */
		CONTEXTMENU("contextmenu"),
		/**
		 * Indicates a Windows RC CTEXT control.
		 */
		CTEXT("ctext"),
		/**
		 * Indicates a cursor, for example a CURSOR resource in Windows.
		 */
		CURSOR("cursor"),
		/**
		 * Indicates a date/time picker.
		 */
		DATETIMEPICKER("datetimepicker"),
		/**
		 * Indicates a Windows RC DEFPUSHBUTTON control.
		 */
		DEFPUSHBUTTON("defpushbutton"),
		/**
		 * Indicates a dialog box.
		 */
		DIALOG("dialog"),
		/**
		 * Indicates a Windows RC DLGINIT resource block.
		 */
		DLGINIT("dlginit"),
		/**
		 * Indicates an edit box object, for example an EDIT control in Windows.
		 */
		EDIT("edit"),
		/**
		 * Indicates a filename.
		 */
		FILE("file"),
		/**
		 * Indicates a file dialog.
		 */
		FILECHOOSER("filechooser"),
		/**
		 * Indicates a footnote.
		 */
		FN("fn"),
		/**
		 * Indicates a font name.
		 */
		FONT("font"),
		/**
		 * Indicates a footer.
		 */
		FOOTER("footer"),
		/**
		 * Indicates a frame object.
		 */
		FRAME("frame"),
		/**
		 * Indicates a XUL grid element.
		 */
		GRID("grid"),
		/**
		 * Indicates a groupbox object, for example a GROUPBOX control in
		 * Windows.
		 */
		GROUPBOX("groupbox"),
		/**
		 * Indicates a header item.
		 */
		HEADER("header"),
		/**
		 * Indicates a heading, such has the content of &lt;h1>, &lt;h2>, etc.
		 * in HTML.
		 */
		HEADING("heading"),
		/**
		 * Indicates a Windows RC HEDIT control.
		 */
		HEDIT("hedit"),
		/**
		 * Indicates a horizontal scrollbar.
		 */
		HSCROLLBAR("hscrollbar"),
		/**
		 * Indicates an icon, for example an ICON resource in Windows.
		 */
		ICON("icon"),
		/**
		 * Indicates a Windows RC IEDIT control.
		 */
		IEDIT("iedit"),
		/**
		 * Indicates keyword list, such as the content of the Keywords meta-data
		 * in HTML, or a K footnote in WinHelp RTF.
		 */
		KEYWORDS("keywords"),
		/**
		 * Indicates a label object.
		 */
		LABEL("label"),
		/**
		 * Indicates a label that is also a HTML link (not necessarily a URL).
		 */
		LINKLABEL("linklabel"),
		/**
		 * Indicates a list (a group of list-items, for example an &lt;ol> or
		 * %lt;ul> element in HTML).
		 */
		LIST("list"),
		/**
		 * Indicates a listbox object, for example an LISTBOX control in
		 * Windows.
		 */
		LISTBOX("listbox"),
		/**
		 * Indicates an list item (an entry in a list).
		 */
		LISTITEM("listitem"),
		/**
		 * Indicates a Windows RC LTEXT control.
		 */
		LTEXT("ltext"),
		/**
		 * Indicates a menu (a group of menu-items).
		 */
		MENU("menu"),
		/**
		 * Indicates a toolbar containing one or more tope level menus.
		 */
		MENUBAR("menubar"),
		/**
		 * Indicates a menu item (an entry in a menu).
		 */
		MENUITEM("menuitem"),
		/**
		 * Indicates a XUL menuseparator element.
		 */
		MENUSEPARATOR("menuseparator"),
		/**
		 * Indicates a message, for example an entry in a MESSAGETABLE resource
		 * in Windows.
		 */
		MESSAGE("message"),
		/**
		 * Indicates a calendar control.
		 */
		MONTHCALENDAR("monthcalendar"),
		/**
		 * Indicates an edit box beside a spin control.
		 */
		NUMERICUPDOWN("numericupdown"),
		/**
		 * Indicates a catch all for rectangular areas.
		 */
		PANEL("panel"),
		/**
		 * Indicates a standalone menu not necessarily associated with a
		 * menubar.
		 */
		POPUPMENU("popupmenu"),
		/**
		 * Indicates a pushbox object, for example a PUSHBOX control in Windows.
		 */
		PUSHBOX("pushbox"),
		/**
		 * Indicates a Windows RC PUSHBUTTON control.
		 */
		PUSHBUTTON("pushbutton"),
		/**
		 * Indicates a radio button object.
		 */
		RADIO("radio"),
		/**
		 * Indicates a menuitem with associated radio button.
		 */
		RADIOBUTTONMENUITEM("radiobuttonmenuitem"),
		/**
		 * Indicates raw data resources for an application.
		 */
		RCDATA("rcdata"),
		/**
		 * Indicates a row in a table.
		 */
		ROW("row"),
		/**
		 * Indicates a Windows RC RTEXT control.
		 */
		RTEXT("rtext"),
		/**
		 * Indicates a user navigable container used to show a portion of a
		 * document.
		 */
		SCROLLPANE("scrollpane"),
		/**
		 * Indicates a generic divider object (e.g. menu group separator).
		 */
		SEPARATOR("separator"),
		/**
		 * Windows accelerators, shortcuts in resource or property files.
		 */
		SHORTCUT("shortcut"),
		/**
		 * Indicates a UI control to indicate process activity but not progress.
		 */
		SPINNER("spinner"),
		/**
		 * Indicates a splitter bar.
		 */
		SPLITTER("splitter"),
		/**
		 * Indicates a Windows RC STATE3 control.
		 */
		STATE3("state3"),
		/**
		 * Indicates a window for providing feedback to the users, like
		 * 'read-only', etc.
		 */
		STATUSBAR("statusbar"),
		/**
		 * Indicates a string, for example an entry in a STRINGTABLE resource in
		 * Windows.
		 */
		STRING("string"),
		/**
		 * Indicates a layers of controls with a tab to select layers.
		 */
		TABCONTROL("tabcontrol"),
		/**
		 * Indicates a display and edits regular two-dimensional tables of
		 * cells.
		 */
		TABLE("table"),
		/**
		 * Indicates a XUL textbox element.
		 */
		TEXTBOX("textbox"),
		/**
		 * Indicates a UI button that can be toggled to on or off state.
		 */
		TOGGLEBUTTON("togglebutton"),
		/**
		 * Indicates an array of controls, usually buttons.
		 */
		TOOLBAR("toolbar"),
		/**
		 * Indicates a pop up tool tip text.
		 */
		TOOLTIP("tooltip"),
		/**
		 * Indicates a bar with a pointer indicating a position within a certain
		 * range.
		 */
		TRACKBAR("trackbar"),
		/**
		 * Indicates a control that displays a set of hierarchical data.
		 */
		TREE("tree"),
		/**
		 * Indicates a URI (URN or URL).
		 */
		URI("uri"),
		/**
		 * Indicates a Windows RC USERBUTTON control.
		 */
		USERBUTTON("userbutton"),
		/**
		 * Indicates a user-defined control like CONTROL control in Windows.
		 */
		USERCONTROL("usercontrol"),
		/**
		 * Indicates the text of a variable.
		 */
		VAR("var"),
		/**
		 * Indicates version information about a resource like VERSIONINFO in
		 * Windows.
		 */
		VERSIONINFO("versioninfo"),
		/**
		 * Indicates a vertical scrollbar.
		 */
		VSCROLLBAR("vscrollbar"),
		/**
		 * Indicates a graphical window.
		 */
		WINDOW("window"),
		/**
		 * Indicates the terminating state.
		 */
		FINAL("final"),
		/**
		 * Indicates only non-textual information needs adaptation.
		 */
		NEEDS_ADAPTATION("needs-adaptation"),
		/**
		 * Indicates both text and non-textual information needs adaptation.
		 */
		NEEDS_L10N("needs-l10n"),
		/**
		 * Indicates only non-textual information needs review.
		 */
		NEEDS_REVIEW_ADAPTATION("needs-review-adaptation"),
		/**
		 * Indicates both text and non-textual information needs review.
		 */
		NEEDS_REVIEW_L10N("needs-review-l10n"),
		/**
		 * Indicates that only the text of the item needs to be reviewed.
		 */
		NEEDS_REVIEW_TRANSLATION("needs-review-translation"),
		/**
		 * Indicates that the item needs to be translated.
		 */
		NEEDS_TRANSLATION("needs-translation"),
		/**
		 * Indicates that the item is new. For example, translation units that
		 * were not in a previous version of the document.
		 */
		NEW("new"),
		/**
		 * Indicates that changes are reviewed and approved.
		 */
		SIGNED_OFF("signed-off"),
		/**
		 * Indicates that the item has been translated.
		 */
		TRANSLATED("translated");

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
