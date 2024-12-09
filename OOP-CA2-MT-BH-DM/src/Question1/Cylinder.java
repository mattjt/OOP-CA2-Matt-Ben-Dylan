package org.example.Question1;

public class Cylinder implements IMeasurableContainer {
    private double height;
    private double diameter;
    private double weight;

    public Cylinder(double height, double diameter, double weight) {
        this.height = height;
        this.diameter = diameter;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    public double rectangularVolume() {
        return diameter * diameter * height;
    }

    public double getHeight() {
        return height;
    }
    public double getDiameter() {
        return diameter;
    }
    public double getWeight() {
        return weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
}
