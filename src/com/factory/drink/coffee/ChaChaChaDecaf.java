package com.factory.drink.coffee;

import com.factory.Product;

public class ChaChaChaDecaf extends Coffee implements Product {
    /**
     * Creates a new ChaChaChaDecaf object with the specified parameters.
     *
     * @param name     String
     * @param size     String
     * @param milkType Milk
     * @param quantity Int
     */
    public ChaChaChaDecaf(String name, Size size, Milk milkType, int quantity) {
        super(name, size, milkType, quantity);
        description = "Cha cha cha decaf with ";
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
                drinkCost += 2.00 * quantity;
                break;
            case MEDIUM:
                drinkCost += 2.50 * quantity;
                break;
            case LARGE:
                drinkCost += 3.00 * quantity;
                break;
        }
        return drinkCost;
    }
}
