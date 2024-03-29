package com.decorator.toppings.drinktoppings;

import com.factory.drink.Drink;

/**
 * Strawberries is a type of Topping available at "Cha-cha-cha Time!
 */
public class Strawberries extends Toppings {
    /**
     * Wraps a Drink object into a new Boba object.
     * @param base Drink
     */
    public Strawberries(Drink base) {
        super(base);
    }

    /**
     * Returns the description for the new product
     * @return String
     */
    @Override
    public String getDescription() {
        return base.getDescription() + "strawberries, ";
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
     * Returns the base cost for the new product with the addition of Boba
     * @return double
     */
    @Override
    public double getCost() {
        return base.getCost() + 0.50;
    }
}
