package com.factory;

/**
 * A Product Factory is an abstract representation of a Factory object that creates more specific types of products.
 */
public abstract class ProductFactory {
    public abstract Product createProduct(Object name, Object type, Object details, Object details2, Object details3, Object details4, Object details5);
}