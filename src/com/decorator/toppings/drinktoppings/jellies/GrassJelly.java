package com.decorator.toppings.drinktoppings.jellies;

import com.decorator.toppings.drinktoppings.Toppings;
import com.factory.drink.Drink;

/**
 * GrassJelly is a type of Topping available at "Cha-cha-cha Time!"
 */
public class GrassJelly extends Toppings {
    /**
     * Wraps a Drink object into a new GrassJelly object.
     * @param base Drink
     */
    public GrassJelly(Drink base) {
        super(base);
    }

    /**
     * Returns the description for the new product
     * @return String
     */
    @Override
    public String getDescription() {
        return base.getDescription() + "grass jelly, ";
    }

    /**
     * Returns the name of the new product, including all of it's other decorations and it's base class name
     * @return String
     */
    @Override
    public String getName() {
        return base.getName();
    }

    /**
     * Returns the base cost for the new product with the addition for GrassJelly
     * @return double
     */
    @Override
    public double getCost() {
        return base.getCost() + 0.50;
    }
}
