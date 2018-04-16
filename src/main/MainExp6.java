package main;

import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.informed.HillClimbingSearch;

public class MainExp6 {

    public static void main(String[] args) throws Exception {
        interficie();
    }

    private static void interficie() throws Exception {
        int numCentres;
        int numGrups;
        int seed = 1234;
        int helisPerCentre;
        AreaRescat area;
        RescatHeuristicFunction.setHeuristic2(false);

        long startTime;
        long stopTime;


        System.out.println("------------------------------------------------");
        System.out.println("-HILL CLIMBING EXPERIMENT 6-");
        System.out.println("------------------------------------------------");

        numGrups = 100;

        for (int k = 1; k <= 20; ++k) {

            numCentres = 5*k;
            helisPerCentre = 1;

            System.out.println("------------------------------------------------");
            System.out.println("#Centres #Grups #Helis/Centre");
            System.out.println(numCentres + " " + numGrups + " " + helisPerCentre);

            area = new AreaRescat(numGrups, numCentres, helisPerCentre, seed);
            area.solucioInicial3();

            startTime = System.currentTimeMillis();
            AreaRescatHillClimbing(area);
            stopTime = System.currentTimeMillis();
            System.out.println("Temp: " + (stopTime - startTime));

            numCentres = numCentres/k;
            helisPerCentre = k;

            System.out.println("#Centres #Grups #Helis/Centre");
            System.out.println(numCentres + " " + numGrups + " " + helisPerCentre);

            area = new AreaRescat(numGrups, numCentres, helisPerCentre, seed);
            area.solucioInicial3();

            startTime = System.currentTimeMillis();
           AreaRescatHillClimbing(area);
            stopTime = System.currentTimeMillis();
            System.out.println("Temp: " + (stopTime - startTime));

        }

        System.out.println("------------------------------------------------");
        System.out.println("END EXP 6");


    }

    private static void AreaRescatHillClimbing (AreaRescat area) throws Exception {
        Problem problem = new Problem(area, new sucexp4(), new RescatGoalTest(),
                new RescatHeuristicFunction());
        Search search = new HillClimbingSearch();
        SearchAgent agent = new SearchAgent(problem, search);
        //printActions(agent.getActions());
    }

}