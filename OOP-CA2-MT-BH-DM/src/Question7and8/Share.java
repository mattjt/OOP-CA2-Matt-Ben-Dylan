package org.example.Question7and8;

public class Share {
    private int quantity;
    private final double price;

    public Share(int qty, double price) {
        this.quantity = qty;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double sellShare(int sellQty, double sellPrice) {
        double sellTotal;

        //if number of shares being sold is less than or equal to share quantity
        if (sellQty <= this.quantity) {
            sellTotal = sellQty * sellPrice;
            this.quantity -= sellQty;
        }
        //if more shares are being sold set sold shares to quantity and current shares to 0
        else {
            sellTotal = this.quantity * sellPrice;
            this.quantity = 0;
        }
        //return total amount sold
        return sellTotal;
    }
}
