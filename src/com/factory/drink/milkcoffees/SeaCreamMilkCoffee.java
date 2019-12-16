package com.factory.drink.milkcoffees;

import com.factory.Product;

public class SeaCreamMilkCoffee extends MilkCoffee implements Product {
    /**
     * Creates a new Coffee object with the specified parameters.
     *
     * @param name     The name of the coffee
     * @param size     The size of the coffee
     * @param milkType The type of milk in the coffee
     */
    public SeaCreamMilkCoffee(String name, Size size, Milk milkType) {
        super(name, size, milkType);
        description = "sea cream";
    }

    @Override
    public double getCost() {
        return super.getCost() + cost;
    }
}
