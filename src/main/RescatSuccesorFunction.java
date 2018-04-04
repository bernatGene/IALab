package main;

import aima.search.framework.SuccessorFunction;

import java.util.ArrayList;
import java.util.List;

public class RescatSuccesorFunction implements SuccessorFunction {

    public List getSuccessors(Object state) {
        ArrayList retval = new ArrayList();
        AreaRescat areaRescat = (AreaRescat) state;

        retval.addAll( estatsSwapTrajectes( areaRescat ) );

        return retval;
    }


    private ArrayList<AreaRescat> estatsSwapTrajectes(AreaRescat area) {
        ArrayList estats = new ArrayList(  );
        ArrayList<Helicopter> helicopters = area.getHelicopters();

        for (int i=0; i < helicopters.size(); ++i) {
            for (int j=0; j < helicopters.size(); ++j){
                AreaRescat newArea = operadorSwapTrajectes(area, i, j, 0,0);
                estats.add(newArea);
            }
        }
        return estats;
    }



    /*
    Donats dos helicopters i dos indexs de trajecte corresponents a cada un,
    retorna l'estat on els dos helicopters s'han intercanviat els trajectes.
     */
    private AreaRescat operadorSwapTrajectes(AreaRescat area, int idHeli1, int idHeli2, int indexTraj1, int indexTraj2) {
        AreaRescat newArea = new AreaRescat(area);
        newArea.swapTrajectes(idHeli1, idHeli2, indexTraj1, indexTraj2);
        return newArea;
    }


    /*
    FALTA IMPLEMENTAR:
    idea: Donat un helicopter i dos indexs de trajectes seus i els indexs dels grups de cada trajecte,
    retorna l'estat on l'helicoper fa el trajecte 1 pero recollint el grup del trajecteG2 i viceversa
     */
    private AreaRescat operadorSwapGrups(AreaRescat area, int idHeli, int indexTraj1, int indexTraj2, int indexG1, int indexG2) {
        AreaRescat newArea = new AreaRescat(area);
        newArea.swapGrups(idHeli, indexTraj1, indexTraj2, indexG1, indexG2);
        return newArea;
    }

    /*
    Donats dos helicopters i un index de trajecte del primer, retorna l'estat on el primer helicopter
    on el trajecte el fa el segon helicopter enlloc del primer.
     */
    private AreaRescat operadorMoureTrajecte(AreaRescat area, int idHeli1, int idHeli2, int indexTraj) {
        AreaRescat newArea = new AreaRescat(area);
        newArea.mouTrajecte(idHeli1, idHeli2, indexTraj);
        return newArea;
    }

}
