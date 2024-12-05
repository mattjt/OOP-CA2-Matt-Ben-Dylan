package org.example.Question2;

import java.util.Scanner;

/**
 * Name: Dylan Murphy
 * Class Group: SD2b
 */
public class Question2  // Car Parking - Stack
{
    public static void runSimulation() {
        ParkingSimulator cp = new ParkingSimulator();
        Scanner kb = new Scanner(System.in);
        String input = "";
        int carNumber;

        System.out.println("""
                \u001B[94m
                Driveway parking simulation
                -----------------------------
                Commands:
                Enter positive number to add input car no. - ('1' will add car no.1)
                Enter negative number to remove input car no. - ('-1' will remove car no.1)
                Enter 'show-driveway' to show current driveway state
                Enter 'show-street' to show current street state
                Enter 'quit' to exit simulation
                -----------------------------
                \u001B[0m""");

        while (true) {
            System.out.print("Enter command: ");
            input = kb.nextLine();

            if (!input.matches("-?\\d+")) {//if input is not a positive or negative integer, check for text based commands
                switch (input.toLowerCase()) {
                    case "quit":
                        System.out.println("\u001B[31mExiting simulation...\u001B[0m");
                        return;
                    case "show-driveway":
                        cp.getDriveway();
                        break;
                    case "show-street":
                        cp.getStreet();
                        break;
                    default:
                        System.out.println("\u001B[31mInvalid command entered: Please try again\u001B[0m");
                        break;

                }
            }else if(input.matches("^\\d{1,9}$")) {//if input is a positive number, add car
                carNumber = Integer.parseInt(input);
                cp.addCar(carNumber);

            }else if (input.matches("^-\\d{1,9}$")) {//if input is a negative number, remove car
                carNumber = Integer.parseInt(input.substring(1));
                cp.removeCar(carNumber);
            } else {
                System.out.println("\u001B[31mInvalid number entered: enter a positive or negative number under 10 digits long\u001B[0m");
            }
        }
    }

    public static void main(String[] args) {
        runSimulation();
    }
}
