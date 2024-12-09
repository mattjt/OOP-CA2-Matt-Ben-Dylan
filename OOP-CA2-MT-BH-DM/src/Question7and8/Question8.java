package org.example.Question7and8;

import java.util.Scanner;

/**
 *  Name: Dylan Murphy
 *  Class Group: SD2b
 */
public class Question8 // Multi-company (Queue)
{
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        ShareQueueMap sqm = new ShareQueueMap();
        String input;
        //buy and sell regex to validate user enters commands correctly and int variable is within range.
        String buyRegex = "^buy\\s+" + "\\w+\\s+" + "([1-9]\\d{0,8})\\s+" + "\\d+(\\.\\d+)?$";
        String sellRegex = "^sell\\s+" + "\\w+\\s+" + "([1-9]\\d{0,8})\\s+" + "\\d+(\\.\\d+)?$";
        String displayRegex = "^show-shares\\s+" + "\\w+$";
        String[] inputs;
        int qty;
        double price;

        while (true) {  //loop will repeat until return statement when the user inputs quit
            System.out.println("""
                    \u001B[94m
                    Stock Shares Calculator
                    -----------------------
                    Enter 'buy [symbol] [quantity] [price]' to buy stocks
                    Enter 'sell [symbol] [quantity] [price]' to sell stocks
                    Enter 'show-shares' to display all current shares owned
                    Enter 'show-shares [symbol]' to display shares owned in [symbol]
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
                sqm.displayCompanyShares();
                continue; //repeat loop after displaying shares
            } else if (input.matches(displayRegex)) {
                int spaceIndex = input.indexOf(' ');
                sqm.displayCompanyShares(input.substring(spaceIndex + 1));
            } else if (!input.matches(buyRegex) && !input.matches(sellRegex)) {//validating user input
                System.out.println("""
                        \u001b[31m
                        -----------------------
                        Error: Invalid command, please try again
                        For buy and sell, use format '[command] [symbol] [int value in range 1-999999999] [positive number]'
                        -----------------------
                        \u001b[0m
                        """);
                continue;//repeat loop if invalid input
            }

            try {
                inputs = input.split("\\s+"); //splitting input, using regex, into an array
                String symbol = inputs[1];
                qty = Integer.parseInt(inputs[2]);
                price = Double.parseDouble(inputs[3]);

                if (input.matches(buyRegex)) {
                    sqm.buyCompanyShares(symbol, qty, price); //buy shares for the input symbol.
                } else if (input.matches(sellRegex)) {
                    sqm.sellCompanyShares(symbol, qty, price); //sell shares for the input symbol.
                }
            } catch (Exception e) {
                System.out.println(e.getMessage() + "\nPlease try again.");
                //if exception is thrown, error message display. loop will restart naturally
            }
        }
    }
}
