package main;

import aima.search.framework.SuccessorFunction;

import java.util.ArrayList;
import java.util.List;

public class RescatSuccesorFunction implements SuccessorFunction {

    public List getSuccessors(Object state) {
        ArrayList retval = new ArrayList();
        AreaRescat areaRescat = (AreaRescat) state;


        return retval;
    }



    /*
    FALTA IMPLEMENTAR:
    idea: Donats dos helicopters i dos indexs de trajecte corresponents a cada un,
    retorna l'estat on els dos helicopters s'han intercanviat els trajectes.
     */
    private AreaRescat operadorSwapTrajectes(AreaRescat area, int idHeli1, int idHeli2, int indexTraj1, int indexTraj2) {
        return  area;
    }


    /*
    FALTA IMPLEMENTAR:
    idea: Donat un helicopter i dos indexs de trajectes seus i els indexs dels grups de cada trajecte,
    retorna l'estat on l'helicoper fa el trajecte 1 pero recollint el grup del trajecteG2 i viceversa
     */
    private AreaRescat operadorSwapGrups(AreaRescat area, int idHeli, int indexTraj1, int indexTraj2, int indexG1, int indexG2) {
        return area;
    }

    /*
    FALTA IMPLEMENTAR:
    idea: Donats dos helicopters i un index de trajecte del primer, retorna l'estat on el primer helicopter
    no el trajecte el fa el segon helicopter enlloc del primer.
     */
    private AreaRescat operadorMoureTrajecte(AreaRescat area, int idHeli1, int idHeli2, int indexTraj) {
        return area;
    }

}
