package com.factory.drink.teas;

import com.factory.Product;

public class RoseGreenTea extends Tea implements Product {
    /**
     * Initializes a new Tea object with the specified parameters.
     *
     * @param name      The name of the tea
     * @param size      The size of the tea
     * @param sweetness The sweetness of the tea
     * @param milkType  The type of milk in the tea
     */
    public RoseGreenTea(String name, Size size, Sweetness sweetness, Milk milkType) {
        super(name, size, sweetness, milkType);
        description = "rose green tea";
    }

    private double drinkPrice;
    public void setCost(double newPrice) {
        drinkPrice = newPrice;
    }
    public double getCost() {
        return drinkPrice;
    }

    @Override
    public double getCost() {
        double drinkCost = super.getCost();
        switch (size) {
            case SMALL:
                drinkCost += drinkPrice * quantity;
                break;
            case MEDIUM:
                drinkCost += drinkPrice * quantity;
                break;
            case LARGE:
                drinkCost += drinkPrice * quantity;
                break;
        }
        return drinkCost;
    }
}
