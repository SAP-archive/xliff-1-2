package com.sap.mlt.xliff12.api.attribute;

import com.sap.mlt.xliff12.api.base.XTendableAttribute;
import com.sap.mlt.xliff12.api.element.delimiter.Mrk;
import com.sap.mlt.xliff12.api.element.structural.Source;
import com.sap.mlt.xliff12.api.element.structural.Target;

/**
 * Marker type -The mtype attribute specifies what a {@link Mrk} element is
 * defining within the content of a {@link Source} or {@link Target} element.
 * 
 * @author D049314
 */
public interface Mtype extends XTendableAttribute {

	/**
	 * The attribute's name.
	 */
	final static String NAME = "mtype";

	/**
	 * Pre-defined mtype values.
	 * 
	 * @author D049314
	 */
	enum Value {
		/**
		 * Indicates the marked text is an abbreviation.
		 */
		ABBREV("abbrev"),
		/**
		 * ISO-12620 2.1.8: A term resulting from the omission of any part of
		 * the full term while designating the same concept.
		 */
		ABBREVIATED_FORM("abbreviated-form"),
		/**
		 * ISO-12620 2.1.8.1: An abbreviated form of a simple term resulting
		 * from the omission of some of its letters (e.g. 'adj.' for
		 * 'adjective').
		 */
		ABBREVIATION("abbreviation"),
		/**
		 * ISO-12620 2.1.8.4: An abbreviated form of a term made up of letters
		 * from the full form of a multiword term strung together into a
		 * sequence pronounced only syllabically (e.g. 'radar' for 'radio
		 * detecting and ranging').
		 */
		ACRONYM("acronym"),
		/**
		 * ISO-12620: A proper-name term, such as the name of an agency or other
		 * proper entity.
		 */
		APPELLATION("appellation"),
		/**
		 * ISO-12620 2.1.18.1: A recurrent word combination characterized by
		 * cohesion in that the components of the collocation must co-occur
		 * within an utterance or series of utterances, even though they do not
		 * necessarily have to maintain immediate proximity to one another.
		 */
		COLLOCATION("collocation"),
		/**
		 * ISO-12620 2.1.5: A synonym for an international scientific term that
		 * is used in general discourse in a given language.
		 */
		COMMON_NAME("common-name"),
		/**
		 * Indicates the marked text is a date and/or time.
		 */
		DATETIME("datetime"),
		/**
		 * ISO-12620 2.1.15: An expression used to represent a concept based on
		 * a statement that two mathematical expressions are, for instance,
		 * equal as identified by the equal sign (=), or assigned to one another
		 * by a similar sign.
		 */
		EQUATION("equation"),
		/**
		 * ISO-12620 2.1.7: The complete representation of a term for which
		 * there is an abbreviated form.
		 */
		EXPANDED_FORM("expanded-form"),
		/**
		 * ISO-12620 2.1.14: Figures, symbols or the like used to express a
		 * concept briefly, such as a mathematical or chemical formula.
		 */
		FORMULA("formula"),
		/**
		 * ISO-12620 2.1.1: The concept designation that has been chosen to head
		 * a terminological record.
		 */
		HEAD_TERM("head-term"),
		/**
		 * ISO-12620 2.1.8.3: An abbreviated form of a term consisting of some
		 * of the initial letters of the words making up a multiword term or the
		 * term elements making up a compound term when these letters are
		 * pronounced individually (e.g. 'BSE' for 'bovine spongiform
		 * encephalopathy').
		 */
		INITIALISM("initialism"),
		/**
		 * ISO-12620 2.1.4: A term that is part of an international scientific
		 * nomenclature as adopted by an appropriate scientific body.
		 */
		INTERNATIONAL_SCIENTIFIC_TERM("international-scientific-term"),
		/**
		 * ISO-12620 2.1.6: A term that has the same or nearly identical
		 * orthographic or phonemic form in many languages.
		 */
		INTERNATIONALISM("internationalism"),
		/**
		 * ISO-12620 2.1.16: An expression used to represent a concept based on
		 * mathematical or logical relations, such as statements of inequality,
		 * set relationships, Boolean operations, and the like.
		 */
		LOGICAL_EXPRESSION("logical-expression"),
		/**
		 * ISO-12620 2.1.17: A unit to track object.
		 */
		MATERIALS_MANAGEMENT_UNIT("materials-management-unit"),
		/**
		 * Indicates the marked text is a name.
		 */
		NAME("name"),
		/**
		 * ISO-12620 2.1.3: A term that represents the same or a very similar
		 * concept as another term in the same language, but for which
		 * interchangeability is limited to some contexts and inapplicable in
		 * others.
		 */
		NEAR_SYNONYM("near-synonym"),
		/**
		 * ISO-12620 2.1.17.2: A unique alphanumeric designation assigned to an
		 * object in a manufacturing system.
		 */
		PART_NUMBER("part-number"),
		/**
		 * Indicates the marked text is a phrase.
		 */
		PHRASE("phrase"),
		/**
		 * ISO-12620 2.1.18: Any group of two or more words that form a unit,
		 * the meaning of which frequently cannot be deduced based on the
		 * combined sense of the words making up the phrase.
		 */
		PHRASEOLOGICAL_UNIT("phraseological-unit"),
		/**
		 * Indicates the marked text should not be translated.
		 */
		PROTECTED("protected"),
		/**
		 * ISO-12620 2.1.12: A form of a term resulting from an operation
		 * whereby non-Latin writing systems are converted to the Latin
		 * alphabet.
		 */
		ROMANIZED_FORM("romanized-form"),
		/**
		 * Indicates that the marked text represents a segment.
		 */
		SEG("seg"),
		/**
		 * ISO-12620 2.1.18.2: A fixed, lexicalized phrase.
		 */
		SET_PHRASE("set-phrase"),
		/**
		 * ISO-12620 2.1.8.2: A variant of a multiword term that includes fewer
		 * words than the full form of the term (e.g. 'Group of Twenty-four' for
		 * 'Intergovernmental Group of Twenty-four on International Monetary
		 * Affairs').
		 */
		SHORT_FORM("short-form"),
		/**
		 * ISO-12620 2.1.17.1: Stock keeping unit, an inventory item identified
		 * by a unique alphanumeric designation assigned to an object in an
		 * inventory control system.
		 */
		SKU("sku"),
		/**
		 * ISO-12620 2.1.19: A fixed chunk of recurring text.
		 */
		STANDARD_TEXT("standard-text"),
		/**
		 * ISO-12620 2.1.13: A designation of a concept by letters, numerals,
		 * pictograms or any combination thereof.
		 */
		SYMBOL("symbol"),
		/**
		 * ISO-12620 2.1.2: Any term that represents the same or a very similar
		 * concept as the main entry term in a term entry.
		 */
		SYNONYM("synonym"),
		/**
		 * ISO-12620 2.1.18.3: Phraseological unit in a language that expresses
		 * the same semantic content as another phrase in that same language.
		 */
		SYNONYMOUS_PHRASE("synonymous-phrase"),
		/**
		 * Indicates the marked text is a term.
		 */
		TERM("term"),
		/**
		 * ISO-12620 2.1.11: A form of a term resulting from an operation
		 * whereby the characters of one writing system are represented by
		 * characters from another writing system, taking into account the
		 * pronunciation of the characters converted.
		 */
		TRANSCRIBED_FORM("transcribed-form"),
		/**
		 * ISO-12620 2.1.10: A form of a term resulting from an operation
		 * whereby the characters of an alphabetic writing system are
		 * represented by characters from another alphabetic writing system.
		 */
		TRANSLITERATED_FORM("transliterated-form"),
		/**
		 * ISO-12620 2.1.8.5: An abbreviated form of a term resulting from the
		 * omission of one or more term elements or syllables (e.g. 'flu' for
		 * 'influenza').
		 */
		TRUNCATED_TERM("truncated-term"),
		/**
		 * ISO-12620 2.1.9: One of the alternate forms of a term.
		 */
		VARIANT("variant");

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
