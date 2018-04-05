package main;

import IA.Desastres.Centro;
import IA.Desastres.Centros;
import IA.Desastres.Grupos;

import java.util.ArrayList;
import java.util.List;

public class MainProves {

    public static void main(String[] args) {

        System.out.println("Generant Area de Rescat");

        int numGrups = 100;
        int numCentres = 5;
        int helisPerCentre = 1;
        int seed = 1234;
        AreaRescat area = new AreaRescat(numGrups, numCentres, helisPerCentre, seed);

        System.out.println("printant Area de Rescat:");

        Centros centres = area.getCentres();
        numCentres = area.getNumCentres();
        System.out.println(numCentres);
        Grupos grups = area.getGrups();
        numGrups = area.getNumGrups();

        System.out.println("Centres:");
        AreaRescat.printaCentres();

        System.out.println("\nGrups:");
        AreaRescat.printaGrups();

        area.solucioInicial2();
        System.out.println("\nRecorreguts:");
        area.printaRescat();

        double temps = RescatHeuristicFunction.tempsTotal(area);
        System.out.println("\nTemps total: " + temps);


        System.out.println("\nEstats veins: els seus temps:");
        RescatSuccesorFunction sf = new RescatSuccesorFunction();
        //AreaRescat novaArea = sf.operadorSwapTrajectes(area,0,1,0,0);

        //novaArea.printaRescat();


        /*ArrayList<AreaRescat> estats = sf.estatsSwapTrajectes(area);
        for (int i = 0; i < estats.size(); ++i) {
            double tempsfill = RescatHeuristicFunction.tempsTotal(estats.get(i));
            System.out.println("Fill " + i + " temps: " + tempsfill);
            estats.get(i).printaRescat();
            System.out.println("-----------");
        }*/
    }
}
