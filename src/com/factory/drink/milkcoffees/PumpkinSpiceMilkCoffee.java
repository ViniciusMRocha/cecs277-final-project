package com.factory.drink.milkcoffees;

import com.factory.Product;

public class PumpkinSpiceMilkCoffee extends MilkCoffee implements Product {
    /**
     * Creates a new PumpkinSpiceMilkCoffee object with the specified parameters.
     *
     * @param name      String
     * @param size      Size
     * @param milkType  Milk
     */
    public PumpkinSpiceMilkCoffee(String name, Size size, Milk milkType) {
        super(name, size, milkType);
        description = "pumpkin spice";
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
