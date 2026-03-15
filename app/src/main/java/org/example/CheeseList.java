package org.example;

import java.util.ArrayList;

public class CheeseList {

    private ArrayList<Cheese> cheeses;

    public CheeseList() {
        cheeses = new ArrayList<>();
    }

    public void add(Cheese cheese) {
        cheeses.add(cheese);
    }

    public ArrayList<Cheese> getCheeses() {
        return cheeses;
    }

    public int size() {
        return cheeses.size();
    }
}
