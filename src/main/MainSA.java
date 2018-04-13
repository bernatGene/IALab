package main;

import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.informed.SimulatedAnnealingSearch;

import java.util.List;

public class MainSA {

    public static void main(String[] args) throws Exception {
        interficie();
    }

    private static void interficie() throws Exception {
        int numCentres =  5;
        int numGrups = 100;
        int seed = 1234;
        int helisPerCentre = 1;
        RescatHeuristicFunction.setHeuristic2(false);
        AreaRescat area = new AreaRescat( numGrups, numCentres, helisPerCentre, seed );
        area.solucioInicial3();
        System.out.println("------------------------------------------------");

        long startTime;
        long stopTime;
        long accumulated = 0;

        // Primera prueba
        for (int i=0; i < 20; ++i ) {
            startTime = System.currentTimeMillis();
            AreaRescatSimulatedAnnealing(area, 100000, 1000, 10, 0.1);
            stopTime = System.currentTimeMillis();
            accumulated = accumulated + (stopTime-startTime);
        }

        System.out.println(accumulated/20);

        System.out.println("------------------------------------------------");
        accumulated = 0;
        for (int i=0; i < 20; ++i ) {
            startTime = System.currentTimeMillis();
            AreaRescatSimulatedAnnealing(area, 100000, 1000, 10, 0.01);
            stopTime = System.currentTimeMillis();
            accumulated = accumulated + (stopTime-startTime);
        }

        System.out.println(accumulated/20);
        System.out.println("------------------------------------------------");
        accumulated = 0;
        for (int i=0; i < 20; ++i ) {
            startTime = System.currentTimeMillis();
            AreaRescatSimulatedAnnealing(area, 100000, 1000, 10, 0.001);
            stopTime = System.currentTimeMillis();
            accumulated = accumulated + (stopTime-startTime);
        }

        System.out.println(accumulated/20);
        System.out.println("------------------------------------------------");
        accumulated = 0;
        for (int i=0; i < 20; ++i ) {
            startTime = System.currentTimeMillis();
            AreaRescatSimulatedAnnealing(area, 100000, 1000, 10, 0.0001);
            stopTime = System.currentTimeMillis();
            accumulated = accumulated + (stopTime-startTime);
        }
        System.out.println(accumulated/20);
        System.out.println("------------------------------------------------");
        System.out.println("END");

    // segunda prueba

        for (int i=0; i < 20; ++i ) {
            startTime = System.currentTimeMillis();
            AreaRescatSimulatedAnnealing(area, 100000, 1000, 5, 0.1);
            stopTime = System.currentTimeMillis();
            accumulated = accumulated + (stopTime-startTime);
        }

        System.out.println(accumulated/20);

        System.out.println("------------------------------------------------");
        accumulated = 0;
        for (int i=0; i < 20; ++i ) {
            startTime = System.currentTimeMillis();
            AreaRescatSimulatedAnnealing(area, 100000, 1000, 5, 0.01);
            stopTime = System.currentTimeMillis();
            accumulated = accumulated + (stopTime-startTime);
        }

        System.out.println(accumulated/20);
        System.out.println("------------------------------------------------");
        accumulated = 0;
        for (int i=0; i < 20; ++i ) {
            startTime = System.currentTimeMillis();
            AreaRescatSimulatedAnnealing(area, 100000, 1000, 5, 0.001);
            stopTime = System.currentTimeMillis();
            accumulated = accumulated + (stopTime-startTime);
        }

        System.out.println(accumulated/20);
        System.out.println("------------------------------------------------");
        accumulated = 0;
        for (int i=0; i < 20; ++i ) {
            startTime = System.currentTimeMillis();
            AreaRescatSimulatedAnnealing(area, 100000, 1000, 5, 0.0001);
            stopTime = System.currentTimeMillis();
            accumulated = accumulated + (stopTime-startTime);
        }
        System.out.println(accumulated/20);
        System.out.println("------------------------------------------------");
        System.out.println("END");

        // tercer prueba


        for (int i=0; i < 20; ++i ) {
            startTime = System.currentTimeMillis();
            AreaRescatSimulatedAnnealing(area, 100000, 1000, 5, 0.1);
            stopTime = System.currentTimeMillis();
            accumulated = accumulated + (stopTime-startTime);
        }

        System.out.println(accumulated/20);

        System.out.println("------------------------------------------------");
        accumulated = 0;
        for (int i=0; i < 20; ++i ) {
            startTime = System.currentTimeMillis();
            AreaRescatSimulatedAnnealing(area, 100000, 1000, 5, 0.01);
            stopTime = System.currentTimeMillis();
            accumulated = accumulated + (stopTime-startTime);
        }

        System.out.println(accumulated/20);
        System.out.println("------------------------------------------------");
        accumulated = 0;
        for (int i=0; i < 20; ++i ) {
            startTime = System.currentTimeMillis();
            AreaRescatSimulatedAnnealing(area, 100000, 1000, 5, 0.001);
            stopTime = System.currentTimeMillis();
            accumulated = accumulated + (stopTime-startTime);
        }

        System.out.println(accumulated/20);
        System.out.println("------------------------------------------------");
        accumulated = 0;
        for (int i=0; i < 20; ++i ) {
            startTime = System.currentTimeMillis();
            AreaRescatSimulatedAnnealing(area, 100000, 1000, 5, 0.0001);
            stopTime = System.currentTimeMillis();
            accumulated = accumulated + (stopTime-startTime);
        }
        System.out.println(accumulated/20);
        System.out.println("------------------------------------------------");
        System.out.println("END");


        for (int i=0; i < 20; ++i ) {
            startTime = System.currentTimeMillis();
            AreaRescatSimulatedAnnealing(area, 10000, 100, 5, 0.1);
            stopTime = System.currentTimeMillis();
            accumulated = accumulated + (stopTime-startTime);
        }

        System.out.println(accumulated/20);

        System.out.println("------------------------------------------------");
        accumulated = 0;
        for (int i=0; i < 20; ++i ) {
            startTime = System.currentTimeMillis();
            AreaRescatSimulatedAnnealing(area, 10000, 100, 5, 0.01);
            stopTime = System.currentTimeMillis();
            accumulated = accumulated + (stopTime-startTime);
        }

        System.out.println(accumulated/20);
        System.out.println("------------------------------------------------");
        accumulated = 0;
        for (int i=0; i < 20; ++i ) {
            startTime = System.currentTimeMillis();
            AreaRescatSimulatedAnnealing(area, 10000, 100, 5, 0.001);
            stopTime = System.currentTimeMillis();
            accumulated = accumulated + (stopTime-startTime);
        }

        System.out.println(accumulated/20);
        System.out.println("------------------------------------------------");
        accumulated = 0;
        for (int i=0; i < 20; ++i ) {
            startTime = System.currentTimeMillis();
            AreaRescatSimulatedAnnealing(area, 10000, 100, 5, 0.0001);
            stopTime = System.currentTimeMillis();
            accumulated = accumulated + (stopTime-startTime);
        }
        System.out.println(accumulated/20);
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

}
