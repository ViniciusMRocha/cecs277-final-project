package com.decorator.toppings.drinktoppings;

import com.factory.Drink;

public class PoppingBoba extends Toppings {
    public PoppingBoba(Drink base) {
        super(base);
    }

    @Override
    public String getDescription() {
        return "Popping boba";
    }

    @Override
    public double getCost() {
        return 0.50;
    }
}
