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
     * @param name The name of the croissant
     * @param quantity The quantity to be purchased
     * @param heatState The HeatState of the Croissant
     */
    protected Croissant(String name, int quantity, HeatState heatState) {
        this.name = name;
        this.quantity = quantity;
        this.heatState = heatState;
        description = "A delicious, fresh croissant with ";
    }

    @Override
    public double getCost() {
        double pastryCost = 0.0;
        switch (HeatState) {
            case HEATED:
                pastryCost += 0.5;
                break;
            case COLD:
                pastryCost += 0.0;
                break;
        }

        return pastryCost;
    }
}