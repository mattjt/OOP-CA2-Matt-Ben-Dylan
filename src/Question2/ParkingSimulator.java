package org.example.Question2;

import java.util.Stack;

public class ParkingSimulator {
    private final Stack<Integer> drivewayStack = new Stack<>();
    private final Stack<Integer> streetStack = new Stack<>();

    public void addCar(int carNumber) {
        drivewayStack.push(carNumber);
        System.out.println("\u001B[32mCar " + carNumber + " pulled into the driveway\u001B[0m");
    }

    public void removeCar(int carNumber) {
        boolean carFound = false;
        //Running through a loop until driveway is empty,
        //taking all cars out the driveway and putting them onto the street until the selected car is found
        //if it's found, carFound will be set to true,
        //if not found, carFound is used in an if statement to output a message car not found
        while (!drivewayStack.isEmpty()) {
            if (drivewayStack.peek() == carNumber) {
                drivewayStack.pop();
                System.out.println("\u001B[32mCar " + carNumber + " pulled out of the driveway\u001B[0m");
                carFound = true;
                break;
            } else {
                streetStack.push(drivewayStack.pop());
            }
        }

        if (!carFound) {
            System.out.println("\u001B[31mCar " + carNumber + " was not in the driveway\u001B[0m");
        }

        //pulling all cars from the street and back into the driveway
        for (int i = streetStack.size(); i > 0; i--) {
            drivewayStack.push(streetStack.pop());
        }
    }

    public void getDriveway() {
        System.out.println("\u001B[36mCurrent state of the driveway: " + drivewayStack + "\u001B[0m");

    }

    public void getStreet() {
        System.out.println("\u001B[36mCurrent state of the street: " + streetStack + "\u001B[0m");
    }

}
