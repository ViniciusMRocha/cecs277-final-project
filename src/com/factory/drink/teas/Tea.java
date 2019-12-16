package com.factory.drink.teas;

import com.factory.DrinkTypes;
import com.factory.drink.Drink;

/**
 * Tea is an extension of the abstract Drink class, which is a type of Product available for purchase at
 * "Cha-cha-cha Time!"
 */
public abstract class Tea extends Drink {
    private Sweetness sweetness;
    /**
     * Initializes a new Tea object with the specified parameters.
     * @param name String
     * @param size String
     * @param sweetness Sweetness
     * @param milkType Milk
     * @param quantity int
     */
    protected Tea(String name, Size size, Sweetness sweetness, Milk milkType, int quantity) {
        this.name = name;
        this.size = size;
        this.sweetness = sweetness;
        this.milkType = milkType;
        this.quantity = quantity;
        drinkType = DrinkTypes.TEA;
        description = "";
    }

    /**
     * Gets the cost of the tea.
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