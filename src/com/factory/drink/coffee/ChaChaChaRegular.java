package com.factory.drink.coffee;

import com.factory.Product;

public class ChaChaChaRegular extends Coffee implements Product {
    /**
     * Initializes a new Tea object with the specified parameters.
     *
     * @param name      The name of the tea
     * @param size      The size of the tea
     * @param milkType  The type of milk in the tea
     * @param quantity The quantity purchased
     */
    public ChaChaChaRegular(String name, Size size, Milk milkType, int quantity) {
        super(name, size, milkType, quantity);
        description = "Cha cha cha with ";
    }

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
