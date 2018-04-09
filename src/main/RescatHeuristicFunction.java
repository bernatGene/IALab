package main;

import IA.Desastres.Centros;
import IA.Desastres.Grupo;
import IA.Desastres.Grupos;
import aima.search.framework.HeuristicFunction;

import java.util.ArrayList;

public class RescatHeuristicFunction implements HeuristicFunction {
    public double getHeuristicValue(Object n) {
        AreaRescat area = (AreaRescat) n;
        double temps = tempsTotal(area);
        return temps;
    }

    public static double tempsTotal(AreaRescat area) {
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

    public static double tempsHelicopter(Helicopter helicopter, AreaRescat area, int centre) {
        double temps = 0.0;
        for (int i=0; i < helicopter.size(); ++i) {
            int [] trajecte = helicopter.getTrajecteIndex( i );
            double tempsTrajecte = tempsTrajecte(trajecte, centre );
            if (tempsTrajecte != 0) {
                temps += tempsTrajecte;
                if (i != helicopter.size()-1) temps+=10;
            }

        }
        return temps;
    }

    public static double tempsTrajecte(int [] trajecte, int centre) {
        double temps = 0.0;
        Grupos grups = AreaRescat.getGrups();
        double distTrajecte = Helicopter.distanciaTrajecte(trajecte, centre);
        if (distTrajecte != 0) {
            temps += (distTrajecte * (0.6));
        }
        for (int j=0; j<3; ++j) {
            if (trajecte[j] != -1) {
                Grupo grup = grups.get( trajecte[j] );
                if (grup.getPrioridad() == 1) temps += grup.getNPersonas()*2;
                else temps += grup.getNPersonas();
            }
        }
        return temps;

    }

    public static double tempsPrioritat1(AreaRescat area) {
        double temps = 0.0;
        

        return temps;
    }
}
