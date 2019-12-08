package com.decorator.toppings.drinktoppings;

public enum DrinkToppings {
    COCONUT_JELLY("Coconut Jelly"), LYCHEE_JELLY("Lychee Jelly"), GRASS_JELLY("Grass Jelly"), PASSIONFRUIT_JELLY("Passionfruit Jelly"),
    BOBA("Boba"), POPPING_BOBA("Popping Boba"),
    WHIPPED_CREAM("Whipped Cream"), STRAWBERRIES("Strawberries");


    private String toppingNames;

    DrinkToppings(String toppingNames) {
        this.toppingNames = toppingNames;
    }

    public String getToppingNames() {
        return toppingNames;
    }

    @Override
    public String toString() {
        return toppingNames;
    }
}