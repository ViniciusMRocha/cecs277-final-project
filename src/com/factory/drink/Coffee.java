package com.factory.drink;

import com.factory.DrinkTypes;

/**
 * Coffee is an extension of the abstract Drink class, which is a type of Product available for purchase at
 * "Cha-cha-cha Time!"
 */
public class Coffee extends Drink {

    /**
     * Creates a new Coffee object with the specified parameters.
     * @param name String
     * @param size String
     * @param milkType String
     * @param quantity String
     */
    public Coffee(String name, Size size, Milk milkType, int quantity) {
        drinkType = DrinkTypes.COFFEE;
        this.name = name;
        this.size = size;
        this.milkType = milkType;
        this.quantity = quantity;
        description = "";
    }

    /**
     * Gets the cost of coffee.
     * @return double
     */
    public double getCost() {
        double drinkCost = 0.0;
        switch (size) {
            case SMALL:
            case MEDIUM:
                drinkCost += 2.00;
                break;

            case LARGE:
                drinkCost += 2.50;
                break;
        }

        switch (milkType) {
            case SOY_MILK:
                drinkCost += 0.50;
                break;

            case HALF_AND_HALF:
                drinkCost += 0.25;
                break;
        }
        return drinkCost;
    }
}