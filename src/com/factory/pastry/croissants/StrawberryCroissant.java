package com.factory.pastry.croissants;

import com.factory.Product;

public class StrawberryCroissant extends Croissant implements Product {
    /**
     * Initializes a new chocolate chip cookie object with the specified parameters.
     *
     * @param name The name of the cookie
     * @param quantity The quantity to be purchased
     */
    public StrawberryCroissant(String name, int quantity, HeatState heatState) {
        super(name, quantity, heatState);
        description = "strawberry";
    }

    @Override
    public double getCost() {
        double pastryCost = super.getCost();
        pastryCost += 3.25 * quantity;
        return pastryCost;
    }
}
