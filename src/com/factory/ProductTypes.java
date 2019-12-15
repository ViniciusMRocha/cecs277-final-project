package com.factory;

/**
 * Describes the different types of products available for purchase at "Cha-cha-cha Time!"
 */
public enum ProductTypes {
    DRINK("Drink"), PASTRY("Pastry");

    private String productName;

    /**
     * Defines a new enum with the given product type
     * @param productName The name of the type of product
     */
    ProductTypes(String productName) {
        this.productName = productName;
    }

    /**
     * Prints out the value of the enum to a String
     * @return The value of a ProductTypes enum
     */
    @Override
    public String toString() {
        return productName;
    }
}