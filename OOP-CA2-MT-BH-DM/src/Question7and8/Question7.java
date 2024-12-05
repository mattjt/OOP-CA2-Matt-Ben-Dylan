package org.example.Question7and8;

import java.util.Scanner;

/**
 *  Name: Dylan Murphy
 *  Class Group: SD2b
 */
public class Question7 // Shares Tax Calculations (Queue)
{
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        ShareQueue sq = new ShareQueue();
        String input;
        //buy and sell regex to validate user enters commands correctly and int variable is within range.
        String buyRegex = "^buy\\s+" + "([1-9]\\d{0,8})\\s+" + "\\d+(\\.\\d+)?$";
        String sellRegex = "^sell\\s+" + "([1-9]\\d{0,8})\\s+" + "\\d+(\\.\\d+)?$";
        String[] inputs;
        int qty;
        double price;

        while (true) { //loop will repeat until return statement when the user inputs quit
            System.out.println("""
                    \u001B[94m
                    Stock Shares Calculator
                    -----------------------
                    Enter 'buy [quantity] [price]' to buy stocks
                    Enter 'sell [quantity] [price]' to sell stocks
                    Enter 'show-shares' to display current shares owned
                    Enter 'quit' to end program
                    -----------------------
                    \u001B[0m
                    Enter Command:
                    """);

            input = kb.nextLine().toLowerCase().trim();

            if (input.equals("quit")) {
                System.out.println("\u001b[31mExiting program...\u001b[0m");
                return;
            } else if (input.equals("show-shares")) {
                sq.displayShares();
                continue; //repeat loop after displaying shares
            } else if (!input.matches(buyRegex) && !input.matches(sellRegex)) { //validating user input
                System.out.println("""
                        \u001b[31m
                        -----------------------
                        Error: Invalid command, please try again
                        For buy and sell, use format '[command] [int value in range 1-999999999] [positive number]'
                        -----------------------
                        \u001b[0m
                        """);
                continue;//repeat loop if invalid input
            }

            try {
                inputs = input.split("\\s+"); //splitting input, using regex, into an array
                qty = Integer.parseInt(inputs[1]);
                price = Double.parseDouble(inputs[2]);

                if (input.matches(buyRegex)) {
                    sq.buyShares(qty, price);
                } else if (input.matches(sellRegex)) {
                    sq.sellShares(qty, price);
                } else {
                    System.out.println("\u001b[31mInvalid command, please try again\u001b[0m");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage() + "\nPlease try again");
                //if exception is thrown, error message display. loop will restart naturally
            }
        }
    }
}
