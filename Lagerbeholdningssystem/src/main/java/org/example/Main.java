package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String lagerFil = "lagerbeholdning.json";
        FileWriter fw = new FileWriter();
        fw.UpdateStorage("A -20;C -5", lagerFil);

        /*
        FileReader fr = new FileReader();
        Map<String, Vare> vareListe = new HashMap<>();
        vareListe = fr.ReadFile("lagerbeholdning.json");
        for (Vare vare : vareListe.values()) {
            System.out.println(vare.name + " " + vare.count);
        }
        */


        /*
        InputHelper inputHelper = new InputHelper();

        String name = inputHelper.getString("Enter your name: ");
        int age = inputHelper.getInt("Enter your age: ");

        System.out.println("Hello, " + name + "!");
        System.out.println("You are " + age + " years old.");

        inputHelper.close();
        */
    }
}