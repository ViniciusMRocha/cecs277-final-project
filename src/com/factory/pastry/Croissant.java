package com.factory.pastry;

/**
 * A croissant is a type of pastry, which is a type of product available for purchase at "Cha-cha-cha Time!"
 */
public class Croissant extends Pastry {
    private HeatState heatState;

    /**
     * Initializes a new croissant object with the specified parameters.
     *
     * @param name The name of the croissant
     * @param quantity The quantity to be purchased
     * @param heatState The HeatState of the Croissant
     */
    Croissant(String name, int quantity, HeatState heatState) {
        this.name = name;
        this.quantity = quantity;
        this.heatState = heatState;
        description = "A delicious, fresh croissant with ";
    }

    /**
     * Gets the cost of the croissant(s) purchased
     * @return The total cost of the croissant(s)
     */
    public double getCost() {
        switch (heatState) {
            case HEATED:
                return (quantity * 2.50);
            case COLD:
            default:
                return (quantity * 2.00);
        }
    }
}