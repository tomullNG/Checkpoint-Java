package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String lagerFil = "lagerbeholdningTest.json";
        FileWriter fw = new FileWriter();
        fw.UpdateStorage("A 0;C 0;B -15", lagerFil);
        //fw.Restock("lagerbeholdningTest.json");

        // TODO: Add initializer of writing data to lagerbeholdning.json

        //FileReader fr = new FileReader();
        //fr.ReadFile("lagerbeholdning.json");
        //fr.ReadOrderData("ordredata.json");

        //UserInputHandler userInputHandler = new UserInputHandler();
        //userInputHandler.openCommunication();
    }
}