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

    /**
     * An abstract method to determine the cost of different sub-types of pastry.
     * @return the cost
     */
    public abstract double getCost();
}

/**
 * A Croissant is a type of pastry.
 */
class Croissant extends Pastry {
    private boolean heated;

    public Croissant() {
        name = "Croissant";
        description = "A delicious, fresh croissant";
    }

    public double getCost() { return 4; }
}
/**
 * A Cookie is a type of pastry.
 */
class Cookie extends Pastry {
    public Cookie() {
        name = "Cookie";
        description = "A mouth-watering treat!";
    }

    /**
     * Whether or not a set of three has been purchased.
     * @return the answer.
     */
    private boolean purchasedSetOfThree() {
        return false;
    }

    public double getCost() { return 6; }
}
/**
 * A Macaroon is a type of pastry.
 */
class Macaroon extends Pastry {
    public Macaroon()  {
        name = "Macaroon";
        description = "This is a macaroon.";
    }

    /**
     * Whether or not a half dozen has been purchased.
     * @return the answer.
     */
    private boolean purchasedHalfDozen() {
        return false;
    }

    public double getCost() { return 100;  }
}