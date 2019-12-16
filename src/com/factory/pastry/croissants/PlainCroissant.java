package com.factory.pastry.croissants;

import com.factory.Product;

public class PlainCroissant extends Croissant implements Product {
    /**
     * Initializes a new PlainCroissant object with the specified parameters.
     * @param name String
     * @param quantity int
     * @param heatState HeatState
     */
    public PlainCroissant(String name, int quantity, HeatState heatState) {
        super(name, quantity, heatState);
        description = "plain";
    }

    /**
     * Gets the cost of the PlainCroissant object
     * @return double
     */
    @Override
    public double getCost() {
        return 1.50;
    }
}
