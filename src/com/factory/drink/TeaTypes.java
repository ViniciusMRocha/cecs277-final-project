package com.factory.drink;

/**
 * Describes the different types of tea available for purchase at "Cha-cha-cha Time!"
 */
public enum TeaTypes {
    JASMINE_GREEN_TEA("Jasmine Green Tea"),
    SUMMER_MINT_TEA("Summer Mint Tea"),
    MILK_TEA("Milk Tea");

    private String teaName;

    /**
     * Defines a new enum with the given tea name
     * @param teaName The name of the tea drink
     */
    TeaTypes(String teaName) {
        this.teaName = teaName;
    }

    /**
     * Prints out the value of the enum to a String
     * @return The value of a TeaTypes enum
     */
    @Override
    public String toString() {
        return teaName;
    }
}
