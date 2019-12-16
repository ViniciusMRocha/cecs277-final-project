package com.factory.drink.coffee;

import com.factory.Product;

public class ChaChaChaDecaf extends Coffee implements Product {
    /**
     * Initializes a new Tea object with the specified parameters.
     *
     * @param name      The name of the tea
     * @param size      The size of the tea
     * @param milkType  The type of milk in the tea
     * @param quantity The quantity purchased
     */
    public ChaChaChaDecaf(String name, Size size, Milk milkType, int quantity) {
        super(name, size, milkType, quantity);
        description = "Cha cha cha decaf with ";
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
