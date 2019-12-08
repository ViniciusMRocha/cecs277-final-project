package com.factory.drink;

public enum TeaTypes {
    JASMINE_GREEN_TEA("Jasmine Green Tea"),
    SUMMER_MINT_TEA("Summer Mint Tea"),
    MILK_TEA("Milk Tea");

    private String teaName;

    TeaTypes(String teaName) {
        this.teaName = teaName;
    }

    public String toString() {
        return teaName;
    }
}
