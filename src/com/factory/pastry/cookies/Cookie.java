package com.factory.pastry.cookies;

import com.factory.pastry.Pastry;

/**
 * A Cookie is a type of pastry, which is a type of product available for purchase at "Cha-cha-cha Time!"
 */
public abstract class Cookie extends Pastry {

    /**
     * Initializes a new Cookie object with the specified parameters.
     * @param name String
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
    private int setsOfThreePurchased(int quantity) {
        return (int) (Math.floor(quantity / 3));
    }

    /**
     * Gets the cost of the Cookie(s) purchased
     * @return double
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
