package com.decorator.toppings.drinktoppings;

import com.decorator.toppings.drinktoppings.DrinkToppings;
import com.factory.Drink;

public class Boba extends DrinkToppings {
    public Boba(Drink base) {
        super(base);
    }

    @Override
    public String getDescription() {
        return "Boba";
    }

    @Override
    public double getCost() {
        return 5;
    }
}