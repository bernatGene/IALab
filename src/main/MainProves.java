package main;

import IA.Desastres.Centro;
import IA.Desastres.Centros;
import IA.Desastres.Grupos;

public class MainProves {

    public static void main(String[] args) {

        System.out.println( "Generant Area de Rescat" );

        int numGrups = 100;
        int numCentres = 5;
        int helisPerCentre = 1;
        int seed = 2;
        AreaRescat area = new AreaRescat(numGrups, numCentres, helisPerCentre, seed);

        System.out.println( "printant Area de Rescat:" );

        Centros centres = area.getCentres();
        numCentres = area.getNumCentres();
        System.out.println( numCentres );
        Grupos grups = area.getGrups();
        numGrups = area.getNumGrups();

        System.out.println( "Centres:" );
        AreaRescat.printaCentres();

        System.out.println( "\nGrups:" );
        AreaRescat.printaGrups();

        area.solucioInicial2();
        System.out.println( "\nRecorreguts:" );
        area.printaRescat();
    }
}
