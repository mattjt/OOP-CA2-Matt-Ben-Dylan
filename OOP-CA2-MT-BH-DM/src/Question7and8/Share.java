package org.example.Question7and8;

public class Share {
    private int quantity;
    private double price;

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

    public void setQuantity(int qty) {
        this.quantity = qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double sellShare(int sellQty, double sellPrice) {
        double sellTotal;

        if (sellQty <= this.quantity) {//if number of shares being sold is less than or equal to share quantity
            sellTotal = sellQty * sellPrice;
            this.quantity -= sellQty;
        } else {//if more shares are being sold set sold shares to quantity and current shares to 0
            sellTotal = this.quantity * sellPrice;
            this.quantity = 0;
        }
        //return total amount sold
        return sellTotal;
    }
}
