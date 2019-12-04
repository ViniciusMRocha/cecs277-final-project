package com.decorator.toppings.drinktoppings.milk;

import com.decorator.toppings.drinktoppings.Toppings;
import com.factory.Drink;

public class WhippedCream extends Toppings {
    public WhippedCream(Drink base) {
        super(base);
    }

    @Override
    public String getDescription() {
        return base.getDescription() + "whipped cream, ";
    }

    @Override
    public double getCost() {
        return base.getCost() + 0.50;
    }
}
