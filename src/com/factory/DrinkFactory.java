package com.factory;

import com.decorator.toppings.drinktoppings.DrinkToppings;

import java.util.ArrayList;

/**
 * A DrinkFactory is an implementation of the ProductFactory. It creates a unique type of Drink object depending on
 * the user's specifications.
 */
public class DrinkFactory implements ProductFactory {

    /**
     * The createProduct(Object, Object) method initializes a new Drink object given a set of parameters.
     * TODO: Properly document the uses for each object parameter, if applicable.
     */
    @Override
    public Product createProduct(Object type, Object size, Object toppings, Object sweetness) {
        Drink p = null;

        switch((DrinkTypes)type) {
            case TEA:
                p = new Tea((Drink.Size)size, (Tea.Sweetness)sweetness);
                break;

            case COFFEE:
                p = new Coffee((Drink.Size)size);
                break;
        }
        return p;
    }
}