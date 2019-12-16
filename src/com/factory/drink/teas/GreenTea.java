package com.factory.drink.teas;

import com.factory.Product;

public class GreenTea extends Tea implements Product {

    /**
     * Initializes a new GreenTea object with the specified parameters.
     * @param name String
     * @param size Size
     * @param sweetness Sweetness
     * @param milkType Milk
     * @param quantity int
     */
    public GreenTea(String name, Size size, Sweetness sweetness, Milk milkType, int quantity) {
        super(name, size, sweetness, milkType, quantity);
        description = "green tea";
    }

    /**
     * Gets the cost for the GreenTea object given its size
     * @return double
     */
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
