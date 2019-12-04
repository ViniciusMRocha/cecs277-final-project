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

/**
 * A enum that represents what size the Drink is.
 */
public enum HeatState {
    HEATED("Heated"), COLD("Cold");
}

/**
 * A Croissant is a type of pastry.
 */
private HeatState heatState;
public Croissant(HeatState heatState) {
    name = "Croissant";
    description = "A delicious, fresh croissant!";
    this.heatState = heatState;
}
public double getCost() {
    switch(heatState) {
        case HEATED:
            return 2.50;
        case COLD:
        default:
            return 2.00;
    }
}
/**
 * A Cookie is a type of pastry.
 */
class Cookie extends Pastry {
    private int amountRegPrice = 0;
    private int triosDiscounted = 0;
    public Cookie(int numBought) {
        if (numBought >= 3) {
            amountRegPrice = numBought % 3;
            triosDiscounted = numBought / 3;
        }
        name = "Cookie";
        description = "A mouth-watering treat!";
    }

    /**
     * Whether or not a set of three has been purchased.
     * @return the answer.
     */
    private boolean purchasedSetOfThree() {
        if (amountDiscounted > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public double getCost() {
        return amountRegPrice * 1.5 + triosDiscounted * 3;
    }
}
/**
 * A Macaroon is a type of pastry.
 */
class Macaroon extends Pastry {
    private int amountRegPrice = 0;
    private int halfDozDiscounted = 0;
    public Macaroon(int numBought)  {
        if (numBought >= 3) {
            amountRegPrice = numBought % 6;
            halfDozDiscounted = numBought / 6;
        }
        name = "Macaroon";
        description = "This is a macaroon.";
    }

    /**
     * Whether or not a half dozen has been purchased.
     * @return the answer.
     */
    private boolean purchasedSetOfThree() {
        if (halfDozDiscounted > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public double getCost() {
        return amountRegPrice * 2 + triosDiscounted * 9;
    }
}