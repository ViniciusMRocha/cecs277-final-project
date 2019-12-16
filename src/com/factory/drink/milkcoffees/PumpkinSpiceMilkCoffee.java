package com.factory.drink.milkcoffees;

import com.factory.Product;

public class PumpkinSpiceMilkCoffee extends MilkCoffee implements Product {
    /**
     * Creates a new Coffee object with the specified parameters.
     *
     * @param name     The name of the coffee
     * @param size     The size of the coffee
     * @param milkType The type of milk in the coffee
     */
    public PumpkinSpiceMilkCoffee(String name, Size size, Milk milkType) {
        super(name, size, milkType);
        description = "pumpkin spice";
    }

    @Override
    public double getCost() {
        double drinkCost = super.getCost();
        switch (size) {
            case SMALL:
                drinkCost +=  4.00 * quantity;
                break;
            case MEDIUM:
                drinkCost += 4.50 * quantity;
                break;
            case LARGE:
                drinkCost += 5.00 * quantity;
                break;
        }

        return drinkCost;
    }
}
