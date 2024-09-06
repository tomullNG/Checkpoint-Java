package org.example;

import com.fasterxml.jackson.databind.JsonNode;

public class VareHandler implements JsonStructureHandler<Vare> {

    @Override
    public void handleNode(JsonNode rootNode, VareListe<Vare> vareListe) {
        for (JsonNode node : rootNode) {
            String itemId = getNodeText.getNode(node, "item_id");
            String name = getNodeText.getNode(node, "name");
            int count = getNodeInt.getNode(node, "count");

            Vare vare = new Vare(itemId, name, count);
            vareListe.liste.put(vare.item_id, vare);
        }
    }
}
