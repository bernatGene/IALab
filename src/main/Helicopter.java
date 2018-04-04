package main;

import IA.Desastres.Centro;
import IA.Desastres.Centros;
import IA.Desastres.Grupo;
import IA.Desastres.Grupos;

import java.util.ArrayList;

import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

public class Helicopter {
    private ArrayList<int []> trajectes;


    public Helicopter() {
        trajectes = new ArrayList<>();
    }

    public int[] getTrajecteIndex(int index) {
        return trajectes.get( index );
    }

    public void deleteTrajecteIndex(int index) {
        trajectes.remove( index );
    }

    public void addTrajecte(int [] trajecte, int idCentre) {
        int [] nou = ordenaTrajecte( trajecte, idCentre);
        trajectes.add(nou);
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

    /*
   Donat una tripleta de grups (trajecte) i un centre, retorna la tripleta en lordre
   tal que la distancia per enllacar es la minima
    */
    public int[] ordenaTrajecte(int [] antic, int idCentre) {
        int [] nou1 = {antic[1],antic[2], antic[0]};
        int [] nou2 = {antic[2],antic[0], antic[1]};
        double dist0, dist1, dist2;
        dist0 = distanciaRecorregut(antic, idCentre);
        dist1 = distanciaRecorregut(nou1, idCentre);
        dist2 = distanciaRecorregut(nou2, idCentre);
        if (dist1 > dist0 && dist1 > dist2) return nou1;
        if (dist2 > dist0) return nou2;
        else return antic;
    }


    /*
    Donat una tripleta de grups i un centre, determina la distancia del recorregut
     */
    public double distanciaRecorregut(int [] recorregut, int idCentre) {
        Grupos grups = AreaRescat.getGrups();
        Centros centres = AreaRescat.getCentres();
        Centro centre = centres.get( idCentre );
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
            return -1;
        }
        if (recorregut[1] != -1)  {
            grup1 = grups.get( recorregut[1] );
            g1x = grup1.getCoordX();
            g1y = grup1.getCoordY();
        }
        else {
            return -1;
        }
        if (recorregut[2] != -1)  {
            grup2 = grups.get( recorregut[2] );
            g2x = grup2.getCoordX();
            g2y = grup2.getCoordY();
        }
        else {
            return -1;
        }

        double dist = 0;
        dist += sqrt( pow(cx-g0x, 2)+pow( cy-g0y, 2 ) );
        dist += sqrt( pow(g0x-g1x, 2)+pow( g0y-g1y, 2 ) );
        dist += sqrt( pow(g1x-g2x, 2)+pow( g1y-g2y, 2 ) );
        return dist;
    }
}
