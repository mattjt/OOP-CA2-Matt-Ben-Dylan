package org.example.Question11;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class CityMap {
    private final Map<String, TreeSet<DistanceTo>> c = new HashMap<>();

    public void addCityRoutes() {
        try {
            File f = new File("city routes.txt");
            Scanner fileReader = new Scanner(f);

            while (fileReader.hasNextLine()) {
                String city1 = fileReader.next();
                String city2 = fileReader.next();
                int distance = fileReader.nextInt();

                //adding new city keys if they haven't been added yet
                c.putIfAbsent(city1, new TreeSet<>());
                c.putIfAbsent(city2, new TreeSet<>());

                //adding in each city pair and adding the distance value between them to both.
                c.get(city1).add(new DistanceTo(city2, distance));
                c.get(city2).add(new DistanceTo(city1, distance));
            }
            System.out.println("\u001b[32m - City Routes Added Successfully - \u001b[0m\n");
        } catch (Exception e) {
            System.out.println("\u001b[31mError reading city routes: " + e.getMessage() + "\u001b[0m\n");
        }
    }

    public void findShortestDistances(String startCity) {
        //Add DistanceTo(from, 0) to a priority queue.
        PriorityQueue<DistanceTo> routes = new PriorityQueue<>();
        routes.add(new DistanceTo(startCity, 0));

        //Construct a map shortestKnownDistance from city names to distances.
        Map<String, Integer> shortestKnownDistance = new HashMap<>();

        //While the priority queue is not empty
        while (!routes.isEmpty()) {
            //Get its smallest element.
            DistanceTo currentRoute = routes.poll();
            String target = currentRoute.getTarget();
            int dist = currentRoute.getDistance();

            //If its target is not a key in shortestKnownDistance
            if (!shortestKnownDistance.containsKey(target)) {

                //Put (target, d) into shortestKnownDistance.
                shortestKnownDistance.put(target, dist);

                //For all cities c that have a direct connection from target
                for (DistanceTo directTarget : c.get(target)) {
                    String newTarget = directTarget.getTarget();
                    if (shortestKnownDistance.containsKey(newTarget)) {
                        continue;
                    }

                    //Add DistanceTo(c, d + distance from target to c) to the priority queue
                    int newDist = dist + directTarget.getDistance();
                    routes.add(new DistanceTo(newTarget, newDist));
                }
            }
        }

        //Removing the start city as it isn't needed for the output
        shortestKnownDistance.remove(startCity);

        //Sorting map by values in ascending order. Sort code obtained from https://www.baeldung.com/java-hashmap-sort
        Map<String, Integer> sortedMap = shortestKnownDistance.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        System.out.println("\u001b[1;93mShortest distances from " + startCity + " to:");
        for (String city : sortedMap.keySet()) {//looping through all cities
            int dist = sortedMap.get(city);  //extracting distance from startCity
            System.out.printf("%-10s %2s %-2d\n", city, " > ", dist);
        }
        System.out.println("\u001b[0m");
    }
}

