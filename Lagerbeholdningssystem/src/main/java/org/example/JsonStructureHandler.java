package org.example;

import com.fasterxml.jackson.databind.JsonNode;

public interface JsonStructureHandler<T> {
    void handleNode(JsonNode node, VareListe<T> vareListe);
}

