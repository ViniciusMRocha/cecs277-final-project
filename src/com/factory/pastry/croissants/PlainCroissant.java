package com.factory.pastry.croissants;

import com.factory.Product;

/**
 * A PlainCroissant is a type of pastry, which is a type of product available for purchase at "Cha-cha-cha Time!"
 */
public class PlainCroissant extends Croissant implements Product {

    /**
     * Initializes a new PlainCroissant object with the specified parameters.
     * @param name String
     * @param quantity int
     * @param heatState heatState
     */
    public PlainCroissant(String name, int quantity, HeatState heatState) {
        super(name, quantity, heatState);
        description = "plain";
    }

    /**
     * Gets the cost for the pastry
     * @return double
     */
    @Override
    public double getCost() {
        double pastryCost = super.getCost();
        pastryCost += (1.50 * quantity);
        return pastryCost;
    }
}