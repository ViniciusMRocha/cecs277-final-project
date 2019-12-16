package com.factory.pastry.cookies;

import com.factory.Product;

public class ChocolateChipCookie extends Cookie implements Product {
    /**
     * Initializes a new ChocolateChipCookie object with the specified parameters.
     *
     * @param name String
     * @param quantity int
     */
    public ChocolateChipCookie(String name, int quantity) {
        super(name, quantity);
        description = "chocolate chip";
    }

    /**
     * Gets the cost of the ChocolateChipCookie object
     * @return double
     */
    @Override
    public double getCost() {
        return 1.50;
    }
}
