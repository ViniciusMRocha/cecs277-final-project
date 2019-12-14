package com.factory;

public enum PastryTypes {
    CROISSANT("Croissant"), COOKIE("Cookie"), MACAROON("Macaroon");

    private String pastryName;

    PastryTypes(String pastryName) {
        this.pastryName = pastryName;
    }

    public String getPastryName() {
        return pastryName;
    }

    @Override
    public String toString() {
        return pastryName;
    }
}