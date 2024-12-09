package org.example.Question1;

import java.util.ArrayList;

/**
 * Your Name: Dylan Murphy
 * Class Group: SD2b
 */
public class Question1 {    // Interfaces
    public static void main(String[] args) {
        System.out.println("Question 1\n__________\n");

        ContainerManager manager = new ContainerManager();

        Box b1 = new Box(24.0, 24.0, 24.0, 50.0);
        Cylinder c1 = new Cylinder(50.0, 10.0, 25.0);
        Pyramid p1 = new Pyramid(50.0, 24.0, 24.0);
        Box b2 = new Box(10.0, 20.0, 30.0, 40.0);
        Cylinder c2 = new Cylinder(10.0, 10.0, 20.0);
        Pyramid p2 = new Pyramid(30.0, 30.0, 25.0);

        manager.add(b1);
        manager.add(c1);
        manager.add(p1);
        manager.add(b2);
        manager.add(c2);
        manager.add(p2);

        System.out.println("Box 1 minimum box volume: " + b1.rectangularVolume());
        System.out.println("Cylinder 1 minimum box volume: " + c1.rectangularVolume());

        double totalWeight = manager.totalWeight();
        double totalVolume = manager.totalRectangularVolume();

        System.out.println("Total Weight: " + totalWeight);
        System.out.println("Total Rectangular Volume: " + totalVolume);
        System.out.println(" ");

        int boxcount = 1, cylcount = 1, pyramidcount = 1;
        ArrayList<IMeasurableContainer> allContainers = manager.getAllContainers();
        for (int i = 0; i < allContainers.size(); i++) {
            IMeasurableContainer container = allContainers.get(i);
            if (container instanceof Box b) {
                System.out.println("Box " + (boxcount) +
                        ":\nLength: " + b.getLength() +
                        "\nWidth: " + b.getWidth() +
                        "\nDepth: " + b.getDepth() +
                        "\nWeight: " + b.weight() + "\n");
                boxcount++;
            } else if (container instanceof Cylinder c) {
                System.out.println("Cylinder " + (cylcount) +
                        ":\nHeight: " + c.getHeight() +
                        "\nDiameter: " + c.getDiameter() +
                        "\nWeight: " + c.weight() + "\n");
                cylcount++;
            } else if (container instanceof Pyramid p) {
                System.out.println("Pyramid " + (pyramidcount) +
                        ":\nLength: " + p.getLength() +
                        "\nSide Length: " + p.getSideLength() +
                        "\nWeight: " + p.weight() + "\n");
                pyramidcount++;
            }
        }
    }
}


