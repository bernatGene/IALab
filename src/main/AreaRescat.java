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
            hel1.addTrajecte(trajecte);
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

    }

    /*
    Igual que la solucio incial2 pero cada trajecte s'ordena per tal de minimitzar el temps.
     */
    public void solucioInicial3() {

    }


    /*
    Donat una tripleta de grups (trajecte) i un centre, retorna la tripleta en lordre
    tal que la distancia per enllacar es la minima
     */
    public int[] ordenaTrajecte(int [] antic, Centro centre) {
        int [] nou1 = {antic[1],antic[2], antic[0]};
        int [] nou2 = {antic[2],antic[0], antic[1]};
        double dist0, dist1, dist2;
        dist0 = distanciaRecorregut(antic, centre);
        dist1 = distanciaRecorregut(nou1, centre);
        dist2 = distanciaRecorregut(nou2, centre);
        if (dist0 > dist1 && dist0 > dist2) return antic;
        else if (dist1 > dist2) return nou1;
        else return nou2;
    }


    /*
    Donat una tripleta de grups i un centre, determina la distancia del recorregut
     */
    public double distanciaRecorregut(int [] recorregut, Centro centre) {
        Grupo grup0, grup1, grup2;
        int cx, cy, g0x, g0y, g1x, g1y, g2x, g2y;
        cx = centre.getCoordX();
        cy = centre.getCoordY();
        if (recorregut[0] != -1)  {
            grup0 = grups.get( recorregut[0] );
            g0x = grup0.getCoordX();
            g0y = grup0.getCoordY();
        }
        else {
            g0x = cx;
            g0y = cy;
        }
        if (recorregut[1] != -1)  {
            grup1 = grups.get( recorregut[1] );
            g1x = grup1.getCoordX();
            g1y = grup1.getCoordY();
        }
        else {
            g1x = g0x;
            g1y = g0y;
        }
        if (recorregut[2] != -1)  {
            grup2 = grups.get( recorregut[2] );
            g2x = grup2.getCoordX();
            g2y = grup2.getCoordY();
        }
        else {
            g2x = g1x;
            g2y = g1y;
        }

        double dist = 0;
        dist += sqrt( pow(cx-g0x, 2)+pow( cy-g0y, 2 ) );
        dist += sqrt( pow(g0x-g1x, 2)+pow( g0y-g1y, 2 ) );
        dist += sqrt( pow(g1x-g2x, 2)+pow( g1y-g2y, 2 ) );
        return dist;
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
            int x, y;
            x = grup.getCoordX();
            y = grup.getCoordY();
            System.out.println("Grup" +i+ ": x="+x+", y="+y );
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
