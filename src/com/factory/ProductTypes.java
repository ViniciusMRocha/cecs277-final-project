package com.factory;

public enum ProductTypes {
    DRINK("Drink"), PASTRY("Pastry");

    private String productName;

    ProductTypes(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return productName;
    }
}