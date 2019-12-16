package com.factory.drink.coffee;

import com.factory.Product;

public class CafeDeLaOllaCoffee extends Coffee implements Product {
    /**
     * Initializes a new CafeDeLaOllaCoffee object with the specified parameters.
     * @param name      String
     * @param size      Size
     * @param milkType  Milk
     */
    public CafeDeLaOllaCoffee(String name, Size size, Milk milkType) {
        super(name, size, milkType);
        description = "Cafe de la Olla with ";
    }

    /**
     * Gets the cost for the Drink
     * @return double
     */
    @Override
    public double getCost() {
        return super.getCost() + cost;
    }
}
