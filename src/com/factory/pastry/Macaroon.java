package com.factory.pastry;

/**
 * A macaroon is a type of pastry, which is a type of product available for purchase at "Cha-cha-cha Time!"
 */
public class Macaroon extends Pastry {

    /**
     * Initializes a new croissant object with the specified parameters.
     * @param name String
     * @param quantity int
     */
    Macaroon(String name, int quantity)  {
        this.name = name;
        this.quantity = quantity;
        description = "A " + name + " macaroon";
    }

    /**
     * How many half-dozen croissants have been purchased.
     *
     * @param quantity int
     * @return int
     */
    private int halfDozensPurchased(int quantity) {
        return (int)(Math.floor(quantity / 6));
    }

    /**
     * Gets the cost of the macaroon(s) purchased
     * @return double
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