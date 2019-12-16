package com.factory.pastry;

/**
 * Describes the different types of Croissants available for purchase at "Cha-cha-cha Time!"
 */
public enum CroissantTypes {
    PLAIN("Plain croissant"),
    VARIETY("Variety croissant");

    private String croissantName;

    /**
     * Defines a new enum with the given croissant name
     * @param croissantName String
     */
    CroissantTypes(String croissantName) {
        this.croissantName = croissantName;
    }

    /**
     * Prints out the value of the enum to a String
     * @return String
     */
    @Override
    public String toString() {
        return croissantName;
    }
}
