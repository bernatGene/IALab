package main;

import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.informed.HillClimbingSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws Exception {
        interficie();
    }

    private static void interficie() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Area de Rescat:");
        System.out.println("Opcions: 0=Execucio per defecte | 1=Modificar parametres");
        String valor = br.readLine();
        if (valor == "0") {
            int numCentres, numGrups, seed, helisPerCentre;
            numCentres = 5;
            numGrups = 100;
            seed = 1234;
            helisPerCentre = 1;
            AreaRescat area = new AreaRescat(numGrups, numCentres, helisPerCentre, seed);
            area.solucioInicial2();
            AreaRescatHillClimbing( area );
        }
        else {

        }


    }

    private static void AreaRescatHillClimbing(AreaRescat area) throws Exception {
        Problem problem = new Problem( area, new RescatSuccesorFunction(), new RescatGoalTest(),
                new RescatHeuristicFunction() );
        Search search = new HillClimbingSearch();
        SearchAgent agent = new SearchAgent( problem, search);

        System.out.println();
        
        printActions(agent.getActions());
        printInstrumentation(agent.getInstrumentation());
    }

    private static void printActions(List actions) {
        for (int i = 0; i < actions.size(); i++) {
            String action = (String) actions.get(i);
            System.out.println(action);
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

