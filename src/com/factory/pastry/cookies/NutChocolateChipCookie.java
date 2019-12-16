package com.factory.pastry.cookies;

import com.factory.Product;

public class NutChocolateChipCookie extends Cookie implements Product {
    /**
     * Initializes a new NutChocolateChipCookie object with the specified parameters.
     * @param name String
     * @param quantity int
     */
    public NutChocolateChipCookie(String name, int quantity) {
        super(name, quantity);
        this.description = "nutty chocolate chip";
    }

    /**
     * Gets the cost of the NutChocolateChipCookie object
     * @return double
     */
    @Override
    public double getCost() {
        return 2.00;
    }
}
