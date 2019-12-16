package com.factory.drink.coffee;

import com.factory.DrinkTypes;
import com.factory.drink.Drink;

/**
 * Coffee is an extension of the abstract Drink class, which is a type of Product available for purchase at
 * "Cha-cha-cha Time!"
 */
public abstract class Coffee extends Drink {

    /**
     * Creates a new Coffee object with the specified parameters.
     *
     * @param name The name of the coffee
     * @param size The size of the coffee
     * @param milkType The type of milk in the coffee
     * @param quantity The amount of coffee products to buy
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
        switch (milkType) {
            case HALF_AND_HALF:
                drinkCost += 0.25;
                break;

            case SOY_MILK:
                drinkCost += 0.50;
                break;
        }
        return drinkCost;
    }
}