package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


//Oppdater så denne kan brukes for RestockHandler også.
public class FileReader {

    public String jsonFilePath = "src/main/java/resources/";

    public<T> VareListe<T> ReadFile(String fileName, JsonStructureHandler<T> handler) {
        VareListe<T> vareListe = new VareListe<>();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath + fileName));

            if (rootNode.isArray()) {
                handler.handleNode(rootNode, vareListe);

            } else {
                System.err.println("The JSON root node is not an array.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return vareListe;

    }
}
