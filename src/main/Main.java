package main;

import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.informed.HillClimbingSearch;

public class Main {

    public static void main(String[] args) {
        AreaRescat area = new AreaRescat(  );

    }

    private static void AreaRescatHillClimbing(AreaRescat area) throws Exception {
        Problem problem = new Problem( area, new RescatSuccesorFunction(), new RescatGoalTest(),
                new RescatHeuristicFunction() );
        Search search = new HillClimbingSearch();
        SearchAgent agent = new SearchAgent( problem, search);
    }
}

