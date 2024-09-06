package org.example;
import com.fasterxml.jackson.databind.JsonNode;


public class RestockHandler implements JsonStructureHandler<VareThreshold> {

    @Override
    public void handleNode(JsonNode node, VareListe<VareThreshold> vareListe) {
        String itemId = getNodeText.getNode(node, "item_id");
        int threshold = getNodeInt.getNode(node, "threshold");
        int restock = getNodeInt.getNode(node, "restock");

        VareThreshold vare = new VareThreshold(itemId, threshold, restock);
        vareListe.liste.put(vare.item_id, vare);
    }
}
