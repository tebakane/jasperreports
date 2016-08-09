/*
 * JasperReports - Free Java Reporting Library.
 * Copyright (C) 2001 - 2016 TIBCO Software Inc. All rights reserved.
 * http://www.jaspersoft.com
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of JasperReports.
 *
 * JasperReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JasperReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with JasperReports. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.jasperreports.engine.json;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Narcis Marcu (narcism@users.sourceforge.net)
 */
public class JsonNodeContainer {
    private List<JRJsonNode> nodes;

    public JsonNodeContainer() {
        nodes = new ArrayList<>();
    }

    public JsonNodeContainer(JRJsonNode node) {
        this();
        nodes.add(node);
    }

    public void add(JRJsonNode node) {
        nodes.add(node);
    }

    public void addNodes(List<JRJsonNode> nodes) {
        this.nodes.addAll(nodes);
    }

    public List<JRJsonNode> getNodes() {
        return nodes;
    }

    public JRJsonNode getFirst() {
        return nodes.get(0);
    }

    public int getSize() {
        return nodes.size();
    }

    public int getContainerSize() {
        if (nodes.size() > 1) {
            return nodes.size();
        } else if (nodes.size() == 1 && nodes.get(0).getDataNode().isArray()) {
            return nodes.get(0).getDataNode().size();
        }

        return 0;
    }

    /**
     * Checks if this is a true container
     */
    public boolean isContainer() {
        return nodes.size() > 1 || (nodes.size() == 1 && nodes.get(0).getDataNode().isArray());
    }

}