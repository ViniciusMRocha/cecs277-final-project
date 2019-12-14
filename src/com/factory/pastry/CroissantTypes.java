package com.factory.pastry;

public enum CroissantTypes {
    PLAIN("Plain croissant"),
    VARIETY("Variety croissant");

    private String croissantName;

    CroissantTypes(String croissantName) {
        this.croissantName = croissantName;
    }

    @Override
    public String toString() {
        return croissantName;
    }
}
