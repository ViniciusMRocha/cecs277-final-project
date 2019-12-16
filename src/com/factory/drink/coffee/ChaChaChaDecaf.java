package com.factory.drink.coffee;

import com.factory.Product;

public class ChaChaChaDecaf extends Coffee implements Product {
    /**
     * Initializes a new ChaChaChaDecaf object with the specified parameters.
     * @param name      String
     * @param size      Size
     * @param milkType  Milk
     */
    public ChaChaChaDecaf(String name, Size size, Milk milkType) {
        super(name, size, milkType);
        description = "Cha cha cha decaf with ";
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
