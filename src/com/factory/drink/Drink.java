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
     * @return String
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Get the quantity of the drink.
     * @return integer
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * An abstract method to determine the cost of different sub-types of pastry.
     * @return double
     */
    public abstract double getCost();

    /**
     * Gets the name of the drink.
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Set cost for drinks
     * @param cost double
     */
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
         * Defines a new Size enum by passing sizeName as a String.
         * @param sizeName String
         */
        Size(String sizeName) {
            this.sizeName = sizeName;
        }

        /**
         * Prints out the value of an enum to a String
         * @return String
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
         * Defines a new Sweetness enum by passing the sweetness of a Drink as a String .
         * @param description String
         */
        Sweetness(String description) {
            this.description = description;
        }

        /**
         * Gets the description of the enum type
         * @return String
         */
        public String getDescription() {
            return description;
        }

        /**
         * Prints out the value of an enum to a String.
         * @return String
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
         * Defines a type of Milk enum by passing the milkiness of a Drink as String.
         * @param milkDescription String
         */
        Milk(String milkDescription) {
            this.milkDescription = milkDescription;
        }

        /**
         * Prints out the value of an enum to a String
         * @return String
         */
        @Override
        public String toString() {
            return milkDescription;
        }
    }
}