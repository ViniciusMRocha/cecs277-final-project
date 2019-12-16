package com.decorator.toppings.drinktoppings.jellies;

import com.decorator.toppings.drinktoppings.Toppings;
import com.factory.drink.Drink;

/**
 * PassionFruitJelly is a type of Topping available at "Cha-cha-cha Time!"
 */
public class PassionFruitJelly extends Toppings {
    /**
     * Wraps a Drink object into a new PassionFruitJelly object.
     * @param base Drink
     */
    public PassionFruitJelly(Drink base) {
        super(base);
    }

    /**
     * Returns the description for the new product
     * @return String
     */
    @Override
    public String getName() {
        return base.getName();
    }

    /**
     * Returns the name of the new product, including all of it's other decorations and it's base class name
     * @return String
     */
    @Override
    public String getDescription() {
        return base.getDescription() + "passion fruit jelly, ";
    }

    /**
     * Returns the base cost for the new product with the addition for PassionFruitJelly
     * @return double
     */
    @Override
    public double getCost() {
        return base.getCost() + 0.50;
    }
}
