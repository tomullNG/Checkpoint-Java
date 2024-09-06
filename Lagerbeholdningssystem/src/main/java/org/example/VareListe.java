package org.example;

import java.util.HashMap;
import java.util.Map;

public class VareListe<T> {
    public Map<String, T> liste = new HashMap<>();
    // Default constructor
    public VareListe() {}

    public void setVareListe(Map<String, T> vareListe) {
        this.liste = vareListe;
    }
}
