<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

<xsl:output method="xml" indent="no" encoding="UTF-8"/>
<xsl:preserve-space elements="xsl:text"/>
<xsl:param name="indentsequence" select="'&#x9;'" />

<xsl:template match="*">
	<xsl:param name="depth">0</xsl:param>
	
	<xsl:variable name="isxliffelement" select="namespace-uri(.) = 'urn:oasis:names:tc:xliff:document:1.2'"/>
	<xsl:variable name="lname" select="local-name(.)"/>
	<xsl:variable name="isinlinename" select="$lname = 'g' or $lname = 'x' or $lname = 'bx' or $lname = 'ex' or $lname = 'ph' or $lname = 'bpt' or $lname = 'ept' or $lname = 'it' or $lname = 'sub' or $lname = 'mrk'"/>
	<xsl:variable name="isinline" select="$isxliffelement and $isinlinename"/>
	<xsl:variable name="iscontname" select="$lname = 'source' or $lname = 'target' or $lname = 'seg-source' or $lname = 'alt-trans'"/>
	<xsl:variable name="iscont" select="$isxliffelement and $iscontname"/>
	
	<xsl:if test="not($isinline)">      
		<xsl:text>&#xA;</xsl:text>
		<xsl:call-template name="indent">
 			<xsl:with-param name="depth" select="$depth"/>
		</xsl:call-template>
	</xsl:if>
	
	<xsl:copy>
		<xsl:copy-of select="@*"/>
		<xsl:apply-templates>
			<xsl:with-param name="depth" select="$depth + 1"/>
		</xsl:apply-templates>
		<xsl:if test="(count(*) &gt; 0) and not($isinline) and not($iscont)">
			<xsl:text>&#xA;</xsl:text>
			<xsl:call-template name="indent">
 				<xsl:with-param name="depth" select="$depth"/>
			</xsl:call-template>
		</xsl:if>
	</xsl:copy>
</xsl:template>

<xsl:template name="indent">
	<xsl:param name="depth"/>
	<xsl:if test="$depth &gt; 0">
		<xsl:value-of select="$indentsequence" />
		<xsl:call-template name="indent">
			<xsl:with-param name="depth" select="$depth - 1"/>
		</xsl:call-template>
	</xsl:if>
</xsl:template>

<xsl:template match="text()">
	<xsl:value-of select="." />
</xsl:template>

</xsl:stylesheet>
