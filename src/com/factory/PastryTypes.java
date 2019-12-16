package com.factory;

/**
 * Describes the different types of pastries available for purchase at "Cha-cha-cha Time!"
 */
public enum PastryTypes {
    CROISSANT("Croissant"), COOKIE("Cookie"), MACAROON("Macaroon");

    private String pastryName;

    /**
     * Defines a new enum with the given pastry type
     * @param pastryName String
     */
    PastryTypes(String pastryName) {
        this.pastryName = pastryName;
    }

    /**
     * Prints out the value of the enum to a String
     * @return String
     */
    @Override
    public String toString() {
        return pastryName;
    }
}