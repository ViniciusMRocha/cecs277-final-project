package com.factory.pastry;

/**
 * A Macaroon is a type of pastry.
 */
public class Macaroon extends Pastry {

    Macaroon(String name, int quantity)  {
        this.name = name;
        description = "This is a macaroon.";
        this.quantity = quantity;
    }

    /**
     * How many half-dozen macaroons have been purchased.
     * @return how many half-dozens purchased.
     */
    private int halfDozensPurchased(int quantity) {
        return (int)(Math.floor(quantity / 6));
    }

    public double getCost() {
        double originalPrice = 2;
        double specialPrice = 1.50;

        if(quantity < 6) return (quantity * originalPrice);
        int macaroonsInSets = halfDozensPurchased(quantity) * 6;
        int remainingMacaroons = quantity % (macaroonsInSets);
        return (remainingMacaroons * originalPrice) + (macaroonsInSets * specialPrice);
    }
}