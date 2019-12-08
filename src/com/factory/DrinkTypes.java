package com.factory;

public enum DrinkTypes {
    COFFEE("Coffee"), TEA("Tea");

    private String drinkName;

    DrinkTypes(String drinkName) {
        this.drinkName = drinkName;
    }

    @Override
public String toString() {
        return drinkName;
    }
}
