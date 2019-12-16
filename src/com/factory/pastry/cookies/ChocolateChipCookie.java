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
        return 1.50;
    }
}
