package com.factory;

/**
 * Describes the different types of drinks available for purchase at "Cha-cha-cha Time!"
 */
public enum DrinkTypes {
    COFFEE("Coffee"), TEA("Tea");

    private String drinkName;

    /**
     * Defines a new enum with the given drink type
     * @param drinkName The name of the type of drink
     */
    DrinkTypes(String drinkName) {
        this.drinkName = drinkName;
    }

    /**
     * Prints out the value of the enum to a String
     * @return The value of a DrinkTypes enum
     */
    @Override
    public String toString() {
        return drinkName;
    }
}
