package main;

import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.informed.HillClimbingSearch;
import aima.search.informed.SimulatedAnnealingSearch;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws Exception {
        interficie();
    }

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in ));
    private static void interficie() throws Exception {
        System.out.print("\nCERCA LOCAL: Desastres\n Opcions: 0=Executar per defecte, 1=Canviar parametres");
        String s = br.readLine();
        int numCentres, numGrups, seed, helisPerCentre;
        if (Objects.equals( s, "0" )) {
            numCentres = 5;
            numGrups = 100;
            seed = 1234;
            helisPerCentre = 1;
            AreaRescat area = new AreaRescat( numGrups, numCentres, helisPerCentre, seed );
            area.solucioInicial3();
            System.out.println( "Inici cronometre..." );
            long startTime = System.currentTimeMillis();
            AreaRescatHillClimbing( area );
            long stopTime = System.currentTimeMillis();
            AreaRescat.printaUsOperadors();
            System.out.println( "Temps: "+(stopTime-startTime)+" ms" );
        }
        else {
            System.out.print("Numero de centres?");
            numCentres =  Integer.valueOf (br.readLine());
            System.out.print("Numero de Grups?");
            numGrups =  Integer.valueOf (br.readLine());
            System.out.print("Llavor Aleatoria?");
            seed =  Integer.valueOf (br.readLine());
            System.out.print("Helicopters per Centre?");
            helisPerCentre =  Integer.valueOf (br.readLine());
            System.out.print("Heuristic? (1 | 2)");
            int heu =  Integer.valueOf (br.readLine());
            RescatHeuristicFunction.setHeuristic2(heu==2);
            System.out.print("Algorisme? (0=HC, 1=SA)");
            int alg =  Integer.valueOf (br.readLine());
            AreaRescat area = new AreaRescat( numGrups, numCentres, helisPerCentre, seed );
            System.out.print("Solucio Inicial (1 | 2 | 3)?");
            int sol =  Integer.valueOf (br.readLine());
            if (sol == 1)
                area.solucioInicial1();
            else if (sol == 2)
                area.solucioInicial2();
            else
                area.solucioInicial3();
            System.out.println( "Inici cronometre..." );
            long startTime = System.currentTimeMillis();
            if (alg ==0) AreaRescatHillClimbing( area );
            else {
                AreaRescatSimulatedAnnealing(area);
            }
            long stopTime = System.currentTimeMillis();
            AreaRescat.printaUsOperadors();
            System.out.println( "Temps: "+(stopTime-startTime)+" ms" );
        }



    }

    private static void AreaRescatSimulatedAnnealing(AreaRescat area) throws Exception {
        Problem problem = new Problem(area, new RescatSuccessorFunctionSA(), new RescatGoalTest(),
                new RescatHeuristicFunction());
        int nIter, IpS, k;
        double l;
        System.out.print("SA: Nombre maxim d'iteracions?");
        nIter = Integer.valueOf(br.readLine());
        System.out.print("SA: Iteracions per pas de Tº?");
        IpS = Integer.valueOf(br.readLine());
        System.out.print("SA: Parametre k?");
        k = Integer.valueOf(br.readLine());
        System.out.print("SA: Parametre lambda?");
        l = Double.valueOf(br.readLine());


        Search search = new SimulatedAnnealingSearch(nIter, IpS, k, l);
        //((SimulatedAnnealingSearch) search).traceOn();
        SearchAgent agent = new SearchAgent(problem, search);
        printActionsSA(agent.getActions());
        printInstrumentation(agent.getInstrumentation());
    }

    private static void AreaRescatHillClimbing(AreaRescat area) throws Exception {
        Problem problem = new Problem( area, new RescatSuccessorFunction(), new RescatGoalTest(),
                new RescatHeuristicFunction() );
        Search search = new HillClimbingSearch();
        SearchAgent agent = new SearchAgent( problem, search);
        printActions(agent.getActions());
        printInstrumentation(agent.getInstrumentation());
    }

    private static void printActions(List actions) {
        for (int i = 0; i < actions.size(); i++) {
            System.out.println((String) actions.get(i));
        }
    }

    private static void printActionsSA(List actions) {
        for (int i = 0; i < actions.size(); i++) {
            String s = ((AreaRescat) actions.get(i)).printaRescatString();
            System.out.println(s);
        }
    }

    private static void printInstrumentation(Properties properties) {
        Iterator keys = properties.keySet().iterator();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            String property = properties.getProperty(key);
            System.out.println(key + " : " + property);
        }
    }
}

