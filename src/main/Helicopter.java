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

    public void printaTrajecte() {
        int n = trajectes.size();
        for (int i =0; i< n; ++i) {
            int trajecte[] = trajectes.get( i );
            System.out.print("["+trajecte[0]+","+trajecte[1]+","+trajecte[2]+"] "  );
        }
    }
}
