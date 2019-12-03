package com.decorator.toppings.drinktoppings.milk;

import com.decorator.toppings.drinktoppings.DrinkToppings;
import com.factory.Drink;

public class WhippedCream extends DrinkToppings {
    public WhippedCream(Drink base) {
        super(base);
    }

    @Override
    public String getDescription() {
        return "whipped cream";
    }

    @Override
    public double getCost() {
        return 5;
    }
}
