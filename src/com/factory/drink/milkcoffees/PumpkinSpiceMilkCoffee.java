package com.factory.drink.milkcoffees;

import com.factory.Product;

public class PumpkinSpiceMilkCoffee extends MilkCoffee implements Product {
    /**
     * Creates a new PumpkinSpiceMilkCoffee object with the specified parameters.
     *
     * @param name     String
     * @param size     String
     * @param milkType Milk
     * @param quantity Int
     */
    public PumpkinSpiceMilkCoffee(String name, Size size, Milk milkType, int quantity) {
        super(name, size, milkType, quantity);
        description = "pumpkin spice";
    }

    /**
     * gets the cost of the product regarding its size
     * @return double
     */
    @Override
    public double getCost() {
        double drinkCost = super.getCost();
        switch (size) {
            case SMALL:
                drinkCost +=  3.00 * quantity;
                break;
            case MEDIUM:
                drinkCost += 3.50 * quantity;
                break;
            case LARGE:
                drinkCost += 4.00 * quantity;
                break;
        }

        return drinkCost;
    }
}
