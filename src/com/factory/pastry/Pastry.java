package com.factory.pastry;

import com.factory.Product;

/**
 * An abstract representation of a pastry.
 */
public abstract class Pastry implements Product {
    String name;
    String description;
    int quantity;

    /**
     * Get the description of the pastry.
     * @return
     */
    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return name;
    }

    /**
     * An abstract method to determine the cost of different sub-types of pastry.
     * @return the cost
     */
    public abstract double getCost();

    public int getQuantity() {
        return quantity;
    }

    /**
     * A enum that represents what size the Drink is.
     */
    public enum HeatState {
        HEATED("Heated"), COLD("Cold");

        private String name;

        HeatState(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

}