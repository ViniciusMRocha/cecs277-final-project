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
        return 1.00;
    }
}
