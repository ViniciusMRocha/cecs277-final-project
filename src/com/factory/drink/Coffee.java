package com.factory.drink;

/**
 * Coffee is a type of drink.
 */
public class Coffee extends Drink {
    /**
     * Creates a new Coffee drink,
     */
    public Coffee(String name, Size size, Milk milkType) {
        this.name = name;
        this.size = size;
        this.milkType = milkType;
        description = "A delicious coffee with ";
    }
    /**
     * Gets the cost of coffee.
     * @return the total cost.
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
        cost = drinkCost;
        return drinkCost;
    }
}