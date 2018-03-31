package main;


import IA.Desastres.Centro;
import IA.Desastres.Centros;
import IA.Desastres.Grupos;

import java.util.ArrayList;

public class AreaRescat {
    private static int numGrups = 100;
    private static int numCentres = 5;
    private static int helisPerCentre = 1;
    private static int seed = 2;
    private static Grupos grups;
    private static Centros centres;

    private ArrayList<Helicopter> helicopters;

    /* Constructor */

    public AreaRescat() {
        Grupos grups = new Grupos( numGrups, seed );
        Centros centres = new Centros( numCentres, helisPerCentre, seed );
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


    public int[] ordenaTrajecte(int [] antic, Centro centre) {
        int [] nou = new int[3];

        
        return nou;

    }



}
