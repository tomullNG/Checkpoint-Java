package org.example;

import com.fasterxml.jackson.databind.JsonNode;

public class getNodeText {

    public static String getNode(JsonNode node, String fieldName) {
        JsonNode fieldNode = node.get(fieldName);
        return (fieldNode != null && !fieldNode.isNull()) ? fieldNode.asText() : null;
    }

}
