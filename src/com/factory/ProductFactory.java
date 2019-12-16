package com.factory;

/**
 * A Product Factory is an abstract representation of a Factory object that creates more specific types of products.
 */

public abstract class ProductFactory {

    /**
     * Abstract Method to create a product
     *
     * @param name Object
     * @param type Object
     * @param details Object
     * @param details2 Object
     * @param details3 Object
     * @param details4 Object
     * @param details5 Object
     */
    public abstract Product createProduct(Object name, Object type, Object details, Object details2, Object details3, Object details4, Object details5);
}