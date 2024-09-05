package org.example;

public class Vare {
    public String item_id;
    public String name;
    public int count;
    // Default constructor
    public Vare() {}

    public Vare(String item_id, String name, int count) {
        this.item_id = item_id;
        this.name = name;
        this.count = count;
    }
}
