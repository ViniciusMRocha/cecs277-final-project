package com.factory.pastry.cookies;

import com.factory.pastry.Pastry;

/**
 * A Cookie is a type of pastry, which is a type of product available for purchase at "Cha-cha-cha Time!"
 */
public abstract class Cookie extends Pastry {

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
    private int setsOfThreePurchased(int quantity) {
        return (int) (Math.floor(quantity / 3));
    }

    /**
     * Gets the cost of the Cookie(s) purchased
     * @return The total cost of the cookies
     */
    public double getCost() {
        double originalPrice = 1.50;
        double specialPrice = 1.00;

        if (quantity < 3) return (quantity * originalPrice);
        int cookiesInSetsOfThree = setsOfThreePurchased(quantity) * 3;
        int remainingCookies = quantity % (cookiesInSetsOfThree);
        return (remainingCookies * originalPrice) + (cookiesInSetsOfThree * specialPrice);
    }
}
