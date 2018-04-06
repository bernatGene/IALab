package main;

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

import java.util.ArrayList;
import java.util.List;

public class RescatSuccessorFunction implements SuccessorFunction {

    public List getSuccessors(Object state) {
        ArrayList retval = new ArrayList();
        AreaRescat areaRescat = (AreaRescat) state;

        retval.addAll( Operators.estatsSwapTrajectes( areaRescat ) );
        retval.addAll( Operators.estatsMoureTrajecte( areaRescat ) );
        retval.addAll( Operators.estatsSwapGrups( areaRescat ) );

        //retval.addAll( estatsSwapGrups2( areaRescat ) );
        return retval;
    }



}
