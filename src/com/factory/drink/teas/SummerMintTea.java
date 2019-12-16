package com.factory.drink.teas;

import com.factory.Product;

public class SummerMintTea extends Tea implements Product {
    /**
     * Initializes a new SummerMintTea object with the specified parameters.
     * @param name String
     * @param size Size
     * @param sweetness Sweetness
     * @param milkType Milk
     * @param quantity int
     */
    public SummerMintTea(String name, Size size, Sweetness sweetness, Milk milkType, int quantity) {
        super(name, size, sweetness, milkType, quantity);
        description = "summer mint tea";
    }

    /**
     * Gets the cost for the SummerMintTea object given its size
     * @return double
     */
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
