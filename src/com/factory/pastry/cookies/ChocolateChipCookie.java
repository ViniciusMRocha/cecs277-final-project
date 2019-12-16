package com.factory.pastry.cookies;

import com.factory.Product;

public class ChocolateChipCookie extends Cookie implements Product {
    /**
     * Initializes a new chocolate chip cookie object with the specified parameters.
     *
     * @param name The name of the cookie
     * @param quantity The quantity to be purchased
     */
    public ChocolateChipCookie(String name, int quantity) {
        super(name, quantity);
        description = "chocolate chip";
    }

    @Override
    public double getCost() {
        normalPrice = 1.50;
        trioPrice = 3.00 / 3;
        if (quantity < 3) return (quantity * normalPrice);
        int cookiesInSetsOfThree = setsOfThreePurchased(quantity) * 3;
        System.out.println("Sets: " + cookiesInSetsOfThree);
        int remainingCookies = quantity % (cookiesInSetsOfThree);
        System.out.println("remaining:" + remainingCookies);
        return (remainingCookies * normalPrice) + (cookiesInSetsOfThree * trioPrice);
    }
}
