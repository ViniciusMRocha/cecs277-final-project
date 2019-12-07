package com.factory.pastry;

public class Croissant extends Pastry {
    /**
     * A Croissant is a type of pastry.
     */
    private HeatState heatState;

    Croissant(String name, int quantity, HeatState heatState) {
        this.name = name;
        this.quantity = quantity;
        description = "A delicious, fresh croissant with ";
        this.heatState = heatState;
    }

    public double getCost() {
        switch (heatState) {
            case HEATED:
                return 2.50;
            case COLD:
            default:
                return 2.00;
        }
    }
}