package com.factory.drink.teas;

import com.factory.Product;

public class GreenTea extends Tea implements Product {
    /**
     * Initializes a new Tea object with the specified parameters.
     *
     * @param name      The name of the tea
     * @param size      The size of the tea
     * @param sweetness The sweetness of the tea
     * @param milkType  The type of milk in the tea
     * @param quantity The quantity purchased
     */
    public GreenTea(String name, Size size, Sweetness sweetness, Milk milkType, int quantity) {
        super(name, size, sweetness, milkType, quantity);
        description = "green tea";
    }

    @Override
    public double getCost() {
        switch (size) {
            case SMALL:
                return 2.00;
            case MEDIUM:
                return 2.50;
            case LARGE:
                return 3.00;
        }
        return 0.0;
    }
}
