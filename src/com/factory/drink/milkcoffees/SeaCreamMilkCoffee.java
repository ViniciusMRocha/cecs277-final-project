package com.factory.drink.milkcoffees;

import com.factory.Product;

public class SeaCreamMilkCoffee extends MilkCoffee implements Product {
    /**
     * Creates a new Coffee object with the specified parameters.
     *
     * @param name     The name of the coffee
     * @param size     The size of the coffee
     * @param milkType The type of milk in the coffee
     * @param quantity The amount of coffee products to buy
     */
    public SeaCreamMilkCoffee(String name, Size size, Milk milkType, int quantity) {
        super(name, size, milkType, quantity);
        description = "sea cream";
    }

    @Override
    public double getCost() {
        switch (size) {
            case SMALL:
                return 2.25;
            case MEDIUM:
                return 2.75;
            case LARGE:
                return 3.25;
        }
        return 0.0;
    }
}
