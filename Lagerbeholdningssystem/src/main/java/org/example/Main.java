package org.example;

public class Main {
    public static void main(String[] args) {

        FileReader fr = new FileReader();
        fr.ReadFile("lagerbeholdning.json");

        InputHelper inputHelper = new InputHelper();

        String name = inputHelper.getString("Enter your name: ");
        int age = inputHelper.getInt("Enter your age: ");

        System.out.println("Hello, " + name + "!");
        System.out.println("You are " + age + " years old.");

        inputHelper.close();
    }
}