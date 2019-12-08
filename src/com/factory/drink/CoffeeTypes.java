package com.factory.drink;

public enum CoffeeTypes {
    ALMOND_LATTE("Almond Latte"),
    DARK_ROAST("Dark Roast"),
    HAZELNUT_LATTE("Hazelnut Latte"),
    PUMPKIN_SPICE_LATTE("Pumpkin Space Latte");

    private String coffeeName;

    CoffeeTypes(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public String toString() {
        return coffeeName;
    }
}
