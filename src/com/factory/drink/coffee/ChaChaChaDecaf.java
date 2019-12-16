package com.factory.drink.coffee;

import com.factory.Product;

public class ChaChaChaDecaf extends Coffee implements Product {
    /**
     * Initializes a new Tea object with the specified parameters.
     *
     * @param name      The name of the tea
     * @param size      The size of the tea
     * @param milkType  The type of milk in the tea
     */
    public ChaChaChaDecaf(String name, Size size, Milk milkType) {
        super(name, size, milkType);
        description = "Cha cha cha decaf with ";
    }

    @Override
    public double getCost() {
        return super.getCost() + cost;
    }
}
