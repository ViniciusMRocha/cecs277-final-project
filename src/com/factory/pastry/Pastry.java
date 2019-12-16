package com.factory.pastry;

import com.factory.Product;

/**
 * An abstract representation of a Pastry, which is also a type of Product sold at "Cha-cha-cha Time!"
 */
public abstract class Pastry implements Product {
    protected String name;
    protected String description;
    protected int quantity;

    /**
     * Get the description of the pastry.
     * @return String
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Gets the description of the pastry.
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * An abstract method to determine the cost of different sub-types of pastry.
     * @return double
     */
    public abstract double getCost();

    /**
     * Gets the quantity of pastries purchased.
     * @return int
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Describes the different HeatStates that a croissant can be in.
     */
    public enum HeatState {
        HEATED("Heated"), COLD("Cold");

        private String description;

        /**
         * Defines a new enum with the given description.
         * @param description String
         */
        HeatState(String description) {
            this.description = description;
        }

        /**
         * Prints out the value of the enum to a String
         * @return String
         */
        @Override
        public String toString() {
            return description;
        }
    }

}