package com.decorator.toppings.drinktoppings.milk;

import com.decorator.toppings.drinktoppings.Toppings;
import com.factory.drink.Drink;

/**
 * WhippedCream is a type of Topping available at "Cha-cha-cha Time!"
 */
public class WhippedCream extends Toppings {
    /**
     * Wraps a Drink object into a new WhippedCream object.
     * @param base Drink
     */
    public WhippedCream(Drink base) {
        super(base);
    }

    /**
     * Get the topping Description
     * @return String
     */
    @Override
    public String getDescription() {
        return base.getDescription() + "whipped cream, ";
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
     * Gets the topping cost
     * @return double
     */
    @Override
    public double getCost() {
        return base.getCost() + 0.50;
    }
}
