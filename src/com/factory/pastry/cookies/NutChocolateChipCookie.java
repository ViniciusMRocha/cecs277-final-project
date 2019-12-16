package com.factory.pastry.cookies;

import com.factory.Product;

public class NutChocolateChipCookie extends Cookie implements Product {
    /**
     * Initializes a new chocolate chip cookie object with the specified parameters.
     *
     * @param name The name of the cookie
     * @param quantity The quantity to be purchased
     */
    public NutChocolateChipCookie(String name, int quantity) {
        super(name, quantity);
        this.description = "nutty chocolate chip";
    }

    @Override
    public double getCost() {
        normalPrice = 2.00;
        trioPrice = 5.00;
        if (quantity < 3) return (quantity * normalPrice);
        int cookiesInSetsOfThree = setsOfThreePurchased(quantity) * 3;
        int remainingCookies = quantity - (cookiesInSetsOfThree);
        return (remainingCookies * normalPrice) + (cookiesInSetsOfThree * trioPrice);
    }
}
