package main;

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RescatSuccessorFunctionSA implements SuccessorFunction {

    public List getSuccessors(Object state) {
        ArrayList retval = new ArrayList();
        AreaRescat areaRescat = (AreaRescat) state;
        ArrayList<Helicopter> helicopters = areaRescat.getHelicopters();
        Random random = new Random();
        int op = random.nextInt(3);
        //decidim aleatoriament quin dels 3 operadors utilitzar
        if(op ==0) {
            //Swap Trajectes: determinem aleatoriament els parametres
            int idHeli1, idHeli2, indexTraj1, indexTraj2;
            idHeli1 = random.nextInt(helicopters.size());
            idHeli2 = getRandomWithExclusion(random, 0, helicopters.size(), idHeli1);
            indexTraj1 = random.nextInt(helicopters.get(idHeli1).size());
            indexTraj2 = random.nextInt(helicopters.get(idHeli2).size());
            retval.add(Operators.operadorSwapTrajectes(areaRescat,idHeli1,idHeli2,indexTraj1,indexTraj2));
        }
        else if (op == 1) {
            //Moure Trajecte: determinem aleatoriament els parametres
            int idHeli1, idHeli2, indexTraj;
            idHeli1 = random.nextInt(helicopters.size());
            idHeli2 = getRandomWithExclusion(random, 0, helicopters.size(), idHeli1);
            indexTraj = random.nextInt(helicopters.get(idHeli1).size());
            retval.add(Operators.operadorMoureTrajecte(areaRescat, idHeli1, idHeli2, indexTraj));
        }
        else {
            //Swap Grups: determinem aleatorimanet els parametres
            int idHeli, indexTraj1, indexTraj2, indexG1, indexG2;
            idHeli = random.nextInt(helicopters.size());
            indexTraj1 = random.nextInt(helicopters.get(idHeli).size());
            indexTraj2 = getRandomWithExclusion(random, 0, helicopters.get(idHeli).size(),indexTraj1);
            indexG1 = random.nextInt(3);
            indexG2 = random.nextInt(3);
            retval.add(Operators.operadorSwapGrups(areaRescat, idHeli,idHeli,indexTraj1,indexTraj2,indexG1,indexG2));
        }
        return retval;
    }

    public int getRandomWithExclusion(Random rnd, int start, int end, int... exclude) {
        int random = start + rnd.nextInt(end - start + 1 - exclude.length);
        for (int ex : exclude) {
            if (random < ex) {
                break;
            }
            random++;
        }
        return random;
    }
}

