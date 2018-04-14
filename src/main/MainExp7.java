package main;

import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.informed.HillClimbingSearch;
import aima.search.informed.SimulatedAnnealingSearch;

import java.util.List;

public class MainExp7 {

    public static void main(String[] args) throws Exception {
        interficie();
    }

    private static void interficie() throws Exception {
        int numCentres;
        int numGrups;
        int seed = 1234;
        int helisPerCentre = 1;
        AreaRescat area;
        RescatHeuristicFunction.setHeuristic2(false);

        long startTime;
        long stopTime;
        System.out.println("------------------------------------------------");
        System.out.println("-SIMULATED ANNEALING-");
        System.out.println("------------------------------------------------");





        
        long accumulator = 0;
        for (int k = 1; k <= 25; ++k) {

            numCentres = k * 5;
            numGrups = k * 100;

            for (int j = 0; j < 3; j++) {
                area = new AreaRescat(numGrups, numCentres, helisPerCentre, seed);
                area.solucioInicial3();

                startTime = System.currentTimeMillis();
                AreaRescatSimulatedAnnealing(area, 10000, 100, 5, 0.001);
                stopTime = System.currentTimeMillis();

                accumulator = accumulator + stopTime - startTime;

            }
            System.out.print(accumulator/30 + ",");
            accumulator = 0;
        }
        System.out.println("------------------------------------------------");
        System.out.println("END");
    }

    private static void AreaRescatSimulatedAnnealing(AreaRescat area, int nIter, int IpS, int k, double l) throws Exception {
        Problem problem = new Problem(area, new RescatSuccessorFunctionSA(), new RescatGoalTest(),
                new RescatHeuristicFunction());
        Search search = new SimulatedAnnealingSearch(nIter, IpS, k, l);
        SearchAgent agent = new SearchAgent(problem, search);
        printActionsSA(agent.getActions());

    }

    private static void printActionsSA(List actions) {
        for (int i = 0; i < actions.size(); i++) {
            String s = ((AreaRescat) actions.get(i)).printaTempString();
            System.out.println(s);
        }
    }

    private static void AreaRescatHillClimbing(AreaRescat area) throws Exception {
        Problem problem = new Problem( area, new sucexp4(), new RescatGoalTest(),
                new RescatHeuristicFunction() );
        Search search = new HillClimbingSearch();
        SearchAgent agent = new SearchAgent( problem, search);
        //printActions(agent.getActions());
    }

    private static void printActions(List actions) {
        for (int i = 0; i < actions.size(); i++) {
            System.out.println((String) actions.get(i));
        }
    }
}
