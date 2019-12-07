package com.factory.drink;

import com.factory.Product;

/**
 * An abstract representation of a Drink.
 */
public abstract class Drink implements Product {
    String description = "Unknown Drink";
    Size size;
    String name;
    Milk milkType;
    double cost;


    /**
     * Get the description of the drink.
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }
    /**
     * An abstract method to determine the cost of different sub-types of pastry.
     * @return the cost
     */
    public abstract double getCost();


    public String getName() {
        return name;
    }

    public double getDrinkCost() {
        return cost;
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

        Size(String sizeName) {
            this.sizeName = sizeName;
        }

        public String getSizeName() {
            return sizeName;
        }
    }

    /**
     * An enum that defines the amount of sweetness the tea will have.
     */
    public enum Sweetness {
        QUARTER_SWEET("A fourth sweet"), HALF_SWEET("Half sweet"), THREE_FOURTHS_SWEET("Three fourths sweet"), NO_SUGAR("No sugar");
        private String description;
        Sweetness(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    /**
     * An enum that defines the amount of sweetness the tea will have.
     */
    public enum Milk {
        NO_MILK("No milk"), HALF_AND_HALF("Half and half"), SOY_MILK("Soy milk");

        private String milkDescription;
        Milk(String milkDescription) {
            this.milkDescription = milkDescription;
        }

        public String getMilkDescription() {
            return milkDescription;
        }
    }
}