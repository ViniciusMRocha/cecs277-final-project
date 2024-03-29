package com.factory;

/**
 * Describes the different types of drinks available for purchase at "Cha-cha-cha Time!"
 */
public enum DrinkTypes {
    MILK_COFFEE("Milk coffee"),
    COFFEE("Coffee"),
    TEA("Tea");

    private String drinkName;

    /**
     * Defines a new enum with the given drink type
     * @param drinkName String
     */
    DrinkTypes(String drinkName) {
        this.drinkName = drinkName;
    }

    /**
     * Prints out the value of the enum to a String
     * @return String
     */
    @Override
    public String toString() {
        return drinkName;
    }
}
