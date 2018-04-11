package main;

import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.informed.SimulatedAnnealingSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class MainSA {

    public static void main(String[] args) throws Exception {
        interficie();
    }

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in ));

    private static void interficie() throws Exception {
        int numCentres =  5;
        int numGrups = 100;
        int seed = 1234;
        int helisPerCentre = 1;
        RescatHeuristicFunction.setHeuristic2(false);
        AreaRescat area = new AreaRescat( numGrups, numCentres, helisPerCentre, seed );
        area.solucioInicial2();
        System.out.println("------------------------------------------------");


        AreaRescatSimulatedAnnealing(area, 10000, 10, 5, 0.001);
        AreaRescatSimulatedAnnealing(area, 10000, 100, 5, 0.001);
        AreaRescatSimulatedAnnealing(area, 10000, 1000, 5, 0.001);

        AreaRescatSimulatedAnnealing(area, 100000, 10, 5, 0.001);
        AreaRescatSimulatedAnnealing(area, 100000, 100, 5, 0.001);
        AreaRescatSimulatedAnnealing(area, 100000, 1000, 5, 0.001);
        AreaRescatSimulatedAnnealing(area, 100000, 10000, 5, 0.001);

        AreaRescatSimulatedAnnealing(area, 10000, 10, 50, 0.001);
        AreaRescatSimulatedAnnealing(area, 10000, 100, 50, 0.001);
        AreaRescatSimulatedAnnealing(area, 10000, 1000, 50, 0.001);

        AreaRescatSimulatedAnnealing(area, 100000, 10, 50, 0.001);
        AreaRescatSimulatedAnnealing(area, 100000, 100, 50, 0.001);
        AreaRescatSimulatedAnnealing(area, 100000, 1000, 50, 0.001);
        AreaRescatSimulatedAnnealing(area, 100000, 10000, 50, 0.001);

        AreaRescatSimulatedAnnealing(area, 10000, 10, 5, 0.01);
        AreaRescatSimulatedAnnealing(area, 10000, 100, 5, 0.01);
        AreaRescatSimulatedAnnealing(area, 10000, 1000, 5, 0.01);

        AreaRescatSimulatedAnnealing(area, 100000, 10, 5, 0.01);
        AreaRescatSimulatedAnnealing(area, 100000, 100, 5, 0.01);
        AreaRescatSimulatedAnnealing(area, 100000, 1000, 5, 0.01);
        AreaRescatSimulatedAnnealing(area, 100000, 10000, 5, 0.01);


        AreaRescatSimulatedAnnealing(area, 10000, 10, 5, 0.1);
        AreaRescatSimulatedAnnealing(area, 10000, 100, 5, 0.1);
        AreaRescatSimulatedAnnealing(area, 10000, 1000, 5, 0.1);

        AreaRescatSimulatedAnnealing(area, 100000, 10, 5, 0.1);
        AreaRescatSimulatedAnnealing(area, 100000, 100, 5, 0.1);
        AreaRescatSimulatedAnnealing(area, 100000, 1000, 5, 0.1);
        AreaRescatSimulatedAnnealing(area, 100000, 10000, 5, 0.1);

        System.out.println("------------------------------------------------");
        System.out.println("END");

    }

    private static void AreaRescatSimulatedAnnealing(AreaRescat area, int nIter, int IpS, int k, double l) throws Exception {
        Problem problem = new Problem(area, new RescatSuccessorFunctionSA(), new RescatGoalTest(),
                new RescatHeuristicFunction());
        long startTime = System.currentTimeMillis();
        Search search = new SimulatedAnnealingSearch(nIter, IpS, k, l);
        SearchAgent agent = new SearchAgent(problem, search);
        long stopTime = System.currentTimeMillis();
        System.out.print(nIter+" & "+IpS+" & "+k+" & "+l+" & ");
        printActionsSA(agent.getActions());
        System.out.println(" & "+(stopTime-startTime) + "\\" + "\\");

    }

    private static void printActionsSA(List actions) {
        for (int i = 0; i < actions.size(); i++) {
            String s = ((AreaRescat) actions.get(i)).printaTempString();
            System.out.print(s);
        }
    }

}
