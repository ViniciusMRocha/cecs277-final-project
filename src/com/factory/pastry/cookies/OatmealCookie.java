package com.factory.pastry.cookies;

import com.factory.Product;

/**
 * A OatmealCookie is a type of pastry, which is a type of product available for purchase at "Cha-cha-cha Time!"
 */
public class OatmealCookie extends Cookie implements Product {
    /**
     * Initializes a new OatmealCookie object with the specified parameters.
     * @param name String
     * @param quantity String
     */
    public OatmealCookie(String name, int quantity) {
        super(name, quantity);
        description = "oatmeal";
    }

    /**
     * Gets the cost for the pastry
     * @return double
     */
    @Override
    public double getCost() {
        normalPrice = 1.00;
        trioPrice = 2.50 / 3;
        if (quantity < 3) return (quantity * normalPrice);
        int cookiesInSetsOfThree = setsOfThreePurchased(quantity) * 3;
        System.out.println("Sets: " + cookiesInSetsOfThree);
        int remainingCookies = quantity % (cookiesInSetsOfThree);
        System.out.println("remaining:" + remainingCookies);
        return (remainingCookies * normalPrice) + (cookiesInSetsOfThree * trioPrice);
    }
}
