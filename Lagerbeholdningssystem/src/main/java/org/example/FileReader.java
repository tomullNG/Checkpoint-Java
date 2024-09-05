package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileReader {
    public String jsonFilePath = "src/main/resources/";
    ObjectMapper objectMapper;

    public void ReadFile(String fileName) {
        try {
            objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath + fileName));

            Map<String, Vare> vareListe = new HashMap<>();

            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    String itemId = getNodeText.getNode(node, "item_id");
                    String name = getNodeText.getNode(node, "name");
                    int count = getNodeInt.getNode(node, "count");

                    Vare vare = new Vare(itemId, name, count);
                    vareListe.put(vare.item_id, vare);
                }
            } else {
                System.err.println("The JSON root node is not an array.");
            }

            System.out.println("Lagerbeholdning:");
            for (Vare vare : vareListe.values()) {
                System.out.println("Antall av " + vare.name + " på lager: " + vare.count);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void ReadOrderData(String filename) {
        try {
            objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath + filename));
            Map<String, Vare> vareListe;
            Map<String, Ordre> ordreListe = new HashMap<>();

            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    String order_id = getNodeText.getNode(node, "order_id");
                    String order_status = getNodeText.getNode(node, "order_status");
                    JsonNode orderLineNode = node.get("order_line");

                    if (orderLineNode != null && orderLineNode.isArray()) {
                        vareListe = new HashMap<>();

                        for (JsonNode item : orderLineNode) {
                            //System.out.println("Item: " + item);
                            String item_id = getNodeText.getNode(item, "item_id");
                            String item_name = getNodeText.getNode(item, "item_name");
                            int item_count = getNodeInt.getNode(item, "count");
                            Vare vare = new Vare(item_id, item_name, item_count);
                            vareListe.put(vare.item_id, vare);
                        }

                        Ordre ordre = new Ordre(order_id, order_status ,vareListe);
                        ordreListe.put(ordre.order_id, ordre);
                    }
                }
            } else {
                System.err.println("The JSON root node is not an array.");
            }

            for (Ordre ordre : ordreListe.values()) {
                for (Vare vare : ordre.vare.values()) {
                    System.out.println(ordre.order_id + ": " + ordre.status + " " + vare.count +
                            " stk. av vare [" + vare.item_id + "] " + vare.name);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
