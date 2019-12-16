package com.factory.drink.teas;

import com.factory.Product;

public class GreenTea extends Tea implements Product {
    /**
     * Initializes a new Tea object with the specified parameters.
     *
     * @param name      The name of the tea
     * @param size      The size of the tea
     * @param sweetness The sweetness of the tea
     * @param milkType  The type of milk in the tea
     */
    public GreenTea(String name, Size size, Sweetness sweetness, Milk milkType) {
        super(name, size, sweetness, milkType);
        description = "green tea";
    }

    @Override
    public double getCost() {
        double drinkCost = super.getCost();
        switch (size) {
            case SMALL:
                drinkCost += 3.00 * quantity;
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
