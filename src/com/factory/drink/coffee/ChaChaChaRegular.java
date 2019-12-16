package com.factory.drink.coffee;

import com.factory.Product;

public class ChaChaChaRegular extends Coffee implements Product {
    /**
     * Initializes a new Tea object with the specified parameters.
     *
     * @param name      The name of the tea
     * @param size      The size of the tea
     * @param milkType  The type of milk in the tea
     */
    public ChaChaChaRegular(String name, Size size, Milk milkType) {
        super(name, size, milkType);
        description = "Cha cha cha with ";
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
