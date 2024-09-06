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
    public String jsonFilePath = "src/main/resources/";
    public static String restockFile = "ItemThreshold.json";

    public<T> void WriteToFile(String filename, VareListe<T> vareListe){
        // Convert map values to list
        List<T> vareList = new ArrayList<>(vareListe.liste.values());

        // Write to JSON file
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(filename), vareList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Legg til måte å skrive ut leverandør rapport
    public void UpdateStorage(String input, String lagerFile) {
        VareListe<Vare> vareListe = new VareListe();
        FileReader fr = new FileReader();
        VareHandler vareHandler = new VareHandler();
        vareListe = fr.ReadFile(lagerFile, vareHandler);

        String[] inputVarer = input.split(";");
        String key;
        String count;
        Vare temp_vare;
        for (String vare : inputVarer){
            String[] parts = vare.split(" ");
            key = parts[0];
            count = parts[1];
            if (vareListe.liste.containsKey(key)){
                temp_vare = vareListe.liste.get(key);
                temp_vare.count += Integer.valueOf(count);
                vareListe.liste.put(key, temp_vare);
            }
        }

        //writing updated storage
        WriteToFile(jsonFilePath + lagerFile, vareListe);

        System.out.println("TEST");
        for (Vare vare : vareListe.liste.values()){
            System.out.println(vare.name + " " + vare.count);
        }

        //Restocking if necessary
        Restock(lagerFile);
    }

    //method for restocking the amount of items in storage IF they are bellow a given threshold
    public void Restock(String lagerFile) {
        VareListe<Vare> vareListe;
        VareHandler vareHandler = new VareHandler();

        VareListe<VareThreshold> restockListe;
        RestockHandler restockHandler = new RestockHandler();

        FileReader fr = new FileReader();
        vareListe = fr.ReadFile(lagerFile, vareHandler);
        restockListe = fr.ReadFile(restockFile, restockHandler);

        //iterating over and updating values that are bellow the given threshold
        String key;
        for (Vare vare : vareListe.liste.values()){
            key = vare.item_id;
            if (restockListe.liste.get(key).threshold > vare.count){
                System.out.print("System restocking item: " + vare.name + ". \nOld count: " + vare.count + ". ");
                vare.count += restockListe.liste.get(key).restock;
                System.out.println("New count: " + vare.count);
            }
        }

        //updating the file
        WriteToFile(jsonFilePath + lagerFile, vareListe);
    }
}
