package com.factory.pastry.cookies;

import com.factory.Product;

public class OatmealCookie extends Cookie implements Product {
    /**
     * Initializes a new OatmealCookie object with the specified parameters.
     * @param name String
     * @param quantity int
     */
    public OatmealCookie(String name, int quantity) {
        super(name, quantity);
        description = "oatmeal";
    }

    /**
     * Gets the cost of the NutChocolateChipCookie object
     * @return double
     */
    @Override
    public double getCost() {
        return 1.00;
    }
}
