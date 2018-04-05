package main;

import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.informed.HillClimbingSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws Exception {
        interficie();
    }

    private static void interficie() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in ));
        System.out.print("\nCERCA LOCAL: Desastres\n Opcions: 0=Executar per defecte, 1=Canviar parametres");
        String s = br.readLine();
        int numCentres, numGrups, seed, helisPerCentre;
        if (Objects.equals( s, "0" )) {
            numCentres = 5;
            numGrups = 100;
            seed = 1234;
            helisPerCentre = 1;
            AreaRescat area = new AreaRescat( numGrups, numCentres, helisPerCentre, seed );
            area.solucioInicial2();
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
            AreaRescat area = new AreaRescat( numGrups, numCentres, helisPerCentre, seed );
            System.out.print("Solucio Inicial (1 | 2)?");
            int sol =  Integer.valueOf (br.readLine());
            if (sol == 1) area.solucioInicial1();
            else area.solucioInicial2();
            System.out.println( "Inici cronometre..." );
            long startTime = System.currentTimeMillis();
            AreaRescatHillClimbing( area );
            long stopTime = System.currentTimeMillis();
            AreaRescat.printaUsOperadors();
            System.out.println( "Temps: "+(stopTime-startTime)+" ms" );
        }



    }

    private static void AreaRescatHillClimbing(AreaRescat area) throws Exception {
        Problem problem = new Problem( area, new RescatSuccesorFunction(), new RescatGoalTest(),
                new RescatHeuristicFunction() );
        Search search = new HillClimbingSearch();
        SearchAgent agent = new SearchAgent( problem, search);

        System.out.println("Processant");
        
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

