package com.factory.drink.teas;

import com.factory.Product;

public class JasmineGreenTea extends Tea implements Product {
    /**
     * Initializes a new JasmineGreenTea object with the specified parameters.
     * @param name String
     * @param size Size
     * @param sweetness Sweetness
     * @param milkType Milk
     * @param quantity int
     */
    public JasmineGreenTea(String name, Size size, Sweetness sweetness, Milk milkType, int quantity) {
        super(name, size, sweetness, milkType, quantity);
        description = "jasmine green tea";
    }

    /**
     * Gets the cost for the JasmineGreenTea object given its size
     * @return double
     */
    @Override
    public double getCost() {
        double drinkCost = super.getCost();
        switch (size) {
            case SMALL:
                drinkCost += 2.25 * quantity;
                break;
            case MEDIUM:
                drinkCost += 2.75 * quantity;
                break;
            case LARGE:
                drinkCost += 3.25 * quantity;
                break;
        }
        return drinkCost;
    }
}
