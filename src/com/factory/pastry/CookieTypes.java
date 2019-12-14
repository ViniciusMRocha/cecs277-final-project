package com.factory.pastry;

public enum CookieTypes {
    OATMEAL("Oatmeal cookie");

    private String cookieName;

    CookieTypes(String cookieName) {
        this.cookieName = cookieName;
    }

    @Override
    public String toString() {
        return cookieName;
    }
}
