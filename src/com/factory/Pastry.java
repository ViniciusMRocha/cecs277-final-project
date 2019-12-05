package com.factory;

/**
 * An abstract representation of a pastry.
 */
public abstract class Pastry implements Product {
    String name;
    String description;
    int quantity;

    public ProductTypes type() {
        return ProductTypes.PASTRY;
    }
    /**
     * Get the description of the pastry.
     * @return
     */
    public String getDescription() {
        return "Name: " + this.name + "\nToppings: " + this.description + "\nQuantity: " + this.quantity;
    }

    public String getName() {
        return name;
    }

    /**
     * An abstract method to determine the cost of different sub-types of pastry.
     * @return the cost
     */
    public abstract double getCost();

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

class Croissant extends Pastry {
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
/**
 * A Macaroon is a type of pastry.
 */
class Macaroon extends Pastry {

    Macaroon(String name, int quantity)  {
        this.name = name;
        description = "This is a macaroon.";
        this.quantity = quantity;
    }

    /**
     * How many half-dozen macaroons have been purchased.
     * @return how many half-dozens purchased.
     */
    private int halfDozensPurchased(int quantity) {
        return (int)(Math.floor(quantity / 6));
    }

    public double getCost() {
        double originalPrice = 2;
        double specialPrice = 1.50;

        if(quantity < 6) return (quantity * originalPrice);
        int macaroonsInSets = halfDozensPurchased(quantity) * 6;
        int remainingMacaroons = quantity % (macaroonsInSets);
        return (remainingMacaroons * originalPrice) + (macaroonsInSets * specialPrice);
    }
}