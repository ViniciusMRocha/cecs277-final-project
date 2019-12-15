package com.decorator.toppings.drinktoppings.jellies;

import com.decorator.toppings.drinktoppings.Toppings;
import com.factory.drink.Drink;

/**
 * CoconutJelly is a type of Topping available at "Cha-cha-cha Time!"
 */
public class CoconutJelly extends Toppings {
    /**
     * Wraps a Drink object into a new CoconutJelly object.
     * @param base The base Drink to wrap around
     */
    public CoconutJelly(Drink base) {
        super(base);
    }

    @Override
    public String getDescription() {
            return base.getDescription() + "coconut jelly, ";
    }

    /**
     * Returns the name of the new product, including all of it's other decorations and it's base class name
     * @return the name of the object
     */
    @Override
    public String getName() {
        return base.getName();
    }


    @Override
    public double getCost() {
        return base.getCost() + 0.50;
    }
}
