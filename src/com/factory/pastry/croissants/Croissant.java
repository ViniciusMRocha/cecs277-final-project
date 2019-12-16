package com.factory.pastry.croissants;

import com.factory.pastry.Pastry;

/**
 * A croissant is a type of pastry, which is a type of product available for purchase at "Cha-cha-cha Time!"
 */
public abstract class Croissant extends Pastry {
    private HeatState heatState;

    /**
     * Initializes a new croissant object with the specified parameters.
     *
     * @param name String
     * @param quantity int
     * @param heatState heatState
     */
    protected Croissant(String name, int quantity, HeatState heatState) {
        this.name = name;
        this.quantity = quantity;
        this.heatState = heatState;
        System.out.println("heat state: " + heatState);
        description = "A delicious, fresh croissant with ";
    }

    /**
     * Gets the cost for the pastry
     * @return double
     */
    public double getCost() {
        double pastryCost = 0.0;
        switch (heatState) {
            case HEATED:
                System.out.println("I'm hot");
                pastryCost += 0.5;
                break;
        }
        return pastryCost;
    }
}