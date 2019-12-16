package com.factory.drink;

import com.factory.DrinkTypes;
import com.factory.Product;

/**
 * An abstract representation of a Drink, which is also a type of Product sold at "Cha-cha-cha Time!"
 */
public abstract class Drink implements Product {
    protected DrinkTypes drinkType;
    protected String description = "Unknown Drink";
    protected Size size;
    protected String name;
    protected Milk milkType;
    protected double cost;
    protected int quantity;

    /**
     * Get the description of the drink.
     * @return the drink description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Get the quantity of the drink.
     * @return the drink quantity
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * An abstract method to determine the cost of different sub-types of pastry.
     * @return the cost
     */
    public abstract double getCost();

    /**
     * Gets the name of the drink.
     * @return The drink's name
     */
    public String getName() {
        return name;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * A enum that represents what size the Drink is.
     */
    public enum Size {
        SMALL("Small"), MEDIUM("Medium"), LARGE("Large");

        private String sizeName;

        /**
         * Defines a new Size enum with the given sizeName.
         * @param sizeName The size of the drink
         */
        Size(String sizeName) {
            this.sizeName = sizeName;
        }

        /**
         * Prints out the value of an enum to a String
         * @return The value of a Size enum
         */
        @Override
        public String toString() {
            return sizeName;
        }
    }

    /**
     * An enum that defines the amount of sweetness the tea will have.
     */
    public enum Sweetness {
        QUARTER_SWEET("A fourth sweet"), HALF_SWEET("Half sweet"), THREE_FOURTHS_SWEET("Three fourths sweet"), NO_SUGAR("No sugar");
        private String description;

        /**
         * Defines a new Sweetness enum that represents the sweetness of a Drink.
         * @param description The description of the sweetness
         */
        Sweetness(String description) {
            this.description = description;
        }

        /**
         * Gets the description of the enum type
         * @return The description
         */
        public String getDescription() {
            return description;
        }

        /**
         * Prints out the value of an enum to a String.
         * @return The value of a Sweetness enum
         */
        @Override
        public String toString() {
            return description;
        }
    }

    /**
     * An enum that defines the amount of sweetness the tea will have.
     */
    public enum Milk {
        NO_MILK("No milk"), HALF_AND_HALF("Half and half"), SOY_MILK("Soy milk");

        private String milkDescription;

        /**
         * Defines a type of Milk enum that represents the milkiness of a Drink.
         * @param milkDescription The description of the milkiness
         */
        Milk(String milkDescription) {
            this.milkDescription = milkDescription;
        }

        /**
         * Prints out the value of an enum to a String
         * @return The value of a Milk enum
         */
        @Override
        public String toString() {
            return milkDescription;
        }
    }
}