package org.example;

import com.fasterxml.jackson.databind.JsonNode;

public class getNodeInt {

    public static int getNode(JsonNode node, String fieldName) {
        JsonNode fieldNode = node.get(fieldName);
        return (fieldNode != null && !fieldNode.isNull()) ? fieldNode.asInt() : 0;
    }
}
