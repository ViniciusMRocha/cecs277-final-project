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
     *
     * @param name The name of the tea
     * @param size The size of the tea
     * @param sweetness The sweetness of the tea
     * @param milkType The type of milk in the tea
     */
    protected Tea(String name, Size size, Sweetness sweetness, Milk milkType) {
        this.name = name;
        this.size = size;
        this.sweetness = sweetness;
        this.milkType = milkType;
        this.quantity = 1;
        drinkType = DrinkTypes.TEA;
        description = "";
    }

    /**
     * Gets the cost of the tea.
     *
     * @return the total cost.
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