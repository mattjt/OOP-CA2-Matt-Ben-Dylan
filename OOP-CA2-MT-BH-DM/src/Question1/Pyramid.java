package org.example.Question1;

public class Pyramid implements IMeasurableContainer {
    private double length;
    private double sideLength;
    private double weight;

    public Pyramid(double length, double sideLength, double weight) {
        this.length = length;
        this.sideLength = sideLength;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    public double rectangularVolume() {
        return length * sideLength * sideLength;
    }

    public double getLength() {
        return length;
    }
    public double getSideLength() {
        return sideLength;
    }
    public double getWeight() {
        return weight;
    }

    public void setLength(double length) {
        this.length = length;
    }
    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

}
