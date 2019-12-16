package com.factory.pastry.macaroons;

import com.factory.pastry.Pastry;

/**
 * A macaroon is a type of pastry, which is a type of product available for purchase at "Cha-cha-cha Time!"
 */
public class Macaroon extends Pastry {

    /**
     * Initializes a new croissant object with the specified parameters.
     *
     * @param name The name of the macaroon
     * @param quantity The quantity to be purchased
     */
    public Macaroon(String name, int quantity)  {
        this.name = name;
        this.quantity = quantity;
        description = "A " + name + " macaroon";
    }

    /**
     * How many half-dozen croissants have been purchased.
     *
     * @param quantity The total quantity purchased
     * @return How many half-dozens are in the quantity
     */
    private int halfDozensPurchased(int quantity) {
        return (int)(Math.floor(quantity / 6));
    }

    /**
     * Gets the cost of the macaroon(s) purchased
     * @return The total cost of the macaroon(s)
     */
    public double getCost() {
        double originalPrice = 2;
        double specialPrice = 1.50;

        if(quantity < 6) return (quantity * originalPrice);
        int macaroonsInSets = halfDozensPurchased(quantity) * 6;
        int remainingMacaroons = quantity % (macaroonsInSets);
        return (remainingMacaroons * originalPrice) + (macaroonsInSets * specialPrice);
    }
}