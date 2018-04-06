package main;

import aima.search.framework.Successor;

import java.util.ArrayList;

public class Operators {

    /*
   Descripcio: Genera tots els estats que es poden aconseguir a partir del donat (area)
   canviant dos trajectes entre dos helicopters. El bulce i recorre lhelicopter 1, el bucle j lhelicopter2,
   el bucle k els trajectes de lhelicopter 1 i el bucle l els del 2.
    */
    public static ArrayList<Successor> estatsSwapTrajectes(AreaRescat area) {
        ArrayList estats = new ArrayList(  );
        ArrayList<Helicopter> helicopters = area.getHelicopters();

        for (int i=0; i < helicopters.size(); ++i) {
            for (int j=i+1; j < helicopters.size(); ++j){
                for (int k=0; k < helicopters.get(i).size(); ++k) {
                    for (int l=0; l < helicopters.get(j).size(); ++l) {
                        AreaRescat newArea = operadorSwapTrajectes(area, i, j, k, l);
                        String s = ("Canvio t"+k+" d'Heli"+i+" amb t"+l+" d'Heli"+j+"\n");
                        if (newArea != null) {
                            s += newArea.printaRescatString();
                            AreaRescat.incSwpT();
                            estats.add(new Successor(s,newArea));
                        }
                    }
                }
            }
        }
        return estats;
    }
    /*
    Donats dos helicopters i dos indexs de trajecte corresponents a cada un,
    retorna l'estat on els dos helicopters s'han intercanviat els trajectes.
     */
    public static AreaRescat operadorSwapTrajectes(AreaRescat area, int idHeli1, int idHeli2, int indexTraj1, int indexTraj2) {
        AreaRescat newArea = new AreaRescat(area);
        if (newArea.swapTrajectes(idHeli1, idHeli2, indexTraj1, indexTraj2)) {
            return newArea;
        }
        else return null;
    }

    public static ArrayList<Successor> estatsSwapGrups(AreaRescat area) {
        ArrayList estats = new ArrayList(  );
        ArrayList<Helicopter> helicopters = area.getHelicopters();
        for (int i = 0; i < helicopters.size(); ++i) {
            Helicopter helicopter = helicopters.get(i);
            for (int j = 0; j < helicopter.size(); ++j) {
                for (int k = j + 1; k < helicopter.size(); ++k) {
                    for (int l = 0; l < 3; ++l) {
                        for (int m = 0; m < 3; ++m) {
                            String S = "En l'Heli" + i + " canvio G" + l + " de T" + j + " amb G" + m + " de T" + k + " ";
                            AreaRescat newArea = operadorSwapGrups(area, i, i, j, k, l, m);
                            if (newArea != null) {
                                S += newArea.printaRescatString();
                                AreaRescat.incSwpG();
                                estats.add(new Successor(S, newArea));
                            }
                        }
                    }
                }
            }
        }

        return estats;
    }


    public static ArrayList<Successor> estatsSwapGrups2(AreaRescat area) {
        ArrayList estats = new ArrayList(  );
        ArrayList<Helicopter> helicopters = area.getHelicopters();
        for(int n = 0; n < helicopters.size(); ++n) {
            for (int i = 0; i < helicopters.size(); ++i) {
                Helicopter helicopter = helicopters.get(i);
                Helicopter helicopter2 = helicopters.get(n);
                for (int j = 0; j < helicopter.size(); ++j) {
                    for (int k = j + 1; k < helicopter2.size(); ++k) {
                        for (int l = 0; l < 3; ++l) {
                            for (int m = 0; m < 3; ++m) {
                                String S = "En l'Heli" + i + " canvio G" + l + " de T" + j + " amb G" + m + " de T" + k + " ";
                                AreaRescat newArea = operadorSwapGrups(area, n, i, j, k, l, m);
                                if (newArea != null) {
                                    S += newArea.printaRescatString();
                                    AreaRescat.incSwpG();
                                    estats.add(new Successor(S, newArea));
                                }
                            }
                        }
                    }
                }
            }
        }

        return estats;
    }
    /*
    Donat un helicopter i dos indexs de trajectes seus i els indexs dels grups de cada trajecte,
    retorna l'estat on l'helicoper fa el trajecte 1 pero recollint el grup del trajecteG2 i viceversa
     */
    public static AreaRescat operadorSwapGrups(AreaRescat area, int idHeli1, int idHeli2, int indexTraj1, int indexTraj2, int indexG1, int indexG2) {
        AreaRescat newArea = new AreaRescat(area);
        if (newArea.swapGrups(idHeli1, idHeli2, indexTraj1, indexTraj2, indexG1, indexG2))
            return newArea;
        else return null;
    }


    public static ArrayList<Successor> estatsMoureTrajecte(AreaRescat area) {
        ArrayList estats = new ArrayList(  );
        ArrayList<Helicopter> helicopters = area.getHelicopters();

        for (int i=0; i < helicopters.size(); ++i) {
            for (int j=i+1; j < helicopters.size(); ++j){
                for (int k=0; k < helicopters.get(i).size(); ++k) {
                    AreaRescat newArea = operadorMoureTrajecte(area, i, j, k);
                    String s = ("Moc t"+k+" d'Heli"+i+" a Heli"+j+"\n");
                    if (newArea != null) {
                        s += newArea.printaRescatString();
                        AreaRescat.incMouT();
                        estats.add(new Successor(s,newArea));
                    }
                }
            }
        }
        return estats;
    }

    /*
    Donats dos helicopters i un index de trajecte del primer, retorna l'estat on el primer helicopter
    on el trajecte el fa el segon helicopter enlloc del primer.
     */
    public static AreaRescat operadorMoureTrajecte(AreaRescat area, int idHeli1, int idHeli2, int indexTraj) {
        AreaRescat newArea = new AreaRescat(area);
        newArea.mouTrajecte(idHeli1, idHeli2, indexTraj);
        return newArea;
    }
}
