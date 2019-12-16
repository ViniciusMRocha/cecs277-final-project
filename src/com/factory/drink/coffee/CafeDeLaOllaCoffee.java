package com.factory.drink.coffee;

import com.factory.Product;

public class CafeDeLaOllaCoffee extends Coffee implements Product {
    /**
     * Initializes a new Tea object with the specified parameters.
     *
     * @param name      The name of the tea
     * @param size      The size of the tea
     * @param milkType  The type of milk in the tea
     */
    public CafeDeLaOllaCoffee(String name, Size size, Milk milkType) {
        super(name, size, milkType);
        description = "Cafe de la Olla with ";
    }

    @Override
    public double getCost() {
        return super.getCost() + cost;
    }
}
