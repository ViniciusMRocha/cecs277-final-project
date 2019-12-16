package com.factory;

public enum PastryTypes {

    MACAROON("Macaroon"), CROISSANT("Croissant"), COOKIE("Cookie");

    private String pastryName;

    /**
     * Defines a new enum with the given pastry type
     * @param pastryName The name of the type of pastry
     */
    PastryTypes(String pastryName) {
        this.pastryName = pastryName;
    }

    /**
     * Prints out the value of the enum to a String
     * @return The value of a AvailablePastryTypes enum
     */
    @Override
    public String toString() {
        return pastryName;
    }
}
