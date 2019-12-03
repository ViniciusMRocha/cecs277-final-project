package com.factory;
/**
 * An abstract representation of a Drink.
 */
public abstract class Drink implements Product {
    String description = "Unknown Drink";
    Size size;

    /**
     * Get the description of the drink.
     * @return the description
     */
    public String getDescription() {
        return description;
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
}

/**
 * Tea is a type of Drink.
 */
class Tea extends Drink {
    private String name;
    private Sweetness sweetness;

    /**
     * Initializes Tea.
     */
    public Tea(Size size, Sweetness sweetness) {
        this.size = size;
        this.sweetness = sweetness;
        description = "A nice cuppa tea!";
        name = "Tea";
    }

    /**
     * Gets the cost of tea.
     * @return the total cost.
     */
    public double getCost() {
        switch (size) {
            case SMALL:
                return 1.50;

            case MEDIUM:
                return 2.00;

            case LARGE:
                return 2.50;

            default:
                return 0;
        }
    }

    /**
     * Gets description.
     *
     * TODO: Properly add descriptions based on toppings added!
     * @return complete information about the product
     */
    public String getDescription() {
        return "Name: " + this.name + "\nDescription: " + this.description + "\nSweetness: " + this.sweetness.getDescription()
                + "\nSize: " + this.size.getSizeName() + "\nCost: " + String.format("$%.2f" , this.getCost()) + "\n\n";
    }
}

/**
 * Coffee is a type of drink.
 */
class Coffee extends Drink {
    private String name;

    /**
     * Creates a new Coffee drink,
     */
    public Coffee(Size size) {
        this.size = size;
        description = "Hot coffee!";
        name = "Coffee";
    }
    /**
     * Gets the cost of coffee.
     * @return the total cost.
     */
    public double getCost() {
        switch (size) {
            case SMALL:
                return 2.50;

            case MEDIUM:
                return 3.00;

            case LARGE:
                return 3.50;

            default:
                return 0;
        }
    }

    /**
     * Gets description.
     *
     * TODO: Properly add descriptions based on toppings added!
     * @return complete information about the product
     */
    public String getDescription() {
        return "Name: " + this.name + "\nDescription: " + this.description + "\nSize: " + this.size.getSizeName()
                + "\nCost: " + String.format("$%.2f" , this.getCost()) + "\n\n" ;
    }

}