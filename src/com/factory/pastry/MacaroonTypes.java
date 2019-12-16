package com.factory.pastry;

/**
 * Describes the different types of Croissants available for purchase at "Cha-cha-cha Time!"
 */
public enum MacaroonTypes {
    VARIETY("Variety macaroon");

    private String macaroonName;

    /**
     * Defines a new enum with the given macaroon name
     * @param macaroonName String
     */
    MacaroonTypes(String macaroonName) {
        this.macaroonName = macaroonName;
    }

    /**
     * Prints out the value of the enum to a String
     * @return String
     */
    @Override
    public String toString() {
        return macaroonName;
    }
}
