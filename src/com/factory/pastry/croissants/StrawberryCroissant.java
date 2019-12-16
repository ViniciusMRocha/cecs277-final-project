package com.factory.pastry.croissants;

import com.factory.Product;

public class StrawberryCroissant extends Croissant implements Product {
    /**
     * Initializes a new StrawberryCroissant object with the specified parameters.
     * @param name String
     * @param quantity int
     * @param heatState HeatState
     */
    public StrawberryCroissant(String name, int quantity, HeatState heatState) {
        super(name, quantity, heatState);
        description = "strawberry";
    }

    /**
     * Gets the cost of the StrawberryCroissant object
     * @return double
     */
    @Override
    public double getCost() {
        return 3.25;
    }
}
