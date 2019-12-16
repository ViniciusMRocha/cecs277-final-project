package com.factory.pastry.croissants;

import com.factory.Product;

public class PlainCroissant extends Croissant implements Product {
    /**
     * Initializes a new chocolate chip cookie object with the specified parameters.
     *
     * @param name The name of the cookie
     * @param quantity The quantity to be purchased
     */
    public PlainCroissant(String name, int quantity, HeatState heatState) {
        super(name, quantity, heatState);
        description = "plain";
    }

    @Override
    public double getCost() {
        double pastryCost = super.getCost();
        pastryCost += (1.50 * quantity);
        return pastryCost;
    }
}