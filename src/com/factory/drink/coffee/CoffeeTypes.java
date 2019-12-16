package com.factory.drink.coffee;
/**
 * Describes the different types of drinks available for purchase at "Cha-cha-cha Time!"
 */
public enum CoffeeTypes {
    CHA_CHA_CHA_REGULAR("Cha-Cha-Cha regular"),
    CHA_CHA_CHA_DECAF("Cha-cha-cha decaf"),
    HAZELNUT_HAPPINESS("Hazelnut happiness"),
    CAFE_DE_LA_OLLA("Cafe de la Olla");


    private String drinkName;

    /**
     * Defines a new enum with the given drink type
     * @param drinkName String
     */
    CoffeeTypes(String drinkName) {
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
