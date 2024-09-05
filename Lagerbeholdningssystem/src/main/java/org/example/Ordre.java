package org.example;

import java.util.Map;

public class Ordre {
    String order_id;
    String status;
    Map<String, Vare> vare;

    public Ordre(String order_id, String status, Map<String, Vare> vare) {
        this.order_id = order_id;
        this.vare = vare;
        this.status = status;
    }
}

