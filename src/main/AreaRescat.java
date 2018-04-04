package main;


import IA.Desastres.Centro;
import IA.Desastres.Centros;
import IA.Desastres.Grupo;
import IA.Desastres.Grupos;

import java.util.ArrayList;

import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

public class AreaRescat {
    private static int numGrups;
    private static int numCentres;
    private static int helisPerCentre;
    private static int seed;
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

    public ArrayList<Helicopter> getHelicopters() {
        return helicopters;
    }

    /* Constructor */


    public AreaRescat(int numGrups, int numCentres, int helisPerCentre, int seed) {
        this.numGrups = numGrups;
        this.numCentres = numCentres;
        this.helisPerCentre = helisPerCentre;
        this.seed = seed;
        grups = new Grupos( numGrups, seed );
        centres = new Centros( numCentres, helisPerCentre, seed );
        helicopters = new ArrayList<>( numCentres*helisPerCentre );
    }

    public AreaRescat(AreaRescat area) {
        numGrups = area.numGrups;
        numCentres = area.numCentres;
        helisPerCentre = area.helisPerCentre;
        seed = area.seed;
        grups = area.grups;
        centres = area.centres;
        this.helicopters = area.helicopters;
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

    public void swapTrajectes(int idHeli1, int idHeli2, int indexTraj1, int indexTraj2) {
        int[] trajecte1 = helicopters.get(idHeli1).getTrajecteIndex(indexTraj1);
        int[] trajecte2 = helicopters.get(idHeli2).getTrajecteIndex(indexTraj2);

        helicopters.get(idHeli1).deleteTrajecteIndex(indexTraj1);
        helicopters.get(idHeli1).addTrajecte(trajecte2, idHeli1); // set

        helicopters.get(idHeli2).deleteTrajecteIndex(indexTraj2);
        helicopters.get(idHeli2).addTrajecte(trajecte1, idHeli2);

    }

    public void swapGrups(int idHeli, int indexTraj1, int indexTraj2, int indexG1, int indexG2) {

    }

    public void mouTrajecte(AreaRescat area, int idHeli1, int idHeli2, int indexTraj) {
        int[] trajecte = helicopters.get(idHeli1).getTrajecteIndex(indexTraj);

        helicopters.get(idHeli1).deleteTrajecteIndex(indexTraj);
        helicopters.get(idHeli2).addTrajecte(trajecte, idHeli2);
    }

    public static void printaGrups() {
        for (int i=0; i < numGrups; ++i ) {
            Grupo grup = grups.get( i );
            int x, y, p, pr;
            x = grup.getCoordX();
            y = grup.getCoordY();
            p = grup.getNPersonas();
            pr = grup.getPrioridad();
            System.out.println("Grup" +i+ ": x="+x+", y="+y+" Persones:"+p+" Prioritat:"+pr);
        }
    }

    public void printaRescat() {
        for (int i=0; i < (numCentres*helisPerCentre); ++i ) {
            Helicopter heli = helicopters.get(i);
            double tempsHeli = RescatHeuristicFunction.tempsHelicopter( heli, this, i/helisPerCentre );
            System.out.println( "Heli"+i+", temps="+tempsHeli+" :");
            heli.printaTrajecte(i/helisPerCentre);
            System.out.println(  );
        }
    }


}
