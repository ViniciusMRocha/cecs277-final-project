package com.factory.drink.coffee;

import com.factory.Product;

public class CafeDeLaOllaCoffee extends Coffee implements Product {
    /**
     * Creates a new CafeDeLaOllaCoffee object with the specified parameters.
     *
     * @param name     String
     * @param size     String
     * @param milkType Milk
     * @param quantity Int
     */
    public CafeDeLaOllaCoffee(String name, Size size, Milk milkType, int quantity) {
        super(name, size, milkType, quantity);
        description = "Cafe de la Olla with ";
    }

    /**
     * Gets the cost of the product regarding its size
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
