package com.factory.drink.milkcoffees;

import com.factory.Product;

public class PumpkinSpiceMilkCoffee extends MilkCoffee implements Product {
    /**
     * Creates a new Coffee object with the specified parameters.
     *
     * @param name     The name of the coffee
     * @param size     The size of the coffee
     * @param milkType The type of milk in the coffee
     * @param quantity The amount of coffee products to buy
     */
    public PumpkinSpiceMilkCoffee(String name, Size size, Milk milkType, int quantity) {
        super(name, size, milkType, quantity);
        description = "pumpkin spice";
    }

    @Override
    public double getCost() {
        switch (size) {
            case SMALL:
                return 3.00;
            case MEDIUM:
                return 3.50;
            case LARGE:
                return 4.00;
        }
        return cost;
    }
}
