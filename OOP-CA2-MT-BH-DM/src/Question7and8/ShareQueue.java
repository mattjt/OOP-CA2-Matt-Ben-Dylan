package org.example.Question7and8;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShareQueue {
    public final Queue<Share> shares;

    public ShareQueue() {
        this.shares = new LinkedList<>();
    }

    public void displayShares() {
        if (shares.isEmpty()) {
            System.out.println("\u001b[31mYou currently hold no shares\u001b[0m");
            return;
        }
        System.out.println("\u001b[1;93mYou currently hold " + getTotalShares() + " shares:");
        System.out.printf("%-8s %s %-10s\n", "Quantity", "|", "Price");
        System.out.println("-------------------");
        for (Share share : shares) {
            System.out.printf("%-8d %s $%-10.2f\n", share.getQuantity(), "|", share.getPrice());
        }
        System.out.println("\u001b[0m");
    }

    //returns the total quantity of shares stored in queue
    public int getTotalShares() {
        Iterator<Share> iterator = shares.iterator();
        int totalSharesInQueue = 0;
        while (iterator.hasNext()) {
            Share share = iterator.next();
            totalSharesInQueue += share.getQuantity();
        }
        return totalSharesInQueue;
    }

    //adds input stock entry into queue
    public void buyShares(int buyQty, double buyPrice) {
        shares.add(new Share(buyQty, buyPrice));
        System.out.println("Bought " + buyQty + " shares @ $" + buyPrice + "\n" + "Total cost: $" + (buyQty * buyPrice) + "\u001B[0m");
    }

    //overloaded buyShares to be used in Question 8
    public void buyShares(String symbol, int buyQty, double buyPrice) {
        shares.add(new Share(buyQty, buyPrice));
        System.out.println("Bought " + buyQty + " shares of " + symbol + " @ $" + buyPrice + "\nTotal cost: $" + (buyQty * buyPrice) + "\u001B[0m");
    }

    public void sellShares(int sellQty, double sellPrice) {
        sellSharesLogic(sellQty, sellPrice,null); //setting symbol to null to share completed method for selling between question 7 and 8
    }

    //overloaded sellShares to be used in Question 8
    public void sellShares(String symbol, int sellQty, double sellPrice) {
        sellSharesLogic(sellQty, sellPrice, symbol);
    }

    //creating this method with my share logic to avoid code repetition across two methods
    private void sellSharesLogic(int sellQty, double sellPrice, String symbol) {
        double saleValue, sharesCost, totalValueSold = 0.0, totalProfitLoss = 0.0;
        int sharesSold, totalSharesSold = 0, totalSharesInQueue = getTotalShares();

        //validating the user inputs a valid quantity of stock to sell
        if (sellQty <= 0) {
            System.out.println("\u001b[31mError: Sell quantity must be greater than 0\u001b[0m");
            return;
        } else if (totalSharesInQueue == 0) {
            System.out.println("\u001B[31mError: There are no shares to sell\u001B[0m");
            return;
        }

        //if user attempts to sell more than total stocks, outputs confirm dialogue
        if (sellQty > totalSharesInQueue && !confirmSellAllShares(sellQty, sellPrice, totalSharesInQueue)) {
            return;
        }

        while (!shares.isEmpty() && sellQty > 0) {
            Share share = shares.peek();//set current share to next element in queue

            sharesSold = Math.min(sellQty, share.getQuantity());//use the smaller value between sellQty and share.getQuantity()

            sharesCost = share.getPrice() * sharesSold;//calculating the amount originally paid for stock that's being sold
            saleValue = share.sellShare(sharesSold, sellPrice);//removing the shares being sold from share and returning sale value

            totalProfitLoss += saleValue - sharesCost; //adding up total ProfitLoss to be output once loop ends
            totalValueSold += saleValue;//adding up total amount sold to be output once loop ends
            totalSharesSold += sharesSold; //adding up total sold shares to be output once loop ends

            sellQty -= sharesSold;//remove total shares sold from sellQty to repeat loop until sellQty is 0

            //if all shares of this element are depleted, remove from queue
            if (share.getQuantity() <= 0) {
                shares.poll();
            }
        }

        if(symbol == null) {
            //displaying profit
            if (totalProfitLoss >= 0) {
                System.out.println("Sold " + totalSharesSold + " shares @ $" + sellPrice + "\n" + "Total: $" + String.format("%.2f", totalValueSold) + "\n" + "\u001b[92mProfit: $" + String.format("%.2f", totalProfitLoss) + "\u001B[0m");
            }

            //displaying loss
            else {
                System.out.println("Sold " + totalSharesSold + " shares @ $" + sellPrice + "\n" + "Total: $" + String.format("%.2f", totalValueSold) + "\n" + "\u001b[91mLoss: $" + String.format("%.2f", totalProfitLoss) + "\u001B[0m");
            }
        }else{
            //displaying profit
            if (totalProfitLoss >= 0) {
                System.out.println("Sold " + totalSharesSold + " shares @ $" + sellPrice + " for " + symbol + "\n" + "Total: $" + String.format("%.2f", totalValueSold) + "\n" + "\u001b[92mProfit: $" + String.format("%.2f", totalProfitLoss) + "\u001B[0m");
            }

            //displaying loss
            else {
                System.out.println("Sold " + totalSharesSold + " shares @ $" + sellPrice + " for " + symbol + "\n" + "Total: $" + String.format("%.2f", totalValueSold) + "\n" + "\u001b[91mLoss: $" + String.format("%.2f", totalProfitLoss) + "\u001B[0m");
            }
        }

    }

    //confirm dialogue to sell all shares, returns true/false for yes/no
    public boolean confirmSellAllShares(int sellQty, double sellPrice, int totalSharesInQueue) {
        Scanner kb = new Scanner(System.in);
        while (true) {
            System.out.println("\u001B[33mSell quantity is greater than total shares\n" + "Total shares: " + totalSharesInQueue + "\n" + "Quantity selected: " + sellQty + "\n" + "This will sell for a total of: $" + (totalSharesInQueue * sellPrice) + "\u001B[0m\n" + "Type 'yes' or 'y' to confirm selling all " + totalSharesInQueue + " shares\n" + "Type 'no' or 'n' to cancel operation");

            String input = kb.nextLine().toLowerCase();

            switch (input) {
                case "yes", "y":
                    System.out.println("\u001b[32mSelling Shares...\n\u001b[0m");
                    return true;
                case "no", "n":
                    System.out.println("\u001b[31mSell canceled...\n\u001b[0m");
                    return false;
                default:
                    System.out.println("\u001b[31mError: Invalid input, please try again\u001b[0m");
            }
        }
    }
}
