package com.factory.drink.milkcoffees;
/**
 * Describes the different types of drinks available for purchase at "Cha-cha-cha Time!"
 */
public enum MilkCoffeeTypes {
    HOUSE_PREMIUM("House premium"),
    SEA_CREAM("Sea cream"),
    PUMPKIN_SPICE("Pumpkin spice");

    private String drinkName;

    /**
     * Defines a new enum with the given drink type by passing a drink name
     * @param drinkName String
     */
    MilkCoffeeTypes(String drinkName) {
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
