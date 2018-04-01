package main;


import IA.Desastres.Centro;
import IA.Desastres.Centros;
import IA.Desastres.Grupo;
import IA.Desastres.Grupos;

import java.util.ArrayList;

import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

public class AreaRescat {
    private static int numGrups = 100;
    private static int numCentres = 5;
    private static int helisPerCentre = 1;
    private static int seed = 2;
    private static Grupos grups;
    private static Centros centres;

    private ArrayList<Helicopter> helicopters;

    public static int getHelisPerCentre() {
        return helisPerCentre;
    }

    public static int getNumCentres() {
        return numCentres;
    }

    public static int getNumGrups() {
        return numGrups;
    }

    public static int getSeed() {
        return seed;
    }

    public static Grupos getGrups() {
        return grups;
    }

    public static Centros getCentres() {
        return centres;
    }

    /* Constructor */

    public AreaRescat() {
    }

    public void inicializa() {
        numGrups = 100;
        numCentres = 5;
        helisPerCentre = 1;
        seed = 2;
        grups = new Grupos( numGrups, seed );
        centres = new Centros( numCentres, helisPerCentre, seed );
        helicopters = new ArrayList<>( numCentres*helisPerCentre );
    }

    /*
    Molt bàsica: L'helicopter del primer centre recull el primer grup, torna
    recull el segon grup i aixi successivament
     */
    public void solucioInicial1() {
        Helicopter hel1 = new Helicopter();
        for (int i = 0; i < numGrups; ++i) {
            int [] trajecte = {i,-1,-1};
            hel1.addTrajecte(trajecte, 0);
        }
        helicopters.add(hel1);
        for (int i=1; i<numCentres*helisPerCentre; ++i) {
            Helicopter hel2 = new Helicopter();
            helicopters.add(hel2);
        }
    }
    /*
    El primer helicopter recull en orde tans grups com pugui en un trajecte.
    El segon continua on ho ha deixat el primer.
    Aixi successivament. Si queden grups per recollir i no helicopters, el primer afegeix un
    trajecte recollint el grup que venia a continuacio
     */
    public void solucioInicial2() {
        int grupsRecollits = 0;
        for (int i=0; i<numCentres*helisPerCentre; ++i) {
            Helicopter hel = new Helicopter();
            helicopters.add(hel);
        }
        int indexHelic = 0;
        int indexGrup = 0;
        int places = 15;
        while (indexGrup < numGrups) {
            int trajecte[] = {-1,-1,-1};
            for (int i=0; i < 3 && indexGrup<numGrups; ++i) {
                Grupo grup = grups.get( indexGrup );
                if (places - grup.getNPersonas() >= 0) {
                    places -= grup.getNPersonas();
                    trajecte[i] = indexGrup;
                    indexGrup++;

                }
                else i = 3;
            }
            Helicopter helicopter = helicopters.get( indexHelic );
            helicopter.addTrajecte( trajecte, indexHelic );
            places = 15;
            indexHelic++;
            if (indexHelic == numCentres*helisPerCentre) indexHelic = 0;
        }
    }

    public static void printaCentres() {
        for (int i=0; i < numCentres; ++i ) {
            Centro centre = centres.get( i );
            int x, y;
            x = centre.getCoordX();
            y = centre.getCoordY();
            System.out.println("Centre" +i+ ": x="+x+", y="+y );
        }
    }

    public static void printaGrups() {
        for (int i=0; i < numGrups; ++i ) {
            Grupo grup = grups.get( i );
            int x, y, p;
            x = grup.getCoordX();
            y = grup.getCoordY();
            p = grup.getNPersonas();
            System.out.println("Grup" +i+ ": x="+x+", y="+y+" Persones:"+p);
        }
    }

    public void printaRescat() {
        for (int i=0; i < (numCentres*helisPerCentre); ++i ) {
            Helicopter heli = helicopters.get(i);
            System.out.println( "Heli"+i+":" );
            heli.printaTrajecte();
            System.out.println(  );
        }
    }

}
