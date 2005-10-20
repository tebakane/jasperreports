/*
 * ============================================================================
 * GNU Lesser General Public License
 * ============================================================================
 *
 * JasperReports - Free Java report-generating library.
 * Copyright (C) 2001-2005 JasperSoft Corporation http://www.jaspersoft.com
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307, USA.
 * 
 * JasperSoft Corporation
 * 185, Berry Street, Suite 6200
 * San Francisco CA 94107
 * http://www.jaspersoft.com
 */
package net.sf.jasperreports.engine.xml;

import net.sf.jasperreports.engine.design.JRDesignDataset;

import org.xml.sax.Attributes;

/**
 * @author Lucian Chirita (lucianc@users.sourceforge.net)
 * @version $Id$
 */
public class JRDatasetFactory extends JRBaseFactory
{
	public static final String TAG_SUB_DATASET = "subDataset";
	
	public static final String ATTRIBUTE_name = "name";
	public static final String ATTRIBUTE_scriptletClass = "scriptletClass";
	public static final String ATTRIBUTE_resourceBundle = "resourceBundle";
	public static final String ATTRIBUTE_whenResourceMissingType = "whenResourceMissingType";

	
	public Object createObject(Attributes attributes)
	{
		JRDesignDataset dataset = new JRDesignDataset(false);
		
		dataset.setName(attributes.getValue(ATTRIBUTE_name));
		dataset.setScriptletClass(attributes.getValue(ATTRIBUTE_scriptletClass));
		
		dataset.setResourceBundle(attributes.getValue(ATTRIBUTE_resourceBundle));

		String resMissingAttr = attributes.getValue(ATTRIBUTE_whenResourceMissingType);
		if (resMissingAttr != null && resMissingAttr.length() > 0)
		{
			Byte whenResourceMissingType = (Byte) JRXmlConstants.getWhenResourceMissingTypeMap().get(resMissingAttr);
			dataset.setWhenResourceMissingType(whenResourceMissingType.byteValue());
		}

		return dataset;
	}
}
