package com.factory.pastry.macaroons;

/**
 * Describes the different types of Croissants available for purchase at "Cha-cha-cha Time!"
 */
public enum MacaroonTypes {
    MACAROON("Macaroon");

    private String macaroonName;

    /**
     * Defines a new enum with the given macaroon name
     * @param macaroonName The name of the macaroon pastry
     */
    MacaroonTypes(String macaroonName) {
        this.macaroonName = macaroonName;
    }

    /**
     * Prints out the value of the enum to a String
     * @return The value of a MacaroonTypes enum
     */
    @Override
    public String toString() {
        return macaroonName;
    }
}
