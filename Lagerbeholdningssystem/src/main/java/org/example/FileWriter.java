package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.File;

/**
 * LESE INPUT SOM "VARE ANTALL"
 * --KAN TA KEY OG ANTALL
 * ---HVIS KEY IKKE EKSISTERE, RETURNER FEILMELDING
 * --KAN OGSÅ TA KEY, ANTALL OG VARE
 * ---HVIS VARE IKKE MATCHER KEY, RETURNER FEILMELDING
 * ---HVIS VARE EKSISTERER I TIDLIGERE KEY, RETURNER FEILMELDING
 * ---HVIS VARE OG KEY IKKE EKSISTERER, OPPRETT VARE OG KEY
 * HVIS VARE EKSISTERER, LEGG TIL ANTALL I LISTE
 * HVIS VARE IKKE EKSISTERER, LAG NY KEY ID OG LEGG TIL VARE
 */
public class FileWriter {

    public void WriteToFile(String input, String lagerFile) {
        Map<String, Vare> vareListe = new HashMap<>();
        FileReader fr = new FileReader();
        vareListe = fr.ReadFile(lagerFile);

        /*System.out.println(input);
        System.out.println(vareListe);
        for (Vare vare : vareListe.values()) {
            System.out.println(vare.name);
        }*/

        String[] inputVarer = input.split(";");
        String key;
        String count;
        Vare temp_vare;
        for (String vare : inputVarer){
            String[] parts = vare.split(" ");
            key = parts[0];
            count = parts[1];
            if (vareListe.containsKey(key)){
                temp_vare = vareListe.get(key);
                temp_vare.count += Integer.valueOf(count);
                vareListe.put(key, temp_vare);
            }
        }

        // Convert map values to list
        List<Vare> vareList = new ArrayList<>(vareListe.values());

        // Write to JSON file
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("output.json"), vareList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("TEST");
        for (Vare vare : vareListe.values()){
            System.out.println(vare.name + " " + vare.count);
        }

    }
}
