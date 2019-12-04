package com.factory;

/**
 * An abstract representation of a pastry.
 */
public abstract class Pastry implements Product {
    String name;
    String description;
    String type;
    int quantity;

    /**
     * Get the description of the pastry.
     * @return
     */
    public String getDescription() {
        return "Name: " + this.name + "\nToppings: " + this.description + "\nType: " + this.type + "\nQuantity:" + this.quantity;
    }

    public String getName() {
        return name;
    }

    /**
     * An abstract method to determine the cost of different sub-types of pastry.
     * @return the cost
     */
    public abstract double getCost();
}

class Croissant extends Pastry {
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

    /**
     * A Croissant is a type of pastry.
     */
    private HeatState heatState;

    Croissant(HeatState heatState) {
        name = "Croissant";
        description = "A delicious, fresh croissant!";
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
 * A Cookie is a type of pastry.
 */
class Cookie extends Pastry {

    Cookie(int quantity) {
        name = "Cookie";
        description = "A mouth-watering treat!";
        this.quantity = quantity;
    }

    /**
     * How many sets-of-three cookies have been purchased.
     * @return the many sets of three purchased.
     */
    private int setsOfThreePurchased(int quantity) {
        return (int)(Math.floor(quantity / 3));
    }

    public double getCost() {
        double originalPrice = 1.50;
        double specialPrice = 3;

        int cookiesInSetsOfThree = setsOfThreePurchased(quantity) * 3;
        int remainingCookies = quantity % (cookiesInSetsOfThree);
        return (remainingCookies * originalPrice) + (cookiesInSetsOfThree * specialPrice);
    }
}
/**
 * A Macaroon is a type of pastry.
 */
class Macaroon extends Pastry {

    Macaroon(int quantity)  {
        name = "Macaroon";
        description = "This is a macaroon.";
        this.quantity = quantity;
    }

    /**
     * How many half-dozen macaroons have been purchased.
     * @return how many half-dozens purchased.
     */
    private int halfDozensPurchased(int quantity) {
        return (int)(Math.floor(quantity / 12));
    }

    public double getCost() {
        double originalPrice = 2;
        double specialPrice = 9;

        int macaroonsInSets = halfDozensPurchased(quantity) * 12;
        int remainingMacaroons = quantity % (macaroonsInSets);
        return (remainingMacaroons * originalPrice) + (macaroonsInSets * specialPrice);
    }
}