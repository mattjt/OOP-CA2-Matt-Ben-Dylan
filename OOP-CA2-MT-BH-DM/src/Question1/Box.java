package org.example.Question1;

public class Box implements IMeasurableContainer {
    private double length;
    private double width;
    private double depth;
    private double weight;

    public Box(double length, double width, double depth, double weight) {
        this.length = length;
        this.width = width;
        this.depth = depth;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    public double rectangularVolume() {
        return length * width * depth;
    }

    public double getLength(){
        return length;
    }
    public double getWidth(){
        return width;
    }
    public double getDepth(){
        return depth;
    }
    public double getWeight(){
        return weight;
    }

    public void setLength(double length){
        this.length = length;
    }
    public void setWidth(double width){
        this.width = width;
    }
    public void setDepth(double depth){
        this.depth = depth;
    }
    public void setWeight(double weight){
        this.weight = weight;
    }
}
