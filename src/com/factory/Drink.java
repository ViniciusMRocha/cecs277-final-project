package com.factory;
/**
 * An abstract representation of a Drink.
 */
public abstract class Drink implements Product {
    String description = "Unknown Drink";
    Size size;
    protected String name;
    Milk milkType;

    /**
     * Get the description of the drink.
     * @return the description
     */
    public String getDescription() {
        return "Name: " + name + "\nToppings: " + this.description;
    }
    /**
     * An abstract method to determine the cost of different sub-types of pastry.
     * @return the cost
     */
    public abstract double getCost();

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

/**
 * Tea is a type of Drink.
 */
class Tea extends Drink {
    private Sweetness sweetness;

    /**
     * Initializes Tea.
     */
    public Tea(String name, Size size, Sweetness sweetness, Milk milkType) {
        this.name = name;

        this.size = size;
        this.sweetness = sweetness;
        this.milkType = milkType;
        description = "A nice cuppa tea with ";
    }

    /**
     * Gets the cost of tea.
     * @return the total cost.
     */
    public double getCost() {
        double drinkCost = 0.0;
        switch (size) {
            case SMALL:
                drinkCost += 1.50;
                break;

            case MEDIUM:
                drinkCost += 2.00;
                break;

            case LARGE:
                drinkCost += 3.00;
                break;
        }

        switch (milkType) {
            case SOY_MILK:
                drinkCost += 0.50;
                break;

            case HALF_AND_HALF:
                drinkCost += 0.25;
                break;
        }
        return drinkCost;
    }
}

/**
 * Coffee is a type of drink.
 */
class Coffee extends Drink {
    /**
     * Creates a new Coffee drink,
     */
    public Coffee(String name, Size size, Milk milkType) {
        this.name = name;
        this.size = size;
        this.milkType = milkType;
        //description = "Hot coffee!";
    }
    /**
     * Gets the cost of coffee.
     * @return the total cost.
     */
    public double getCost() {
        double drinkCost = 0.0;
        switch (size) {
            case SMALL:
            case MEDIUM:
                drinkCost += 2.00;
                break;

            case LARGE:
                drinkCost += 2.50;
                break;
        }

        switch (milkType) {
            case SOY_MILK:
                drinkCost += 0.50;
                break;

            case HALF_AND_HALF:
                drinkCost += 0.25;
                break;
        }

        return drinkCost;
    }
}