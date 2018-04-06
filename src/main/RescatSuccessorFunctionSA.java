package main;

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RescatSuccessorFunctionSA implements SuccessorFunction {

    public List getSuccessors(Object state) {
        ArrayList<Successor> retval = new ArrayList<>();
        AreaRescat areaRescat = (AreaRescat) state;
        ArrayList<Helicopter> helicopters = areaRescat.getHelicopters();
        Random random = new Random();
        int op = random.nextInt(3);
        //decidim aleatoriament quin dels 3 operadors utilitzar
        if(op ==0) {
            //Swap Trajectes: determinem aleatoriament els parametres. Han de ser possibles
            //si no ho son saltarem a swap grup
            retval.add(successorAleatoriSwpT(areaRescat, random));
        }
        if (op == 1) {
            //Moure Trajecte: determinem aleatoriament els parametres
            retval.add(successorAleatoriMouT(areaRescat,random));
        }
        else {
            //Swap Grups: determinem aleatorimanet els parametres
            retval.add(successorAleatoriSwpG(areaRescat,random));
        }
        return retval;
    }

    private int idHelinoBuit(Random rand, int exc, ArrayList<Helicopter> helicopters) {
        int numHelis;
        numHelis = helicopters.size();
        ArrayList<Integer> capTrajecte = new ArrayList<>();
        for (int i=0; i<numHelis; ++i) {
            if (helicopters.get(i).size() == 0) {
                capTrajecte.add(i);
            }
        }
        if (exc != -1) capTrajecte.add(exc);
        if (numHelis-capTrajecte.size() < 1) {
            return -1;
        }
        return getRandomWithExclusion(rand, 0, numHelis, capTrajecte);
    }

    private Successor successorAleatoriSwpT(AreaRescat area, Random random) {

        ArrayList<Helicopter> helicopters = area.getHelicopters();
        int  idHeli1, idHeli2, indexTraj1, indexTraj2;
        idHeli1 = idHelinoBuit(random, -1, helicopters);
        idHeli2 = idHelinoBuit(random, idHeli1, helicopters);
        if (idHeli2 == -1 ) {
            return successorAleatoriSwpG(area,random);
        }
        indexTraj1 = random.nextInt(helicopters.get(idHeli1).size());
        indexTraj2 = random.nextInt(helicopters.get(idHeli2).size());
        String s = ("Canvio t"+indexTraj1+" d'Heli"+idHeli1+" amb t"+indexTraj2+" d'Heli"+idHeli2+"\n");
        AreaRescat newArea = Operators.operadorSwapTrajectes(area, idHeli1, idHeli2, indexTraj1, indexTraj2);
        return new Successor(s, newArea);
    }

    private Successor successorAleatoriMouT(AreaRescat area, Random random) {

        ArrayList<Helicopter> helicopters = area.getHelicopters();
        int  idHeli1, idHeli2, indexTraj1;
        idHeli1 = idHelinoBuit(random, -1, helicopters);
        if (idHeli1 == -1 ) {
            return successorAleatoriSwpG(area,random);
        }
        ArrayList<Integer> exc = new ArrayList<>(); exc.add(idHeli1);
        idHeli2 = getRandomWithExclusion(random,0,helicopters.size(),exc);
        indexTraj1 = random.nextInt(helicopters.get(idHeli1).size());
        String s = ("Moc t"+indexTraj1+" d'Heli"+idHeli1+" a Heli"+idHeli2+"\n");
        AreaRescat newArea = Operators.operadorMoureTrajecte(area, idHeli1, idHeli2, indexTraj1);
        return new Successor(s, newArea);
    }

    private Successor successorAleatoriSwpG(AreaRescat area, Random random) {
        ArrayList<Helicopter> helicopters = area.getHelicopters();
        int  idHeli1, indexTraj1, indexTraj2, indexG1, indexG2;
        idHeli1 = idHelinoBuit(random, -1, helicopters);
        String p = "Esteril";
        if (idHeli1 == -1 || helicopters.get(idHeli1).size()<2) {
            return new Successor(p, area);
        }
        int numTraj = helicopters.get(idHeli1).size();
        indexTraj1 = random.nextInt(numTraj);
        ArrayList<Integer> exc = new ArrayList<>(); exc.add(indexTraj1);
        indexTraj2 = getRandomWithExclusion(random,0, numTraj, exc);
        indexG1 = random.nextInt(3);
        indexG2 = random.nextInt(3);
        String s = "En l'Heli" + idHeli1 + " canvio G" + indexG1 + " de T" + indexTraj1 + " amb G" + indexG2 + " de T" + indexTraj2 + " ";
        AreaRescat newArea = Operators.operadorSwapGrups(area,idHeli1,idHeli1,indexTraj1,indexTraj2,indexG1,indexG2);
        if (newArea == null) return new Successor(p, area);
        return new Successor(s, newArea);
    }

    public int getRandomWithExclusion(Random rnd, int start, int end, ArrayList<Integer> exclude) {
        end--;
        int random = start + rnd.nextInt(end - start + 1 - exclude.size());
        for (int ex : exclude) {
            if (random < ex) {
                break;
            }
            random++;
        }
        return random;
    }
}

