package org.example.Question11;

import java.util.Scanner;

/**
 * Name: Dylan Murphy
 * Class Group: SD2b
 */

//List of unique routes
//Pendleton - Pierre = 2        Pueblo - Pierre = 3         Pueblo - Peoria = 3             Peoria - Pittsburgh = 5         Pittsburgh - Princeton = 2
//Pendleton - Pueblo = 8        Phoenix - Peoria = 4        Phoenix - Pittsburgh = 10       Pittsburgh - Pensacola = 4      Princeton - Pensacola = 5
//Pendleton - Phoenix = 4       Phoenix - Pueblo = 3        Phoenix - Pensacola = 5

public class Question11 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        CityMap c = new CityMap();
        c.addCityRoutes();
        while (true) {
            System.out.println("""
                    \u001B[94m
                    Shortest Distance to City
                    -------------------------
                    Enter a number from one of the following cities:
                    1 - Pendleton
                    2 - Pierre
                    3 - Pueblo
                    4 - Phoenix
                    5 - Peoria
                    6 - Pittsburgh
                    7 - Princeton
                    8 - Pensacola
                    Enter 'quit' to end program
                    -------------------------
                    \u001B[0m
                    Enter Option:
                    """);

            String input = kb.nextLine().toLowerCase().trim();

            if (input.equals("quit")) {
                System.out.println("\u001b[31mExiting program...\u001b[0m");
                return;
            }

            switch (input) {
                case "1", "pendleton":
                    input = "Pendleton";
                    break;
                case "2", "pierre":
                    input = "Pierre";
                    break;
                case "3", "pueblo":
                    input = "Pueblo";
                    break;
                case "4", "phoenix":
                    input = "Phoenix";
                    break;
                case "5", "peoria":
                    input = "Peoria";
                    break;
                case "6", "pittsburgh":
                    input = "Pittsburgh";
                    break;
                case "7", "princeton":
                    input = "Princeton";
                    break;
                case "8", "pensacola":
                    input = "Pensacola";
                    break;
                default:
                    System.out.println("\u001b[31mError: Please enter a valid option\u001b[0m");
                    continue;
            }
            c.findShortestDistances(input);
        }
    }
}

