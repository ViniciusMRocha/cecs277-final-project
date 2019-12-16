package com.factory.drink;

/**
 * Describes the different types of coffee available for purchase at "Cha-cha-cha Time!"
 */
public enum CoffeeTypes {
    ALMOND_LATTE("Almond Latte"),
    DARK_ROAST("Dark Roast"),
    HAZELNUT_LATTE("Hazelnut Latte"),
    PUMPKIN_SPICE_LATTE("Pumpkin Space Latte");

    private String coffeeName;

    /**
     * Defines a new enum with the given coffee name
     * @param coffeeName String
     */
    CoffeeTypes(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    /**
     * Prints out the value of the enum to a String
     * @return String
     */
    @Override
    public String toString() {
        return coffeeName;
    }
}
