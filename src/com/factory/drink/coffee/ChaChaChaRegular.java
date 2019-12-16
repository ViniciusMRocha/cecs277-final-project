package com.factory.drink.coffee;

import com.factory.Product;

public class ChaChaChaRegular extends Coffee implements Product {
    /**
     * Initializes a new ChaChaChaRegular object with the specified parameters.
     * @param name      String
     * @param size      Size
     * @param milkType  Milk
     */
    public ChaChaChaRegular(String name, Size size, Milk milkType) {
        super(name, size, milkType);
        description = "Cha cha cha with ";
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
