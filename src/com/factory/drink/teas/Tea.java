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
     * @param quantity The quantity purchased
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
     *
     * @return the total cost.
     */
    public double getCost() {
        double drinkCost = 0.0;
        switch (size) {
            case SMALL:
                drinkCost += 1.50;
                break;

            case MEDIUM:
                drinkCost += 2.00;
                break;

            case LARGE:
                drinkCost += 3.00;
                break;
        }

        switch (milkType) {
            case HALF_AND_HALF:
                drinkCost += 0.25;
                break;

            case SOY_MILK:
                drinkCost += 0.50;
                break;
        }
        cost = drinkCost;
        return drinkCost;
    }
}