package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        InputHelper inputHelper = new InputHelper();

        String name = inputHelper.getString("Enter your name: ");
        int age = inputHelper.getInt("Enter your age: ");

        System.out.println("Hello, " + name + "!");
        System.out.println("You are " + age + " years old.");

        inputHelper.close();
    }
}