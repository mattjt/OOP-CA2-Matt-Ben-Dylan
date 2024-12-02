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

        Box b1 = new Box(2.0, 3.0, 4.0, 5.0);
        Cylinder c1 = new Cylinder(5.0, 3.0, 4.0);
        Pyramid p1 = new Pyramid(3.0, 3.0, 2.0);
        Box b2 = new Box(2.0, 3.0, 4.0, 5.0);
        Cylinder c2 = new Cylinder(5.0, 3.0, 4.0);
        Pyramid p2 = new Pyramid(3.0, 3.0, 2.0);

        manager.add(b1);
        manager.add(c1);
        manager.add(p1);
        manager.add(b2);
        manager.add(c2);
        manager.add(p2);

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


