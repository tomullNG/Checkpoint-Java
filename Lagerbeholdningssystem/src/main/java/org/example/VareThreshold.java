package org.example;

public class VareThreshold {
    public String item_id;
    public int threshold;
    public int restock;
    // Default constructor
    public VareThreshold() {}

    public VareThreshold(String item_id, int threshold, int restock) {
        this.item_id = item_id;
        this.threshold = threshold;
        this.restock = restock;

    }
}
