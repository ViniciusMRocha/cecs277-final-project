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
     * @param type The type of Drink to be created.
     * @param details An ArrayList that outlines any additional additions the drink will have
     * @return The new Drink object.
     */
    @Override
    public Product createProduct(Object type, Object details) {
        Drink p = null;

        switch((DrinkTypes)type) {
            case TEA:
                p = new Tea();
                break;

            case COFFEE:
                p = new Coffee();
                break;
        }

        p.setSize((Drink.Size)details);

        return p;
    }
}