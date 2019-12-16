package com.factory.pastry.cookies;

import com.factory.pastry.Pastry;

/**
 * A Cookie is a type of pastry, which is a type of product available for purchase at "Cha-cha-cha Time!"
 */
public abstract class Cookie extends Pastry {

    protected double trioPrice;
    protected double normalPrice;

    protected Cookie(String name, int quantity) {
        this.name = name;
        description = "";
        this.quantity = quantity;
    }
    /**
     * How many sets-of-three cookies have been purchased.
     *
     * @param quantity The total quantity purchased
     * @return How many sets of three are in the quantity
     */
    protected int setsOfThreePurchased(int quantity) {
        return (int) (Math.floor(quantity / 3));
    }

    /**
     * Gets the cost of the Cookie(s) purchased
     * @return The total cost of the cookies
     */
    public abstract double getCost();
}
