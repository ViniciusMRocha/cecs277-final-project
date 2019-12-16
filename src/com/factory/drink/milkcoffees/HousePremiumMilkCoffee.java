package com.factory.drink.milkcoffees;

import com.factory.Product;

public class HousePremiumMilkCoffee extends MilkCoffee implements Product {
    /**
     * Creates a new Coffee object with the specified parameters.
     *
     * @param name     The name of the coffee
     * @param size     The size of the coffee
     * @param milkType The type of milk in the coffee
     */
    public HousePremiumMilkCoffee(String name, Size size, Milk milkType) {
        super(name, size, milkType);
        description = "house premium with ";

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
