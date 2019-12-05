package com.factory;

/**
 * Tea is a type of Drink.
 */
class Tea extends Drink {
    private Sweetness sweetness;

    /**
     * Initializes Tea.
     */
    public Tea(String name, Size size, Sweetness sweetness, Milk milkType) {
        this.name = name;
        this.size = size;
        this.sweetness = sweetness;
        this.milkType = milkType;
        description = "A nice cuppa tea with ";
    }

    /**
     * Gets the cost of tea.
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