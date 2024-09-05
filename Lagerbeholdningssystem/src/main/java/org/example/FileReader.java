package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileReader {

    public String jsonFilePath = "src/main/java/resources/";

    public Map<String, Vare> ReadFile(String fileName) {
        Map<String, Vare> vareListe = new HashMap<>();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath + fileName));


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


        } catch (IOException e) {
            e.printStackTrace();
        }
        return vareListe;

    }
}
