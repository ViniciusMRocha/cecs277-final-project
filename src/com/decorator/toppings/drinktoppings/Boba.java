package com.decorator.toppings.drinktoppings;

import com.factory.Drink;

public class Boba extends Toppings {
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