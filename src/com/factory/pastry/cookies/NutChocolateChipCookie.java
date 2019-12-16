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
        return 2.00;
    }
}