package com.factory.drink.coffee;

import com.factory.Product;

public class HazelnutHappinessCoffee extends Coffee implements Product {
    /**
     * Initializes a new HazelnutHappinessCoffee object with the specified parameters.
     * @param name      String
     * @param size      Size
     * @param milkType  Milk
     */
    public HazelnutHappinessCoffee(String name, Size size, Milk milkType) {
        super(name, size, milkType);
        description = "Hazelnut happiness with ";
    }

    /**
     * Gets the cost for the Drink
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