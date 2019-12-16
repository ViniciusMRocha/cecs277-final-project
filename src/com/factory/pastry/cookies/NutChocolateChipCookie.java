package com.factory.pastry.cookies;

import com.factory.Product;

/**
 * A NutChocolateChipCookie is a type of pastry, which is a type of product available for purchase at "Cha-cha-cha Time!"
 */
public class NutChocolateChipCookie extends Cookie implements Product {
    /**
     * Initializes a new NutChocolateChipCookie object with the specified parameters.
     * @param name String
     * @param quantity String
     */
    public NutChocolateChipCookie(String name, int quantity) {
        super(name, quantity);
        this.description = "nutty chocolate chip";
    }
    /**
     * Gets the cost for the pastry
     * @return double
     */
    @Override
    public double getCost() {
        normalPrice = 2.00;
        trioPrice = 5.00 / 3;
        if (quantity < 3) return (quantity * normalPrice);
        int cookiesInSetsOfThree = setsOfThreePurchased(quantity) * 3;
        int remainingCookies = quantity - (cookiesInSetsOfThree);
        return (remainingCookies * normalPrice) + (cookiesInSetsOfThree * trioPrice);
    }
}
