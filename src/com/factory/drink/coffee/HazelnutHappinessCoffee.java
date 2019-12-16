package com.factory.drink.coffee;

import com.factory.Product;

public class HazelnutHappinessCoffee extends Coffee implements Product {
    /**
     * Initializes a new Tea object with the specified parameters.
     *
     * @param name      The name of the tea
     * @param size      The size of the tea
     * @param milkType  The type of milk in the tea
     */
    public HazelnutHappinessCoffee(String name, Size size, Milk milkType) {
        super(name, size, milkType);
        description = "Hazelnut happiness with ";
    }

    @Override
    public double getCost() {
        return super.getCost() + cost;
    }
}