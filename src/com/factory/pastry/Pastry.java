package com.factory.pastry;

import com.factory.Product;

/**
 * An abstract representation of a Pastry, which is also a type of Product sold at "Cha-cha-cha Time!"
 */
public abstract class Pastry implements Product {
    protected String name;
    protected String description;
    protected int quantity;
    protected HeatState HeatState;

    /**
     * Get the description of the pastry.
     * @return the pastry description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Gets the description of the pastry.
     * @return The pastry's description
     */
    public String getName() {
        return name;
    }

    /**
     * An abstract method to determine the cost of different sub-types of pastry.
     * @return the cost of the pastry
     */
    public abstract double getCost();

    /**
     * Gets the quantity of pastries purchased.
     * @return the quantity of pastries purchased
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
         * @param description The description of the heat state of the pastry
         */
        HeatState(String description) {
            this.description = description;
        }

        /**
         * Prints out the value of the enum to a String
         * @return The value of a HeatState enum
         */
        @Override
        public String toString() {
            return description;
        }
    }

}