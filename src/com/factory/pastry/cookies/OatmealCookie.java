package com.factory.pastry.cookies;

import com.factory.Product;

public class OatmealCookie extends Cookie implements Product {
    /**
     * Initializes a new chocolate chip cookie object with the specified parameters.
     *
     * @param name The name of the cookie
     * @param quantity The quantity to be purchased
     */
    public OatmealCookie(String name, int quantity) {
        super(name, quantity);
        description = "oatmeal";
    }

    @Override
    public double getCost() {
        normalPrice = 1.00;
        trioPrice = 2.50 / 3;
        if (quantity < 3) return (quantity * normalPrice);
        int cookiesInSetsOfThree = setsOfThreePurchased(quantity) * 3;
        int remainingCookies = quantity - (cookiesInSetsOfThree);
        return (remainingCookies * normalPrice) + (cookiesInSetsOfThree * trioPrice);
    }
}
