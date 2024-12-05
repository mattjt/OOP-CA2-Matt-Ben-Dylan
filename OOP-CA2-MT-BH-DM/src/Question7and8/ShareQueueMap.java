package org.example.Question7and8;

import java.util.HashMap;
import java.util.Map;

public class ShareQueueMap {
    private final Map<String, ShareQueue> companyShares;

    public ShareQueueMap() {
        this.companyShares = new HashMap<>();
    }

    public void displayCompanyShares() {
        if (companyShares.isEmpty()) {
            System.out.println("\u001b[31mYou currently hold no shares\u001b[0m");
            return;//if there aren't any shares in the map, return
        }

        System.out.println("\u001b[1;93mDisplaying all company shares:"); //table header
        System.out.printf("%-8s %s %-8s %s %-10s\n", "Symbol", "|", "Quantity", "|", "Price");
        System.out.println("---------------------------------");

        for (String symbol : companyShares.keySet()) { //looping through all symbols in the map
            ShareQueue currentQueue = companyShares.get(symbol); //assigning currentQueue to a ShareQueue of current symbol

            //checking that the symbol exists and has shares within it
            if (currentQueue != null && !currentQueue.shares.isEmpty()) {
                for (Share share : currentQueue.shares) { //looping through all Shares within currentQueue
                    System.out.printf("%-8s %s %-8d %s $%-10.2f\n", symbol, "|", share.getQuantity(), "|", share.getPrice());
                }
            }
        }
        System.out.println("\u001b[0m");
    }

    public void displayCompanyShares(String symbol) {
        ShareQueue currentQueue = companyShares.get(symbol);//assigning currentQueue to a ShareQueue of current symbol

        //checking that the symbol exists and has shares within it
        if (currentQueue == null || currentQueue.shares.isEmpty()) {
            System.out.println("\u001b[31mYou currently hold no shares for symbol: " + symbol + "\u001b[0m");
            return; //if there aren't any shares to display, return
        }

        System.out.println("\u001b[1;93mDisplaying company shares: " + symbol + ":"); //table header
        System.out.printf("%-8s %s %-8s %s %-10s\n", "Symbol", "|", "Quantity", "|", "Price");
        System.out.println("---------------------------------");

        for (Share share : currentQueue.shares) {//looping through all Shares within currentQueue
            System.out.printf("%-8s %s %-8d %s $%-10.2f\n", symbol, "|", share.getQuantity(), "|", share.getPrice());
        }

        System.out.println("\u001b[0m");
    }

    public void buyCompanyShares(String symbol, int buyQty, double buyPrice) {
        ShareQueue currentQueue = companyShares.get(symbol); //assigning currentQueue to a ShareQueue of current symbol
        companyShares.putIfAbsent(symbol, new ShareQueue());//if provided key (symbol) doesn't exist, create a new queue using this symbol
        currentQueue.buyShares(symbol, buyQty, buyPrice);//access the queue using provided key (symbol) and add new share into the queue
    }

    public void sellCompanyShares(String symbol, int sellQty, double sellPrice) {
        ShareQueue currentQueue = companyShares.get(symbol);//assigning currentQueue to a ShareQueue of current symbol

        //if the key doesn't exist or there are 0 shares in the queue, output message
        if (currentQueue == null || currentQueue.getTotalShares() == 0) {
            System.out.println("\u001b[31mError: No shares available for " + symbol + "\u001b[0m");
            return;
        }

        currentQueue.sellShares(symbol, sellQty, sellPrice);

        //if all shares are sold, remove the key from map
        if (currentQueue.getTotalShares() == 0) {
            companyShares.remove(symbol);
        }
    }
}
