package com.factory.drink.milkcoffees;

import com.factory.Product;

public class HousePremiumMilkCoffee extends MilkCoffee implements Product {
    /**
     * Creates a new HousePremiumMilkCoffee object with the specified parameters.
     *
     * @param name      String
     * @param size      Size
     * @param milkType  Milk
     */
    public HousePremiumMilkCoffee(String name, Size size, Milk milkType) {
        super(name, size, milkType);
        description = "house premium with ";
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
