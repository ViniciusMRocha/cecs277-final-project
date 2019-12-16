package com.factory.pastry;

/**
 * A croissant is a type of pastry, which is a type of product available for purchase at "Cha-cha-cha Time!"
 */
public class Croissant extends Pastry {
    private HeatState heatState;

    /**
     * Initializes a new croissant object with the specified parameters.
     * @param name String
     * @param quantity int
     * @param heatState HeatState
     */
    Croissant(String name, int quantity, HeatState heatState) {
        this.name = name;
        this.quantity = quantity;
        this.heatState = heatState;
        description = "A delicious, fresh croissant with ";
    }

    /**
     * Gets the cost of the croissant(s) purchased
     * @return double
     */
    public double getCost() {
        double cost = 2.00;
        switch (heatState) {
            case HEATED:
                cost += 0.5;
                return (quantity * cost);
            case COLD:
            default:
                return (quantity * cost);
        }
    }
}