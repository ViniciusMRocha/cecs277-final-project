package com.factory.drink.teas;

import com.factory.Product;

public class SummerMintTea extends Tea implements Product {
    /**
     * Initializes a new Tea object with the specified parameters.
     *
     * @param name      The name of the tea
     * @param size      The size of the tea
     * @param sweetness The sweetness of the tea
     * @param milkType  The type of milk in the tea
     * @param quantity The quantity purchased
     */
    public SummerMintTea(String name, Size size, Sweetness sweetness, Milk milkType, int quantity) {
        super(name, size, sweetness, milkType, quantity);
        description = "summer mint tea";
    }

    @Override
    public double getCost() {
        switch (size) {
            case SMALL:
                return 3.00;
            case MEDIUM:
                return 3.50;
            case LARGE:
                return 4.00;
        }
        return 0.0;
    }
}
