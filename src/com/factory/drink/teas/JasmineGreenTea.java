package com.factory.drink.teas;

import com.factory.Product;

public class JasmineGreenTea extends Tea implements Product {
    /**
     * Initializes a new Tea object with the specified parameters.
     *
     * @param name      The name of the tea
     * @param size      The size of the tea
     * @param sweetness The sweetness of the tea
     * @param milkType  The type of milk in the tea
     */
    public JasmineGreenTea(String name, Size size, Sweetness sweetness, Milk milkType) {
        super(name, size, sweetness, milkType);
        description = "jasmine green tea";
    }

    @Override
    public double getCost() {
        return super.getCost() + cost;
    }
}
