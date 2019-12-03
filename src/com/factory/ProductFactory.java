package com.factory;

public interface ProductFactory {
    Product createProduct(Object type, Object details);
}