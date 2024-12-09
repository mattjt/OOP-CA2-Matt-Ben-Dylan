package org.example.Question11;

public class DistanceTo implements Comparable<DistanceTo> {
    private final String target;
    private final int distance;

    public DistanceTo(String city, int dist) {
        target = city;
        distance = dist;
    }

    public String getTarget() {
        return target;
    }

    public int getDistance() {
        return distance;
    }

    //Replaced with new compareTo method as I was getting a total of 22 routes rather than 26 when adding city routes
    //It was running into issues when there were multiple routes of the same distance stemming from the same city
    public int compareTo(DistanceTo other) {
        if (distance != other.distance) {
            return distance - other.distance;
        }
        //if distances are equal, compare with the city instead
        else {
            return target.compareTo(other.target);
        }
    }
}
