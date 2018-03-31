package main;

import IA.Desastres.Centro;
import IA.Desastres.Centros;
import IA.Desastres.Grupos;

public class MainProves {

    public static void main(String[] args) {

        System.out.println( "Generant Area de Rescat" );
        AreaRescat area = new AreaRescat();
        area.inicializa();

        System.out.println( "printant Area de Rescat:" );

        Centros centres = area.getCentres();
        int numCentres = area.getNumCentres();
        System.out.println( numCentres );
        Grupos grups = area.getGrups();
        int numGrups = area.getNumGrups();

        System.out.println( "Centres:" );
        AreaRescat.printaCentres();

        System.out.println( "\nGrups:" );
        AreaRescat.printaGrups();

        area.solucioInicial1();
        System.out.println( "\nRecorreguts:" );
        area.printaRescat();
    }
}
