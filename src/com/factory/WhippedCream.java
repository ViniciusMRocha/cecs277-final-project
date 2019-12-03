package com.factory;

import com.decorator.toppings.drinktoppings.DrinkToppings;

public class WhippedCream extends DrinkToppings {
    public WhippedCream(Drink base) {
        super(base);
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public double getCost() {
        return 0;
    }
}
