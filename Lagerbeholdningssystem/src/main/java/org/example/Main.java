package org.example;

public class Main {
    public static void main(String[] args) {

        // TODO: Add initializer of writing data to lagerbeholdning.json

        //FileReader fr = new FileReader();
        //fr.ReadFile("lagerbeholdning.json");
        //fr.ReadOrderData("ordredata.json");

        UserInputHandler userInputHandler = new UserInputHandler();
        userInputHandler.openCommunication();
    }
}