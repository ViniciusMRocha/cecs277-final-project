package com.factory.pastry.cookies;

import com.factory.pastry.Pastry;

/**
 * A Cookie is a type of pastry, which is a type of product available for purchase at "Cha-cha-cha Time!"
 */
public abstract class Cookie extends Pastry {

    protected double trioPrice;
    protected double normalPrice;

    /**
     * Created a cookine object
     * @param name string
     * @param quantity int
     */
    protected Cookie(String name, int quantity) {
        this.name = name;
        description = "";
        this.quantity = quantity;
    }
    /**
     * How many sets-of-three cookies have been purchased.
     *
     * @param quantity int
     * @return int
     */
    protected int setsOfThreePurchased(int quantity) {
        return (int) (Math.floor(quantity / 3));
    }

    /**
     * Gets the cost of the Cookie(s) purchased
     * @return int
     */
    public abstract double getCost();
}
