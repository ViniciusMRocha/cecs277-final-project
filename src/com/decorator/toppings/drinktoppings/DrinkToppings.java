package com.decorator.toppings.drinktoppings;

/**
 * DrinkToppings creates the enums for the drink toppings available at "Cha-cha-cha Time!"
 */
public enum DrinkToppings {
    COCONUT_JELLY("Coconut Jelly"),
    LYCHEE_JELLY("Lychee Jelly"),
    GRASS_JELLY("Grass Jelly"),
    PASSIONFRUIT_JELLY("Passionfruit Jelly"),
    BOBA("Boba"),
    POPPING_BOBA("Popping Boba"),
    WHIPPED_CREAM("Whipped Cream"),
    STRAWBERRIES("Strawberries");

    private String toppingNames;

    /**
     * Recieves a String and creates a
     * @param toppingNames String
     */
    DrinkToppings(String toppingNames) {
        this.toppingNames = toppingNames;
    }

    /**
     * Returns the topping name as a String
     * @return String
     */
    @Override
    public String toString() {
        return toppingNames;
    }

    /**
     * Gets the enum value and creates a string from it. The method takes in a String that matches the enums
     * @param text String
     * @return toppings
     */
    public static DrinkToppings getEnumValueFromString(String text) {
        for (DrinkToppings toppings : DrinkToppings.values()) {
            if (toppings.toppingNames.equalsIgnoreCase(text))
                return toppings;
        }
        return null;
    }
}