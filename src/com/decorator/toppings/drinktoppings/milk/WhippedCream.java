package com.decorator.toppings.drinktoppings.milk;

import com.decorator.toppings.drinktoppings.Toppings;
import com.factory.Drink;

public class WhippedCream extends Toppings {
    public WhippedCream(Drink base) {
        super(base);
    }

    @Override
    public String getDescription() {
        return "whipped cream";
    }

    @Override
    public double getCost() {
        return 0.50;
    }
}
