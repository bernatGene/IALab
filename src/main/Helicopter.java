package main;

import java.util.ArrayList;

public class Helicopter {
    private ArrayList<int []> trajectes;


    public Helicopter() {
        trajectes = new ArrayList<>();
    }

    public int[] getTrajecteIndex(int index) {
        return trajectes.get( index );
    }

    public void addTrajecte(int [] trajecte) {
        trajectes.add(trajecte);
    }

    public void setTrajecteIndex(int index, int [] trajecte) {
        trajectes.set(index, trajecte);
    }
}
