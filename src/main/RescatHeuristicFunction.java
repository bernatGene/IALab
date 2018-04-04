package main;

import IA.Desastres.Centros;
import IA.Desastres.Grupos;
import aima.search.framework.HeuristicFunction;

import java.util.ArrayList;

public class RescatHeuristicFunction implements HeuristicFunction {
    public double getHeuristicValue(Object n) {
        AreaRescat area = (AreaRescat) n;
        double temps = tempsTotal(area);
        return temps;
    }

    private double tempsTotal(AreaRescat area) {
        ArrayList<Helicopter> helicopters = area.getHelicopters();
        int numCentres = AreaRescat.getNumCentres();
        int numGrups = AreaRescat.getNumGrups();
        int helisPerCentre = AreaRescat.getHelisPerCentre();
        double tempsTotal = 0.0;
        for (int i=0; i < (numCentres*helisPerCentre); ++i) {
            int centre = i/helisPerCentre;
            Helicopter helicopter = helicopters.get(i);
            tempsTotal += tempsHelicopter(helicopter, area, centre);

        }
        return tempsTotal;

    }

    private double tempsHelicopter(Helicopter helicopter, AreaRescat area, int centre) {
        Centros centres = AreaRescat.getCentres();
        Grupos grups = AreaRescat.getGrups();
        double temps = 0.0;
        return temps;
    }
}
