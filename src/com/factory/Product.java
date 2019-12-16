package com.factory;

/**
 * A Product object represents anything that can be sold at "Cha-cha-cha Time!"
 */
public interface Product {
    String getName();
    int getQuantity();
    String getDescription();
    double getCost();
}
