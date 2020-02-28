![](https://img.shields.io/badge/STATUS-NOT%20CURRENTLY%20MAINTAINED-red.svg?longCache=true&style=flat)

# Important Notice
We have decided to stop the maintenance of this public GitHub repository.


# Xliff 1.2

The XML Localisation Interchange File Format (XLIFF) version 1.2 and 2.0 are OASIS Standards. XLIFF is the outcome of contributors from eg. from IBM, Lionbridge, Oracle and ... SAP. SAP Language Services has been contributing (to 1.2 by participation in the XLIFF Technical Committee at OASIS). 

XLIFF defines an XML-based vocabulary which allows any localizable data to be mapped to a single format without loss of information. This reduces the complexity of localizing software, documentation and other types of content since many steps in the overall processing chain only need to be enabled for one single format. 

XLIFF already has an impact on the way translation is organized, and XLIFF's impact is expected to grow. Accordingly, SLS is actively promoting it to many content and tool producers - internally and externally. 

Using XLIFF not only simplifies internal translation processes. As an open standard XLIFF also offers the advantage to be supported by lots of localization software. Especially projects that offer the possibility to be enhanced or customized by customers will benefit from XLIFF, as SAP's customers can easily translate their own developments and customizations using the localization software of their choice. 

To simplify several XLIFF-related processes, SAP created a set of Java libraries that take over a lot of the typical tasks. The XLIFF 1.2 Core library offers functionality for constructing, reading, modifying and writing XLIFF 1.2 files according to the OASIS specification. The library closely resembles the XLIFF 1.2 specification using Java language elements. The library ensures that only structurally valid XLIFF document is generated. Furthermore, referential constraints are checked by the library on serialization. The library currently deserializes files that validate against the XLIFF 1.2 transitional XML schema, and confirm with the specification. As a result the API might drop some attributes and elements on serialization of XLIFF documents to guarantee specification compliance. 

##Libraries Xliff12 builds upon
* Apache Abdera	1.1.3
* Apache Xerces Java XML Parser	2.11.0


##Current known limitations

There are inconsistencies between the OASIS XLIFF 1.2 specification and the XML schema provided by OASIS for validating XLIFF files. The library currently allows to deserialize files only that can be validated against the XLIFF 1.2 transitional XML schema. Furthermore it will only write XLIFF files that are valid according to both the specification and the XLIFF 1.2 transitional schema. 

The differences are as follows:

###Section 2.5.1:

The <body>-element is missing in the example XLIFF code. The example schema in this section won't work this way in conjunction with the previous example. Attribute targetNamespace should read targetNamespace="http://www.ChaucerState.ac.pg/Frm/XLFSup-v1"; instead of targetNamespace="XLFSup-v1". Furthermore line xmlns:sup="http://www.ChaucerState.ac.pg/Frm/XLFSup-v1"; should read xmlns="http://www.ChaucerState.ac.pg/Frm/XLFSup-v1"; as prefix "sup" is not used in the schema.

###Section 2.5.2:

The <body>-element is missing in the example XLIFF code, too.

###Section 3.2.1:

According to specification content of the <glossary> element consists of the "glossary description and either exactly one <internal-file> or one <external-file> element". However, the schema allows either exactly one <internal-file> or one <external-file> element only, but no glossary description. 
Same as above for <reference>: According to specification content of the <reference> element consists of "A description of the reference material and either exactly one <internal-file> or one <external-file> element". However, the schema allows either exactly one <internal-file> or one <external-file> element only, but no reference material description. 
Attribute "phase-name" in element <phase> is typed as "string" in schema. However, in elements <target>, <alt-trans>, <bin-unit> and <bin-target> it is typed as "NMTOKEN". Therefore the schema allows to create phases by names you cannot  reference in the above elements.

###Section 3.2.2:

According to specification content of a <count-group> element consists of "One or more <count> elements". The schema allows zero <count> elements, too. 
According to specification in element <count> the attribute "count-type" is required. However, it is optional in the schema. 
