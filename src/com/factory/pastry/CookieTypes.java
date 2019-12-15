package com.factory.pastry;

/**
 * Describes the different types of Cookies available for purchase at "Cha-cha-cha Time!"
 */
public enum CookieTypes {
    OATMEAL("Oatmeal cookie");

    private String cookieName;

    /**
     * Defines a new enum with the given cookie name
     * @param cookieName The name of the cookie pastry
     */
    CookieTypes(String cookieName) {
        this.cookieName = cookieName;
    }

    /**
     * Prints out the value of the enum to a String
     * @return The value of a CookieTypes enum
     */
    @Override
    public String toString() {
        return cookieName;
    }
}