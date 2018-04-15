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
        int helisPerCentre = 1;
        AreaRescat area;
        RescatHeuristicFunction.setHeuristic2(false);
        System.out.println("------------------------------------------------");
        System.out.println("-SIMULATED ANNEALING-");
        System.out.println("------------------------------------------------");
        numCentres = 5;
        numGrups = 100;

        int seed;

        /*seed = 1234;
        RescatHeuristicFunction.setHeuristic2(false);
        area = new AreaRescat(numGrups, numCentres, helisPerCentre, seed);
        area.solucioInicial3();
        AreaRescatSimulatedAnnealing(area, 10000, 100, 5, 0.001);
        System.out.println("------------------------------------------------");
        RescatHeuristicFunction.setHeuristic2(true);
        area = new AreaRescat(numGrups, numCentres, helisPerCentre, seed);
        area.solucioInicial3();
        AreaRescatSimulatedAnnealing(area, 10000, 100, 5, 0.001);
        System.out.println("------------------------------------------------");
        System.out.println("------------------------------------------------");
        seed = 1111;
        RescatHeuristicFunction.setHeuristic2(false);
        area = new AreaRescat(numGrups, numCentres, helisPerCentre, seed);
        area.solucioInicial3();
        AreaRescatSimulatedAnnealing(area, 10000, 100, 5, 0.001);
        System.out.println("------------------------------------------------");
        RescatHeuristicFunction.setHeuristic2(true);
        area = new AreaRescat(numGrups, numCentres, helisPerCentre, seed);
        area.solucioInicial3();
        AreaRescatSimulatedAnnealing(area, 10000, 100, 5, 0.001);
        System.out.println("------------------------------------------------");
        System.out.println("------------------------------------------------");
        seed = 2222;
        RescatHeuristicFunction.setHeuristic2(false);
        area = new AreaRescat(numGrups, numCentres, helisPerCentre, seed);
        area.solucioInicial3();
        AreaRescatSimulatedAnnealing(area, 10000, 100, 5, 0.001);
        System.out.println("------------------------------------------------");
        RescatHeuristicFunction.setHeuristic2(true);
        area = new AreaRescat(numGrups, numCentres, helisPerCentre, seed);
        area.solucioInicial3();
        AreaRescatSimulatedAnnealing(area, 10000, 100, 5, 0.001);
        System.out.println("------------------------------------------------");
        System.out.println("------------------------------------------------");
        seed = 3333;
        RescatHeuristicFunction.setHeuristic2(false);
        area = new AreaRescat(numGrups, numCentres, helisPerCentre, seed);
        area.solucioInicial3();
        AreaRescatSimulatedAnnealing(area, 10000, 100, 5, 0.001);
        System.out.println("------------------------------------------------");
        RescatHeuristicFunction.setHeuristic2(true);
        area = new AreaRescat(numGrups, numCentres, helisPerCentre, seed);
        area.solucioInicial3();
        AreaRescatSimulatedAnnealing(area, 10000, 100, 5, 0.001);
        System.out.println("------------------------------------------------");
        System.out.println("------------------------------------------------");
        seed = 4444;
        RescatHeuristicFunction.setHeuristic2(false);
        area = new AreaRescat(numGrups, numCentres, helisPerCentre, seed);
        area.solucioInicial3();
        AreaRescatSimulatedAnnealing(area, 10000, 100, 5, 0.001);
        System.out.println("------------------------------------------------");
        RescatHeuristicFunction.setHeuristic2(true);
        area = new AreaRescat(numGrups, numCentres, helisPerCentre, seed);
        area.solucioInicial3();
        AreaRescatSimulatedAnnealing(area, 10000, 100, 5, 0.001);
        System.out.println("------------------------------------------------");
        System.out.println("------------------------------------------------");
        */

        seed = 1234;
        RescatHeuristicFunction.setHeuristic2(false);
        area = new AreaRescat(numGrups, numCentres, helisPerCentre, seed);
        area.solucioInicial3();
        RescatHeuristicFunction.setPonderation(1);
        //AreaRescatSimulatedAnnealing(area, 10000, 100, 5, 0.001);
        //System.out.println("-----------------------------------------------");
        AreaRescatHillClimbing(area);
        seed = 1234;
        RescatHeuristicFunction.setHeuristic2(true);
        area = new AreaRescat(numGrups, numCentres, helisPerCentre, seed);
        area.solucioInicial3();
        RescatHeuristicFunction.setPonderation(1);
        AreaRescatHillClimbing(area);
        //System.out.println("------------------------------------------------");
        for (int k=1; k < 100; ++k) {
            RescatHeuristicFunction.setHeuristic2(true);
            area = new AreaRescat(numGrups, numCentres, helisPerCentre, seed);
            area.solucioInicial3();
            RescatHeuristicFunction.setPonderation(k*2);
            AreaRescatHillClimbing(area);
            //System.out.println("------------------------------------------------");
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
            String s = ((AreaRescat) actions.get(i)).printaRescatString();
            System.out.println(s);
        }
    }

    private static void AreaRescatHillClimbing(AreaRescat area) throws Exception {
        Problem problem = new Problem( area, new RescatSuccessorFunction(), new RescatGoalTest(),
                new RescatHeuristicFunction() );
        Search search = new HillClimbingSearch();
        SearchAgent agent = new SearchAgent( problem, search);
        printActions(agent.getActions());
    }

    private static void printActions(List actions) {
        System.out.println((String) actions.get(actions.size()-1));
    }
}
