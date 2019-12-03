package com.decorator.toppings.drinktoppings;

import com.decorator.toppings.drinktoppings.DrinkToppings;
import com.factory.Drink;

public class PoppingBoba extends DrinkToppings {
    public PoppingBoba(Drink base) {
        super(base);
    }

    @Override
    public String getDescription() {
        return "Popping boba";
    }

    @Override
    public double getCost() {
        return 3;
    }
}
